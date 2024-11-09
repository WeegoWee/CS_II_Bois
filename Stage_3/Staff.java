
import java.util.Scanner;

public class Staff extends Individual {
    static Scanner scanner = new Scanner(System.in);
    private String employeeID;
    private Restaurant restaurant;

    public Staff(String name, String contactInformation, String employeeID, Restaurant restaurant) {
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
     public void viewStaffMembers() {
        System.out.println("\nCurrent Staff:");
        if (restaurant.getStaff().isEmpty()) {
            System.out.println("No staff members found.");
        } else {
            for (Staff staff : restaurant.getStaff()) {
                System.out.println("Name | " + staff.getName() + ", Role | " + staff.getContactInformation() + ", ID | " + staff.getEmployeeID());
            }
        }
    }

    public void addStaffMember() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        System.out.print("Enter staff ID: ");
        String employeeID = scanner.nextLine();

        Staff newStaff = new Staff(name, role, employeeID, restaurant);
        restaurant.addStaff(newStaff);
        System.out.println("Staff member added successfully.");
    }

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
