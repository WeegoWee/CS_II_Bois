import java.util.ArrayList;

public class Menu {
    private ArrayList<Inventory> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItems(Inventory item) {
        items.add(item);
    }

    public void removeItems(Inventory item) {
        items.remove(item);
    }

    public void showMenu() {
        for (Inventory item : items) {
            System.out.println("Item: " + item.getItems() + " | Quantity: " + item.getTotalItems() + " | Price: " + item.getPrice());
        }
    }

    public void showInfo() {
        System.out.println("Menu Items:");
        showMenu();
    }
}
