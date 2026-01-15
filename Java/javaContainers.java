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

        //LinkedList - a doubly-linked list implementation
        // - Implements both List and Deque interfaces
        // - Fast insertion/deletion at beginning or end (O(1))
        // - Slow random access (O(n) - must traverse from head/tail)
        // - Uses more memory than ArrayList (stores node references)
        // - Good for frequent insertions/deletions, queue/stack operations
        java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.addFirst("Zero");
        linkedList.addLast("Third");
        System.out.println("LinkedList elements:");
        for (String item : linkedList) {
            System.out.println(item);
        }

        //TreeSet - a sorted set implementation using red-black tree
        // - Elements stored in sorted order (natural or custom comparator)
        // - O(log n) for add, remove, contains operations
        // - Does not allow null elements
        // - Implements NavigableSet interface
        // - Useful when you need sorted unique elements
        java.util.TreeSet<Integer> treeSet = new java.util.TreeSet<>();
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(80);
        treeSet.add(10);
        System.out.println("TreeSet elements (sorted):");
        for (Integer num : treeSet) {
            System.out.println(num);
        }

        //TreeMap - a sorted map implementation using red-black tree
        // - Keys stored in sorted order (natural or custom comparator)
        // - O(log n) for get, put, remove operations
        // - Does not allow null keys (but allows null values)
        // - Implements NavigableMap interface
        // - Useful when you need sorted key-value pairs
        java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<>();
        treeMap.put("Zebra", 3);
        treeMap.put("Apple", 1);
        treeMap.put("Mango", 2);
        System.out.println("TreeMap elements (sorted by key):");
        for (String key : treeMap.keySet()) {
            System.out.println(key + " : " + treeMap.get(key));
        }

        //LinkedHashMap - HashMap with insertion order or access order
        // - Maintains insertion order (or access order if configured)
        // - Slightly slower than HashMap due to maintaining order
        // - Allows one null key and multiple null values
        // - Useful for LRU cache implementation
        java.util.LinkedHashMap<String, String> linkedHashMap = new java.util.LinkedHashMap<>();
        linkedHashMap.put("First", "A");
        linkedHashMap.put("Second", "B");
        linkedHashMap.put("Third", "C");
        System.out.println("LinkedHashMap elements (insertion order):");
        for (String key : linkedHashMap.keySet()) {
            System.out.println(key + " : " + linkedHashMap.get(key));
        }

        //LinkedHashSet - HashSet with insertion order
        // - Maintains insertion order of elements
        // - O(1) for add, remove, contains operations
        // - Slightly slower than HashSet due to maintaining linked list
        // - Allows null elements
        java.util.LinkedHashSet<String> linkedHashSet = new java.util.LinkedHashSet<>();
        linkedHashSet.add("Third");
        linkedHashSet.add("First");
        linkedHashSet.add("Second");
        System.out.println("LinkedHashSet elements (insertion order):");
        for (String item : linkedHashSet) {
            System.out.println(item);
        }

        //PriorityQueue - a queue with elements ordered by priority
        // - Elements ordered by natural ordering or custom comparator
        // - Head of queue is always the smallest/highest priority element
        // - O(log n) for add and poll operations, O(1) for peek
        // - Does not allow null elements
        // - Not thread-safe
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(20);
        System.out.println("PriorityQueue elements (natural order):");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        //ArrayDeque - resizable array implementation of Deque interface
        // - Faster than LinkedList for queue/stack operations
        // - Can be used as stack (LIFO) or queue (FIFO)
        // - No capacity restrictions (grows as needed)
        // - Does not allow null elements
        // - More memory efficient than LinkedList
        java.util.ArrayDeque<String> deque = new java.util.ArrayDeque<>();
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("New First");
        System.out.println("ArrayDeque elements:");
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
        }

        //Stack - LIFO (Last-In-First-Out) data structure
        // - Extends Vector class (legacy, synchronized)
        // - push() adds element to top, pop() removes from top
        // - peek() views top element without removing
        // - ArrayDeque is recommended over Stack for new code
        java.util.Stack<String> stack = new java.util.Stack<>();
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");
        System.out.println("Stack elements (LIFO):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        //Vector - synchronized resizable array (legacy)
        // - Thread-safe version of ArrayList
        // - Slower than ArrayList due to synchronization
        // - Doubles capacity when full (ArrayList grows by 50%)
        // - Generally replaced by ArrayList + Collections.synchronizedList()
        java.util.Vector<Integer> vector = new java.util.Vector<>();
        vector.add(100);
        vector.add(200);
        vector.add(300);
        System.out.println("Vector elements:");
        for (Integer num : vector) {
            System.out.println(num);
        }

        //Hashtable - synchronized hash map (legacy)
        // - Thread-safe, all methods synchronized
        // - Does not allow null keys or null values
        // - Slower than HashMap or ConcurrentHashMap
        // - Generally replaced by ConcurrentHashMap
        java.util.Hashtable<String, String> hashtable = new java.util.Hashtable<>();
        hashtable.put("Key1", "Value1");
        hashtable.put("Key2", "Value2");
        System.out.println("Hashtable elements:");
        for (String key : hashtable.keySet()) {
            System.out.println(key + " : " + hashtable.get(key));
        }

        //EnumSet - specialized set for enum types
        // - Very efficient (uses bit vector internally)
        // - Much faster and more memory efficient than HashSet for enums
        // - All elements must be from same enum type
        // - Cannot contain null
        java.util.EnumSet<Day> weekend = java.util.EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("EnumSet elements:");
        for (Day day : weekend) {
            System.out.println(day);
        }

        //EnumMap - specialized map for enum keys
        // - Very efficient (uses array internally)
        // - Keys must be from same enum type
        // - Maintains natural order of enum constants
        // - Faster than HashMap for enum keys
        java.util.EnumMap<Day, String> schedule = new java.util.EnumMap<>(Day.class);
        schedule.put(Day.MONDAY, "Work");
        schedule.put(Day.SATURDAY, "Relax");
        System.out.println("EnumMap elements:");
        for (Day day : schedule.keySet()) {
            System.out.println(day + " : " + schedule.get(day));
        }

        return;
    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}