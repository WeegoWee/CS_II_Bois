import java.util.ArrayList;

public class Menu {
    private ArrayList<Inventory> items;

    // Constructor initializes the items ArrayList
    public Menu() {
        this.items = new ArrayList<>();
    }

    // Adds a new item to the menu
    public void addItems(Inventory item) {
        items.add(item);
    }

    // Removes an item from the menu
    public void removeItems(Inventory item) {
        items.remove(item);
    }

    // Gets the list of all items in the menu
    public ArrayList<Inventory> getItems() {
        return items;
    }

    // Displays the menu with items, their prices, and availability
    public void showMenu() {
        for (Inventory item : items) {
            System.out.println(item.getItems() + " - $" + item.getPrice() + " (Available: " + item.getTotalItems() + ")");
        }
    }

    // Finds an item by its name and returns the Inventory object
    public Inventory findItemByName(String name) {
        for (Inventory item : items) {
            if (item.getItems().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // Return null if no item found
    }
}
