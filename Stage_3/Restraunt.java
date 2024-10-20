/**
 *
 * @author fredp
 */
import java.util.ArrayList;
public class Restraunt extends Menu {
    private String restaurantName;
    private String location;
    private Menu menu;
    private ArrayList<Staff> staffs;
    
    public Restraunt(String restaurantName, String location, Menu menu){
        this.restaurantName = restaurantName;
        this.location = location;
        this.menu = menu;
        this.staffs = new ArrayList<>();
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
    
    public void addStaff(Staff staff){
        staffs.add(staff);
    }
    
    public void removeStaff(Staff staff){
        staffs.remove(staff);
    }
    
    @Override
    public void showInfo(){
        System.out.printf("\t%s",getRestaurantName());
        Super.getMenu();
    }
}