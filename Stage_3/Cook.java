
public class Cook extends Individual{
    private String order;
    private String name;
    private String employeeID;
    private Individual contactinfo;
    
    public Cook(String name, String contactInfo) {
        super(name, contactInfo);
    }

    public Cook(String order, String name, String employeeID, String contactInfo) {
        super(name, contactInfo);
        this.order = order;
        this.name = name;
        this.employeeID = employeeID;
        
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
