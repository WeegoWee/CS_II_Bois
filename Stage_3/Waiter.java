
public class Waiter extends Staff{
    private Order order;
    private String name;
    private String employeeID;
    private String contactInfo;

    /**
     *
     * @param order
     * @param name
     * @param employeeID
     * @param contactInfo
     * @param name
     * @param contactInfo
     * @param employeeID
     * @param duties
     */
    public Waiter(Order order, String name, String employeeID, String contactInfo) {
        super(name, contactInfo, employeeID, duties);
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
