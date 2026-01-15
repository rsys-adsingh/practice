import java.util.*;

/**
 * Demonstration of all Queue interface functions in Java
 * Queue is a FIFO (First-In-First-Out) data structure
 */
public class QueueFunctions {
    public static void main(String[] args) {
        // Creating a Queue using LinkedList implementation
        Queue<String> queue = new LinkedList<>();
        
        System.out.println("=== Queue Operations Demo ===\n");
        
        // 1. add(E e) - Adds element, throws exception if fails
        System.out.println("1. add() - Adds element, throws exception if capacity restricted");
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        System.out.println("After add(): " + queue);
        
        // 2. offer(E e) - Adds element, returns false if fails (preferred for capacity-restricted queues)
        System.out.println("\n2. offer() - Adds element, returns false if fails");
        boolean offered = queue.offer("Fourth");
        System.out.println("Offer result: " + offered);
        System.out.println("After offer(): " + queue);
        
        // 3. element() - Retrieves but does not remove head, throws exception if empty
        System.out.println("\n3. element() - Retrieves head without removal, throws exception if empty");
        String head = queue.element();
        System.out.println("Head element: " + head);
        System.out.println("Queue unchanged: " + queue);
        
        // 4. peek() - Retrieves but does not remove head, returns null if empty
        System.out.println("\n4. peek() - Retrieves head without removal, returns null if empty");
        String peeked = queue.peek();
        System.out.println("Peeked element: " + peeked);
        System.out.println("Queue unchanged: " + queue);
        
        // 5. remove() - Retrieves and removes head, throws exception if empty
        System.out.println("\n5. remove() - Retrieves and removes head, throws exception if empty");
        String removed = queue.remove();
        System.out.println("Removed element: " + removed);
        System.out.println("After remove(): " + queue);
        
        // 6. poll() - Retrieves and removes head, returns null if empty
        System.out.println("\n6. poll() - Retrieves and removes head, returns null if empty");
        String polled = queue.poll();
        System.out.println("Polled element: " + polled);
        System.out.println("After poll(): " + queue);
        
        // 7. size() - Returns number of elements
        System.out.println("\n7. size() - Returns number of elements");
        System.out.println("Queue size: " + queue.size());
        
        // 8. isEmpty() - Checks if queue is empty
        System.out.println("\n8. isEmpty() - Checks if queue is empty");
        System.out.println("Is empty: " + queue.isEmpty());
        
        // 9. contains(Object o) - Checks if element exists
        System.out.println("\n9. contains() - Checks if element exists");
        System.out.println("Contains 'Third': " + queue.contains("Third"));
        System.out.println("Contains 'First': " + queue.contains("First"));
        
        // 10. clear() - Removes all elements
        System.out.println("\n10. clear() - Removes all elements");
        queue.clear();
        System.out.println("After clear(): " + queue);
        System.out.println("Is empty now: " + queue.isEmpty());
        
        // Demonstrating behavior with empty queue
        System.out.println("\n=== Empty Queue Behavior ===");
        System.out.println("peek() on empty queue: " + queue.peek());
        System.out.println("poll() on empty queue: " + queue.poll());
        
        // 11. toArray() - Converts to array
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        System.out.println("\n11. toArray() - Converts queue to array");
        Object[] array = queue.toArray();
        System.out.println("Array: " + Arrays.toString(array));
        
        // 12. iterator() - Returns an iterator
        System.out.println("\n12. iterator() - Iterates through queue");
        Iterator<String> iterator = queue.iterator();
        System.out.print("Elements: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Summary comparison
        System.out.println("\n=== Key Differences ===");
        System.out.println("add() vs offer(): add throws exception, offer returns false");
        System.out.println("remove() vs poll(): remove throws exception, poll returns null");
        System.out.println("element() vs peek(): element throws exception, peek returns null");
    }
}