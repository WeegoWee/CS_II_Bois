/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author estra
 */
public class OrderMenuGUI extends javax.swing.JFrame {
    private Inventory inventory;
    private OrderSystem order;
    private Menu menu;
    /**
     * Creates new form OrderMenuGUI
     */
    public OrderMenuGUI() {
        inventory = new Inventory();
        order = new OrderSystem();
        menu = new Menu();
        initializeMenuItems();
        initComponents();
        setPrices();
    }
    
    private void setPrices()
    {
        setPriceForItem("Avocado Toast", txtAvoToast);
        setPriceForItem("BLT Sandwich", txtBLT);
        setPriceForItem("Panini", txtPanini);
        setPriceForItem("Tiramisu", txtTiramisu);
        setPriceForItem("Chai Latte", txtChai);
        
       
    }
    private void initializeMenuItems() {
        menu.addItems(new Inventory("Avocado Toast", (short) 10, 8.99f));
        menu.addItems(new Inventory("BLT Sandwich", (short) 15, 6.99f));
        menu.addItems(new Inventory("Panini", (short) 12, 7.99f));
        menu.addItems(new Inventory("Tiramisu", (short) 8, 5.99f));
        menu.addItems(new Inventory("Chai Latte", (short) 20, 3.99f));
    }
    
    private void setPriceForItem(String itemName, javax.swing.JTextField textField) {
        Inventory item = menu.findItemByName(itemName);
        if (item != null) {
            textField.setText(Float.toString(item.getPrice()));
        } else {
            textField.setText("N/A");
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

        mainPanel = new javax.swing.JPanel();
        lblAvoToast = new javax.swing.JLabel();
        lblTiramisu = new javax.swing.JLabel();
        lblBLT = new javax.swing.JLabel();
        spnAvoToast = new javax.swing.JSpinner();
        spnPanini = new javax.swing.JSpinner();
        spnTiramisu = new javax.swing.JSpinner();
        spnChai = new javax.swing.JSpinner();
        spnBLT = new javax.swing.JSpinner();
        txtAvoToast = new javax.swing.JTextField();
        txtBLT = new javax.swing.JTextField();
        txtChai = new javax.swing.JTextField();
        txtTiramisu = new javax.swing.JTextField();
        txtPanini = new javax.swing.JTextField();
        lblPanini = new javax.swing.JLabel();
        lblChai = new javax.swing.JLabel();
        panelSell = new javax.swing.JPanel();
        totalButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        sellButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAvoToast.setText("Avocado Toast");

        lblTiramisu.setText("Tiramisu");

        lblBLT.setText("BLT Sandwitch");

        spnAvoToast.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnPanini.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnTiramisu.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnChai.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnBLT.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        txtAvoToast.setEditable(false);

        txtBLT.setEditable(false);

        txtChai.setEditable(false);

        txtTiramisu.setEditable(false);

        txtPanini.setEditable(false);

        lblPanini.setText("Panini");

        lblChai.setText("Chai Latte");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPanini)
                            .addComponent(lblChai)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lblAvoToast)
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAvoToast, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPanini, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtChai, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnAvoToast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnChai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnBLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnPanini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnTiramisu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lblTiramisu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTiramisu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lblBLT)
                                .addGap(18, 18, 18)
                                .addComponent(txtBLT, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnChai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPanini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnPanini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(lblChai)
                        .addGap(24, 24, 24)
                        .addComponent(lblPanini)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAvoToast)
                            .addComponent(txtAvoToast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnAvoToast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBLT)
                    .addComponent(txtBLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnBLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTiramisu)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTiramisu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnTiramisu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        totalButton.setText("Total");
        totalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);

        sellButton.setText("Sell");
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSellLayout = new javax.swing.GroupLayout(panelSell);
        panelSell.setLayout(panelSellLayout);
        panelSellLayout.setHorizontalGroup(
            panelSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSellLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalButton)
                .addGroup(panelSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSellLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sellButton))
                    .addGroup(panelSellLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(resetButton)))
                .addContainerGap())
        );
        panelSellLayout.setVerticalGroup(
            panelSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSellLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalButton)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton))
                .addGap(18, 18, 18)
                .addComponent(sellButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(panelSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        setSize(new java.awt.Dimension(478, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void totalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalButtonActionPerformed
// Initialize the total variable
    float total = 0;

    // Get the price and quantity for each item and add it to the total

    // Avocado Toast
    Inventory avoToast = menu.findItemByName("Avocado Toast");
    if (avoToast != null) {
        int avoToastQuantity = (int) spnAvoToast.getValue(); // Get the quantity selected
        total += avoToast.getPrice() * avoToastQuantity; // Add to total
    }

    // BLT Sandwich
    Inventory blt = menu.findItemByName("BLT Sandwich");
    if (blt != null) {
        int bltQuantity = (int) spnBLT.getValue(); // Get the quantity selected
        total += blt.getPrice() * bltQuantity; // Add to total
    }

    // Panini
    Inventory panini = menu.findItemByName("Panini");
    if (panini != null) {
        int paniniQuantity = (int) spnPanini.getValue(); // Get the quantity selected
        total += panini.getPrice() * paniniQuantity; // Add to total
    }

    // Tiramisu
    Inventory tiramisu = menu.findItemByName("Tiramisu");
    if (tiramisu != null) {
        int tiramisuQuantity = (int) spnTiramisu.getValue(); // Get the quantity selected
        total += tiramisu.getPrice() * tiramisuQuantity; // Add to total
    }

    // Chai Latte
    Inventory chai = menu.findItemByName("Chai Latte");
    if (chai != null) {
        int chaiQuantity = (int) spnChai.getValue(); // Get the quantity selected
        total += chai.getPrice() * chaiQuantity; // Add to total
    }

    // Display the total in a label or text field
    txtTotal.setText("Total: $" + String.format("%.2f", total)); // Display formatted total
    }//GEN-LAST:event_totalButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // Reset the total text field to an empty value or a default message
        txtTotal.setText("Total: $0.00");  // Reset the total to $0.00

        // Optionally, reset all JSpinners (quantities) to 0 or their default values
        spnAvoToast.setValue(0);
        spnBLT.setValue(0);
        spnPanini.setValue(0);
        spnTiramisu.setValue(0);
        spnChai.setValue(0);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        // Calculate the total cost (you can use the same code as in totalButtonActionPerformed)
    float total = 0;

    // Avocado Toast
    Inventory avoToast = menu.findItemByName("Avocado Toast");
    if (avoToast != null) {
        int avoToastQuantity = (int) spnAvoToast.getValue();
        total += avoToast.getPrice() * avoToastQuantity;
    }

    // BLT Sandwich
    Inventory blt = menu.findItemByName("BLT Sandwich");
    if (blt != null) {
        int bltQuantity = (int) spnBLT.getValue();
        total += blt.getPrice() * bltQuantity;
    }

    // Panini
    Inventory panini = menu.findItemByName("Panini");
    if (panini != null) {
        int paniniQuantity = (int) spnPanini.getValue();
        total += panini.getPrice() * paniniQuantity;
    }

    // Tiramisu
    Inventory tiramisu = menu.findItemByName("Tiramisu");
    if (tiramisu != null) {
        int tiramisuQuantity = (int) spnTiramisu.getValue();
        total += tiramisu.getPrice() * tiramisuQuantity;
    }

    // Chai Latte
    Inventory chai = menu.findItemByName("Chai Latte");
    if (chai != null) {
        int chaiQuantity = (int) spnChai.getValue();
        total += chai.getPrice() * chaiQuantity;
    }

    // Open the SellGUI and pass the total value
    new SellGUI(total).setVisible(true);
    }//GEN-LAST:event_sellButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderMenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAvoToast;
    private javax.swing.JLabel lblBLT;
    private javax.swing.JLabel lblChai;
    private javax.swing.JLabel lblPanini;
    private javax.swing.JLabel lblTiramisu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelSell;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton sellButton;
    private javax.swing.JSpinner spnAvoToast;
    private javax.swing.JSpinner spnBLT;
    private javax.swing.JSpinner spnChai;
    private javax.swing.JSpinner spnPanini;
    private javax.swing.JSpinner spnTiramisu;
    private javax.swing.JButton totalButton;
    private javax.swing.JTextField txtAvoToast;
    private javax.swing.JTextField txtBLT;
    private javax.swing.JTextField txtChai;
    private javax.swing.JTextField txtPanini;
    private javax.swing.JTextField txtTiramisu;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}