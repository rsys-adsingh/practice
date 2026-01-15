// Define a Car class - a blueprint for creating car objects
class Car {
    // Instance variables (also called fields or attributes)
    // These store the state of each Car object
    String make;   // Brand of the car
    String model;  // Model name of the car
    int year;      // Manufacturing year

    // Constructor - special method called when creating a new Car object
    // It initializes the object's state
    public Car(String make, String model, int year) {
        // 'this' keyword refers to the current object instance
        // It distinguishes between instance variables and parameters with the same name
        this.make = make;     // Assign parameter value to instance variable
        this.model = model;
        this.year = year;
    }
    // No-argument constructor
    public Car() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }

    // Instance method - defines behavior that Car objects can perform
    // 'public' means this method can be called from outside the class
    // 'void' means this method doesn't return a value
    public void displayInfo() {
        // Access instance variables directly within the class
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Car Year: " + year);
    }
}

// Define a Person class - another blueprint for creating person objects
class Person {
    // Instance variables for Person
    String name;  // Person's name
    int age;      // Person's age
    
    // Constructor for Person class
    // Parameters allow passing initial values when creating an object
    public Person(String name, int age) {
        // Initialize instance variables using 'this' keyword
        this.name = name;
        this.age = age;
    }
    
    // Instance method to display person information
    public void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}

// Main class containing the entry point of the program
class javaClasses {
    // main method - where program execution begins
    // 'static' means it belongs to the class, not to instances
    // 'void' means it doesn't return a value
    // String[] args allows passing command-line arguments
    public static void main(String[] args) {
        // Creating an instance (object) of the Car class
        // 'new' keyword allocates memory and calls the constructor
        // 'myCar' is a reference variable that points to the Car object
        Car myCar = new Car("Toyota", "Corolla", 2020);
        // Creating another Car object using the no-argument constructor
        // Note: This will cause a compilation error because Car class doesn't have a no-argument constructor
        // Java doesn't provide a default constructor when you've defined a parameterized constructor
        Car anotherCar = new Car();
        
        // Directly accessing and modifying instance variables from outside the class
        // This works because the fields (make, model, year) have default (package-private) access
        // However, this breaks encapsulation - it's better to use constructors or setter methods
        anotherCar.make = "Honda";
        anotherCar.model = "Civic";
        anotherCar.year = 2019;

        // Call the displayInfo method on the myCar object
        // Using dot notation to access object members
        myCar.displayInfo();
        anotherCar.displayInfo();

        // Creating an instance of the Person class
        // Constructor parameters are passed in parentheses
        Person person = new Person("Alice", 30);
        
        // Call the introduce method on the person object
        person.introduce();
    }
} 