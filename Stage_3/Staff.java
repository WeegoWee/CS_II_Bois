
import java.util.Scanner;
//This is the staff class that extend the Individual class
public class Staff extends Individual {
    static Scanner scanner = new Scanner(System.in);
    private String employeeID;
    private Restaurant restaurant;

    public Staff(String name, String role, String employeeID) {
        super(name, role);
        this.employeeID = employeeID;
        this.restaurant = restaurant;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    /**
     * This method received the the staff list from the restaurant class and displays it
     */
    public void viewStaffMembers() {
        System.out.println("\nCurrent Staff:");
        if (restaurant.getStaff().isEmpty()) {
            System.out.println("No staff members found.");
        } else {
            for (Staff staff : restaurant.getStaff()) {
                System.out.println("Name | " + staff.getName() + ", Role | " + staff.getRole() + ", ID | " + staff.getEmployeeID());
            }
        }
    }

    /**
     * This method adds a staff member to the database of staff members
     */
    public void addStaffMember() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        System.out.print("Enter staff ID: ");
        String employeeID = scanner.nextLine();

        Staff newStaff = new Staff(name, role, employeeID);
        restaurant.addStaff(newStaff);
        System.out.println("Staff member added successfully.");
    }

    /**
     * This method removes a staff member from the staff member list
     */
    public void removeStaffMember() {
        System.out.print("Enter staff ID to remove: ");
        String employeeID = scanner.nextLine();

        Staff toRemove = null;
        for (Staff staff : restaurant.getStaff()) {
            if (staff.getEmployeeID().equals(employeeID)) {
                toRemove = staff;
                break;
            }
        }

        if (toRemove != null) {
            restaurant.removeStaff(toRemove);
            System.out.println("Staff member removed successfully.");
        } else {
            System.out.println("Staff member not found.");
        }
    }
}
