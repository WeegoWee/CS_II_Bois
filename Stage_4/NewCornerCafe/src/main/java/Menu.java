import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Menu {
    private Map<String, Inventory> items;
    private Consumer<Inventory> itemAddedListener;

    // Constructor initializes the items HashMap
    public Menu() {
        this.items = new HashMap<>();
    }

    // Adds a new item to the menu and notifies the listener
    public void addItems(Inventory item) {
        items.put(item.getItems(), item); // Using item name as the key
        if (itemAddedListener != null) {
            itemAddedListener.accept(item);
        }
    }

    // Removes an item from the menu
    public void removeItems(Inventory item) {
        items.remove(item.getItems());
    }

    // Registers a listener to be notified when a new item is added
    public void setItemAddedListener(Consumer<Inventory> listener) {
        this.itemAddedListener = listener;
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

    public Inventory findItemByName(String itemName) {
    return items.get(itemName);  // Returns the Inventory object associated with the item name
}
}
