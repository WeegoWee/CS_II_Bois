import java.util.Scanner;

public class Inventory {
    static Scanner scanner = new Scanner(System.in);
    private String items;
    private float price;
    private short totalItems;
    private Restaurant restaurant;

    public Inventory(String items, short totalItems, float price) {
        this.items = items;
        this.totalItems = totalItems;
        this.price = price;
        this.restaurant = restaurant;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public short getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(short totalItems) {
        this.totalItems = totalItems;
    }
    
    /**
     * This method adds items to the inventory list
     */
//    public void addMenuItem() {
//        System.out.print("Enter item name: ");
//        String itemName = scanner.nextLine();
//        System.out.print("Enter food quantity: ");
//        short totalItems = scanner.nextShort();
//        System.out.print("Enter price for the item: ");
//        float price = scanner.nextFloat();
//        scanner.nextLine(); 
//
//        Inventory newItem = new Inventory(itemName, totalItems, price);
//        restaurant.getMenu().addItems(newItem);
//        System.out.println("Item added successfully.");
//    }
//    
//    /**
//     * this method removes items from the inventory list
//     */
//    public void removeMenuItem() {
//        System.out.print("Enter item name to remove: ");
//        String itemName = scanner.nextLine();
//
//        for (Inventory item : restaurant.getMenu().getItems()) {
//            if (item.getItems().equals(itemName)) {
//                restaurant.getMenu().removeItems(item);
//                System.out.println("Item removed successfully.");
//                return;
//            }
//        }
//        System.out.println("Item not found.");
//    }
//
//    public void showMenu() {
//        System.out.println("Current Menu:");
//        restaurant.getMenu().showMenu();
//    }
}
