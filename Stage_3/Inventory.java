//this is the Inventory class
public class Inventory {
    private String items;
    private float price;
    private short totalItems;

    //thhe inventory constructor initializes the instance variables.
    public Inventory(String items, short totalItems, float price) {
        this.items = items;
        this.totalItems = totalItems;
        this.price = price;
    }

    //this method gets the items and returns the items.
    public String getItems() {
        return items;
    }

    //this method sets the items to a items variable
    public void setItems(String items) {
        this.items = items;
    }

    //this method gets the price and returns the price
    public float getPrice() {
        return price;
    }

    //this sets the price to a price variable.
    public void setPrice(float price) {
        this.price = price;
    }

    //this method gets the tital items and returns the total items
    public short getTotalItems() {
        return totalItems;
    }

    //this sets the total items to a total items variable.
    public void setTotalItems(short totalItems) {
        this.totalItems = totalItems;
    }
}
