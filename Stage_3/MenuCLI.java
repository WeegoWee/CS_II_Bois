import java.util.Scanner;

public class MenuCLI {
    private Scanner scanner;
    private Restaurant restaurant;
    private OrderSystem orderSystem;
    private Inventory inventory;
    private Menu menu;
    private Order order;

    public MenuCLI(Restaurant restaurant) {
        this.scanner = new Scanner(System.in);
        this.restaurant = restaurant;
        this.orderSystem = new OrderSystem(restaurant.getMenu());
        this.inventory = inventory;
        this.menu = menu;
        this.order = order;
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
                case 1:restaurant.showInfo();break;
                case 2:manageStaffMenu();break;
                case 3:manageMenu();break;
                case 4:displayOrderMenu();break;
                case 5:System.out.println("Exiting the application...");return;
                default:System.out.println("Invalid choice. Please try again.");
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
                case 1:restaurant.viewStaffMembers();break;
                case 2:restaurant.addStaffMember();break;
                case 3:restaurant.removeStaffMember();break;
                case 4:return;
                default:System.out.println("Invalid choice. Please try again.");
            }
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
                case 1:restaurant.addMenuItem();break;
                case 2:restaurant.removeMenuItem();break;
                case 3:restaurant.showMenu();break;
                case 4:return;
                default:System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    // Display the order menu
    public void displayOrderMenu() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("*********************************");
            System.out.println("\n*********** Order Menu **********");
            System.out.println("|\t1. Place an Order\t|");
            System.out.println("|\t2. View Orders\t\t|");
            System.out.println("|\t3. Make Payment\t\t|");
            System.out.println("|\t4. Remove an Order\t|");
            System.out.println("|\t5. Back to Main Menu\t|");
            System.out.println("Select an option: ");
            System.out.println("*********************************");
            System.out.println("*********************************");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:orderSystem.placeOrder();break;
                case 2:orderSystem.viewOrders();break;
                case 3:orderSystem.makePayment(); break;
                case 4:orderSystem.removeOrder();break;
                case 5:return;
                default:System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        Restaurant restaurant = new Restaurant("Corner Cafe", "P. Sherman 42 Wallaby Way", menu);
        MenuCLI cli = new MenuCLI(restaurant);
        cli.displayMainMenu();
    }
    
}