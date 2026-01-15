#include <stdio.h>

int main() {
    int i = 10;
    float f = 3.14;
    
    // Declare a generic pointer
    void *ptr;

    // 1. Point to the Integer
    ptr = &i; 
    // printf("%d", *ptr); // ERROR: Compiler doesn't know how many bytes to read!
    
    // Correct way: Cast to (int*) then dereference
    printf("Integer value: %d\n", *(int*)ptr);

    // 2. Point to the Float
    ptr = &f;
    
    // Correct way: Cast to (float*) then dereference
    printf("Float value: %.2f\n", *(float*)ptr);

    return 0;
}