import java.util.ArrayList;
import java.util.List;

public class AssignmentTwo {
    // List to store rides available in the park
    private List<Ride> rides;
    // List to store employees working in the park
    private List<Employee> employees;
    // List to store visitors currently in the park
    private List<Visitor> visitors;

    // Constructor to initialize the lists for rides, employees, and visitors
    public AssignmentTwo() {
        this.rides = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.visitors = new ArrayList<>();
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Create an instance of AssignmentTwo representing the park
        AssignmentTwo park = new AssignmentTwo();

        // Create instances of rides with specific parameters: name, minimum age, energy requirement, etc.
        Ride rollerCoaster = new Ride("Thunderbolt", 12, 50, 3, 3);
        Ride ferrisWheel = new Ride("Sky View", 5, 20, 1, 2);
        Ride waterSlide = new Ride("Splash Mountain", 8, 30, 2, 4);

        // Add the created rides to the park's list of rides
        park.addRide(rollerCoaster);
        park.addRide(ferrisWheel);
        park.addRide(waterSlide);

        // Create employee instances with specific attributes: name, age, position, and experience
        Employee john = new Employee("John", 30, "Ride Operator", 5);
        Employee sarah = new Employee("Sarah", 25, "Ride Operator", 2);

        // Hire employees by adding them to the park's list of employees
        park.hireEmployee(john);
        park.hireEmployee(sarah);

        // Assign the hired employees as operators to specific rides
        rollerCoaster.assignOperator(john);
        ferrisWheel.assignOperator(sarah);

        // Create visitor instances with attributes: name, age, and whether they have a ticket
        Visitor alice = new Visitor("Alice", 15, true);
        Visitor bob = new Visitor("Bob", 10, true);
        Visitor charlie = new Visitor("Charlie", 20, false);
        Visitor dave = new Visitor("Dave", 12, true);
        Visitor eve = new Visitor("Ev2", 8, false);
        Visitor frank = new Visitor("Frank", 18, true);
        Visitor grace = new Visitor("Grace", 22, false);
        Visitor hank = new Visitor("Hank", 9, true);
        Visitor ivy = new Visitor("Ivy", 14, false);
        Visitor jack = new Visitor("Jack", 11, true);

        // Admit visitors into the park by adding them to the park's list of visitors
        park.admitVisitor(alice);
        park.admitVisitor(bob);
        park.admitVisitor(charlie);
        park.admitVisitor(dave);
        park.admitVisitor(eve);
        park.admitVisitor(frank);
        park.admitVisitor(grace);
        park.admitVisitor(hank);
        park.admitVisitor(ivy);
        park.admitVisitor(jack);

        // Demonstrate different parts of the assignment by calling specific methods
        park.partThree();
        park.partFourA();
        park.partFourB();
        park.partFive();
        park.partSix();
        park.partSeven();
    }

    // Method to add a ride to the park's list of rides
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    // Method to hire an employee and add them to the park's list of employees
    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method to admit a visitor to the park by adding them to the park's list of visitors
    public void admitVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public void partThree() {
        System.out.println("\n--- Part Three ---");
        // Assume the first ride in the list is the roller coaster named "Thunderbolt"
        Ride rollerCoaster = rides.get(0);

        // Add specific visitors to the queue for the roller coaster
        rollerCoaster.addVisitorToQueue(visitors.get(0));  // Add Alice to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(1));  // Add Bob to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(2));  // Add Charlie to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(3));  // Add Dave to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(4));  // Add Eve to the queue

        // Print the initial state of the queue
        System.out.println("Initial queue:");
        rollerCoaster.printQueue();

        // Remove one visitor from the front of the queue
        rollerCoaster.removeVisitorFromQueue();

        // Print the state of the queue after removing a visitor
        System.out.println("\nQueue after removing one visitor:");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        System.out.println("\n--- Part Four A ---");
        // Assume the second ride in the list is the ferris wheel named "Sky View"
        Ride ferrisWheel = rides.get(1);

        // Add specific visitors to the ride history of the ferris wheel
        ferrisWheel.addVisitorToHistory(visitors.get(0));  // Add Alice to history
        ferrisWheel.addVisitorToHistory(visitors.get(1));  // Add Bob to history
        ferrisWheel.addVisitorToHistory(visitors.get(2));  // Add Charlie to history
        ferrisWheel.addVisitorToHistory(visitors.get(3));  // Add Dave to history
        ferrisWheel.addVisitorToHistory(visitors.get(4));  // Add Eve to history

        // Check if certain visitors are in the ride history
        ferrisWheel.checkVisitorFromHistory(visitors.get(0));  // Check if Alice is in history
        ferrisWheel.checkVisitorFromHistory(visitors.get(2));  // Check if Charlie is in history

        // Print the number of visitors that have been on the ferris wheel
        ferrisWheel.numberOfVisitors();

        // Print the complete history of visitors who have been on the ferris wheel
        ferrisWheel.printRideHistory();
    }
    public void partFourB() {
        System.out.println("\n--- Part Four B ---");
        // Assume the third ride in the list is the water slide named "Splash Mountain"
        Ride waterSlide = rides.get(2);

        // Add specific visitors to the ride history of the water slide
        waterSlide.addVisitorToHistory(visitors.get(0));  // Add Alice to history
        waterSlide.addVisitorToHistory(visitors.get(1));  // Add Bob to history
        waterSlide.addVisitorToHistory(visitors.get(2));  // Add Charlie to history
        waterSlide.addVisitorToHistory(visitors.get(3));  // Add Dave to history
        waterSlide.addVisitorToHistory(visitors.get(4));  // Add Eve to history

        // Print the ride history before sorting
        System.out.println("Ride history before sorting:");
        waterSlide.printRideHistory();

        // Sort the ride history
        waterSlide.sortRideHistory();

        // Print the ride history after sorting
        System.out.println("Ride history after sorting:");
        waterSlide.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n--- Part Five ---");
        // Assume the first ride in the list is the roller coaster named "Thunderbolt"
        Ride rollerCoaster = rides.get(0);

        // Add all listed visitors to the queue for the roller coaster
        rollerCoaster.addVisitorToQueue(visitors.get(0));  // Add Alice to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(1));  // Add Bob to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(2));  // Add Charlie to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(3));  // Add Dave to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(4));  // Add Eve to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(5));  // Add Frank to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(6));  // Add Grace to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(7));  // Add Hank to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(8));  // Add Ivy to the queue
        rollerCoaster.addVisitorToQueue(visitors.get(9));  // Add Jack to the queue

        // Print the initial state of the queue
        System.out.println("Initial queue:");
        rollerCoaster.printQueue();

        // Run one cycle of the ride operation
        rollerCoaster.runOneCycle();

        // Print the state of the queue after one cycle
        System.out.println("\nQueue after one cycle:");
        rollerCoaster.printQueue();

        // Print the ride history after one cycle
        System.out.println("\nRide history after one cycle:");
        rollerCoaster.printRideHistory();
    }
    public void partSix() {
        System.out.println("\n--- Part Six ---");
        // Assume the first ride in the list is the roller coaster named "Thunderbolt"
        Ride rollerCoaster = rides.get(0);

        // Add specific visitors to the ride history of the roller coaster
        rollerCoaster.addVisitorToHistory(visitors.get(0));  // Add Alice to history
        rollerCoaster.addVisitorToHistory(visitors.get(1));  // Add Bob to history
        rollerCoaster.addVisitorToHistory(visitors.get(2));  // Add Charlie to history
        rollerCoaster.addVisitorToHistory(visitors.get(3));  // Add Dave to history
        rollerCoaster.addVisitorToHistory(visitors.get(4));  // Add Eve to history

        // Export the ride history to a CSV file
        rollerCoaster.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        System.out.println("\n--- Part Seven ---");
        // Assume the first ride in the list is the roller coaster named "Thunderbolt"
        Ride rollerCoaster = rides.get(0);

        // Import the ride history from the previously exported CSV file
        rollerCoaster.importRideHistory("ride_history.csv");

        // Print the number of visitors in the ride history
        rollerCoaster.numberOfVisitors();

        // Print all visitors in the ride history
        rollerCoaster.printRideHistory();
    }
}