package com.pethaven.view;

import java.awt.CardLayout;

/**
 * @author Chhantyal
 */
public class PetDashboard extends javax.swing.JFrame {
    
    // --- ADDED MEMORY COMPONENTS ---
    private static String registeredUser = "";
    private static String registeredPass = "";
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PetDashboard.class.getName());

    public PetDashboard() {
        initComponents();
        this.setLocationRelativeTo(null); // Centers the window
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        whiteParentPanel = new javax.swing.JPanel();
        LoginPanel = new javax.swing.JPanel();
        LoginButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SignUpPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        signupUser = new javax.swing.JTextField();
        signupPass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        signupEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(118, 172, 118));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PET HAVEN");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rescue. Care. Rehome.");

        // Logo Logic
        try {
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pethaven/view/catdog.png")));
        } catch (Exception e) {
            jLabel5.setText("Logo Image Missing");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        whiteParentPanel.setLayout(new java.awt.CardLayout());

        LoginPanel.setBackground(new java.awt.Color(255, 255, 255));
        LoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); 
        jLabel7.setForeground(new java.awt.Color(118, 172, 118));
        jLabel7.setText("WELCOME!");
        LoginPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(118, 172, 118));
        jLabel2.setText("Username:");
        LoginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        LoginPanel.add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        jLabel3.setForeground(new java.awt.Color(118, 172, 118));
        jLabel3.setText("Password:");
        LoginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        LoginPanel.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 200, 30));

        LoginButton1.setBackground(new java.awt.Color(118, 172, 118));
        LoginButton1.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton1.setText("Login");
        LoginButton1.addActionListener(evt -> LoginButton1ActionPerformed(evt));
        LoginPanel.add(LoginButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 239, 40));

        jLabel10.setText("Not a member?");
        LoginPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        LoginButton.setBackground(new java.awt.Color(118, 172, 118));
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Signup");
        LoginButton.addActionListener(evt -> LoginButtonActionPerformed(evt));
        LoginPanel.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 239, 40));

        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Forgot Password?");
        LoginPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        jLabel9.setForeground(new java.awt.Color(118, 172, 118));
        jLabel9.setText("Privacy Policy | Terms of Use");
        LoginPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        whiteParentPanel.add(LoginPanel, "login");

        SignUpPanel.setBackground(new java.awt.Color(255, 255, 255));
        SignUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jLabel11.setForeground(new java.awt.Color(118, 172, 118));
        jLabel11.setText("CREATE ACCOUNT");
        SignUpPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel12.setText("Username:");
        SignUpPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        SignUpPanel.add(signupUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 200, 30));

        jLabel13.setText("Email:");
        SignUpPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        SignUpPanel.add(signupEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 200, 30));

        jLabel14.setText("Password:");
        SignUpPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        SignUpPanel.add(signupPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 200, 30));

        jButton1.setBackground(new java.awt.Color(118, 172, 118));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Register");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        SignUpPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 200, 40));

        jButton2.setText("Back to Login");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));
        SignUpPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 200, 30));

        whiteParentPanel.add(SignUpPanel, "signup");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whiteParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(whiteParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    // --- BUTTON LOGIC ---

    // LOGIN ACTION [MODIFIED TO CONNECT TO DASHBOARD]
    private void LoginButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        
        // Checks Admin OR the Memory Variables
        if ((user.equals("admin") && pass.equals("1234")) || 
            (user.equals(registeredUser) && pass.equals(registeredPass) && !registeredUser.isEmpty())) {
            
            javax.swing.JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + user);
            
            // --- THE CONNECTION CODE ---
            new MainDashboard().setVisible(true); // Opens your table window
            this.dispose();                       // Closes this login window
            
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Login Error", 0);
        }
    }                                            

    // SWITCH TO SIGNUP
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        CardLayout card = (CardLayout) whiteParentPanel.getLayout();
        card.show(whiteParentPanel, "signup");
    }                                            

    // SWITCH TO LOGIN
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        CardLayout card = (CardLayout) whiteParentPanel.getLayout();
        card.show(whiteParentPanel, "login");
    }                                        

    // REGISTER ACTION
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String name = signupUser.getText();
        String pass = new String(signupPass.getPassword());

        if (name.isEmpty() || pass.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill in all fields!");
        } else {
            // Save to temporary memory
            registeredUser = name;
            registeredPass = pass;

            javax.swing.JOptionPane.showMessageDialog(this, "Successfully Registered: " + name);
            
            // Auto-switch back to login
            CardLayout card = (CardLayout) whiteParentPanel.getLayout();
            card.show(whiteParentPanel, "login");
        }
    }                                        

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new PetDashboard().setVisible(true));
    }

    // --- VARIABLES ---
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton LoginButton1;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel SignUpPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passField;
    private javax.swing.JTextField signupEmail;
    private javax.swing.JPasswordField signupPass;
    private javax.swing.JTextField signupUser;
    private javax.swing.JTextField userField;
    private javax.swing.JPanel whiteParentPanel;
}