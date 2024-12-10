import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, Inventory> items;

    // Constructor initializes the items HashMap
    public Menu() {
        this.items = new HashMap<>();
    }

    // Adds a new item to the menu
    public void addItems(Inventory item) {
        items.put(item.getItems(), item);  // Using item name as the key
    }

    // Removes an item from the menu
    public void removeItems(Inventory item) {
        items.remove(item.getItems());  // Remove based on item name
    }

    // Gets the list of all items in the menu
    public Map<String, Inventory> getItems() {
        return items;
    }

    // Displays the menu with items, their prices, and availability
    public void showMenu() {
        for (Inventory item : items.values()) {
            System.out.println(item.getItems() + " - $" + item.getPrice() + " (Available: " + item.getTotalItems() + ")");
        }
    }

    // Finds an item by its name and returns the Inventory object
    public Inventory findItemByName(String name) {
        return items.get(name);  // Direct lookup using the name as the key
    }

    // Returns all inventory items
    public Iterable<Inventory> getInventoryItems() {
        return items.values();  // Returns a collection of all inventory items
    }
}
