#include<stdio.h>
int main() {
    int x = 20;           // Declare an integer variable x and initialize it to 20
    float y = 5.5;        // Declare a float variable y and initialize it to 5.5
    char z = 'A';         // Declare a char variable z and initialize it to 'A'
    int *p1 = &x;         // Declare an integer pointer p1 and store the address of x
    float *p2 = &y;       // Declare a float pointer p2 and store the address of y
    char *p3 = &z;        // Declare a char pointer p3 and store the address of z
    printf("Address of x, y, z: %p, %p, %p\n", &x, &y, &z);  // Print memory addresses of x, y, z using & operator
    printf("Address stored in p1, p2, p3: %p, %p, %p\n", p1, p2, p3);  // Print addresses stored in pointers p1, p2, p3
    printf("Value of x, y, z using pointers: %d, %.2f, %c\n", *p1, *p2, *p3);  // Dereference pointers using * to print values
    return 0;             // Return 0 to indicate successful program execution
}