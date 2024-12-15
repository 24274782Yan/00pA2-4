public interface RideInterface {
    // Method to add a visitor to the ride's queue
    void addVisitorToQueue(Visitor visitor);

    // Method to remove a visitor from the ride's queue
    void removeVisitorFromQueue();

    // Method to print the current queue of visitors
    void printQueue();

    // Method to simulate running one cycle of the ride
    void runOneCycle();

    // Method to add a visitor to the ride's history
    void addVisitorToHistory(Visitor visitor);

    // Method to check if a visitor is in the ride's history
    boolean checkVisitorFromHistory(Visitor visitor);

    // Method to get the number of visitors currently in the queue
    int numberOfVisitors();

    // Method to print the history of visitors who have taken the ride
    void printRideHistory();
}