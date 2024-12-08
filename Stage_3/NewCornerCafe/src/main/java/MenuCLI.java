import java.util.Scanner;

public class MenuCLI {
    private Scanner scanner;
    private Restaurant restaurant;
    private OrderSystem orderSystem;
    private final Menu menu;

    public MenuCLI(Restaurant restaurant) {
        this.scanner = new Scanner(System.in);
        this.restaurant = restaurant;
        this.orderSystem = new OrderSystem(restaurant.getMenu());
        this.menu = restaurant.getMenu();  // Correctly initializing menu
    }

    // Displays the initial menu
public void displayMainMenu() {
    while (true) {
        System.out.println("*********************************");
        System.out.println("****** Corner Cafe System *******");
        System.out.println("|\t1. View Restaurant Info\t|");
        System.out.println("|\t2. Staff Management\t|");
        System.out.println("|\t3. Menu Management\t|");
        System.out.println("|\t4. Order Management\t|");
        System.out.println("|\t5. View Customers\t|");
        System.out.println("|\t6. Exit\t\t\t|");
        System.out.println("Select an option: ");
        System.out.println("*********************************");
        System.out.println("*********************************");

        int choice = getValidChoice(6);
        switch (choice) {
            case 1: restaurant.showInfo(); break;
            case 2: manageStaffMenu(); break;
            case 3: manageMenu(); break;
            case 4: displayOrderMenu(); break;
            case 5: viewCustomers(); break;
            case 6:
                System.out.println("Exiting the application...");
                saveDataOnExit();
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
   

    // Displays staff management menu
    private void manageStaffMenu() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("*********************************");
            System.out.println("\n|********** Manage Staff *******|");
            System.out.println("|\t1. View Staff\t\t|");
            System.out.println("|\t2. Add Staff\t\t|");
            System.out.println("|\t3. Remove Staff\t\t|");
            System.out.println("|\t4. Back to Main Menu\t|");
            System.out.println("|\tSelect an option: \t|");
            System.out.println("*********************************");
            System.out.println("*********************************");

            int choice = getValidChoice(4);  // Get valid choice with range check
            switch (choice) {
                case 1: restaurant.viewStaffMembers(); break;
                case 2: restaurant.addStaffMember(); break;
                case 3: restaurant.removeStaffMember(); break;
                case 4: return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Displays menu management options
    private void manageMenu() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("\n********* Menu Management *******");
            System.out.println("|\t1. Add Item\t\t|");
            System.out.println("|\t2. Remove Item\t\t|");
            System.out.println("|\t3. Show Menu\t\t|");
            System.out.println("|\t4. Back to Main Menu\t|");
            System.out.println("Select an option: ");
            System.out.println("*********************************");
            System.out.println("*********************************");

            int choice = getValidChoice(4);  // Get valid choice with range check
            switch (choice) {
                case 1: addMenuItem(); break;
                case 2: removeMenuItem(); break;
                case 3: menu.showMenu(); break;
                case 4: return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Adds an item to the menu
    private void addMenuItem() {
        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.println("Enter item price: ");
        float price = scanner.nextFloat();
        System.out.println("Enter total items: ");
        short totalItems = scanner.nextShort();
        scanner.nextLine();  // Clear the buffer

        Inventory newItem = new Inventory(itemName, totalItems, price);
        menu.addItems(newItem);
        System.out.println("Added new item: " + itemName);
    }

    // Removes an item from the menu
    private void removeMenuItem() {
        System.out.println("Enter item name to remove: ");
        String itemName = scanner.nextLine();
        Inventory itemToRemove = menu.findItemByName(itemName);

        if (itemToRemove != null) {
            menu.removeItems(itemToRemove);
            System.out.println("Removed item: " + itemName);
        } else {
            System.out.println("Item not found.");
        }
    }

    // Displays the order menu
    public void displayOrderMenu() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("*********************************");
            System.out.println("\n*********** Order Menu **********");
            System.out.println("|\t1. Place an Order\t|");
            System.out.println("|\t2. View Orders\t\t|");
            System.out.println("|\t3. Make Payment\t\t|");
            System.out.println("|\t4. Remove an Order\t|");
            System.out.println("|\t5. View Sales Report\t|");
            System.out.println("|\t6. Back to Main Menu\t|");
            System.out.println("Select an option: ");
            System.out.println("*********************************");
            System.out.println("*********************************");

            int choice = getValidChoice(6);  // Get valid choice with range check
            switch (choice) {
                case 1: orderSystem.placeOrder(); break;
                case 2: orderSystem.viewOrders(); break;
                case 3: orderSystem.makePayment(); break;
                case 4: orderSystem.removeOrder(); break;
                case 5: orderSystem.generateSalesReport(); break;
                case 6: return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
        // New method to view customers
    private void viewCustomers() {
        System.out.println("********* Customer List *********");
        restaurant.getIndividualsByRole("Customer").forEach(customer -> {
            System.out.println("Name: " + customer.getName() + ", Phone: " + ((Customer)customer).getPhoneNumber() + ", Points: " + ((Customer)customer).getRewardPoints());
        });
        System.out.println("*********************************");
    }

    // Method to validate the user's menu choice and ensure it's within the allowed range
    private int getValidChoice(int maxChoice) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= maxChoice) {
                    return choice;
                } else {
                    System.out.println("Please enter a valid option between 1 and " + maxChoice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    // New method to save data when exiting the program
    private void saveDataOnExit() {
    // Specify file paths
    String employeesFilePath = "src/main/resources/employees.csv";
    String customersFilePath = "src/main/resources/customers.csv";
    String inventoryFilePath = "src/main/resources/inventory.csv";
    
    // Save data to CSV files
    restaurant.saveEmployeesToCSV(employeesFilePath);
    restaurant.saveCustomersToCSV(customersFilePath);
    restaurant.saveInventoryToCSV(inventoryFilePath);

    System.out.println("Data saved successfully.");
    }

}
