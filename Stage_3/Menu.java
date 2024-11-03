import java.util.ArrayList;

public class Menu{
    private ArrayList<Inventory> items;

    public Menu(){
        items = new ArrayList<>();
    }

    public void addItems(Inventory item) {
        items.add(item);
    }

    public void removeItems(Inventory item) {
        items.remove(item);
    }

    public void showMenu(){
        for (Inventory item : items) {
            System.out.println("Food: " + item.getFood() + ", Drink: " + item.getDrink());
        }
    }

    public void showInfo(){
        System.out.println("Menu Information:");
        for (Inventory item : items) {
            System.out.println("Food: " + item.getFood() + ", Quantity: " + item.getTotalFood());
            System.out.println("Drink: " + item.getDrink() + ", Quantity: " + item.getTotalDrink());
        }
    }
}