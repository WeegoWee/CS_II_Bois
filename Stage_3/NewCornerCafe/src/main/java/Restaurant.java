import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        for (Individual individual : individuals.values()) {
            if (individual instanceof Staff) {
                System.out.println("Name: " + individual.getName() + ", Role: " + individual.getRole() + ", ID: " + individual.getEmployeeID());
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
        if (individuals.containsKey(name)) {
            individuals.remove(name);
            System.out.println("Staff member " + name + " removed successfully.");
        } else {
            System.out.println("Staff member with name " + name + " does not exist.");
        }
    }
    
    // Method to load employees from CSV
    public void loadEmployeesFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();  // Skip header

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String name = fields[0].trim();
                    String role = fields[1].trim();
                    String employeeID = fields[2].trim();
                    addIndividual(new Staff(name, role, employeeID));
                }
            }
            System.out.println("Employees loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading employees from CSV: " + e.getMessage());
        }
    }

    // Method to load customers from CSV
    public void loadCustomersFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();  // Skip header

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String phoneNumber = fields[0].trim();
                    String name = fields[1].trim();
                    int rewardPoints = Integer.parseInt(fields[2].trim());  // Reward points field
                    addIndividual(new Customer(name, phoneNumber, rewardPoints));  // No employeeID
                }
            }
            System.out.println("Customers loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading customers from CSV: " + e.getMessage());
        }
    }

    // Method to save employees to CSV
    public void saveEmployeesToCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("Name,Role,EmployeeID\n");
            
            for (Individual individual : individuals.values()) {
                if (individual instanceof Staff) {
                    Staff staff = (Staff) individual;
                    writer.write(staff.getName() + "," + staff.getRole() + "," + staff.getEmployeeID() + "\n");
                }
            }
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees to CSV: " + e.getMessage());
        }
    }

    // Method to save customers to CSV
    public void saveCustomersToCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("PhoneNumber,Name,RewardPoints\n");

            for (Individual individual : individuals.values()) {
                if (individual instanceof Customer) {
                    Customer customer = (Customer) individual;
                    writer.write(customer.getPhoneNumber() + "," + customer.getName() + "," + customer.getRewardPoints() + "\n");
                }
            }
            System.out.println("Customers saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving customers to CSV: " + e.getMessage());
        }
    }

    // Method to save inventory to CSV
    public void saveInventoryToCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("ItemName,Price,TotalItems\n");
            
            // Write each inventory item to the CSV
            for (Inventory item : menu.getItems().values()) {
                writer.write(item.getItems() + "," + item.getPrice() + "," + item.getTotalItems() + "\n");
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory to CSV: " + e.getMessage());
        }
    }

    // Method to load inventory from CSV
    public void loadInventoryFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();  // Skip header

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String itemName = fields[0].trim();
                    double price = Double.parseDouble(fields[1].trim());
                    int totalItems = Integer.parseInt(fields[2].trim());

                    // Add inventory item to menu
                    Inventory item = new Inventory(itemName, (short) price, totalItems);
                    menu.addItems(item);
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

    Menu getMenu() {
        return menu;
    }
}
