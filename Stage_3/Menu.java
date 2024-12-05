import java.util.ArrayList;
import java.util.HashMap;
//this is the menu class
public class Menu {
    private ArrayList<Inventory> items;
    private HashMap<String, Double> price;
    

    //the constructor initializes the array list
    public Menu() {
        this.price = new HashMap<>();
        this.items = new ArrayList<>();
        
    }
    
    public void addPrices()
    {
        
    }

    //this methd adds new items to the list
    public void addItems(Inventory item) {
        items.add(item);
    }

    //this method removes items from the list
    public void removeItems(Inventory item) {
        items.remove(item);
    }

    //this method gets the items from the array list
    public ArrayList<Inventory> getItems(String item) {
        return items;
    }

    //this method prints the menu
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
