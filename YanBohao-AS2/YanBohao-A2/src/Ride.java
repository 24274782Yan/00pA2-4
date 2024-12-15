import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ride implements RideInterface {
    // Private fields for storing the name of the ride, minimum age required, energy requirement,
    // minimum experience required for the operator, the current operator, operational status,
    // queue of visitors waiting for the ride, history of visitors who have taken the ride,
    // maximum number of riders per cycle, and the number of cycles the ride has run
    private String name;
    private int minimumAge;
    private int energyRequirement;
    private int minimumExperienceRequired;
    private Employee currentOperator;
    private boolean isOperational;
    private Queue<Visitor> visitorQueue;
    private List<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    // Default constructor that initializes a new Ride object with default values
    public Ride() {}

    // Parameterized constructor that initializes a new Ride object with specified values
    public Ride(String name, int minimumAge, int energyRequirement, int minimumExperienceRequired, int maxRider) {
        this.name = name; // Set the name of the ride
        this.minimumAge = minimumAge; // Set the minimum age required to ride
        this.energyRequirement = energyRequirement; // Set the energy requirement for the ride
        this.minimumExperienceRequired = minimumExperienceRequired; // Set the minimum experience required for the operator
        this.isOperational = false; // Initialize the ride as not operational
        this.visitorQueue = new LinkedList<>(); // Initialize the queue for visitors
        this.rideHistory = new LinkedList<>(); // Initialize the history list for visitors
        this.maxRider = maxRider; // Set the maximum number of riders per cycle
        this.numOfCycles = 0; // Initialize the number of cycles to zero
    }

    // Method to assign an operator to the ride
    public void assignOperator(Employee employee) {
        // Check if the employee has enough experience to operate the ride
        if (employee.getExperienceYears() >= minimumExperienceRequired) {
            this.currentOperator = employee; // Assign the employee as the current operator
            this.isOperational = true; // Set the ride to operational
        } else {
            // Print a message if the employee does not meet the experience requirement
            System.out.println(employee.getName() + " is not qualified to operate " + this.name);
        }
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        // Add a visitor to the queue for the ride
        visitorQueue.offer(visitor);
        // Print a message indicating that the visitor has been added to the queue
        System.out.println(visitor.getName() + " added to the queue for " + name);
    }

    // Additional methods for RideInterface would be implemented here

    @Override
    public void removeVisitorFromQueue() {
        // Attempt to remove the first visitor from the queue
        Visitor removedVisitor = visitorQueue.poll();
        // Check if a visitor was removed
        if (removedVisitor != null) {
            // Print the name of the removed visitor
            System.out.println(removedVisitor.getName() + " removed from the queue for " + name);
        } else {
            // Print a message if the queue was empty
            System.out.println("Queue is empty for " + name);
        }
    }

    @Override
    public void printQueue() {
        // Print the header for the list of visitors in the queue
        System.out.println("Visitors in queue for " + name + ":");
        // Iterate over each visitor in the queue
        for (Visitor visitor : visitorQueue) {
            // Print the name of each visitor
            System.out.print(visitor.getName()+ "---");
        }
    }

    @Override
    public void runOneCycle() {
        // Check if the ride is operational
        if (!isOperational) {
            // Print a message if no operator is assigned
            System.out.println(name + " cannot run a cycle because no operator is assigned.");
            return;
        }

        // Check if the queue is empty
        if (visitorQueue.isEmpty()) {
            // Print a message if the queue is empty
            System.out.println(name + " cannot run a cycle because the queue is empty.");
            return;
        }

        // Determine the number of riders for this cycle
        int riders = Math.min(maxRider, visitorQueue.size());
        // Loop over the number of riders
        for (int i = 0; i < riders; i++) {
            // Remove a visitor from the queue
            Visitor visitor = visitorQueue.poll();
            // Add the visitor to the ride history
            addVisitorToHistory(visitor);
            // Print a message indicating the visitor has ridden the ride
            System.out.println(visitor.getName() + " has ridden " + name);
        }

        // Increment the number of cycles the ride has run
        numOfCycles++;
        // Print a message indicating the ride has completed a cycle
        System.out.println(name + " has run one cycle. Total cycles: " + numOfCycles);
    }
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Add the visitor to the ride history list
        rideHistory.add(visitor);
        // Print a message indicating the visitor has been added to the ride history
        System.out.println(visitor.getName() + " added to the ride history for " + name);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // Check if the visitor is present in the ride history
        boolean found = rideHistory.contains(visitor);
        // Print a message indicating whether the visitor is in the ride history
        System.out.println(visitor.getName() + " is " + (found ? "" : "not ") + "in the ride history for " + name);
        // Return the result of the check
        return found;
    }

    @Override
    public int numberOfVisitors() {
        // Get the number of visitors in the ride history
        int count = rideHistory.size();
        // Print the number of visitors in the ride history
        System.out.println("Number of visitors in the ride history for " + name + ": " + count);
        // Return the count of visitors
        return count;
    }

    @Override
    public void printRideHistory() {
        // Print the header for the ride history
        System.out.println("Ride history for " + name + ":");
        // Create an iterator for the ride history list
        Iterator<Visitor> iterator = rideHistory.iterator();
        // Iterate through the ride history
        while (iterator.hasNext()) {
            // Print the name of each visitor in the history
            System.out.print(iterator.next().getName()+ "--");
        }
    }

    public void sortRideHistory() {
        // Sort the ride history using a custom comparator
        Collections.sort(rideHistory, new VisitorComparator());
        // Print a message indicating the ride history has been sorted
        System.out.println("Ride history for " + name + " has been sorted.");
    }

    public void exportRideHistory(String fileName) {
        // Use a FileWriter to export the ride history to a file
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write the CSV header to the file
            writer.write("Name,Age,HappinessLevel,UniqueId\n");

            // Iterate over each visitor in the ride history
            for (Visitor visitor : rideHistory) {
                // Write each visitor's details as a CSV row
                writer.write(visitor.getName() + ",");
                writer.write(visitor.getAge() + ",");
                writer.write(visitor.getHappinessLevel() + ",");
                writer.write(visitor.getUniqueId() + "\n");
            }
            // Print a message indicating the ride history has been exported
            System.out.println("Ride history for " + name + " has been exported to " + fileName);
        } catch (IOException e) {
            // Print an error message if there was an issue exporting the ride history
            System.out.println("An error occurred while exporting ride history: " + e.getMessage());
        }
    }
    public void importRideHistory(String fileName) {
        // Use a stream to read lines from the specified file
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            // Skip the first line (CSV header) and process each subsequent line
            stream.skip(1).forEach(line -> {
                // Split the line into parts using a comma as the delimiter
                String[] parts = line.split(",");
                // Check if there are exactly 4 parts in the line
                if (parts.length == 4) {
                    // Extract and parse each part of the line into variables
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    int happinessLevel = Integer.parseInt(parts[2]);
                    String uniqueId = parts[3];
                    // Create a new Visitor object with the extracted data
                    Visitor visitor = new Visitor(name, age, false);
                    // Set additional properties of the visitor
                    visitor.setHappinessLevel(happinessLevel);
                    visitor.setUniqueId(uniqueId);
                    // Add the visitor to the ride history
                    addVisitorToHistory(visitor);
                }
            });
            // Print a message indicating the ride history has been imported
            System.out.println("Ride history for " + name + " has been imported from " + fileName);
        } catch (IOException e) {
            // Print an error message if there was an issue importing the ride history
            System.out.println("An error occurred while importing ride history: " + e.getMessage());
        }
    }

    // Getters and setters for various attributes of the class
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getMinimumAge() { return minimumAge; }
    public void setMinimumAge(int minimumAge) { this.minimumAge = minimumAge; }
    public int getEnergyRequirement() { return energyRequirement; }
    public void setEnergyRequirement(int energyRequirement) { this.energyRequirement = energyRequirement; }
    public int getMinimumExperienceRequired() { return minimumExperienceRequired; }
    public void setMinimumExperienceRequired(int minimumExperienceRequired) { this.minimumExperienceRequired = minimumExperienceRequired; }
    public Employee getCurrentOperator() { return currentOperator; }
    public void setCurrentOperator(Employee currentOperator) { this.currentOperator = currentOperator; }
    public boolean isOperational() { return isOperational; }
    public void setOperational(boolean operational) { isOperational = operational; }
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    public int getNumOfCycles() { return numOfCycles; }
    public void setNumOfCycles(int numOfCycles) { this.numOfCycles = numOfCycles; }
}