// Public class declaration - 'public' makes this class accessible from other packages
// Class name matches the filename (ArrayFunctions.java)
public class ArrayFunctions {
    
    // 'static' method - can be called without creating an object of the class
    // 'int' is the return type - this method returns an integer value
    // Method parameter: int[] nums - an array of integers passed as input
    static int findMax(int[] nums){
        // 'Integer.MIN_VALUE' - constant representing the smallest possible int value (-2,147,483,648)
        int max = Integer.MIN_VALUE; // Initialize max to the smallest integer value
        
        // Enhanced for loop (for-each) - iterates through each element in the array
        // 'int num' - temporary variable holding current array element
        // ':' - means "in" or "for each element in"
        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    // Instance method (non-static) - requires an object to be called
    // 'int' - return type indicating this method returns an integer
    int findMin(int[] nums){
        // 'Integer.MAX_VALUE' - constant representing the largest possible int value (2,147,483,647)
        int min = Integer.MAX_VALUE; // Initialize min to the largest integer value
        
        // Enhanced for-each loop to iterate through array elements
        for(int num : nums){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    // Static method to create a 2D jagged array with random values
    // 'int[][]' - 2D array return type (array of arrays)
    // Parameters: numRows (number of rows), maxRowSize (maximum columns per row)
    static int[][] createRandomJaggedArray(int numRows, int maxRowSize) {
        // Create Random object for generating random numbers
        // 'java.util.Random' - fully qualified class name (package.class)
        java.util.Random random = new java.util.Random();
        
        // Declare 2D array with specified number of rows, but column sizes not yet defined
        // This is called a "jagged array" because rows can have different lengths
        int[][] jaggedArray = new int[numRows][];

        // Traditional for loop - 'i' is the loop counter/index variable
        // 'i < numRows' - loop condition, continues while true
        // 'i++' - increment operator, increases i by 1 after each iteration
        for (int i = 0; i < numRows; i++) {
            // Generate random row size: random.nextInt(maxRowSize) gives 0 to (maxRowSize-1)
            // Adding 1 ensures size is between 1 and maxRowSize
            int rowSize = random.nextInt(maxRowSize) + 1;
            jaggedArray[i] = new int[rowSize];
            for (int j = 0; j < rowSize; j++) {
                jaggedArray[i][j] = random.nextInt(100);
            }
        }

        return jaggedArray;     
    }
    
    // NEW METHOD: Demonstrates ALL java.util.Arrays library functions
    // 'static void' - static method with no return value
    static void demonstrateArrayLibraryFunctions() {
        System.out.println("\n=== JAVA ARRAY LIBRARY FUNCTIONS DEMONSTRATION ===\n");
        
        // ========== 1. Arrays.toString() ==========
        // Converts array to readable string representation
        // Returns: "[element1, element2, element3, ...]"
        int[] arr1 = {5, 2, 8, 1, 9};
        System.out.println("1. Arrays.toString() - Converts array to string:");
        System.out.println("   " + java.util.Arrays.toString(arr1));
        
        // ========== 2. Arrays.sort() ==========
        // Sorts array in ascending order (in-place modification)
        // Uses dual-pivot quicksort algorithm for primitives
        int[] arr2 = {5, 2, 8, 1, 9};
        System.out.println("\n2. Arrays.sort() - Sorts array in ascending order:");
        System.out.println("   Before: " + java.util.Arrays.toString(arr2));
        java.util.Arrays.sort(arr2);
        System.out.println("   After:  " + java.util.Arrays.toString(arr2));
        
        // ========== 3. Arrays.sort(array, fromIndex, toIndex) ==========
        // Sorts only a portion of the array from fromIndex (inclusive) to toIndex (exclusive)
        int[] arr3 = {9, 5, 2, 8, 1, 3};
        System.out.println("\n3. Arrays.sort(array, start, end) - Partial sort:");
        System.out.println("   Before: " + java.util.Arrays.toString(arr3));
        java.util.Arrays.sort(arr3, 1, 4); // Sort indices 1 to 3
        System.out.println("   After:  " + java.util.Arrays.toString(arr3));
        
        // ========== 4. Arrays.binarySearch() ==========
        // Searches for element in SORTED array using binary search
        // Returns: index if found, negative value if not found
        // NOTE: Array MUST be sorted before using binarySearch
        int[] arr4 = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("\n4. Arrays.binarySearch() - Finds index of element:");
        System.out.println("   Array: " + java.util.Arrays.toString(arr4));
        
        // Example with sorted array
        int index = java.util.Arrays.binarySearch(arr4, 7);
        System.out.println("   Index of 7: " + index);
        int notFound = java.util.Arrays.binarySearch(arr4, 6);
        System.out.println("   Index of 6 (not found): " + notFound);
        
        // Example with unsorted array - INCORRECT RESULTS!
        int[] arr4Unsorted = {7, 1, 9, 3, 5, 13, 11};
        System.out.println("   Unsorted array: " + java.util.Arrays.toString(arr4Unsorted));
        int wrongResult = java.util.Arrays.binarySearch(arr4Unsorted, 7);
        System.out.println("   Index of 7 (unsorted - WRONG!): " + wrongResult);
        
        // Correct approach: sort first, then search
        java.util.Arrays.sort(arr4Unsorted);
        System.out.println("   After sorting: " + java.util.Arrays.toString(arr4Unsorted));
        int correctResult = java.util.Arrays.binarySearch(arr4Unsorted, 7);
        System.out.println("   Index of 7 (sorted - CORRECT): " + correctResult);
        
        // ========== 5. Arrays.copyOf() ==========
        // Creates a new array copy with specified length
        // If new length > original, fills with zeros/null
        // If new length < original, truncates the array
        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println("\n5. Arrays.copyOf() - Copies array with new length:");
        System.out.println("   Original: " + java.util.Arrays.toString(arr5));
        int[] copy1 = java.util.Arrays.copyOf(arr5, 3); // Shorter copy
        System.out.println("   Copy (length 3): " + java.util.Arrays.toString(copy1));
        int[] copy2 = java.util.Arrays.copyOf(arr5, 7); // Longer copy
        System.out.println("   Copy (length 7): " + java.util.Arrays.toString(copy2));
        
        // ========== 6. Arrays.copyOfRange() ==========
        // Copies a range from fromIndex (inclusive) to toIndex (exclusive)
        int[] arr6 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("\n6. Arrays.copyOfRange() - Copies subarray:");
        System.out.println("   Original: " + java.util.Arrays.toString(arr6));
        int[] rangeCopy = java.util.Arrays.copyOfRange(arr6, 2, 5); // Copy indices 2-4
        System.out.println("   Copy [2-5): " + java.util.Arrays.toString(rangeCopy));
        
        // ========== 7. Arrays.fill() ==========
        // Fills entire array with specified value
        int[] arr7 = new int[5];
        System.out.println("\n7. Arrays.fill() - Fills array with value:");
        System.out.println("   Before: " + java.util.Arrays.toString(arr7));
        java.util.Arrays.fill(arr7, 99);
        System.out.println("   After fill(99): " + java.util.Arrays.toString(arr7));
        
        // ========== 8. Arrays.fill(array, fromIndex, toIndex, value) ==========
        // Fills a portion of array from fromIndex (inclusive) to toIndex (exclusive)
        int[] arr8 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("\n8. Arrays.fill(array, start, end, value) - Partial fill:");
        System.out.println("   Before: " + java.util.Arrays.toString(arr8));
        java.util.Arrays.fill(arr8, 2, 5, 0); // Fill indices 2-4 with 0
        System.out.println("   After:  " + java.util.Arrays.toString(arr8));
        
        // ========== 9. Arrays.equals() ==========
        // Compares two arrays for equality (same elements in same order)
        // Returns true if equal, false otherwise
        int[] arr9a = {1, 2, 3, 4, 5};
        int[] arr9b = {1, 2, 3, 4, 5};
        int[] arr9c = {1, 2, 3, 5, 4};
        System.out.println("\n9. Arrays.equals() - Checks if arrays are equal:");
        System.out.println("   Array A: " + java.util.Arrays.toString(arr9a));
        System.out.println("   Array B: " + java.util.Arrays.toString(arr9b));
        System.out.println("   Array C: " + java.util.Arrays.toString(arr9c));
        System.out.println("   A equals B: " + java.util.Arrays.equals(arr9a, arr9b));
        System.out.println("   A equals C: " + java.util.Arrays.equals(arr9a, arr9c));
        
        // ========== 10. Arrays.deepEquals() ==========
        // Compares multidimensional arrays for deep equality
        int[][] arr10a = {{1, 2}, {3, 4}};
        int[][] arr10b = {{1, 2}, {3, 4}};
        int[][] arr10c = {{1, 2}, {4, 3}};
        System.out.println("\n10. Arrays.deepEquals() - Deep comparison for 2D arrays:");
        System.out.println("   Array A: " + java.util.Arrays.deepToString(arr10a));
        System.out.println("   Array B: " + java.util.Arrays.deepToString(arr10b));
        System.out.println("   Array C: " + java.util.Arrays.deepToString(arr10c));
        System.out.println("   A deepEquals B: " + java.util.Arrays.deepEquals(arr10a, arr10b));
        System.out.println("   A deepEquals C: " + java.util.Arrays.deepEquals(arr10a, arr10c));
        
        // ========== 11. Arrays.deepToString() ==========
        // Converts multidimensional array to readable string
        int[][] arr11 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        System.out.println("\n11. Arrays.deepToString() - Converts 2D array to string:");
        System.out.println("   " + java.util.Arrays.deepToString(arr11));
        
        // ========== 12. Arrays.asList() ==========
        // Converts array to fixed-size List (can't add/remove, but can modify)
        // NOTE: Works with wrapper types (Integer, String), not primitives
        Integer[] arr12 = {10, 20, 30, 40, 50};
        System.out.println("\n12. Arrays.asList() - Converts array to List:");
        System.out.println("   Array: " + java.util.Arrays.toString(arr12));
        java.util.List<Integer> list = java.util.Arrays.asList(arr12);
        System.out.println("   List: " + list);
        list.set(0, 99); // Can modify
        System.out.println("   After list.set(0, 99): " + list);
        
        // ========== 13. Arrays.hashCode() ==========
        // Returns hash code based on array contents
        // Useful for storing arrays in hash-based collections
        int[] arr13 = {1, 2, 3, 4, 5};
        System.out.println("\n13. Arrays.hashCode() - Returns hash of array contents:");
        System.out.println("   Array: " + java.util.Arrays.toString(arr13));
        System.out.println("   Hash code: " + java.util.Arrays.hashCode(arr13));
        
        // ========== 14. Arrays.deepHashCode() ==========
        // Returns hash code for multidimensional arrays
        int[][] arr14 = {{1, 2}, {3, 4}};
        System.out.println("\n14. Arrays.deepHashCode() - Hash for 2D arrays:");
        System.out.println("   Array: " + java.util.Arrays.deepToString(arr14));
        System.out.println("   Deep hash code: " + java.util.Arrays.deepHashCode(arr14));
        
        // ========== 15. Arrays.stream() (Java 8+) ==========
        // Converts array to Stream for functional operations
        // Enables operations like filter, map, reduce
        int[] arr15 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("\n15. Arrays.stream() - Creates stream for functional ops:");
        System.out.println("   Array: " + java.util.Arrays.toString(arr15));
        int sum = java.util.Arrays.stream(arr15).sum(); // Sum all elements
        System.out.println("   Sum: " + sum);
        long count = java.util.Arrays.stream(arr15).filter(x -> x > 5).count(); // Count > 5
        System.out.println("   Count > 5: " + count);
        
        // ========== 16. Arrays.parallelSort() (Java 8+) ==========
        // Sorts array using parallel merge sort (faster for large arrays)
        // Uses Fork/Join framework for multi-threaded sorting
        int[] arr16 = {9, 5, 2, 8, 1, 6, 3, 7, 4};
        System.out.println("\n16. Arrays.parallelSort() - Multi-threaded sort:");
        System.out.println("   Before: " + java.util.Arrays.toString(arr16));
        java.util.Arrays.parallelSort(arr16);
        System.out.println("   After:  " + java.util.Arrays.toString(arr16));
        
        // ========== 17. Arrays.setAll() (Java 8+) ==========
        // Sets all elements using a generator function
        // Parameter is index, return value is element value
        int[] arr17 = new int[5];
        System.out.println("\n17. Arrays.setAll() - Sets elements via function:");
        System.out.println("   Before: " + java.util.Arrays.toString(arr17));
        java.util.Arrays.setAll(arr17, i -> i * 10); // arr[i] = i * 10
        System.out.println("   After setAll(i -> i*10): " + java.util.Arrays.toString(arr17));
        
        // ========== 18. Arrays.parallelSetAll() (Java 8+) ==========
        // Sets elements in parallel using generator function
        int[] arr18 = new int[5];
        System.out.println("\n18. Arrays.parallelSetAll() - Parallel element setting:");
        System.out.println("   Before: " + java.util.Arrays.toString(arr18));
        java.util.Arrays.parallelSetAll(arr18, i -> i * i); // arr[i] = i^2
        System.out.println("   After parallelSetAll(i -> i*i): " + java.util.Arrays.toString(arr18));
        
        // ========== 19. Arrays.compare() (Java 9+) ==========
        // Lexicographically compares two arrays
        // Returns: negative if arr < other, 0 if equal, positive if arr > other
        int[] arr19a = {1, 2, 3};
        int[] arr19b = {1, 2, 4};
        int[] arr19c = {1, 2, 3};
        System.out.println("\n19. Arrays.compare() - Lexicographic comparison:");
        System.out.println("   Array A: " + java.util.Arrays.toString(arr19a));
        System.out.println("   Array B: " + java.util.Arrays.toString(arr19b));
        System.out.println("   Array C: " + java.util.Arrays.toString(arr19c));
        System.out.println("   compare(A, B): " + java.util.Arrays.compare(arr19a, arr19b));
        System.out.println("   compare(A, C): " + java.util.Arrays.compare(arr19a, arr19c));
        
        // ========== 20. Arrays.mismatch() (Java 9+) ==========
        // Finds first index where arrays differ
        // Returns: index of mismatch, or -1 if arrays are equal
        int[] arr20a = {1, 2, 3, 4, 5};
        int[] arr20b = {1, 2, 9, 4, 5};
        int[] arr20c = {1, 2, 3, 4, 5};
        System.out.println("\n20. Arrays.mismatch() - Finds first difference:");
        System.out.println("   Array A: " + java.util.Arrays.toString(arr20a));
        System.out.println("   Array B: " + java.util.Arrays.toString(arr20b));
        System.out.println("   Array C: " + java.util.Arrays.toString(arr20c));
        System.out.println("   mismatch(A, B): " + java.util.Arrays.mismatch(arr20a, arr20b));
        System.out.println("   mismatch(A, C): " + java.util.Arrays.mismatch(arr20a, arr20c));
    }
    
    // Method to demonstrate working with 2D jagged arrays
    // 'static' - can be called without object instance
    // 'void' - returns nothing
    static void process2DArray() {
        // Create a jagged array with 4 rows, each row having up to 6 elements
        int[][] jaggedArray = createRandomJaggedArray(4, 6);
        
        System.out.println("\nOriginal 2D Array:");
        print2DArray(jaggedArray); // Call helper method to display array
        
        // Sort each row independently
        // '.length' - property that returns the number of rows in 2D array
        for(int i = 0; i < jaggedArray.length; i++) {
            // 'java.util.Arrays.sort()' - built-in method to sort array in ascending order
            // Sorts the current row in-place (modifies the original array)
            java.util.Arrays.sort(jaggedArray[i]);
        }
        
        System.out.println("\nAfter sorting each row:");
        print2DArray(jaggedArray);
        
        // Find min and max across the entire 2D array
        ArrayFunctions af = new ArrayFunctions(); // Create instance to call findMin
        int min = Integer.MAX_VALUE; // Initialize to highest possible value
        int max = Integer.MIN_VALUE; // Initialize to lowest possible value
        
        // Enhanced for-each loop for 2D array
        // 'int[] row' - each iteration, 'row' holds a reference to one row array
        for(int[] row : jaggedArray) {
            int rowMin = af.findMin(row);  // Instance method call
            int rowMax = findMax(row);      // Static method call (can omit class name)
            
            // Update overall min/max if current row has smaller/larger values
            if(rowMin < min) min = rowMin;
            if(rowMax > max) max = rowMax;
        }
        
        // '+' operator - concatenation when used with strings
        System.out.println("\nMinimum in 2D array: " + min);
        System.out.println("Maximum in 2D array: " + max);
    }
    
    // Helper method to display 2D array contents
    // 'static void' - static method with no return value
    // Parameter: int[][] array - 2D integer array to print
    static void print2DArray(int[][] array) {
        // Outer loop iterates through rows
        for(int i = 0; i < array.length; i++) {
            // 'print' (not println) - prints without newline at the end
            System.out.print("Row " + i + ": ");
            
            // Inner for-each loop iterates through elements in current row
            // 'array[i]' - accesses the i-th row (which is itself an array)
            for(int num : array[i]) {
                System.out.print(num + " "); // Print each number with space separator
            }
            System.out.println(); // Move to next line after printing entire row
        }
    }

    // 'public' - access modifier making this method accessible everywhere
    // 'static' - allows JVM to call this method without creating an object
    // 'void' - return type indicating no value is returned
    // 'main' - special method name recognized by JVM as program entry point
    // 'String[] args' - array of command line arguments passed to the program
    public static void main(String[] args) {
        // Array initialization - 'int[]' declares an integer array type
        // Curly braces {} contain the initial values (array literal)
        int[] numbers = {3, 5, 7, 2, 8};
        
        // Calling static method directly using class name (can also call without class name in same class)
        // Result stored in 'maxNumber' variable
        int maxNumber = findMax(numbers);
        
        // 'new' keyword - creates a new object (instance) of ArrayFunctions class
        // 'ArrayFunctions()' - constructor call to create the object
        // 'af' - reference variable storing the object's memory address
        ArrayFunctions af = new ArrayFunctions();
        
        // Calling instance method using object reference 'af'
        // Dot operator '.' accesses the method through the object
        int minNumber = af.findMin(numbers);
        
        System.out.println("The minimum number is: " + minNumber);
        System.out.println("The maximum number is: " + maxNumber);
        
        // Call 2D array processing
        process2DArray();
        
        // CALL THE NEW METHOD to demonstrate all array library functions
        demonstrateArrayLibraryFunctions();
    }
}
