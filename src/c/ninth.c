#include <stdio.h>
#include <stdlib.h>

int main() {
    // Define a structure to store student information
    struct student {
        char name[20];      // Student's name (max 19 chars + null terminator)
        int class;          // Student's class/grade level
        char sex;           // Student's gender (M/F)
        float age;          // Student's age
    };

    printf("Size of structure : %ld bytes\n", sizeof(struct student));
    // Allocate memory dynamically for one student structure
    struct student *ptr = (struct student*) malloc(sizeof(struct student));

    // Input: Get student details from user
    printf("Enter the name: ");
    scanf("%s", ptr->name);

    printf("Enter the class: ");
    scanf("%d", &ptr->class);
    
    
    printf("Enter the sex: ");
    scanf("%c", &ptr->sex);  
    
    printf("Enter the age: ");
    scanf("%f", &ptr->age);

    // Output: Display the entered student information
    printf("\nStudent Details:\n");
    printf("Name: %s\n", ptr->name);
    printf("Class: %d\n", ptr->class);
    printf("Sex: %c\n", ptr->sex);
    printf("Age: %.2f\n", ptr->age);

    // Free the dynamically allocated memory
    free(ptr);
    
    return 0;
}