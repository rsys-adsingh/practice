import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListFunctions {
    public static void main(String[] args) {
        // 1. Creating ArrayLists
        ArrayList<String> fruits = new ArrayList<>(); // Empty ArrayList
        // ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3)); // With initial values
        // ArrayList<String> colors = new ArrayList<>(10); // With initial capacity
        
        System.out.println("=== ADDING ELEMENTS ===");
        // 2. add(element) - Adds element at the end
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("After add(): " + fruits);
        
        // 3. add(index, element) - Adds element at specific index
        fruits.add(1, "Mango");
        System.out.println("After add(1, 'Mango'): " + fruits);
        
        // 4. addAll(collection) - Adds all elements from another collection
        fruits.addAll(Arrays.asList("Orange", "Grape"));
        System.out.println("After addAll(): " + fruits);
        
        // 5. addAll(index, collection) - Adds all elements at specific index
        fruits.addAll(2, Arrays.asList("Peach", "Plum"));
        System.out.println("After addAll(2, ...): " + fruits);
        
        System.out.println("\n=== ACCESSING ELEMENTS ===");
        // 6. get(index) - Returns element at specified index
        System.out.println("Element at index 0: " + fruits.get(0));
        
        // 7. indexOf(element) - Returns first index of element
        System.out.println("Index of 'Banana': " + fruits.indexOf("Banana"));
        
        // 8. lastIndexOf(element) - Returns last index of element
        fruits.add("Apple"); // Add duplicate
        System.out.println("Last index of 'Apple': " + fruits.lastIndexOf("Apple"));
        
        System.out.println("\n=== MODIFYING ELEMENTS ===");
        // 9. set(index, element) - Replaces element at specified index
        fruits.set(0, "Apricot");
        System.out.println("After set(0, 'Apricot'): " + fruits);
        
        System.out.println("\n=== REMOVING ELEMENTS ===");
        // 10. remove(index) - Removes element at specified index
        fruits.remove(1);
        System.out.println("After remove(1): " + fruits);
        
        // 11. remove(object) - Removes first occurrence of element
        fruits.remove("Apple");
        System.out.println("After remove('Apple'): " + fruits);
        
        // 12. removeAll(collection) - Removes all elements in collection
        fruits.removeAll(Arrays.asList("Peach", "Plum"));
        System.out.println("After removeAll(['Peach', 'Plum']): " + fruits);
        
        // 13. removeIf(predicate) - Removes elements matching condition
        fruits.removeIf(f -> f.startsWith("G"));
        System.out.println("After removeIf(starts with 'G'): " + fruits);
        
        // 14. clear() - Removes all elements
        ArrayList<String> temp = new ArrayList<>(fruits);
        temp.clear();
        System.out.println("After clear(): " + temp);
        
        System.out.println("\n=== CHECKING CONTENT ===");
        // 15. contains(element) - Checks if element exists
        System.out.println("Contains 'Banana': " + fruits.contains("Banana"));
        
        // 16. containsAll(collection) - Checks if all elements exist
        System.out.println("Contains all ['Banana', 'Cherry']: " + 
            fruits.containsAll(Arrays.asList("Banana", "Cherry")));
        
        // 17. isEmpty() - Checks if list is empty
        System.out.println("Is empty: " + fruits.isEmpty());
        
        System.out.println("\n=== SIZE AND CAPACITY ===");
        // 18. size() - Returns number of elements
        System.out.println("Size: " + fruits.size());
        
        // 19. ensureCapacity(minCapacity) - Increases capacity
        fruits.ensureCapacity(20);
        System.out.println("Capacity ensured to 20");
        
        // 20. trimToSize() - Trims capacity to current size
        fruits.trimToSize();
        System.out.println("Trimmed to size");
        
        System.out.println("\n=== SEARCHING AND SORTING ===");
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        
        // 21. sort(comparator) - Sorts the list
        nums.sort(null); // Natural ordering
        System.out.println("Sorted nums: " + nums);
        
        // 22. Collections.sort() - Alternative sorting
        Collections.sort(fruits);
        System.out.println("Sorted fruits: " + fruits);
        
        // 23. Collections.reverse() - Reverses the list
        Collections.reverse(fruits);
        System.out.println("Reversed fruits: " + fruits);
        
        System.out.println("\n=== CONVERSION ===");
        // 24. toArray() - Converts to Object array
        Object[] objArray = fruits.toArray();
        System.out.println("Object array: " + Arrays.toString(objArray));
        
        // 25. toArray(T[] array) - Converts to typed array
        String[] strArray = fruits.toArray(new String[0]);
        System.out.println("String array: " + Arrays.toString(strArray));
        
        System.out.println("\n=== ITERATION ===");
        // 26. iterator() - Returns an iterator
        Iterator<String> iterator = fruits.iterator();
        System.out.print("Using iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // 27. listIterator() - Returns list iterator
        var listIterator = fruits.listIterator();
        System.out.print("Using listIterator: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        
        // 28. forEach(action) - Performs action on each element
        System.out.print("Using forEach: ");
        fruits.forEach(f -> System.out.print(f + " "));
        System.out.println();
        
        System.out.println("\n=== SUBLISTS ===");
        // 29. subList(fromIndex, toIndex) - Returns view of portion
        List<String> subList = fruits.subList(0, 2);
        System.out.println("SubList (0, 2): " + subList);
        
        System.out.println("\n=== BULK OPERATIONS ===");
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("B", "C", "D"));
        
        // 30. retainAll(collection) - Keeps only common elements
        ArrayList<String> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        System.out.println("Intersection: " + intersection);
        
        System.out.println("\n=== OTHER USEFUL METHODS ===");
        // 31. clone() - Creates shallow copy
        @SuppressWarnings("unchecked")
        ArrayList<String> cloned = (ArrayList<String>) fruits.clone();
        System.out.println("Cloned list: " + cloned);
        
        // 32. equals(object) - Compares lists
        System.out.println("fruits equals cloned: " + fruits.equals(cloned));
        
        // 33. hashCode() - Returns hash code
        System.out.println("Hash code: " + fruits.hashCode());
        
        // 34. replaceAll(operator) - Replaces elements using function
        ArrayList<String> lower = new ArrayList<>(Arrays.asList("hello", "world"));
        lower.replaceAll(String::toUpperCase);
        System.out.println("After replaceAll(toUpperCase): " + lower);
        
        System.out.println("\nFinal list: " + fruits);
    }
}