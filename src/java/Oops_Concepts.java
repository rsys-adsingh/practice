// Abstraction - Abstract class with abstract methods
abstract class Vehicle {
    // Encapsulation - private members
    private String model;
    private int price;
    
    // Constructor with super concept
    public Vehicle() {
        System.out.println("Vehicle constructor called");
    }
    
    // Encapsulation - public getter and setter methods
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    // Static method - belongs to class, not instance
    public static void getSpeed() {
        System.out.println("Vehicle speed is 100 km/h");
    }
    
    // Concrete method
    public void start() {
        System.out.println("Vehicle started");
    }
    
    // Final method - cannot be overridden in subclasses
    public final void safety() {
        System.out.println("All vehicles must have safety features");
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void displayType();
}

// Inheritance - Car inherits from Vehicle
class Car extends Vehicle {
    private int numberOfDoors;
    
    public Car(String model, int price, int doors) {
        // super() - calls parent class constructor
        super();
        setModel(model);
        setPrice(price);
        this.numberOfDoors = doors;
    }
    
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    @Override
    public void displayType() {
        System.out.println("This is a Car with " + numberOfDoors + " doors");
    }
    
    @Override
    public void start() {
        // super - calls parent class method
        super.start();
        System.out.println("Car engine started with ignition key");
    }
    
    public void drive() {
        System.out.println("Car is driving");
    }
    
    public void drive(int speed) {
        System.out.println("Car is driving at " + speed + " km/h");
    }
    
    // This would cause compile error - cannot override final method
    // public void safety() { }
}

// Inheritance - Bike inherits from Vehicle
class Bike extends Vehicle {
    private boolean hasCarrier;
    
    public Bike(String model, int price, boolean carrier) {
        // super() - calls parent class constructor
        super();
        setModel(model);
        setPrice(price);
        this.hasCarrier = carrier;
    }
    
    @Override
    public void displayType() {
        System.out.println("This is a Bike. Has carrier: " + hasCarrier);
    }
    
    @Override
    public void start() {
        // super - calls parent class method
        super.start();
        System.out.println("Bike started with kick or electric start");
    }
}

// Final class - cannot be inherited
final class ElectricScooter extends Vehicle {
    private int rangeInKm;
    
    public ElectricScooter(String model, int price, int range) {
        super();
        setModel(model);
        setPrice(price);
        this.rangeInKm = range;
    }
    
    @Override
    public void displayType() {
        System.out.println("This is an Electric Scooter with range: " + rangeInKm + " km");
    }
}

// This would cause compile error - cannot extend final class
// class AdvancedScooter extends ElectricScooter { }

interface Engine {
    default void start() {
        System.out.println("Engine interface: Starting engine");
    }
    
    void getEngineType();
}

interface Electric {
    default void start() {
        System.out.println("Electric interface: Starting electric motor");
    }
    
    void getBatteryCapacity();
}

class HybridCar extends Vehicle implements Engine, Electric {
    private String engineType;
    private int batteryCapacity;
    // final variable - must be initialized and cannot be changed
    private final String manufacturer = "Toyota";
    
    public HybridCar(String model, int price, String engineType, int batteryCapacity) {
        super();
        setModel(model);
        setPrice(price);
        this.engineType = engineType;
        this.batteryCapacity = batteryCapacity;
    }
    
    @Override
    public void start() {
        System.out.println("HybridCar: Starting both engine and electric motor");
        Engine.super.start();
        Electric.super.start();
    }
    
    @Override
    public void displayType() {
        System.out.println("This is a Hybrid Car by " + manufacturer);
    }
    
    @Override
    public void getEngineType() {
        System.out.println("Engine Type: " + engineType);
    }
    
    @Override
    public void getBatteryCapacity() {
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

public class Oops_Concepts {
    public static void main(String[] args) {
        System.out.println("=== OOP Concepts Demonstration ===\n");
        
        System.out.println("1. ENCAPSULATION:");
        Car car = new Car("Tesla Model 3", 50000, 4);
        System.out.println("Car Model: " + car.getModel());
        System.out.println("Car Price: $" + car.getPrice());
        System.out.println();
        
        System.out.println("2. INHERITANCE:");
        Bike bike = new Bike("Yamaha R15", 15000, true);
        System.out.println("Bike Model: " + bike.getModel());
        bike.start();
        System.out.println();
        
        System.out.println("3. ABSTRACTION:");
        car.displayType();
        bike.displayType();
        System.out.println();
        
        System.out.println("4. POLYMORPHISM:");
        System.out.println("a) Method Overriding:");
        Vehicle v1 = new Car("Honda Civic", 25000, 4);
        Vehicle v2 = new Bike("Hero Splendor", 8000, false);
        v1.start();
        v2.start();
        
        System.out.println("\nb) Method Overloading:");
        car.drive();
        car.drive(120);
        System.out.println();
        
        System.out.println("5. STATIC METHOD:");
        Vehicle.getSpeed();
        System.out.println();
        
        System.out.println("6. ACCESS MODIFIERS:");
        System.out.println("Private members accessed via public getters");
        System.out.println();
        
        // Demonstrating super and final
        System.out.println("7. SUPER KEYWORD:");
        System.out.println("- Used to call parent class constructor/methods");
        System.out.println("- Demonstrated in Car/Bike start() methods\n");
        
        System.out.println("8. FINAL KEYWORD:");
        System.out.println("- final method: cannot be overridden (Vehicle.safety())");
        car.safety();
        System.out.println("- final class: cannot be extended (ElectricScooter)");
        ElectricScooter scooter = new ElectricScooter("Ather 450X", 12000, 85);
        scooter.displayType();
        System.out.println("- final variable: cannot be modified (manufacturer in HybridCar)");
        System.out.println();
        
        System.out.println("9. DIAMOND PROBLEM:");
        HybridCar hybrid = new HybridCar("Toyota Prius", 30000, "1.8L Petrol", 45);
        hybrid.displayType();
        hybrid.start();
    }
}