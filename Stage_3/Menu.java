import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Inventory> items;
    private Restaurant restaurant;

    public Menu() {
        this.items = new ArrayList<>();
        this.restaurant = restaurant;
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
    
     public void addMenuItem() {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter food quantity: ");
        short totalItems = scanner.nextShort();
        System.out.print("Enter price for the item: ");
        float price = scanner.nextFloat();
        scanner.nextLine(); 

        Inventory newItem = new Inventory(itemName, totalItems, price);
        restaurant.getMenu().addItems(newItem);
        System.out.println("Item added successfully.");
    }
    
    /**
     * this method removes items from the inventory list
     */
    public void removeMenuItem() {
        System.out.print("Enter item name to remove: ");
        String itemName = scanner.nextLine();

        for (Inventory item : restaurant.getMenu().getItems()) {
            if (item.getItems().equals(itemName)) {
                restaurant.getMenu().removeItems(item);
                System.out.println("Item removed successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void showMenus() {
        System.out.println("Current Menu:");
        restaurant.getMenu().showMenu();
    }
}
