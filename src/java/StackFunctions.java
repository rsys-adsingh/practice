import java.util.Stack;
import java.util.EmptyStackException;

/**
 * Demonstration of all Stack functions in Java
 * Stack is a legacy class that extends Vector and implements LIFO (Last-In-First-Out) data structure
 */
public class StackFunctions {
    
    public static void main(String[] args) {
        // Create a new Stack
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("=== Stack Functions Demo ===\n");
        
        // 1. push(E item) - Pushes an item onto the top of the stack
        System.out.println("1. push() - Add elements to stack");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Stack after pushing 10, 20, 30, 40: " + stack);
        
        // 2. pop() - Removes and returns the top element
        System.out.println("\n2. pop() - Remove and return top element");
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after pop: " + stack);
        
        // 3. peek() - Returns the top element without removing it
        System.out.println("\n3. peek() - View top element without removing");
        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);
        System.out.println("Stack unchanged: " + stack);
        
        // 4. empty() - Tests if the stack is empty
        System.out.println("\n4. empty() - Check if stack is empty");
        System.out.println("Is stack empty? " + stack.empty());
        
        // 5. search(Object o) - Returns 1-based position from top (1 = top)
        System.out.println("\n5. search() - Find position of element from top");
        System.out.println("Position of 30: " + stack.search(30));
        System.out.println("Position of 10: " + stack.search(10));
        System.out.println("Position of 99 (not in stack): " + stack.search(99));
        
        // Inherited Vector methods (commonly used)
        System.out.println("\n=== Inherited Vector Methods ===\n");
        
        // 6. size() - Returns number of elements
        System.out.println("6. size() - Get number of elements");
        System.out.println("Stack size: " + stack.size());
        
        // 7. capacity() - Returns current capacity
        System.out.println("\n7. capacity() - Get current capacity");
        System.out.println("Stack capacity: " + stack.capacity());
        
        // 8. isEmpty() - Check if empty (similar to empty())
        System.out.println("\n8. isEmpty() - Another way to check if empty");
        System.out.println("Is stack empty? " + stack.isEmpty());
        
        // 9. contains(Object o) - Check if element exists
        System.out.println("\n9. contains() - Check if element exists");
        System.out.println("Contains 20? " + stack.contains(20));
        System.out.println("Contains 99? " + stack.contains(99));
        
        // 10. clear() - Remove all elements
        System.out.println("\n10. clear() - Remove all elements");
        Stack<String> tempStack = new Stack<>();
        tempStack.push("A");
        tempStack.push("B");
        System.out.println("Before clear: " + tempStack);
        tempStack.clear();
        System.out.println("After clear: " + tempStack);
        System.out.println("Is empty? " + tempStack.empty());
        
        // Exception handling
        System.out.println("\n=== Exception Handling ===\n");
        
        try {
            Stack<Integer> emptyStack = new Stack<>();
            emptyStack.pop(); // This will throw EmptyStackException
        } catch (EmptyStackException e) {
            System.out.println("EmptyStackException caught when pop() on empty stack");
        }
        
        try {
            Stack<Integer> emptyStack = new Stack<>();
            emptyStack.peek(); // This will throw EmptyStackException
        } catch (EmptyStackException e) {
            System.out.println("EmptyStackException caught when peek() on empty stack");
        }
        
        // Final state
        System.out.println("\n=== Final Stack State ===");
        System.out.println("Stack: " + stack);
        System.out.println("Size: " + stack.size());
    }
}