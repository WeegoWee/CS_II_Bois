public class Waiter {
    private Order order;
    private String name;
    private Staff employeeID;
    private Individual contactInfo;

    public Waiter(String name, Staff employeeID, Individual contactInfo, Order order) {
        this.name = name;
        this.employeeID = employeeID;
        this.contactInfo = contactInfo;
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public Staff getEmployeeID() {
        return employeeID;
    }

    public Individual getContactInfo() {
        return contactInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeID(Staff employeeID) {
        this.employeeID = employeeID;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setContactInfo(Individual contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void showInfo() {
        System.out.println("Waiter: " + name + ", Employee ID: " + employeeID.getEmployeeID());
    }
}
