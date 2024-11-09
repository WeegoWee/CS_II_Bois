import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the Restaurant method 
 * @author CSII BOIS
 */
public class Restaurant {
    static Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private Menu menu;
    private List<Staff> staffList;

    /**
     * this constructor initializes the instance variables
     * @param name
     * @param address
     * @param menu 
     */
    public Restaurant(String name, String address, Menu menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
        this.staffList = new ArrayList<>();
    }

    /**
     * this method shows the restaurant information when the option is chosen
     * from the initial menu
     */
    public void showInfo() {
        System.out.println("Restaurant Name: " + name);
        System.out.println("Address: " + address);
    }

    /**
     * this gets the menu
     * @return menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * this method gets the staff and returns
     * @return staff
     */
    public List<Staff> getStaff() {
        return staffList;
    }

    /**
     * this method adds staff members to the staff list
     * @param staff 
     */
    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    /**
     * this method removes staff members from the list
     * @param staff 
     */
    public void removeStaff(Staff staff) {
        staffList.remove(staff);
    }
    
    /**
     * This method received the the staff list from the restaurant class and displays it
     */
    public void viewStaffMembers() {
        System.out.println("\nCurrent Staff:");
        if (getStaff().isEmpty()) {
            System.out.println("No staff members found.");
        } else {
            for (Staff staff : getStaff()) {
                System.out.println("Name | " + staff.getName() + ", Role | " + staff.getContactInformation() + ", ID | " + staff.getEmployeeID());
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
        addStaff(newStaff);
        System.out.println("Staff member added successfully.");
    }

    /**
     * This method removes a staff member from the staff member list
     */
    public void removeStaffMember() {
        System.out.print("Enter staff ID to remove: ");
        String employeeID = scanner.nextLine();

        Staff toRemove = null;
        for (Staff staff : getStaff()) {
            if (staff.getEmployeeID().equals(employeeID)) {
                toRemove = staff;
                break;
            }
        }

        if (toRemove != null) {
            removeStaff(toRemove);
            System.out.println("Staff member removed successfully.");
        } else {
            System.out.println("Staff member not found.");
        }
    }
}
