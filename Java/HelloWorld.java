// 'class' keyword defines a new class in Java
// 'HelloWorld' is the name of the class (must match filename for public classes)
class HelloWorld {
    
    // 'public' means this method can be accessed from anywhere
    // 'static' means this method belongs to the class, not an instance
    // 'void' means this method doesn't return any value
    // 'main' is the entry point method that JVM looks for to start the program
    // 'String[] args' is an array parameter for command-line arguments
    public static void main(String[] args) {
        
        // 'System' is a built-in class in java.lang package
        // 'out' is a static field in System class, of type PrintStream
        // 'println' is a method that prints text followed by a newline
        System.out.println("Hello, World!");
        
        int num1 = 42; // Declare an integer variable named 'num1' and assign it the value 42
        int num2 = 58; // Declare another integer variable named 'num2' and assign it the value 58
        int sum = num1 + num2; // Calculate the sum of num1 and num2 and store it in 'sum'
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum); // Print the sum

        double doubleNumber = 3.14; // Declare a double variable named 'doubleNumber' and assign it the value 3.14
        float floatNumber = 2.71f; // Declare a float variable named 'floatNumber' and assign it the value 2.71
        System.out.println("Double number: " + doubleNumber); // Print the double number
        System.out.println("Float number: " + floatNumber); // Print the float number

        boolean isJavaFun = true; // Declare a boolean variable named 'isJavaFun' and assign it the value true
        System.out.println("Is Java fun? " + isJavaFun); // Print the boolean value
        // 'return' exits the method (optional in void methods)
        return;
    }
}