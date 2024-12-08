public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // Specify paths to the CSV files
        String employeesFilePath = "src/main/resources/employees.csv";
        String customersFilePath = "src/main/resources/customers.csv";
        String inventoryFilePath = "src/main/resources/inventory.csv";

        try {
            // Load employees from CSV
            System.out.println("Loading employees...");
            restaurant.loadEmployeesFromCSV(employeesFilePath);

            // Load customers from CSV
            System.out.println("Loading customers...");
            restaurant.loadCustomersFromCSV(customersFilePath);
            
            // Load inventory from CSV
            System.out.println("Loading inventory...");
            restaurant.loadInventoryFromCSV(inventoryFilePath);
            
            // Initialize and launch the MenuCLI
            MenuCLI menuCLI = new MenuCLI(restaurant);
            menuCLI.displayMainMenu();

        } catch (Exception e) {
            System.out.println("An error occurred while loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
