import java.util.Scanner;

public class MenuCLI {
    private Scanner scanner;
    private Restaurant restaurant;

    public MenuCLI(Restaurant restaurant) {
        this.scanner = new Scanner(System.in);
        this.restaurant = restaurant;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== Restaurant Management System ===");
            System.out.println("1. View Restaurant Info");
            System.out.println("2. Manage Staff");
            System.out.println("3. Manage Menu");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

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
                    System.out.println("Exiting the application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageStaffMenu() {
        while (true) {
            System.out.println("\n=== Manage Staff ===");
            System.out.println("1. Add Staff");
            System.out.println("2. Remove Staff");
            System.out.println("3. Show Staff");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    removeStaff();
                    break;
                case 3:
                    showStaff();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStaff() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact information: ");
        String contactInformation = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        Staff newStaff = new Staff(name, contactInformation, employeeID);
        restaurant.addStaff(newStaff);
        System.out.println("Staff added successfully.");
    }

    private void removeStaff() {
        System.out.print("Enter employee ID to remove: ");
        String employeeID = scanner.nextLine();

        // This assumes the Staff class has a method to check ID; you might need to implement this logic.
        for (Staff staff : restaurant.getStaff()) {
            if (staff.getEmployeeID().equals(employeeID)) {
                restaurant.removeStaff(staff);
                System.out.println("Staff removed successfully.");
                return;
            }
        }
        System.out.println("Staff not found.");
    }

    private void showStaff() {
        System.out.println("Current Staff:");
        for (Staff staff : restaurant.getStaff()) {
            staff.showInfo();
        }
    }

    private void manageMenu() {
        while (true) {
            System.out.println("\n=== Manage Menu ===");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. Show Menu");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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

    private void addMenuItem() {
        System.out.print("Enter food item name: ");
        String item = scanner.nextLine();
        System.out.print("Enter total food quantity: ");
        short totalItems = scanner.nextShort();
        scanner.nextLine(); // Consume newline

        Inventory newItem = new Inventory(items, totalItems);
        restaurant.getMenu().addItems(newItem);
        System.out.println("Menu item added successfully.");
    }

    private void removeMenuItem() {
        System.out.print("Enter food item name to remove: ");
        String food = scanner.nextLine();

        // This assumes the Inventory class has a method to check food name; you might need to implement this logic.
        for (Inventory item : restaurant.getMenu().getItems()) {
            if (item.getItems().equals(items)) {
                restaurant.getMenu().removeItems(item);
                System.out.println("Menu item removed successfully.");
                return;
            }
        }
        System.out.println("Menu item not found.");
    }

    private void showMenu() {
        System.out.println("Current Menu:");
        restaurant.getMenu().showMenu();
    }

    public static void main(String[] args) {
        // Sample initialization
        Menu menu = new Menu();
        Restaurant restaurant = new Restaurant("Gourmet Heaven", "123 Flavor St", menu);
        MenuCLI cli = new MenuCLI(restaurant);
        cli.displayMainMenu();
    }
}
