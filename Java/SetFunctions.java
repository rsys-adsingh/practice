import java.util.*;

/**
 * Demonstration of all major Set functions in Java
 * Set is a Collection that contains no duplicate elements
 */
public class SetFunctions {
    public static void main(String[] args) {
        System.out.println("=== Java Set Functions Demo ===\n");
        
        // 1. CREATION - Different Set implementations
        // HashSet: No order guarantee, fastest O(1) operations, allows null
        Set<String> hashSet = new HashSet<>();
        
        // LinkedHashSet: Maintains insertion order, slightly slower than HashSet, allows null
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("First");
        linkedHashSet.add("Second");
        linkedHashSet.add("Third");
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
        
        // TreeSet: Sorted order (natural/comparator), O(log n) operations, does NOT allow null
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Zebra");
        treeSet.add("Apple");
        treeSet.add("Mango");
        System.out.println("TreeSet (sorted): " + treeSet);
        
        // TreeSet specific operations
        System.out.println("First element: " + treeSet.first());
        System.out.println("Last element: " + treeSet.last());
        System.out.println("Higher than 'Mango': " + treeSet.higher("Mango"));
        System.out.println("Lower than 'Mango': " + treeSet.lower("Mango"));
        System.out.println("Subset [Apple to Mango): " + treeSet.subSet("Apple", "Mango"));
        System.out.println();
        
        System.out.println("1. ADDING ELEMENTS");
        // add() - adds element, returns true if added, false if already exists
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate - won't be added
        System.out.println("HashSet after add(): " + hashSet);
        
        // addAll() - adds all elements from another collection
        List<String> fruits = Arrays.asList("Date", "Elderberry", "Fig");
        hashSet.addAll(fruits);
        System.out.println("After addAll(): " + hashSet + "\n");
        
        // 2. CHECKING ELEMENTS
        System.out.println("2. CHECKING ELEMENTS");
        // contains() - checks if element exists
        System.out.println("Contains 'Apple': " + hashSet.contains("Apple"));
        
        // containsAll() - checks if all elements exist
        System.out.println("Contains all fruits: " + hashSet.containsAll(fruits));
        
        // isEmpty() - checks if set is empty
        System.out.println("Is empty: " + hashSet.isEmpty());
        
        // size() - returns number of elements
        System.out.println("Size: " + hashSet.size() + "\n");
        
        // 3. REMOVING ELEMENTS
        System.out.println("3. REMOVING ELEMENTS");
        // remove() - removes element, returns true if existed
        boolean removed = hashSet.remove("Banana");
        System.out.println("Removed 'Banana': " + removed);
        System.out.println("After remove(): " + hashSet);
        
        // removeAll() - removes all elements from another collection
        hashSet.removeAll(Arrays.asList("Date", "Fig"));
        System.out.println("After removeAll(): " + hashSet);
        
        // retainAll() - keeps only elements that are in another collection
        hashSet.retainAll(Arrays.asList("Apple", "Cherry", "Grape"));
        System.out.println("After retainAll(): " + hashSet);
        
        // removeIf() - removes elements matching predicate (Java 8+)
        hashSet.add("Apricot");
        hashSet.removeIf(s -> s.startsWith("A"));
        System.out.println("After removeIf (starts with A): " + hashSet + "\n");
        
        // 4. ITERATION
        System.out.println("4. ITERATION");
        hashSet.addAll(Arrays.asList("Mango", "Orange", "Peach"));
        
        // forEach() with lambda (Java 8+)
        System.out.print("forEach: ");
        hashSet.forEach(item -> System.out.print(item + " "));
        System.out.println();
        
        // iterator()
        System.out.print("iterator: ");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Enhanced for loop
        System.out.print("for-each loop: ");
        for (String item : hashSet) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
        
        // 5. CONVERSION
        System.out.println("5. CONVERSION");
        // toArray() - converts to Object array
        Object[] array1 = hashSet.toArray();
        System.out.println("toArray(): " + Arrays.toString(array1));
        
        // toArray(T[]) - converts to typed array
        String[] array2 = hashSet.toArray(new String[0]);
        System.out.println("toArray(String[]): " + Arrays.toString(array2) + "\n");
        
        // 6. BULK OPERATIONS
        System.out.println("6. BULK OPERATIONS");
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        // Union - addAll()
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Intersection - retainAll()
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference - removeAll()
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference + "\n");
        
        // 7. STREAM OPERATIONS (Java 8+)
        System.out.println("7. STREAM OPERATIONS");
        Set<String> words = new HashSet<>(Arrays.asList("apple", "banana", "cherry", "date"));
        
        // stream() and various operations
        long count = words.stream().filter(s -> s.length() > 5).count();
        System.out.println("Words with length > 5: " + count);
        
        // 8. CLEAR
        System.out.println("\n8. CLEAR");
        Set<String> tempSet = new HashSet<>(words);
        tempSet.clear(); // Removes all elements
        System.out.println("After clear(): " + tempSet);
        System.out.println("Is empty: " + tempSet.isEmpty() + "\n");
        
        // 9. COMPARING SET IMPLEMENTATIONS
        System.out.println("9. SET IMPLEMENTATIONS COMPARISON");
        Set<String> hash = new HashSet<>();
        Set<String> linked = new LinkedHashSet<>();
        Set<String> tree = new TreeSet<>();
        
        String[] items = {"Zebra", "Apple", "Mango", "Banana"};
        for (String item : items) {
            hash.add(item);
            linked.add(item);
            tree.add(item);
        }
        
        System.out.println("HashSet (no order): " + hash);
        System.out.println("LinkedHashSet (insertion order): " + linked);
        System.out.println("TreeSet (sorted): " + tree);
    }
}