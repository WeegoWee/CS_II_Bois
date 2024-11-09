import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderSystem {
    private static int orderCounter = 0; // Static counter for unique order numbers
    private HashMap<String, ArrayList<Order>> orders; // Map to hold orders by table ID
    private Menu menu; // Reference to the Menu to check available items
    private Scanner scanner;

    // Nested Order class to represent individual orders
    private class Order {
        private final int orderNumber;
        private final String itemName;
        private final int quantity;
        private final LocalTime orderTime;
        private final LocalDate orderDate;

        public Order(String itemName, int quantity) {
            this.orderNumber = ++orderCounter; // Generate a unique order number
            this.itemName = itemName;
            this.quantity = quantity;
            this.orderTime = LocalTime.now(); // Record time the order was placed
            this.orderDate = LocalDate.now(); // Record date the order was placed
            
        }

        public int getOrderNumber() {
            return orderNumber;
        }

        public String getItemName() {
            return itemName;
        }

        public int getQuantity() {
            return quantity;
        }
        
        public String dateFormat(){
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
 
            return orderDate.format(dateFormatter);
        }
        public String timeFormat(){
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            return orderTime.format(timeFormatter);
        }

        @Override
        public String toString() {
            return "Order #" + orderNumber + ": " + quantity + " x " + itemName + " (Ordered at: " + timeFormat() + " on " + dateFormat() + ")";
        }
    }

    // Constructor
    public OrderSystem(Menu menu) {
        this.orders = new HashMap<>();
        this.menu = menu;
        this.scanner = new Scanner(System.in);
    }

    // Method to place an order
    public void placeOrder() {
        System.out.println("Available Menu Items:");
        menu.showMenu(); // Display available menu items

        System.out.print("Enter the table ID for the order: ");
        String tableID = scanner.nextLine();
        
        System.out.print("Enter the name of the item to order: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Inventory itemToOrder = menu.findItemByName(itemName);
        if (itemToOrder != null && itemToOrder.getTotalItems() >= quantity) {
            itemToOrder.setTotalItems((short) (itemToOrder.getTotalItems() - quantity)); // Deduct quantity from stock
            addToOrder(tableID, itemToOrder, quantity); // Call the method to add the order
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Item not available or insufficient stock.");
        }
    }

    // Method to add an order to a specific table
    public void addToOrder(String tableID, Inventory itemToOrder, int quantity) {
        Order newOrder = new Order(itemToOrder.getItems(), quantity); // Create new order
        orders.computeIfAbsent(tableID, k -> new ArrayList<>()).add(newOrder); // Add order to the table's list
    }

    // Method to view current orders
    public void viewOrders() {
        System.out.print("Enter table ID to view orders: ");
        String tableID = scanner.nextLine();

        ArrayList<Order> tableOrders = orders.get(tableID);
        if (tableOrders == null || tableOrders.isEmpty()) {
            System.out.println("No orders found for table " + tableID + ".");
        } else {
            System.out.println("Current Orders for table " + tableID + ":");
            for (Order order : tableOrders) {
                System.out.println(order);
            }
        }
    }

    // Method to calculate the total for a given table ID
    public double calculateTotal(String tableID) {
        ArrayList<Order> tableOrders = orders.get(tableID);
        double total = 0;

        if (tableOrders != null) {
            for (Order order : tableOrders) {
                Inventory item = menu.findItemByName(order.getItemName());
                if (item != null) {
                    total += item.getPrice() * order.getQuantity(); // Calculate total based on item price and quantity
                }
            }
        }
        return total;
    }

    // Method to make payment
    public void makePayment() {
        System.out.print("Enter table ID for payment: ");
        String tableID = scanner.nextLine();

        double totalAmount = calculateTotal(tableID);
        if (totalAmount > 0) {
            System.out.printf("Total amount due for table %s: $%.2f\n", tableID, totalAmount);

            System.out.println("Choose payment method:");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            int paymentChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (paymentChoice) {
                case 1:
                    System.out.print("Enter amount received: ");
                    double cashReceived = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (cashReceived >= totalAmount) {
                        CashPayment cashPayment = new CashPayment((float) totalAmount, tableID);
                        cashPayment.paymentDetails();
                        double change = cashReceived - totalAmount;
                        System.out.printf("Payment successful. Change: $%.2f\n", change);
                        clearOrder(tableID);
                    } else {
                        System.out.println("Insufficient payment. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Card Number: ");
                    String cardNumber = scanner.nextLine();
                    System.out.print("Enter Expiration Date (MM/YY): ");
                    String expirationDate = scanner.nextLine();
                    CreditCardPayment cardPayment = new CreditCardPayment((float) totalAmount, cardNumber, expirationDate);
                    cardPayment.paymentDetails();
                    clearOrder(tableID);
                    System.out.println("Payment successful.");
                    break;

                default:
                    System.out.println("Invalid payment method. Please try again.");
                    break;
            }
        } else {
            System.out.println("No orders found for table " + tableID);
        }
    }

    // Method to remove an order
    public void removeOrder() {
        System.out.print("Enter the table ID of the order to remove: ");
        String tableID = scanner.nextLine();
        
        ArrayList<Order> tableListOrders = orders.get(tableID);
        if (tableListOrders == null || tableListOrders.isEmpty()) {
            System.out.println("No orders found for table " + tableID + ".");
        } else {
            System.out.println("Current Orders for table " + tableID + ":");
            for (Order order : tableListOrders) {
                System.out.println(order);
            }
        }
       
        System.out.print("Enter the order number to remove: ");
        int orderNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ArrayList<Order> tableOrders = orders.get(tableID);
        if (tableOrders != null) {
            Order toRemove = null;
            for (Order order : tableOrders) {
                if (order.getOrderNumber() == orderNumber) {
                    toRemove = order;
                    break;
                }
            }

            if (toRemove != null) {
                tableOrders.remove(toRemove);
                System.out.println("Order removed successfully: " + toRemove);
            } else {
                System.out.println("Order not found.");
            }
        } else {
            System.out.println("No orders found for table " + tableID);
        }
    }

    // Method to clear orders for a given table ID
    public void clearOrder(String tableID) {
        orders.remove(tableID); // Remove all orders for the specified table ID
        System.out.println("All orders cleared for table " + tableID + ".");
    }
}
