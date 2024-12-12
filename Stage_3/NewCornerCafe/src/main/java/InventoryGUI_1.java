import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import javax.swing.JOptionPane;

public class InventoryGUI_1 extends javax.swing.JFrame {

    private Menu menu; // Menu object to hold the inventory items

    public InventoryGUI_1(Menu menu) {
        initComponents();
        this.menu = menu; // Initialize the menu with the passed object
        loadInventoryFromCSV("resources/inventory.csv"); // Load inventory from the CSV file
        fillTableWithInventory(); // Fill the table with items from the menu
    }

    InventoryGUI_1() {
        
    }

    public void loadInventoryFromCSV(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip the header line
            reader.readLine();
            
            // Read each line and parse the item data
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String itemName = data[0];
                double price = Double.parseDouble(data[1]);
                int quantity = Integer.parseInt(data[2]);

                // Create Inventory object and add it to the menu
                Inventory inventory = new Inventory(itemName, (short) price, quantity);
                menu.addItems(inventory);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading inventory from CSV: " + e.getMessage());
        }
    }

    // Method to fill table with items from Menu
    public void fillTableWithInventory() {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        // Clear existing data
        model.setRowCount(0);

        // Get items from the menu's HashMap and add them to the table
        Map<String, Inventory> items = menu.getItems(); // Fetch the items from the Menu
        for (Inventory inventory : items.values()) {
            Object[] rowData = {inventory.getItems(), inventory.getPrice(), inventory.getTotalItems()};
            model.addRow(rowData);
        }
    }

        


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_additem = new javax.swing.JButton();
        jButton_removeitem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton_additem.setText("Add Item");
        jButton_additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_additemActionPerformed(evt);
            }
        });

        jButton_removeitem.setText("Remove Item");
        jButton_removeitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeitemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton_additem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jButton_removeitem)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_additem)
                    .addComponent(jButton_removeitem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(416, 308));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_additemActionPerformed

    }//GEN-LAST:event_jButton_additemActionPerformed

    private void jButton_removeitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_removeitemActionPerformed

                int selectedRow = jTable1.getSelectedRow();


                if (selectedRow >= 0) {

                    String itemName = (String) jTable1.getValueAt(selectedRow, 0);


                    Inventory itemToRemove = null;
                    for (Inventory inventory : menu.getItems().values()) {
                        if (inventory.getItems().equals(itemName)) {
                            itemToRemove = inventory;
                            break;
                        }
                    }


                    if (itemToRemove != null) {
                        menu.removeItems(itemToRemove);
                    }


                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(selectedRow);
                } else {

                    javax.swing.JOptionPane.showMessageDialog(this, "Please select an item to remove.");
                }
    }//GEN-LAST:event_jButton_removeitemActionPerformed
/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Menu menu = new Menu();
                new InventoryGUI(menu).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_additem;
    private javax.swing.JButton jButton_removeitem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
