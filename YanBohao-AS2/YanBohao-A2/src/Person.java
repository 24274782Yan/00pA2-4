public abstract class Person {
    // Private fields to store the name, age, and unique ID of the person
    private String name;
    private int age;
    private String uniqueId;

    // Default constructor for the Person class
    public Person() {}

    // Parameterized constructor to initialize name and age
    public Person(String name, int age) {
        // Set the name of the person
        this.name = name;
        // Set the age of the person
        this.age = age;
        // Generate a unique ID for the person
        this.uniqueId = generateUniqueId();
    }

    // Private method to generate a unique ID
    private String generateUniqueId() {
        // Create a unique ID using the first two letters of the name in uppercase
        // and append a random four-digit number
        return name.substring(0, 2).toUpperCase() + String.format("%04d", (int)(Math.random() * 10000));
    }

    // Getter for the name field
    public String getName() { return name; }

    // Setter for the name field
    public void setName(String name) { this.name = name; }

    // Getter for the age field
    public int getAge() { return age; }

    // Setter for the age field
    public void setAge(int age) { this.age = age; }

    // Getter for the uniqueId field
    public String getUniqueId() { return uniqueId; }
}