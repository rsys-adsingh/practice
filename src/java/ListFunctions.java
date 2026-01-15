import java.util.*;

/**
 * Comprehensive demonstration of Java List interface methods
 */
public class ListFunctions {
    public static void main(String[] args) {
        System.out.println("=== Java List Functions Demonstration ===\n");

        // 1. Creating Lists
        // ArrayList: Resizable array, fast random access O(1), slower insertions/deletions O(n)
        List<String> list = new ArrayList<>();
        
        // LinkedList: Doubly-linked list, fast insertions/deletions O(1), slower random access O(n)
        List<Integer> numbers = new LinkedList<>();
        
        // LinkedList specific operations:
        // - add() at beginning/end: O(1) time complexity
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println("LinkedList numbers: " + numbers);
        
        // - LinkedList as Queue: efficient for FIFO operations
        LinkedList<Integer> queue = new LinkedList<>(numbers);
        queue.addFirst(5);  // Add to front: O(1)
        queue.addLast(40);  // Add to end: O(1)
        System.out.println("After addFirst/addLast: " + queue);
        System.out.println("removeFirst(): " + queue.removeFirst()); // O(1)
        System.out.println("removeLast(): " + queue.removeLast());   // O(1)
        
        // Demonstrate the differences
        System.out.println("ArrayList vs LinkedList:");
        System.out.println("- ArrayList: Fast get/set (index-based), slower add/remove (middle)");
        System.out.println("- LinkedList: Fast add/remove (any position), slower get/set (requires traversal)\n");

        // 2. add(E e) - Adds element to end
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("After add(): " + list);

        // 3. add(int index, E element) - Adds element at specific index
        list.add(1, "Avocado");
        System.out.println("After add(1, 'Avocado'): " + list);

        // 4. addAll(Collection c) - Adds all elements from collection
        List<String> moreFruits = Arrays.asList("Date", "Elderberry");
        list.addAll(moreFruits);
        System.out.println("After addAll(): " + list);

        // 5. addAll(int index, Collection c) - Adds all at specific index
        list.addAll(2, Arrays.asList("Fig", "Grape"));
        System.out.println("After addAll(2, ...): " + list);

        // 6. get(int index) - Retrieves element at index
        String fruit = list.get(0);
        System.out.println("get(0): " + fruit);

        // 7. set(int index, E element) - Replaces element at index
        list.set(0, "Apricot");
        System.out.println("After set(0, 'Apricot'): " + list);

        // 8. remove(int index) - Removes element at index
        String removed = list.remove(1);
        System.out.println("Removed at index 1: " + removed + ", List: " + list);

        // 9. remove(Object o) - Removes first occurrence of element
        list.remove("Fig");
        System.out.println("After remove('Fig'): " + list);

        // 10. removeAll(Collection c) - Removes all matching elements
        list.removeAll(Arrays.asList("Grape", "Date"));
        System.out.println("After removeAll(): " + list);

        // 11. retainAll(Collection c) - Keeps only matching elements
        list.addAll(Arrays.asList("Apple", "Orange", "Pear"));
        list.retainAll(Arrays.asList("Apple", "Cherry", "Orange"));
        System.out.println("After retainAll(): " + list);

        // 12. clear() - Removes all elements
        List<String> tempList = new ArrayList<>(list);
        tempList.clear();
        System.out.println("After clear(): " + tempList);

        // 13. size() - Returns number of elements
        System.out.println("Size: " + list.size());

        // 14. isEmpty() - Checks if list is empty
        System.out.println("Is empty: " + list.isEmpty());
        System.out.println("Temp list is empty: " + tempList.isEmpty());

        // 15. contains(Object o) - Checks if element exists
        System.out.println("Contains 'Apple': " + list.contains("Apple"));

        // 16. containsAll(Collection c) - Checks if all elements exist
        System.out.println("Contains all [Apple, Cherry]: " + 
            list.containsAll(Arrays.asList("Apple", "Cherry")));

        // 17. indexOf(Object o) - Returns first index of element
        list.add("Apple"); // Add duplicate
        System.out.println("indexOf('Apple'): " + list.indexOf("Apple"));

        // 18. lastIndexOf(Object o) - Returns last index of element
        System.out.println("lastIndexOf('Apple'): " + list.lastIndexOf("Apple"));

        // 19. subList(int fromIndex, int toIndex) - Returns view of portion
        List<String> subList = list.subList(0, 2);
        System.out.println("subList(0, 2): " + subList);

        // 20. toArray() - Converts to array
        Object[] array = list.toArray();
        System.out.println("toArray(): " + Arrays.toString(array));

        // 21. toArray(T[] a) - Converts to typed array
        String[] stringArray = list.toArray(new String[0]);
        System.out.println("toArray(String[]): " + Arrays.toString(stringArray));

        // 22. iterator() - Returns iterator
        System.out.print("Using iterator(): ");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 23. listIterator() - Returns list iterator (bidirectional)
        ListIterator<String> listIterator = list.listIterator();
        System.out.print("Using listIterator(): ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        // 24. listIterator(int index) - Returns list iterator from index
        ListIterator<String> listIterator2 = list.listIterator(1);
        System.out.print("listIterator(1): ");
        while (listIterator2.hasNext()) {
            System.out.print(listIterator2.next() + " ");
        }
        System.out.println();

        // 25. equals(Object o) - Compares lists
        List<String> list2 = new ArrayList<>(list);
        System.out.println("equals(): " + list.equals(list2));

        // 26. hashCode() - Returns hash code
        System.out.println("hashCode(): " + list.hashCode());

        // 27. sort(Comparator c) - Sorts list (Java 8+)
        list.sort(Comparator.naturalOrder());
        System.out.println("After sort(): " + list);

        // 28. replaceAll(UnaryOperator) - Replaces all elements (Java 8+)
        list.replaceAll(String::toUpperCase);
        System.out.println("After replaceAll(toUpperCase): " + list);

        // 29. removeIf(Predicate) - Removes matching elements (Java 8+)
        list.removeIf(s -> s.startsWith("A"));
        System.out.println("After removeIf(starts with A): " + list);

        // 30. forEach(Consumer) - Iterates over elements (Java 8+)
        System.out.print("forEach(): ");
        list.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 31. stream() - Returns stream (Java 8+)
        System.out.print("stream().filter(): ");
        list.stream()
            .filter(s -> s.length() > 5)
            .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 32. parallelStream() - Returns parallel stream (Java 8+)
        long count = list.parallelStream().count();
        System.out.println("parallelStream().count(): " + count);

        // 33. spliterator() - Returns spliterator (Java 8+)
        Spliterator<String> spliterator = list.spliterator();
        System.out.print("spliterator(): ");
        spliterator.forEachRemaining(s -> System.out.print(s + " "));
        System.out.println();

        // Static factory methods (Java 9+)
        // 34. List.of() - Creates immutable list
        List<String> immutableList = List.of("X", "Y", "Z");
        System.out.println("List.of(): " + immutableList);

        // 35. List.copyOf() - Creates immutable copy (Java 10+)
        List<String> copy = List.copyOf(list);
        System.out.println("List.copyOf(): " + copy);
    }
}