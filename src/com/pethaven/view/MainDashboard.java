/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pethaven.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class MainDashboard extends javax.swing.JFrame {

    public MainDashboard() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { e.printStackTrace(); }
        
        initComponents();
        applyAestheticStyle();
    }

    private void applyAestheticStyle() {
        // 1. CUTE LOGOUT BUTTON: Soft yellow shades
        jButton2.setBackground(new Color(255, 249, 196)); // Lemon Chiffon
        jButton2.setOpaque(true);
        jButton2.setBorderPainted(false);
        jButton2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jButton2.setForeground(new Color(85, 85, 85)); // Dark grey text for readability

        // 2. FORCE WHITE BACKGROUNDS: No more corporate grey
        Color bgWhite = Color.WHITE;
        jPanel4.setBackground(bgWhite); // Inventory Tab
        jPanel5.setBackground(bgWhite); // Analytics Tab
        jPanel6.setBackground(bgWhite); // Gallery Tab
        jPanel7.setBackground(bgWhite); // Form Panel
        jTabbedPane1.setBackground(bgWhite);

        // 3. TABLE FIX: High-quality headers and spacing.
        jTable1.setRowHeight(35);
        jTable1.setShowGrid(false);
        jTable1.setIntercellSpacing(new Dimension(0, 0));
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable1.getTableHeader().setBackground(new Color(245, 245, 245));
        jScrollPane2.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)));

        // 4. ACTION BUTTONS: Force vibrancy
        styleBtn(jButton1, new Color(118, 172, 118)); // Green
        styleBtn(jButton5, new Color(100, 149, 237)); // Blue
        styleBtn(jButton4, new Color(255, 105, 97));  // Red

        // 5. SIZE FIX: Stop the table from taking 70% of the screen ok
        // This gives the registration panel a "Preferred" height so the table shrinks.
        jPanel7.setPreferredSize(new Dimension(0, 280)); 
    }

    private void styleBtn(JButton b, Color c) {
        b.setBackground(c);
        b.setForeground(Color.WHITE);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setFont(new Font("Segoe UI", Font.BOLD, 12));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new JPanel();
        jButton2 = new JButton("Logout");
        JLabel lblLogo = new JLabel("PET HAVEN");
        
        jTabbedPane1 = new JTabbedPane();
        
        // --- TAB 1: INVENTORY ---
        jPanel4 = new JPanel(new BorderLayout());
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jPanel7 = new JPanel(new BorderLayout()); // Registration Panel
        
        txtID = new JTextField();
        txtName = new JTextField();
        txtBreed = new JTextField();
        txtAge = new JTextField();
        jButton1 = new JButton("Add Pet");
        jButton5 = new JButton("Update Pet");
        jButton4 = new JButton("Remove Pet");

        // --- TAB 2 & 3: RESTORED PANELS ---
        jPanel5 = new JPanel(); // Analytics
        jPanel6 = new JPanel(); // Shelter Gallery

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pet Haven Management System");

        // Sidebar Branding
        jPanel1.setBackground(new Color(118, 172, 118));
        lblLogo.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
        lblLogo.setForeground(Color.WHITE);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblLogo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        // Inventory Tab Setup
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] { "Pet ID", "Name", "Breed", "Age" }
        ));
        jScrollPane2.setViewportView(jTable1);
        jPanel4.add(jScrollPane2, BorderLayout.CENTER);

        // Form Layout (Centered Grid)
        JPanel formGrid = new JPanel(new GridLayout(4, 2, 10, 10));
        formGrid.setOpaque(false);
        formGrid.add(new JLabel("Pet ID:")); formGrid.add(txtID);
        formGrid.add(new JLabel("Name:")); formGrid.add(txtName);
        formGrid.add(new JLabel("Breed:")); formGrid.add(txtBreed);
        formGrid.add(new JLabel("Age:")); formGrid.add(txtAge);

        JPanel btnBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        btnBar.setOpaque(false);
        btnBar.add(jButton1); btnBar.add(jButton5); btnBar.add(jButton4);

        jPanel7.setBorder(new TitledBorder(new LineBorder(new Color(230,230,230)), "Pet Registration", 0, 0, new Font("Segoe UI", 1, 13)));
        jPanel7.add(formGrid, BorderLayout.CENTER);
        jPanel7.add(btnBar, BorderLayout.SOUTH);
        jPanel4.add(jPanel7, BorderLayout.SOUTH);

        // Assembly
        jTabbedPane1.addTab("Manage Inventory", jPanel4);
        jTabbedPane1.addTab("Analytics", jPanel5);
        jTabbedPane1.addTab("Shelter Gallery", jPanel6);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1)
            .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainDashboard().setVisible(true));
    }

    private javax.swing.JButton jButton1, jButton2, jButton4, jButton5;
    private javax.swing.JPanel jPanel1, jPanel4, jPanel5, jPanel6, jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtID, txtName, txtBreed, txtAge;
}
