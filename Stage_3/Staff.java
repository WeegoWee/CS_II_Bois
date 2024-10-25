
public class Staff extends Individual{
    private String employeeID;
    private String duties;
    
    public Staff(String name, String contactInfo, String employeeID, String duties) {
        super(name, contactInfo);
        this.employeeID = employeeID;
        this.duties = duties;
    }
    

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }
    
    
    
}
