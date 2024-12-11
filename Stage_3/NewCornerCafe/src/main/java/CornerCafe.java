//public class CornerCafe {
//
//    public static void main(String[] args) {
//        // Create a menu
//        Menu menu = new Menu();
//        
//        // Add dummy menu items
//        menu.addItem("Panini", (short) 50, 8.99f);
//        menu.addItem("BLT Sandwich", (short) 30, 6.49f);
//        menu.addItem("Avocado Toast", (short) 20, 10.99f);
//        menu.addItem("Chai Latte", (short) 25, 11.99f);
//        menu.addItem("Tiramisu", (short) 15, 5.99f);
//        
//        // Create a restaurant
//        Restaurant restaurant = new Restaurant("Corner Cafe", "P. Sherman 42 Wallaby Way", menu);
//        
//        // Add dummy staff
//        restaurant.addStaff(new Staff("Alice", "Manager", "001"));
//        restaurant.addStaff(new Staff("Bob", "Chef", "002"));
//        restaurant.addStaff(new Staff("Charlie", "Waiter", "003"));
//        restaurant.addStaff(new Staff("Dana", "Waitress", "004"));
//
//        // Create CLI instance
//        MenuCLI cli = new MenuCLI(restaurant);
//        
//        // Start the CLI
//        cli.displayMainMenu();
//        
//        // Display the menu with prices in the CLI (Example)
//        menu.showMenu();
//    }
//}
