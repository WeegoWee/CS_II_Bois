
public class Waiter {
    private String order;
    private String name;
    private String employeeID;
    private Individual contactinfo;

    public Waiter(String order, String name, String employeeID, Individual contactinfo) {
        this.order = order;
        this.name = name;
        this.employeeID = employeeID;
        this.contactinfo = contactinfo;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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
