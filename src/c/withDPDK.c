/* Simple UDP Receiver - DPDK (Simplified Skeleton) */
#include <rte_eal.h>
#include <rte_ethdev.h>
#include <rte_mbuf.h>
#include <rte_ether.h>  
#include <stdio.h>

#define RX_RING_SIZE 1024
#define TX_RING_SIZE 1024
#define NUM_MBUFS 8191
#define MBUF_CACHE_SIZE 250
#define BURST_SIZE 32

int main(int argc, char *argv[]) {
    struct rte_mempool *mbuf_pool;
    uint16_t port_id = 0;

    // 1. Initialize EAL
    int ret = rte_eal_init(argc, argv);
    if (ret < 0) rte_exit(EXIT_FAILURE, "Error with EAL initialization\n");

    // Check if any ports were found (Virtual or Physical)
    if (rte_eth_dev_count_avail() == 0) {
        rte_exit(EXIT_FAILURE, "No Ethernet ports - bye\n");
    }

    // 2. Allocate Memory Pool
    mbuf_pool = rte_pktmbuf_pool_create("MBUF_POOL", NUM_MBUFS,
        MBUF_CACHE_SIZE, 0, RTE_MBUF_DEFAULT_BUF_SIZE, rte_socket_id());

    if (mbuf_pool == NULL) {
        rte_exit(EXIT_FAILURE, "Cannot create mbuf pool\n");
    }

    // 3. Configure the NIC
    struct rte_eth_conf port_conf = { 0 }; // Initialize to 0
    // Note: older DPDK versions use max_rx_pkt_len, newer ones use MTU APIs.
    // Keeping it simple for compatibility with standard repos:
    port_conf.rxmode.mq_mode = RTE_ETH_MQ_RX_NONE;

    int ret_conf = rte_eth_dev_configure(port_id, 1, 1, &port_conf);
    if (ret_conf < 0) rte_exit(EXIT_FAILURE, "Cannot configure device: err=%d, port=%u\n", ret_conf, port_id);

    // Setup RX Queue
    ret_conf = rte_eth_rx_queue_setup(port_id, 0, RX_RING_SIZE, rte_eth_dev_socket_id(port_id), NULL, mbuf_pool);
    if (ret_conf < 0) rte_exit(EXIT_FAILURE, "Rx queue setup failed: err=%d, port=%u\n", ret_conf, port_id);

    // Setup TX Queue (Required even if we only RX)
    ret_conf = rte_eth_tx_queue_setup(port_id, 0, TX_RING_SIZE, rte_eth_dev_socket_id(port_id), NULL);
    if (ret_conf < 0) rte_exit(EXIT_FAILURE, "Tx queue setup failed: err=%d, port=%u\n", ret_conf, port_id);

    // Start Device
    ret_conf = rte_eth_dev_start(port_id);
    if (ret_conf < 0) rte_exit(EXIT_FAILURE, "rte_eth_dev_start: err=%d, port=%u\n", ret_conf, port_id);
    
    // Enable Promiscuous Mode (so we see all traffic on the virtual tap)
    rte_eth_promiscuous_enable(port_id);

    printf("DPDK Polling started on port %d...\n", port_id);

    // 4. Receive Loop
    struct rte_mbuf *bufs[BURST_SIZE];
    
    while (1) {
        const uint16_t nb_rx = rte_eth_rx_burst(port_id, 0, bufs, BURST_SIZE);

        if (nb_rx > 0) {
            printf("Received %d packets\n", nb_rx);
            for (int i = 0; i < nb_rx; i++) {
                rte_pktmbuf_free(bufs[i]);
            }
        }
    }
    return 0;
}


/*
sudo apt-get update
sudo apt-get install -y libdpdk-dev pkg-config build-essential

gcc -o dpdk_app withDPDK.c  $(pkg-config --cflags --libs libdpdk)      //Use pkg-config to automatically link the correct DPDK libraries
sudo ./dpdk_app -l 1 --vdev=net_tap0 --no-huge

--no-huge: Tells DPDK to use standard RAM instead of hugepages.
--vdev=net_tap0: Tells DPDK to create a virtual TAP interface named dtap0 (which DPDK sees as Port 0).

in other terminal
# 1. Bring the virtual interface up
sudo ip link set dtap0 up

#Option-1. Send some packets to it (using ping)
sudo tcpreplay --intf1=dtap0 --pps=10 some_pcap_file.pcap
#just try pinging broadcast (might not work perfectly without IP assignment)
ping -I dtap0 255.255.255.255

#Option-2
sudo pip3 install scapy
sudo python3 -c 'from scapy.all import *; sendp(Ether()/IP(dst="1.1.1.1")/UDP(), iface="dtap0", count=5000)'     //Python traffic generator command
*/