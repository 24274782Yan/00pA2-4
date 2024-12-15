public class Visitor extends Person {
    // Private fields to store whether the visitor has a pass and their happiness level
    private boolean hasPass;
    private int happinessLevel;

    // Default constructor for the Visitor class
    public Visitor() {}

    // Parameterized constructor to initialize name, age, and pass status
    public Visitor(String name, int age, boolean hasPass) {
        // Call the superclass constructor to set name and age
        super(name, age);
        // Set whether the visitor has a pass
        this.hasPass = hasPass;
        // Initialize the happiness level to a default value of 50
        this.happinessLevel = 50;
    }

    // Getter for the hasPass field
    public boolean isHasPass() { return hasPass; }

    // Setter for the hasPass field
    public void setHasPass(boolean hasPass) { this.hasPass = hasPass; }

    // Getter for the happinessLevel field
    public int getHappinessLevel() { return happinessLevel; }

    // Setter for the happinessLevel field
    public void setHappinessLevel(int happinessLevel) { this.happinessLevel = happinessLevel; }

    // Method to set a unique ID (currently does nothing)
    public void setUniqueId(String uniqueId) {
        // This method is intentionally left blank
    }
}