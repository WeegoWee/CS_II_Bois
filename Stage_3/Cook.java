
public class Cook{
    private String name;
    private String employeeID;
    private Individual contactinfo;
    


    public Cook(String name, String employeeID, String contactInfo) {
        this.name = name;
        this.employeeID = employeeID;
        
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

    public Individual getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(Individual contactinfo) {
        this.contactinfo = contactinfo;
    }
    
    public void showInfo(){
        
    }
    
}
