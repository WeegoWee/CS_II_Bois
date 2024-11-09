import java.util.Scanner;

public class Staff extends Individual {
    static Scanner scanner = new Scanner(System.in);
    private String employeeID;
    private Restaurant restaurant;

    public Staff(String name, String contactInformation, String employeeID) {
        super(name, contactInformation);
        this.employeeID = employeeID;
        this.restaurant = restaurant;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
}
