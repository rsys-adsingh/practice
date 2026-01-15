#include<stdio.h>
int main() {

    // Declare an integer array of size 10
    int arr[10];
    
    // Initialize pointer to point to the first element of the array
    int *ptr = &arr[0];
    
    // Read 10 integers from user input using pointer arithmetic
    // ptr+i points to arr[i]
    for(int i = 0; i < sizeof(arr)/sizeof(arr[0]); i++) {
        scanf("%d", ptr+i);
    }
    
    // Print all array elements using array indexing
    for(int i = 0; i < sizeof(arr)/sizeof(arr[0]); i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}