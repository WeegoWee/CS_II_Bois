
public class Staff extends Individual{
    private String employeeID;
    
    public Staff(String name, String contactInformation) {
        super(name, contactInformation);
    }
    
    public void duties(){
        
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
}
