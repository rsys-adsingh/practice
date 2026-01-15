#include <stdio.h>
#include <stdlib.h>

/* --- 2. Initialized Data Segment --- */
int global_initialized = 10;     // 4 bytes

/* --- 3. BSS (Uninitialized Data) --- */
int global_uninit;               // 4 bytes (zeroed)

void function(int param) {
    /* --- 5. Stack --- */
    int local_var = 20; 
    
    printf("\n[Stack Frame for 'function']\n");
    printf("  Variable 'local_var': Address: %p | Size: %zu bytes\n", (void*)&local_var, sizeof(local_var));
    printf("  Argument 'param':     Address: %p | Size: %zu bytes\n", (void*)&param, sizeof(param));
}

int main() {
    /* --- 2. Initialized Data Segment (Static) --- */
    static int static_init = 5; 
    
    /* --- 3. BSS (Static) --- */
    static int static_uninit;    

    /* --- 4. Heap --- */
    // allocating 1 integer
    int *heap_memory = (int*)malloc(sizeof(int));
    *heap_memory = 30;

    printf("--- Memory Layout: Addresses & Sizes ---\n");
    
    // 1. Text Segment
    // Note: sizeof(main) is not standard C. The size of the text segment is determined by the compiled instructions.
    printf("1. Text Segment (Code)\n");
    printf("   Function 'main':     Address: %p | Size: N/A (Instruction block)\n", (void*)main);
    
    // 2. Initialized Data
    printf("\n2. Initialized Data Segment\n");
    printf("   global_initialized:  Address: %p | Size: %zu bytes\n", (void*)&global_initialized, sizeof(global_initialized));
    printf("   static_init:         Address: %p | Size: %zu bytes\n", (void*)&static_init, sizeof(static_init));

    // 3. BSS
    printf("\n3. BSS (Uninitialized)\n");
    printf("   global_uninit:       Address: %p | Size: %zu bytes\n", (void*)&global_uninit, sizeof(global_uninit));
    printf("   static_uninit:       Address: %p | Size: %zu bytes\n", (void*)&static_uninit, sizeof(static_uninit));

    // 4. Heap
    printf("\n4. Heap (Dynamic Memory)\n");
    printf("   Actual Integer Data: Address: %p | Size: %zu bytes (Allocated space)\n", (void*)heap_memory, sizeof(int));

    // 5. Stack
    printf("\n5. Stack (Local Scope)\n");
    // Note: heap_memory is a POINTER variable living on the stack
    printf("   Pointer 'heap_memory': Address: %p | Size: %zu bytes (Holds address of Heap data)\n", (void*)&heap_memory, sizeof(heap_memory));
    
    function(5);

    free(heap_memory);
    return 0;
}