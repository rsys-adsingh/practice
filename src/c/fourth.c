#include <stdio.h>

// Function to swap two integers using pointers
// Takes two integer pointers as parameters
void swap(int *a, int *b) {
    int temp = *a;  // Store value pointed to by a in temp
    *a = *b;        // Copy value from b to a
    *b = temp;      // Copy temp (original a) to b
}

int main() {
    int n;
    scanf("%d", &n);  // Read the size of the array
    
    int arr[n];       // Declare variable-length array of size n
    int *ptr = &arr[0];  // Initialize pointer to first element of array
    
    // Input loop: read n integers into the array using pointer arithmetic
    for(int i = 0; i < n; i++) {
        scanf("%d", ptr + i);  // ptr + i points to arr[i]
    }
    
    // Reverse the array by swapping elements from both ends
    // int i = 0;
    // while(i < (n / 2)) {  // Only need to swap first half with second half
    //     swap(&arr[i], &arr[n - i - 1]);  // Swap element at i with element at (n-i-1)
    //     i++; 
    // }

    int *start = &arr[0];
    int *end = &arr[n - 1];
    while(start < end) {
        swap(start, end);  // Swap values at start and end pointers
        start++;           // Move start pointer forward
        end--;             // Move end pointer backward
    }

    // Output loop: print all elements using pointer arithmetic
    for(int i = 0; i < n; i++) {
        printf(" %d", *(ptr + i));  // Dereference pointer to get value at arr[i]
    }
    
    return 0;
}