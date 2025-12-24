/* Simple UDP Receiver - Standard Linux Socket */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define PORT 8080
#define BUFFER_SIZE 2048

int main() {
    int sockfd;
    char buffer[BUFFER_SIZE];
    struct sockaddr_in servaddr, cliaddr;
    int packet_count = 0;
    
    // 1. Create Socket (System Call)
    if ((sockfd = socket(AF_INET, SOCK_DGRAM, 0)) < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }

    memset(&servaddr, 0, sizeof(servaddr));
    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr = INADDR_ANY; // Listen on all interfaces
    servaddr.sin_port = htons(PORT);

    // 2. Bind Socket to Port (System Call)
    if (bind(sockfd, (const struct sockaddr *)&servaddr, sizeof(servaddr)) < 0) {
        perror("bind failed");
        exit(EXIT_FAILURE);
    }

    printf("Standard Linux Socket listening on port %d...\n", PORT);
    
    socklen_t len = sizeof(cliaddr);
    
    // 3. Receive Loop
    while (1) {
        // BLOCKS here until interrupt triggers and kernel wakes up process
        int n = recvfrom(sockfd, (char *)buffer, BUFFER_SIZE, 
                        MSG_WAITALL, (struct sockaddr *)&cliaddr, &len);
        
        if (n > 0) {
            packet_count++;
            // buffer[n] = '\0'; // Null terminate if you want to print string content
            printf("Received packet #%d: %d bytes from %s\n", 
                   packet_count, n, inet_ntoa(cliaddr.sin_addr));
        }
    }

    close(sockfd);
    return 0;
}


/*
compile : gcc -o dpdk_app withoutDPDK.c
run : ./dpdk_app


in other terminal 
# 1. Install Scapy
sudo pip3 install scapy
# 2. Send Packets (Requires sudo for raw socket access)
sudo python3 -c 'from scapy.all import *; send(IP(dst="127.0.0.1")/UDP(dport=8080)/Raw(load="Hello"), count=5)'
*/