public class Cook {
    private OrderSystem order;
    private String name;
    private Staff employeeID;
    private Individual contactInfo;

    public Cook(OrderSystem order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeID() {
        return employeeID.getEmployeeID();
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

    public void prepareFood() {
        // Implementation for preparing food
    }

    public void showInfo() {
        System.out.println("Cook: " + name + ", Employee ID: " + employeeID.getEmployeeID());
    }
}

