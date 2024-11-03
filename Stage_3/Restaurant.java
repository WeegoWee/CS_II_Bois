import java.util.ArrayList;

public class Restaurant {
    private String restaurantName;
    private String location;
    private Menu menu;
    public ArrayList<Staff> staff;

    public Restaurant(String restaurantName, String location, Menu menu) {
        this.restaurantName = restaurantName;
        this.location = location;
        this.menu = menu;
        this.staff = new ArrayList<>();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void addStaff(Staff staff) {
        this.staff.add(staff);
    }

    public void removeStaff(Staff staff) {
        this.staff.remove(staff);
    }

    public void showInfo() {
        System.out.println("Restaurant: " + restaurantName + ", Location: " + location);
    }
    
    public ArrayList<Staff> getStaff() {
        return staff;
    }

}
