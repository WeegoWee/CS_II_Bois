public abstract class Individual {
    private String name;
    private String role;
    private String employeeID;  // This will be optional for non-Staff subclasses

    // Constructor for individuals with an employeeID (e.g., Staff)
    public Individual(String name, String role, String employeeID) {
        this.name = name;
        this.role = role;
        this.employeeID = employeeID;
    }

    // Constructor for individuals without an employeeID (e.g., Customer)
    public Individual(String name, String role) {
        this.name = name;
        this.role = role;
        this.employeeID = null;  // No employeeID for non-staff individuals
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}
