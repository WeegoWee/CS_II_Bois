import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Restaurant {
    private Map<String, Individual> individuals = new HashMap<>();
    private PointSystem pointSystem;
    private Menu menu;
    private Scanner scanner = new Scanner(System.in);

    public Restaurant() {
        pointSystem = new PointSystem();
        menu = new Menu();
    }

    // Add individual
    public void addIndividual(Individual individual) {
        individuals.put(individual.getName(), individual);
    }

    // Get individual
    public Individual getIndividual(String name) {
        return individuals.get(name);
    }

    // Add a customer to the points system
    public void addCustomerToPointsSystem(String phoneNumber) {
        if (!pointSystem.isMember(phoneNumber)) {
            pointSystem.addMember(phoneNumber);
        } else {
            System.out.println("Customer is already a member.");
        }
    }

    // Show restaurant info
    public void showInfo() {
        System.out.println("Restaurant Name: Corner Cafe");
        System.out.println("Address: 123 Main St, SomeCity, SomeState");
    }

    // View staff members
    public void viewStaffMembers() {
        List<Staff> staffList = individuals.values()
            .stream()
            .filter(ind -> ind instanceof Staff)
            .map(ind -> (Staff) ind)
            .sorted(Comparator.comparingInt(staff -> {
                try {
                    return Integer.parseInt(staff.getEmployeeID()); // Try to parse as integer
                } catch (NumberFormatException e) {
                    return Integer.MAX_VALUE; // In case of non-numeric ID, move to the end of the list
                }
            }))
            .collect(Collectors.toList());

        for (Staff staff : staffList) {
            System.out.println("Name: " + staff.getName() + ", Position: " + staff.getPosition() + ", ID: " + staff.getEmployeeID());
        }
    }

    // Add staff member
    public void addStaffMember() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        // Check if employee ID already exists
        if (isEmployeeIDExist(employeeID)) {
            System.out.println("Employee ID " + employeeID + " is already taken. Please enter a unique ID.");
            return;
        }

        // Add staff member
        addIndividual(new Staff(name, role, employeeID));

        // Save updated list of staff members to CSV
        saveEmployeesToCSV("src/main/resources/employees.csv");

        System.out.println("Staff member " + name + " added successfully.");
    }

    // Method to check if the employee ID exists
    public boolean isEmployeeIDExist(String employeeID) {
        for (Individual individual : individuals.values()) {
            if (individual instanceof Staff && ((Staff) individual).getEmployeeID().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }


    // Remove staff member
    public void removeStaffMember() {
        System.out.print("Enter the name of the staff member to remove: ");
        String name = scanner.nextLine();
    
        // Check if staff member exists
        if (individuals.containsKey(name)) {
            individuals.remove(name);  // Remove staff member
            
            // Save updated list of staff members to CSV
            saveEmployeesToCSV("src/main/resources/employees.csv");

            System.out.println("Staff member " + name + " removed successfully.");
        } else {
            System.out.println("Staff member with name " + name + " does not exist.");
        }
    }

    // Add an item to the menu
    public void addMenuItem() {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        float price = scanner.nextFloat();
        System.out.print("Enter total items: ");
        short totalItems = scanner.nextShort();
        scanner.nextLine();  // Clear the buffer

        Inventory newItem = new Inventory(itemName, totalItems, price);
        menu.addItems(newItem);

        // Save updated inventory to CSV
        saveInventoryToCSV("src/main/resources/inventory.csv");

        System.out.println("Added new item: " + itemName);
    }


    // Removes an item from the menu
    public void removeMenuItem() {
        System.out.print("Enter item name to remove: ");
        String itemName = scanner.nextLine();
        Inventory itemToRemove = menu.findItemByName(itemName);

        if (itemToRemove != null) {
            menu.removeItems(itemToRemove);

            // Save updated inventory to CSV
            saveInventoryToCSV("src/main/resources/inventory.csv");

            System.out.println("Removed item: " + itemName);
        } else {
            System.out.println("Item not found.");
        }
    }


    // Method to load employees from CSV
    public void loadEmployeesFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();  // Skip header

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String name = fields[0].trim();
                    String role = fields[1].trim();
                    String employeeID = fields[2].trim();
                    addIndividual(new Staff(name, role, employeeID));
                }
            }
            System.out.println("Employees loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading employees from CSV: " + e.getMessage());
        }
    }

    // Method to load customers from CSV
    public void loadCustomersFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();  // Skip header

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String phoneNumber = fields[1].trim();
                    String name = fields[0].trim();
                    int rewardPoints = Integer.parseInt(fields[2].trim());  // Reward points field
                    addIndividual(new Customer(name, phoneNumber, rewardPoints));  // No employeeID
                }
            }
            System.out.println("Customers loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading customers from CSV: " + e.getMessage());
        }
    }

    // Method to save employees to CSV
    public void saveEmployeesToCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("Name,Role,EmployeeID\n");
            
            for (Individual individual : individuals.values()) {
                if (individual instanceof Staff) {
                    Staff staff = (Staff) individual;
                    writer.write(staff.getName() + "," + staff.getPosition() + "," + staff.getEmployeeID() + "\n");
                }
            }
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees to CSV: " + e.getMessage());
        }
    }

    // Method to save customers to CSV
    public void saveCustomersToCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("Name,PhoneNumber,RewardPoints\n");

            for (Individual individual : individuals.values()) {
                if (individual instanceof Customer) {
                    Customer customer = (Customer) individual;
                    writer.write(customer.getName() + "," + customer.getPhoneNumber() + "," + customer.getRewardPoints() + "\n");
                }
            }
            System.out.println("Customers saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving customers to CSV: " + e.getMessage());
        }
    }

    // Method to save inventory to CSV
    public void saveInventoryToCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("ItemName,Price,TotalItems\n");
            
            // Write each inventory item to the CSV
            for (Inventory item : menu.getItems().values()) {
                writer.write(item.getItems() + "," + item.getPrice() + "," + item.getTotalItems() + "\n");
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory to CSV: " + e.getMessage());
        }
    }

    // Method to load inventory from CSV
    public void loadInventoryFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();  // Skip header

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String itemName = fields[0].trim();
                    double price = Double.parseDouble(fields[1].trim());
                    int totalItems = Integer.parseInt(fields[2].trim());

                    // Add inventory item to menu
                    Inventory item = new Inventory(itemName, (short) price, totalItems);
                    menu.addItems(item);
                }
            }
            System.out.println("Inventory loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading inventory from CSV: " + e.getMessage());
        }
    }

    // Filter individuals by role
    public List<Individual> getIndividualsByRole(String role) {
        return individuals.values()
            .stream()
            .filter(ind -> (role.equalsIgnoreCase("Customer") && ind instanceof Customer) || 
                           (role.equalsIgnoreCase("Staff") && ind instanceof Staff))
            .collect(Collectors.toList());
    }
    
    // Method to search for staff by employee ID
    public Staff searchStaffByID(String employeeID) {
        for (Individual individual : individuals.values()) {
            if (individual instanceof Staff) {
                Staff staff = (Staff) individual;
                if (staff.getEmployeeID().equals(employeeID)) {
                    return staff;  // Return staff if found
                }
            }
        }
        return null;  // Return null if no matching staff found
    }
    
    // Method to generate a sales report
    public void generateSalesReport() {
        // Aggregating total sales
        double totalSales = 0;
        Map<String, Integer> itemSales = new HashMap<>();  // Tracks how many times each item was sold

        // Loop through all orders (assuming orders are tracked in the OrderSystem or a similar structure)
        for (Order order : getAllOrders()) {  // Assuming getAllOrders() gives you all completed orders
            if (order.isPaid()) {  // Check if the order has been paid
                totalSales += order.getTotalAmount();  // Add total amount of order to total sales

                // Track sales per item
                for (Inventory item : order.getOrderedItems()) {
                    String itemName = item.getItems();
                    itemSales.put(itemName, itemSales.getOrDefault(itemName, 0) + 1);  // Increment item sale count
                }
            }
        }

        // Print the sales report
        System.out.println("******** Sales Report ********");
        System.out.println("Total Sales: $" + totalSales);

        // Print sales breakdown per item
        System.out.println("\nSales Breakdown by Item:");
        for (Map.Entry<String, Integer> entry : itemSales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " sold");
        }

        // Additional metrics (if any)
        System.out.println("\nTotal number of orders: " + getCompletedOrdersCount()); // Assuming a method to count completed orders
        System.out.println("*********************************");
    }

    private static class orders {

        private static Object stream() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public orders() {
        }
    }
    
    
    public class Order {
        private List<Inventory> orderedItems;  // List of items in the order
        private double totalAmount;            // Total amount for the order
        private boolean paid;                  // Payment status

        // Constructor
        public Order(List<Inventory> orderedItems, double totalAmount) {
            this.orderedItems = orderedItems;
            this.totalAmount = totalAmount;
            this.paid = false;  // By default, the order is not paid
        }

        public List<Inventory> getOrderedItems() {
            return orderedItems;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public boolean isPaid() {
            return paid;
        }

        public void makePayment() {
            this.paid = true;  // Mark the order as paid
        }
    }
    
    private List<Order> orders = new ArrayList<>();  // Holds all orders

    public List<Order> getAllOrders() {
        return orders.stream()
                     .filter(Order::isPaid)
                     .collect(Collectors.toList());
    }

    public int getCompletedOrdersCount() {
        return (int) orders.stream().filter(Order::isPaid).count();
    }

    Menu getMenu() {
        return menu;
    }
}
