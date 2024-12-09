import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, Item> items; // Maps item names to their details

    public Menu() {
        this.items = new HashMap<>();
    }

    public void addItem(String itemName, float price, short totalItems) {
        if (items.containsKey(itemName)) {
            System.out.println("Item already exists. Updating stock.");
            updateStock(itemName, totalItems);
        } else {
            items.put(itemName, new Item(itemName, price, totalItems));
            System.out.println("Item added: " + itemName);
        }
    }

    public void removeItem(String itemName) {
        if (items.remove(itemName) != null) {
            System.out.println("Item removed: " + itemName);
        } else {
            System.out.println("Item not found: " + itemName);
        }
    }

    public void showMenu() {
        if (items.isEmpty()) {
            System.out.println("Menu is empty.");
        } else {
            for (Item item : items.values()) {
                System.out.println(item.getName() + " - $" + item.getPrice() + " (Available: " + item.getTotalItems() + ")");
            }
        }
    }

    public void updateStock(String itemName, short newStock) {
        Item item = items.get(itemName);
        if (item != null) {
            item.setTotalItems(newStock);
            System.out.println("Stock updated: " + itemName);
        } else {
            System.out.println("Item not found: " + itemName);
        }
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public static class Item {
        private String name;
        private float price;
        private short totalItems;

        public Item(String name, float price, short totalItems) {
            this.name = name;
            this.price = price;
            this.totalItems = totalItems;
        }

        public String getName() {
            return name;
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
    }
}
