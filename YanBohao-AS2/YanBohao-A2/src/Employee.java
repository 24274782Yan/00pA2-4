public class Employee extends Person {
    // Private fields to store the position and years of experience of the employee
    private String position;
    private int experienceYears;

    // Default constructor for the Employee class
    public Employee() {}

    // Parameterized constructor to initialize name, age, position, and experience years
    public Employee(String name, int age, String position, int experienceYears) {
        // Call the superclass constructor to set name and age
        super(name, age);
        // Set the position of the employee
        this.position = position;
        // Set the years of experience of the employee
        this.experienceYears = experienceYears;
    }

    // Getter for the position field
    public String getPosition() { return position; }

    // Setter for the position field
    public void setPosition(String position) { this.position = position; }

    // Getter for the experienceYears field
    public int getExperienceYears() { return experienceYears; }

    // Setter for the experienceYears field
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
}