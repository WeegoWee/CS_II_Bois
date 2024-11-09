import java.util.Scanner;

public class MenuCLI {
    private Scanner scanner;
    private Restaurant restaurant;
    private OrderSystem orderSystem;
    private Staff staffMembers;

    public MenuCLI(Restaurant restaurant) {
        this.scanner = new Scanner(System.in);
        this.restaurant = restaurant;
        this.staffMembers = staffMembers;
        this.orderSystem = new OrderSystem(restaurant.getMenu());
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("*********************************");
            System.out.println("\n****** Corner Cafe System *******");
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
                    staffMembers.viewStaffMembers();
                    break;
                case 2:
                    staffMembers.addStaffMember();
                    break;
                case 3:
                    staffMembers.removeStaffMember();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

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
