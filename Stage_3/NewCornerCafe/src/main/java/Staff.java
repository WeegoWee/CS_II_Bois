
public class Staff extends Individual {
    private String employeeID;

    public Staff(String name, String role, String employeeID) {
        super(name, role, employeeID);
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}
