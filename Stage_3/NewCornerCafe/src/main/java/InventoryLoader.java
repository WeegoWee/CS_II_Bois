import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryLoader {

    public static List<Inventory> loadInventoryFromCSV(String filePath) {
        List<Inventory> inventoryList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String itemName = data[0];
                double price = Double.parseDouble(data[1]);
                int quantity = Integer.parseInt(data[2]);
                
                inventoryList.add(new Inventory(itemName, (short) price, quantity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return inventoryList;
    }
}
