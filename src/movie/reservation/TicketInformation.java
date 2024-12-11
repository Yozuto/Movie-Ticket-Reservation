/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.reservation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TicketInformation extends javax.swing.JFrame {
    private javax.swing.JTextField customerNameField;
    private javax.swing.JButton confirmButton;
    private boolean isCancelled = false;
    private MovieInfo movieInfo; 
    
    /**
     * Creates new form TicketInformation
     */
    public TicketInformation() {
        initComponents();
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {
        // Existing component initializations
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ticketCounter = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalCounter = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        seatsLbl = new javax.swing.JTextArea();
        
        // New components
        customerNameField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton("Confirm");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ticket Information");

        // Existing component setup remains the same...
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Multiplex Theatre Showing Screen 1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setText("Movie");

        // Add customer name label and text field
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        customerNameLabel.setForeground(new java.awt.Color(255, 153, 51));
        
        customerNameField.setFont(new java.awt.Font("Tahoma", 0, 14));
        customerNameField.setPreferredSize(new Dimension(200, 30));

        // Style confirm button
        confirmButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        confirmButton.setBackground(new java.awt.Color(0, 153, 51));
        confirmButton.setForeground(Color.WHITE);
        

        // Add action listener to confirm button
      confirmButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        MovieInfo movieInfo = new MovieInfo();
        
        String CustomerName = customerNameField.getText().trim();
        MovieReservationSystemGUI movieReservationSystemGUI = new MovieReservationSystemGUI();
        
        
        if (CustomerName.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a customer name.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE);
            return; // Stop further execution if the name is empty
        }else{
        dispose(); // Close the current window
        //movieReservationSystemGUI.ChangeColor(movieInfo);
        showReceiptDialog();
        }
    }
});
       
       
       
       addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            // Set a flag or take action to indicate cancellation
            isCancelled = true;
            dispose();
        }
    });

        // Modify the existing layout to include new components
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            // Existing components layout...
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customerNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirmButton))
                            // Rest of the existing layout...
                        )
                    )
                )
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                // Existing vertical groups...
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerNameLabel)
                    .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void showReceiptDialog() {
    // Get customer name
   
    String customerName = customerNameField.getText().trim();
 
    
    if (customerName.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Please enter a customer name", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Create receipt dialog
    JDialog receiptDialog = new JDialog(this, "Ticket Receipt", true);
    receiptDialog.setLayout(new BorderLayout());

    // Create receipt panel
    JPanel receiptPanel = new JPanel();
    receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));
    receiptPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // Add receipt details
    JLabel receiptTitle = new JLabel("Ticket Receipt");
    receiptTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
    receiptTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel customerNameReceipt = new JLabel("Customer: " + customerName);
    JLabel movieNameReceipt = new JLabel("Movie: " + nameLbl.getText());
    JLabel timeReceipt = new JLabel("Time: " + timeLbl.getText());
    JLabel ticketsReceipt = new JLabel("Tickets: " + ticketCounter.getText());
    JLabel totalReceipt = new JLabel("Total: " + totalCounter.getText());
    JLabel seatsReceipt = new JLabel("Seats: " + seatsLbl.getText());

    // Style receipt labels
    Font receiptFont = new Font("Tahoma", Font.PLAIN, 18);
    customerNameReceipt.setFont(receiptFont);
    movieNameReceipt.setFont(receiptFont);
    timeReceipt.setFont(receiptFont);
    ticketsReceipt.setFont(receiptFont);
    totalReceipt.setFont(receiptFont);
    seatsReceipt.setFont(receiptFont);

    // Add components to receipt panel
    receiptPanel.add(receiptTitle);
    receiptPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    receiptPanel.add(customerNameReceipt);
    receiptPanel.add(movieNameReceipt);
    receiptPanel.add(timeReceipt);
    receiptPanel.add(ticketsReceipt);
    receiptPanel.add(totalReceipt);
    receiptPanel.add(seatsReceipt);

    // Add confirm button
    JButton confirmButton = new JButton("Confirm");
    confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    confirmButton.addActionListener(e -> {
        receiptDialog.dispose(); // Close the receipt dialog
    });

    receiptPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    receiptPanel.add(confirmButton);

    // Add receipt panel to dialog
    receiptDialog.add(receiptPanel, BorderLayout.CENTER);
    receiptDialog.pack();
    receiptDialog.setLocationRelativeTo(this);
    receiptDialog.setVisible(true);
}// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel nameLbl;
    public static javax.swing.JTextArea seatsLbl;
    public static javax.swing.JLabel ticketCounter;
    public static javax.swing.JLabel timeLbl;
    public static javax.swing.JLabel totalCounter;
    // End of variables declaration//GEN-END:variables
}
