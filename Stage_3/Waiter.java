
public class Waiter extends Individual{
    private Order order;
    private String name;
    private String employeeID;
    private String contactInfo;

    public Waiter(Order order, String name, String employeeID, String contactInfo) {
        super(name, contactInfo);
        this.order = order;
        this.name = name;
        this.employeeID = employeeID;
        this.contactInfo = contactInfo;
    }
   
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    
    
}
