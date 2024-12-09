import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Restaurant {
    private Map<String, Individual> individuals = new HashMap<>();
    private PointSystem pointSystem;
    private Menu menu;

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
        List<Individual> staffMembers = getIndividualsByRole("Staff");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members available.");
        } else {
            for (Individual staff : staffMembers) {
                System.out.println("Name: " + staff.getName() + ", Role: " + staff.getRole() + ", ID: " + staff.getEmployeeID());
            }
        }
    }

    // Add staff member
    public void addStaffMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();
        addIndividual(new Staff(name, role, employeeID));
        System.out.println("Staff member " + name + " added successfully.");
    }

    // Remove staff member
    public void removeStaffMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the staff member to remove: ");
        String name = scanner.nextLine();
        if (individuals.remove(name) != null) {
            System.out.println("Staff member " + name + " removed successfully.");
        } else {
            System.out.println("Staff member with name " + name + " does not exist.");
        }
    }

    // Save inventory to CSV
    public void saveInventoryToCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ItemName,Price,TotalItems\n"); // Header
            for (Menu.Item item : menu.getItems().values()) {
                writer.write(item.getName() + "," + item.getPrice() + "," + item.getTotalItems() + "\n");
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory to CSV: " + e.getMessage());
        }
    }

    // Load inventory from CSV
    public void loadInventoryFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String itemName = fields[0].trim();
                    float price = Float.parseFloat(fields[1].trim());
                    short totalItems = Short.parseShort(fields[2].trim());
                    menu.addItem(itemName, price, totalItems);
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
                .filter(ind -> ind.getRole().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }

    public Menu getMenu() {
        return menu;
    }
}
