public class Staff extends Individual {
    private String employeeID;

    public Staff(String name, String contactInformation, String employeeID) {
        super(name, contactInformation);
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}
