public class Staff extends Individual {
    private String position;

    public Staff(String name, String position, String employeeID) {
        super(name, employeeID);  // Passing name and employeeID
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
