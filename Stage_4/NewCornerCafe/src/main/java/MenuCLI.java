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
            System.out.println("|\t6. View Sales Report\t|"); // New Sales Report option
            System.out.println("|\t7. Exit\t\t\t|");
            System.out.println("Select an option: ");
            System.out.println("*********************************");
            System.out.println("*********************************");

            int choice = getValidChoice(7);
            switch (choice) {
                case 1: restaurant.showName(); break;
                case 2: manageStaffMenu(); break;
                case 3: manageMenu(); break;
                case 4: displayOrderMenu(); break;
                case 5: viewCustomers(); break;
                case 6: generateSalesReport(); break; // New case for Sales Report
                case 7:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
        // Method to generate a sales report
        private void generateSalesReport() {
            System.out.println("********** Sales Report *********");
            restaurant.generateSalesReport();
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
            System.out.println("|\t4. Search Staff by ID\t|"); // New search option
            System.out.println("|\t5. Back to Main Menu\t|");
            System.out.println("|\tSelect an option: \t|");
            System.out.println("*********************************");
            System.out.println("*********************************");

            int choice = getValidChoice(5);  // Get valid choice with range check
            switch (choice) {
                case 1: restaurant.viewStaffMembers(); break;
                case 2: restaurant.addStaffMember(); break;
                case 3: restaurant.removeStaffMember(); break;
                case 4: searchStaffByID(); break;  // New case for searching staff by ID
                case 5: return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // New method to search for staff by ID
    private void searchStaffByID() {
        System.out.print("Enter employee ID to search: ");
        String employeeID = scanner.nextLine();

        Staff staff = restaurant.searchStaffByID(employeeID); // Use search method from Restaurant class
        if (staff != null) {
            System.out.println("Staff found: ");
            System.out.println("Name: " + staff.getName() + ", Position: " + staff.getPosition() + ", ID: " + staff.getEmployeeID());
        } else {
            System.out.println("No staff member found with ID: " + employeeID);
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
                case 1: restaurant.addMenuItem(); break;
                case 2: restaurant.removeMenuItem(); break;
                case 3: menu.showMenu(); break;
                case 4: return;
                default: System.out.println("Invalid choice. Please try again.");
            }
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
}
