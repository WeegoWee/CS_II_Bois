import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private Menu menu;
    private List<Staff> staffList;

    public Restaurant(String name, String address, Menu menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
        this.staffList = new ArrayList<>();
    }

    public void showInfo() {
        System.out.println("Restaurant Name: " + name);
        System.out.println("Address: " + address);
    }

    public Menu getMenu() {
        return menu;
    }

    public List<Staff> getStaff() {
        return staffList;
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public void removeStaff(Staff staff) {
        staffList.remove(staff);
    }
}
