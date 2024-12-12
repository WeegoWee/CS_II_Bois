public abstract class Individual {
    private String name;
    private String employeeID;  // Optional, only for Staff

    // Constructor for individuals with employeeID (e.g., Staff)
    public Individual(String name, String employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    // Constructor for individuals without employeeID (e.g., Customer)
    public Individual(String name) {
        this.name = name;
        this.employeeID = null;  // No employeeID for non-staff individuals
    }

    public String getName() {
        return name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}
