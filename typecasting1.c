#include<stdio.h>

int main() {
    unsigned int a = 10;  // Unsigned integer (always non-negative)
    int b = -20;          // Signed integer (can be negative)
    
    // When comparing signed and unsigned integers, the signed int is converted to unsigned
    // This causes -20 to be interpreted as a very large positive number (integer wraparound)
    // Result: b (4294967276 in unsigned) > a (10), so the condition is true
    if(b>a) {
        printf("b is greater than a\n");
    } else {
        printf("a is greater than or equal to b\n");
    }
    return 0;
}