import java.util.ArrayList;
//this is the menu class
public class Menu {
    
    private ArrayList<Inventory> items;
    

    //the constructor initializes the array list
    public Menu() {
        this.items = new ArrayList<>();
        
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
    public ArrayList<Inventory> getItems() {
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
