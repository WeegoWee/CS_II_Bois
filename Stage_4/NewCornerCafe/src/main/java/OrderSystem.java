import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderSystem {
    private static int orderCounter = 0; // Static counter for unique order numbers
    private HashMap<String, ArrayList<Order>> orders; // Map to hold orders by table ID
    private HashMap<String, Integer> itemsSold; // Track each item and its quantity sold
    private Menu menu; // Reference to the Menu to check available items
    private Scanner scanner;
    private PointSystem pointSystem; // Reference to the PointSystem for customer rewards
    
    // Sales tracking variables
    private double totalSales = 0;
    private int totalOrders = 0;
    private int totalItemsSold = 0;

    // Constructor
    public OrderSystem(Menu menu) {
        this.orders = new HashMap<>();
        this.menu = menu;
        this.scanner = new Scanner(System.in);
        this.pointSystem = new PointSystem();
        this.itemsSold = new HashMap<>();
    }
    public OrderSystem(){
        
    }

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
            this.orderTime = LocalTime.now(); 
            this.orderDate = LocalDate.now(); 
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

        public String dateFormat() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            return orderDate.format(dateFormatter);
        }

        public String timeFormat() {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            return orderTime.format(timeFormatter);
        }

        @Override
        public String toString() {
            return "Order #" + orderNumber + ": " + quantity + " x " + itemName + " (Ordered at: " + timeFormat() + " on " + dateFormat() + ")";
        }
    }

    // Method to place an order
    public void placeOrder() {
        System.out.println("Available Menu Items:");
        menu.showMenu(); 

        System.out.print("Enter the table ID for the order: ");
        String tableID = scanner.nextLine();
        
        System.out.print("Enter the name of the item to order: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        Inventory itemToOrder = menu.findItemByName(itemName);
        if (itemToOrder != null && itemToOrder.getTotalItems() >= quantity) {
            itemToOrder.setTotalItems((short) (itemToOrder.getTotalItems() - quantity)); 
            addToOrder(tableID, itemToOrder, quantity); 
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Item not available or insufficient stock.");
        }
    }

    // Method to add an order to a specific table
    private void addToOrder(String tableID, Inventory itemToOrder, int quantity) {
        Order newOrder = new Order(itemToOrder.getItems(), quantity); 
        orders.computeIfAbsent(tableID, k -> new ArrayList<>()).add(newOrder); 
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
                    total += item.getPrice() * order.getQuantity(); 
                }
            }
        }
        return total;
    }

    // Method to generate a sales report
    public void generateSalesReport() {
        System.out.println("************* Sales Report *************");
        System.out.println("Total Orders: " + totalOrders);
        System.out.println("Total Items Sold: " + totalItemsSold);
        System.out.printf("Total Sales: $%.2f\n", totalSales);
        System.out.println("\nItems Sold:");

        for (String itemName : itemsSold.keySet()) {
            System.out.println("- " + itemName + ": " + itemsSold.get(itemName) + " units");
        }

        System.out.println("****************************************");
    }

    // Method to update sales tally
    private void updateSalesTally(String tableID) {
        ArrayList<Order> tableOrders = orders.get(tableID);
        if (tableOrders != null) {
            for (Order order : tableOrders) {
                Inventory item = menu.findItemByName(order.getItemName());
                if (item != null) {
                    totalSales += item.getPrice() * order.getQuantity(); 
                    totalOrders++; 
                    totalItemsSold += order.getQuantity(); 

                    // Update the itemsSold map
                    itemsSold.put(order.getItemName(), 
                    itemsSold.getOrDefault(order.getItemName(), 0) + order.getQuantity());
                }
            }
        }
    }

    // Method to make payment
    public void makePayment() {
        System.out.print("Enter table ID for payment: ");
        String tableID = scanner.nextLine();
 
        double totalAmount = calculateTotal(tableID);
        if (totalAmount > 0) {
            System.out.println("Rewards Program:");
            System.out.println("1. Join rewards program");
            System.out.println("2. Already a member");
            System.out.println("3. Skip rewards");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
 
            String phoneNumber = null;
            switch (choice) {
                case 1:
                    System.out.print("Enter your phone number to join: ");
                    phoneNumber = scanner.nextLine();
                    pointSystem.addMember(phoneNumber);
                    break;
 
                case 2:
                    System.out.print("Enter your phone number: ");
                    phoneNumber = scanner.nextLine();
 
                    if (pointSystem.isMember(phoneNumber)) {
                        int points = pointSystem.getPoints(phoneNumber);
                        System.out.println("You have " + points + " points.");
 
                        if (points >= 50) {
                            System.out.println("Would you like to use 50 points for $5 off?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            System.out.print("Enter your choice: ");
                            int redeemChoice = scanner.nextInt();
                            scanner.nextLine();
 
                            switch (redeemChoice) {
                                case 1:
                                    totalAmount -= 5;
                                    pointSystem.redeemPoints(phoneNumber);
                                    System.out.println("$5 discount applied.");
                                    break;
                                case 2:
                                    System.out.println("Continuing without using points.");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Continuing without using points.");
                                    break;
                            }
                        } else {
                            System.out.println("Accrue 50 points for a $5 discount. You have " + points + " points.");
                        }
                    } else {
                        System.out.println("Phone number not found in the rewards system.");
                    }
                    break;
 
                case 3:
                    System.out.println("Proceeding without rewards program.");
                    break;
 
                default:
                    System.out.println("Invalid choice. Proceeding without rewards program.");
                    break;
            }
            System.out.printf("Total amount due for table %s: $%.2f\n", tableID, totalAmount);
 
            System.out.println("Choose payment method:");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            int paymentChoice = scanner.nextInt();
            scanner.nextLine(); 
 
            switch (paymentChoice) {
                case 1:
                    System.out.print("Enter amount received: ");
                    double cashReceived = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (cashReceived >= totalAmount) {
                        CashPayment cashPayment = new CashPayment((float) totalAmount, tableID);
                        cashPayment.paymentDetails();
                        double change = cashReceived - totalAmount;
                        System.out.printf("Payment successful. Change: $%.2f\n", change);
                        updateSalesTally(tableID);
                        clearOrder(tableID);
                        if (phoneNumber != null) {
                            pointSystem.addPoints(phoneNumber, (int) totalAmount); // Add points
                        }
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
                    updateSalesTally(tableID);
                    clearOrder(tableID);
                    if (phoneNumber != null) {
                        pointSystem.addPoints(phoneNumber, (int) totalAmount); // Add points
                    }
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
            System.out.print("Enter the order number to remove: ");
            int orderNumber = scanner.nextInt();
            scanner.nextLine(); 

            boolean orderFound = false;
            for (Order order : tableListOrders) {
                if (order.getOrderNumber() == orderNumber) {
                    tableListOrders.remove(order);
                    System.out.println("Order #" + orderNumber + " removed.");
                    orderFound = true;
                    break;
                }
            }

            if (!orderFound) {
                System.out.println("Order number not found.");
            }
        }
    }

    // Method to clear all orders for a table
    public void clearOrder(String tableID) {
        orders.remove(tableID); // Remove all orders for the specified table ID
        System.out.println("All orders for table " + tableID + " have been cleared.");
    }
}
