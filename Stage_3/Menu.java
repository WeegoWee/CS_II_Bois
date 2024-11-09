import java.util.ArrayList;

public class Menu {
    
    private ArrayList<Inventory> items;
    

    public Menu() {
        this.items = new ArrayList<>();
        
    }

    public void addItems(Inventory item) {
        items.add(item);
    }

    public void removeItems(Inventory item) {
        items.remove(item);
    }

    public ArrayList<Inventory> getItems() {
        return items;
    }

    public void showMenu() {
        for (Inventory item : items) {
            System.out.println(item.getItems() + " - $" + item.getPrice() + " (Available | " + item.getTotalItems() + ")");
        }
    }

    // Method to find an item by name
    public Inventory findItemByName(String name) {
        for (Inventory item : items) {
            if (item.getItems().equalsIgnoreCase(name)) { 
                return item;
            }
        }
        return null; 
    }
    
}
