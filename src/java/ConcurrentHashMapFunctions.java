import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

/**
 * Comprehensive demonstration of ConcurrentHashMap functions
 * ConcurrentHashMap is a thread-safe implementation of Map without locking the entire map
 */
public class ConcurrentHashMapFunctions {
    public static void main(String[] args) {
        // 1. Creation and Initialization
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        
        // 2. put() - Adds key-value pair
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        System.out.println("After put: " + map);
        
        // 3. putIfAbsent() - Adds only if key doesn't exist
        map.putIfAbsent("Apple", 50); // Won't update
        map.putIfAbsent("Date", 40);  // Will add
        System.out.println("After putIfAbsent: " + map);
        
        // 4. get() - Retrieves value by key
        Integer value = map.get("Apple");
        System.out.println("get('Apple'): " + value);
        
        // 5. getOrDefault() - Returns default if key not found
        Integer defaultVal = map.getOrDefault("Mango", 0);
        System.out.println("getOrDefault('Mango', 0): " + defaultVal);
        
        // 6. containsKey() - Checks if key exists
        boolean hasKey = map.containsKey("Banana");
        System.out.println("containsKey('Banana'): " + hasKey);
        
        // 7. containsValue() - Checks if value exists
        boolean hasValue = map.containsValue(20);
        System.out.println("containsValue(20): " + hasValue);
        
        // 8. remove() - Removes key-value pair
        map.remove("Cherry");
        System.out.println("After remove('Cherry'): " + map);
        
        // 9. remove(key, value) - Removes only if key maps to specific value
        map.remove("Banana", 25); // Won't remove
        map.remove("Banana", 20); // Will remove
        System.out.println("After conditional remove: " + map);
        
        // 10. replace() - Replaces value for existing key
        map.replace("Apple", 15);
        System.out.println("After replace('Apple', 15): " + map);
        
        // 11. replace(key, oldValue, newValue) - Replaces if current value matches
        map.replace("Apple", 15, 25);
        System.out.println("After conditional replace: " + map);
        
        // 12. compute() - Computes new value for key
        map.compute("Apple", (k, v) -> v == null ? 1 : v + 5);
        System.out.println("After compute: " + map);
        
        // 13. computeIfAbsent() - Computes value if key is absent
        map.computeIfAbsent("Elderberry", k -> k.length());
        System.out.println("After computeIfAbsent: " + map);
        
        // 14. computeIfPresent() - Computes value if key is present
        map.computeIfPresent("Date", (k, v) -> v * 2);
        System.out.println("After computeIfPresent: " + map);
        
        // 15. merge() - Merges value with existing value
        map.merge("Apple", 10, (oldVal, newVal) -> oldVal + newVal);
        map.merge("Fig", 50, (oldVal, newVal) -> oldVal + newVal); // Adds new
        System.out.println("After merge: " + map);
        
        // 16. size() - Returns number of entries
        System.out.println("size(): " + map.size());
        
        // 17. isEmpty() - Checks if map is empty
        System.out.println("isEmpty(): " + map.isEmpty());
        
        // 18. keySet() - Returns set of all keys
        Set<String> keys = map.keySet();
        System.out.println("keySet(): " + keys);
        
        // 19. values() - Returns collection of all values
        Collection<Integer> values = map.values();
        System.out.println("values(): " + values);
        
        // 20. entrySet() - Returns set of key-value pairs
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("entrySet(): " + entries);
        
        // 21. forEach() - Iterates over entries
        System.out.print("forEach(): ");
        map.forEach((k, v) -> System.out.print(k + "=" + v + " "));
        System.out.println();
        
        // 22. replaceAll() - Replaces all values using function
        map.replaceAll((k, v) -> v + 1);
        System.out.println("After replaceAll(+1): " + map);
        
        // 23. putAll() - Adds all entries from another map
        ConcurrentHashMap<String, Integer> newMap = new ConcurrentHashMap<>();
        newMap.put("Grape", 60);
        newMap.put("Kiwi", 70);
        map.putAll(newMap);
        System.out.println("After putAll: " + map);
        
        // 24. clear() - Removes all entries
        ConcurrentHashMap<String, Integer> tempMap = new ConcurrentHashMap<>(map);
        tempMap.clear();
        System.out.println("After clear (tempMap): " + tempMap);
        
        // 25. mappingCount() - Returns accurate count (better than size for large maps)
        long count = map.mappingCount();
        System.out.println("mappingCount(): " + count);
        
        // 26. search() - Searches and returns non-null result
        String result = map.search(1, (k, v) -> v > 50 ? k : null);
        System.out.println("search (value > 50): " + result);
        
        // 27. reduce() - Combines all entries
        Integer sum = map.reduce(1, (k, v) -> v, (v1, v2) -> v1 + v2);
        System.out.println("reduce (sum of values): " + sum);
        
        // 28. forEachKey() - Iterates over keys in parallel
        System.out.print("forEachKey(): ");
        map.forEachKey(1, k -> System.out.print(k + " "));
        System.out.println();
        
        // 29. forEachValue() - Iterates over values in parallel
        System.out.print("forEachValue(): ");
        map.forEachValue(1, v -> System.out.print(v + " "));
        System.out.println();
        
        // 30. forEachEntry() - Iterates over entries in parallel
        System.out.print("forEachEntry(): ");
        map.forEachEntry(1, e -> System.out.print(e.getKey() + "=" + e.getValue() + " "));
        System.out.println();
        
        System.out.println("\nFinal map: " + map);
    }
}