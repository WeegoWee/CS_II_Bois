import java.util.Scanner;

public class MenuCLI {
    private Scanner scanner;
    private Restaurant restaurant;
    private OrderSystem orderSystem;

    public MenuCLI(Restaurant restaurant) {
        this.scanner = new Scanner(System.in);
        this.restaurant = restaurant;
        this.orderSystem = new OrderSystem(restaurant.getMenu());
    }

    //Displays initial menu 
    public void displayMainMenu() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("****** Corner Cafe System *******");
            System.out.println("|\t1. View Restaurant Info\t|");
            System.out.println("|\t2. Staff\t\t|");
            System.out.println("|\t3. Inventory\t\t|");
            System.out.println("|\t4. Order\t\t|");
            System.out.println("|\t5. Exit\t\t\t|");
            System.out.println("Select an option: ");
            System.out.println("*********************************");
            System.out.println("*********************************");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    restaurant.showInfo();
                    break;
                case 2:
                    manageStaffMenu();
                    break;
                case 3:
                    manageMenu();
                    break;
                case 4:
                    orderSystem.displayOrderMenu();
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    //displays staff menu after choosing option 2 in initial menu
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

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStaffMembers();
                    break;
                case 2:
                    addStaffMember();
                    break;
                case 3:
                    removeStaffMember();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * This method received the the staff list from the restaurant class and displays it
     */
    private void viewStaffMembers() {
        System.out.println("\nCurrent Staff:");
        if (restaurant.getStaff().isEmpty()) {
            System.out.println("No staff members found.");
        } else {
            for (Staff staff : restaurant.getStaff()) {
                System.out.println("Name | " + staff.getName() + ", Role | " + staff.getContactInformation() + ", ID | " + staff.getEmployeeID());
            }
        }
    }

    /**
     * This method adds a staff member to the database of staff members
     */
    private void addStaffMember() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        System.out.print("Enter staff ID: ");
        String employeeID = scanner.nextLine();

        Staff newStaff = new Staff(name, role, employeeID);
        restaurant.addStaff(newStaff);
        System.out.println("Staff member added successfully.");
    }

    /**
     * This method removes a staff member from the staff member list
     */
    private void removeStaffMember() {
        System.out.print("Enter staff ID to remove: ");
        String employeeID = scanner.nextLine();

        Staff toRemove = null;
        for (Staff staff : restaurant.getStaff()) {
            if (staff.getEmployeeID().equals(employeeID)) {
                toRemove = staff;
                break;
            }
        }

        if (toRemove != null) {
            restaurant.removeStaff(toRemove);
            System.out.println("Staff member removed successfully.");
        } else {
            System.out.println("Staff member not found.");
        }
    }

    /**
     * This menu has options for adding removing and viewing items in the menu
     */
    private void manageMenu() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("\n*********Iventory****************");
            System.out.println("|\t1. Add Item\t\t|");
            System.out.println("|\t2. Remove Item\t\t|");
            System.out.println("|\t3. Show Inventory\t|");
            System.out.println("|\t4. Back to Main Menu\t|");
            System.out.println("Select an option: ");
            System.out.println("*********************************");
            System.out.println("*********************************");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMenuItem();
                    break;
                case 2:
                    removeMenuItem();
                    break;
                case 3:
                    showMenu();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * This method adds items to the inventory list
     */
    private void addMenuItem() {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter food quantity: ");
        short totalItems = scanner.nextShort();
        System.out.print("Enter price for the item: ");
        float price = scanner.nextFloat();
        scanner.nextLine(); 

        Inventory newItem = new Inventory(itemName, totalItems, price);
        restaurant.getMenu().addItems(newItem);
        System.out.println("Item added successfully.");
    }

    /**
     * this method removes items from the inventory list
     */
    private void removeMenuItem() {
        System.out.print("Enter item name to remove: ");
        String itemName = scanner.nextLine();

        for (Inventory item : restaurant.getMenu().getItems()) {
            if (item.getItems().equals(itemName)) {
                restaurant.getMenu().removeItems(item);
                System.out.println("Item removed successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    private void showMenu() {
        System.out.println("Current Menu:");
        restaurant.getMenu().showMenu();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Restaurant restaurant = new Restaurant("Corner Cafe", "P. Sherman 42 Wallaby Way", menu);
        MenuCLI cli = new MenuCLI(restaurant);
        cli.displayMainMenu();
    }
    
}
