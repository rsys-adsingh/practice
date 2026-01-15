#include<stdio.h>

int main() {
    // Declare an integer variable and initialize it with 10
    int a = 10;
    
    // Declare a pointer to int and store the address of 'a'
    int *pa = &a;
    
    // Declare a pointer to pointer to int and store the address of 'pa'
    int **ppa = &pa;
    
    // Print:
    // - Address stored in ppa (address of pa)
    // - Address stored in *ppa (address of a, dereferenced once from ppa)
    // - Value stored at **ppa (value of a, dereferenced twice from ppa)
    printf("%p %p %d\n", (void*)ppa, (void*)*ppa, **ppa);
    
    return 0;
}