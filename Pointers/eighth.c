#include<stdio.h>
#include<stdlib.h>

int main(){
    // Declare variable to store the number of elements
    int n;
    
    // Read the number of elements from user
    scanf("%d", &n);
    
    // Dynamically allocate memory for n integers
    // malloc returns void*, cast to int* to store integer addresses
    int *ptr = (int*) malloc(n*sizeof(int));
    
    // Read n integers from user and store in allocated memory
    // ptr+i gives address of i-th element
    for(int i = 0; i < n; i++){
        scanf("%d", ptr+i);
    }
    
    // Initialize sum variable to accumulate total
    int sum = 0;
    
    // Calculate sum of all elements
    // *(ptr+i) dereferences pointer to get value at i-th position
    for(int i = 0; i < n; i++){
        sum += *(ptr+i);
    }
    
    // Print the sum of all elements
    printf("%d", sum);
    
    // Free the dynamically allocated memory to prevent memory leak
    free(ptr);
    
    return 0;
}