
public class Waiter{
    private String name;
    private String employeeID;
    private String contactInfo;

    public Waiter(String name, String employeeID, String contactInfo) {
        
        this.name = name;
        this.employeeID = employeeID;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    public void showInfo()
    {
        
    }
    
}
