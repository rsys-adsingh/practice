#include <stdio.h>

// This function takes a void pointer and a 'type' flag
void printValue(void *ptr, char type) {
    if (type == 'i') {
        // Cast to int pointer and print
        printf("Int: %d\n", *(int*)ptr); 
    } 
    else if (type == 'f') {
        // Cast to float pointer and print
        printf("Float: %.2f\n", *(float*)ptr); 
    }
    else if (type == 'c') {
        // Cast to char pointer and print
        printf("Char: %c\n", *(char*)ptr);
    }
}

int main() {
    int x = 100;
    float y = 5.5;
    char z = 'A';

    printValue(&x, 'i'); // Pass address of int
    printValue(&y, 'f'); // Pass address of float
    printValue(&z, 'c'); // Pass address of char

    return 0;
}