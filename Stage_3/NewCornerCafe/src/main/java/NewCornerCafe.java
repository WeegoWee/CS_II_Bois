public class NewCornerCafe {
    public static void main(String[] args) {
        // Initialize the Restaurant
        Restaurant restaurant = new Restaurant();

        // Add some sample staff and menu items for testing
        Staff staff1 = new Staff("Alice", "Manager", "001");
        Staff staff2 = new Staff("Bob", "Waiter","002");
        
        restaurant.addIndividual(staff1);
        restaurant.addIndividual(staff2);

        // Add some sample menu items
        Inventory item1 = new Inventory("Coffee", (short) 10, 3.50f);
        Inventory item2 = new Inventory("Sandwich", (short) 20, 5.00f);
        restaurant.getMenu().addItems(item1);
        restaurant.getMenu().addItems(item2);

        // Add a customer to the points system
        restaurant.addCustomerToPointsSystem("555-1234");

        // Initialize MenuCLI for user interaction
        MenuCLI menuCLI = new MenuCLI(restaurant);

        // Start the application by displaying the main menu
        menuCLI.displayMainMenu();
    }
    
    
}