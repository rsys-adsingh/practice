#include<stdio.h>

// Function to calculate the length of a string using pointer arithmetic
// Parameters: char *s - pointer to the string
// Returns: int - the length of the string (excluding null terminator)
int stringLength(char *s) {
    char *p = s; // Create a pointer to traverse the string
    while (*p != '\0') { // Increment the pointer until the null terminator is reached
        p++;
    }
    return p - s; // The length is the difference between the current pointer and the start pointer
}

int main() {
    char *str = NULL; // Initialize pointer to NULL for getline
    size_t size = 0;  // Buffer size (getline will allocate memory)
    
    printf("Enter a string: ");
    // getline() reads an entire line from stdin, dynamically allocates memory
    getline(&str, &size, stdin);
    
    // Remove newline character if present
    // getline() includes the newline character, so we need to remove it
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == '\n') {
            str[i] = '\0'; // Replace newline with null terminator
            break;
        }
    }
    
    // Calculate and display the string length using our custom function
    int length = stringLength(str);
    printf("The length of the string \"%s\" is: %d\n", str, length);
    
    // Note: In production code, you should free(str) here to avoid memory leak
    return 0;
}