class javaContainers {
    public static void main(String[] args) {


        // Array - a collection that holds multiple values of the same type
        // - Fixed size once created (cannot grow or shrink)
        // - Stores elements in contiguous memory locations
        // - Fast access using index (O(1) time complexity)
        // - Can store primitives (int, double, etc.) or objects
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array elements:");
        for (int num : numbers) {
            System.out.println(num);
        }

        // ArrayList - a resizable array from java.util package
        // - Dynamic size (grows automatically when elements are added)
        // - Backed by an array internally
        // - Allows random access via index (O(1) for get operations)
        // - Adding/removing from middle is slow (O(n) due to shifting elements)
        // - Can only store objects (uses wrapper classes for primitives)
        java.util.ArrayList<String> fruits = new java.util.ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("ArrayList elements:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // HashMap - a collection that maps keys to values
        // - Stores key-value pairs
        // - Keys must be unique; duplicate keys override previous values
        // - Fast lookup, insertion, and deletion (average O(1) time complexity)
        // - Uses hash function to determine where to store elements
        // - Does not maintain order of elements
        // - Allows one null key and multiple null values
        java.util.HashMap<String, Integer> ageMap = new java.util.HashMap<>();
        ageMap.put("Alice", 30);
        ageMap.put("Bob", 25);
        ageMap.put("Charlie", 35);
        System.out.println("HashMap elements:");
        for (String name : ageMap.keySet()) {
            System.out.println(name + " is " + ageMap.get(name) + " years old.");
        }

        //List - an ordered collection from java.util package
        // - Interface implemented by ArrayList, LinkedList, Vector, etc.
        // - Maintains insertion order
        // - Allows duplicate elements
        // - Allows positional access and insertion of elements
        // - Can contain null elements
        java.util.List<String> colors = new java.util.ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        System.out.println("List elements:");
        for (String color : colors) {
            System.out.println(color);
        }

        //Set - a collection that contains no duplicate elements
        // - Interface implemented by HashSet, TreeSet, LinkedHashSet, etc.
        // - Automatically removes duplicates
        // - HashSet: no order guarantee, O(1) operations
        // - TreeSet: sorted order, O(log n) operations
        // - LinkedHashSet: insertion order maintained
        // - Useful for uniqueness checking and mathematical set operations
        java.util.Set<String> uniqueNames = new java.util.HashSet<>();
        uniqueNames.add("Alice");
        uniqueNames.add("Bob");
        uniqueNames.add("Alice"); // Duplicate, will not be added
        System.out.println("Set elements:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }

        //Queue - a collection used to hold multiple elements prior to processing
        // - Follows FIFO (First-In-First-Out) principle
        // - Interface implemented by LinkedList, PriorityQueue, ArrayDeque, etc.
        // - poll() retrieves and removes the head element
        // - peek() retrieves but does not remove the head
        // - Used for task scheduling, breadth-first search, buffering
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue elements:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        //Iterator - an object that enables traversing a collection
        // - Provides uniform way to traverse different collection types
        // - hasNext() checks if more elements exist
        // - next() returns the next element
        // - remove() can safely remove elements during iteration
        // - Fail-fast: throws ConcurrentModificationException if collection is modified
        java.util.List<String> animals = new java.util.ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Rabbit");
        System.out.println("Iterator elements:");
        java.util.Iterator<String> iterator = animals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //ConcurrentHashMap - a thread-safe variant of HashMap
        // - Thread-safe without synchronizing the entire map
        // - Uses lock striping (segments) for better concurrency
        // - Does not allow null keys or null values
        // - Better performance than Hashtable or synchronized HashMap
        // - Useful in multi-threaded applications
        // - Provides atomic operations like putIfAbsent(), replace()
        java.util.concurrent.ConcurrentHashMap<String, Integer> concurrentMap = new java.util.concurrent.ConcurrentHashMap<>();
        concurrentMap.put("X", 100);
        concurrentMap.put("Y", 200);
        System.out.println("ConcurrentHashMap elements:");
        for (String key : concurrentMap.keySet()) {
            System.out.println(key + " : " + concurrentMap.get(key));
        }

        return;
    }
}