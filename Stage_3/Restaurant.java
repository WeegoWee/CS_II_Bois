import java.util.ArrayList;
import java.util.List;
/**
 * This is the Restaurant method 
 * @author CSII BOIS
 */
public class Restaurant {
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
}
