public class Inventory {
    private String items;
    private float price;
    private short totalItems;

    // Constructor initializes the item properties
    public Inventory(String items, short totalItems, float price) {
        this.items = items;
        this.totalItems = totalItems;
        this.price = price;
    }

    // Getter for item name
    public String getItems() {
        return items;
    }

    // Setter for item name
    public void setItems(String items) {
        this.items = items;
    }

    // Getter for price
    public float getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(float price) {
        this.price = price;
    }

    // Getter for total items
    public short getTotalItems() {
        return totalItems;
    }

    // Setter for total items
    public void setTotalItems(short totalItems) {
        this.totalItems = totalItems;
    }

}
