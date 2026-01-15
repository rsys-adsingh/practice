import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Set;

public class HashMapFunctions {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. put(K key, V value) - Inserts key-value pair
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        System.out.println("After put(): " + map);
        
        // 2. putAll(Map m) - Copies all mappings from another map
        HashMap<String, Integer> newMap = new HashMap<>();
        newMap.put("Date", 40);
        map.putAll(newMap);
        System.out.println("After putAll(): " + map);
        
        // 3. putIfAbsent(K key, V value) - Inserts if key doesn't exist
        map.putIfAbsent("Apple", 100); // Won't update
        map.putIfAbsent("Elderberry", 50); // Will insert
        System.out.println("After putIfAbsent(): " + map);
        
        // 4. get(Object key) - Returns value for the key
        Integer value = map.get("Apple");
        System.out.println("get('Apple'): " + value);
        
        // 5. getOrDefault(Object key, V defaultValue) - Returns default if key not found
        Integer val = map.getOrDefault("Mango", 0);
        System.out.println("getOrDefault('Mango', 0): " + val);
        
        // 6. containsKey(Object key) - Checks if key exists
        boolean hasApple = map.containsKey("Apple");
        System.out.println("containsKey('Apple'): " + hasApple);
        
        // 7. containsValue(Object value) - Checks if value exists
        boolean has20 = map.containsValue(20);
        System.out.println("containsValue(20): " + has20);
        
        // 8. size() - Returns number of key-value pairs
        int size = map.size();
        System.out.println("size(): " + size);
        
        // 9. isEmpty() - Checks if map is empty
        boolean empty = map.isEmpty();
        System.out.println("isEmpty(): " + empty);
        
        // 10. keySet() - Returns a Set of all keys
        Set<String> keys = map.keySet();
        System.out.println("keySet(): " + keys);
        
        // 11. values() - Returns a Collection of all values
        Collection<Integer> values = map.values();
        System.out.println("values(): " + values);
        
        // 12. entrySet() - Returns a Set of key-value pairs
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("entrySet(): " + entries);
        
        // 13. forEach(BiConsumer) - Iterates through each entry
        System.out.print("forEach(): ");
        map.forEach((k, v) -> System.out.print(k + "=" + v + " "));
        System.out.println();
        
        // 14. replace(K key, V value) - Replaces value for existing key
        map.replace("Apple", 15);
        System.out.println("After replace('Apple', 15): " + map);
        
        // 15. replace(K key, V oldValue, V newValue) - Replaces if old value matches
        map.replace("Banana", 20, 25);
        System.out.println("After replace('Banana', 20, 25): " + map);
        
        // 16. replaceAll(BiFunction) - Replaces all values using function
        map.replaceAll((k, v) -> v * 2);
        System.out.println("After replaceAll(v * 2): " + map);
        
        // 17. compute(K key, BiFunction) - Computes new value for key
        map.compute("Cherry", (k, v) -> v == null ? 1 : v + 10);
        System.out.println("After compute('Cherry'): " + map);
        
        // 18. computeIfAbsent(K key, Function) - Computes value if key absent
        map.computeIfAbsent("Fig", k -> 60);
        System.out.println("After computeIfAbsent('Fig'): " + map);
        
        // 19. computeIfPresent(K key, BiFunction) - Computes value if key present
        map.computeIfPresent("Fig", (k, v) -> v + 5);
        System.out.println("After computeIfPresent('Fig'): " + map);
        
        // 20. merge(K key, V value, BiFunction) - Merges value with existing
        map.merge("Apple", 5, (oldVal, newVal) -> oldVal + newVal);
        System.out.println("After merge('Apple', 5): " + map);
        
        // 21. remove(Object key) - Removes key-value pair
        map.remove("Date");
        System.out.println("After remove('Date'): " + map);
        
        // 22. remove(Object key, Object value) - Removes if value matches
        map.remove("Banana", 50);
        System.out.println("After remove('Banana', 50): " + map);
        
        // 23. clear() - Removes all entries
        HashMap<String, Integer> tempMap = new HashMap<>(map);
        tempMap.clear();
        System.out.println("After clear() on tempMap: " + tempMap);
        
        // 24. clone() - Creates shallow copy
        @SuppressWarnings("unchecked")
        HashMap<String, Integer> clonedMap = (HashMap<String, Integer>) map.clone();
        System.out.println("clone(): " + clonedMap);
        
        // 25. equals(Object o) - Checks equality with another map
        boolean isEqual = map.equals(clonedMap);
        System.out.println("equals(clonedMap): " + isEqual);
        
        // 26. hashCode() - Returns hash code
        int hash = map.hashCode();
        System.out.println("hashCode(): " + hash);
        
        // 27. toString() - String representation
        String str = map.toString();
        System.out.println("toString(): " + str);
    }
}