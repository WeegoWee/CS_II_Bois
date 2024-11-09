import java.util.Scanner;

public class Order {
    static Scanner scanner = new Scanner(System.in);
    private String orderID;
    private Customer customer;
    private Inventory inventory;
    private Restaurant restaurant;

    public Order(String orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
    }

    public void addOrder(Menu items) {
        // Implementation for adding items to the order
    }

    public void showInfo() {
        System.out.println("Order ID: " + orderID + ", Customer: " + customer.getName());
    }
}
