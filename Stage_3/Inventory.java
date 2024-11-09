public class Inventory {
    private String items;
    private float price;
    private short totalItems;

    public Inventory(String items, short totalItems, float price) {
        this.items = items;
        this.totalItems = totalItems;
        this.price = price;
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
}
