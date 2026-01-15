package com.pethaven.view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * FINAL FULL VERSION - 2026
 * All requirements: Selection, Insertion, Merge Sorts + Search.
 */
public class MainDashboard extends JFrame {

    // --- DATA STRUCTURES ---
    private final ArrayList<PetData> petList = new ArrayList<>();
    private DefaultTableModel tableModel;
    
    // --- UI COMPONENTS ---
    private JTable jTable1;
    private JTextField txtPetID, txtPetName, txtPetBreed, txtPetAge, txtSearchField;
    private JLabel lblTotalCount;

    // Pet Data Model Class
    class PetData {
        String id, name, breed;
        int age;
        PetData(String id, String name, String breed, int age) {
            this.id = id; this.name = name; this.breed = breed; this.age = age;
        }
    }

    public MainDashboard() {
        // Initialize the UI Components first to prevent NullPointerException
        setupUI();
        
        // Window Configuration
        this.setTitle("Pet Haven Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
    }

    private void setupUI() {
        // 1. Sidebar Design
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(118, 172, 118)); // Soft Green
        sidebar.setPreferredSize(new Dimension(200, 0));
        sidebar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        
        JLabel logo = new JLabel("PET HAVEN");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("SansSerif", Font.BOLD, 24));
        sidebar.add(logo);

        // 2. Main Area (Table and Inputs)
        JPanel mainArea = new JPanel(new BorderLayout(15, 15));
        mainArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Top Search Bar
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSearchField = new JTextField(20);
        JButton btnSearch = new JButton("Search Pet (Linear)");
        JButton btnBinarySearch = new JButton("Search Pet (Binary)");
        lblTotalCount = new JLabel("Total Pets: 0");
        searchPanel.add(new JLabel("Name:"));
        searchPanel.add(txtSearchField);
        searchPanel.add(btnSearch);
        searchPanel.add(btnBinarySearch);
        searchPanel.add(lblTotalCount);

        // Table Setup
        String[] columns = {"ID", "Name", "Breed", "Age"};
        tableModel = new DefaultTableModel(columns, 0);
        jTable1 = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(jTable1);

        // Bottom Control Panel (Inputs & Buttons)
        JPanel footer = new JPanel(new GridLayout(1, 2, 20, 0));
        
        // Input Section
        JPanel inputs = new JPanel(new GridLayout(4, 2, 10, 10));
        inputs.setBorder(BorderFactory.createTitledBorder("Add New Pet"));
        inputs.add(new JLabel("Pet ID:")); txtPetID = new JTextField(); inputs.add(txtPetID);
        inputs.add(new JLabel("Name:")); txtPetName = new JTextField(); inputs.add(txtPetName);
        inputs.add(new JLabel("Breed:")); txtPetBreed = new JTextField(); inputs.add(txtPetBreed);
        inputs.add(new JLabel("Age:")); txtPetAge = new JTextField(); inputs.add(txtPetAge);

        // Sort/Action Section
        JPanel buttons = new JPanel(new GridLayout(3, 2, 10, 10));
        JButton btnAdd = new JButton("Add Pet");
        JButton btnDelete = new JButton("Delete Selected");
        JButton btnSortID = new JButton("Sort ID (Selection)");
        JButton btnSortName = new JButton("Sort Name (Insertion)");
        JButton btnSortAge = new JButton("Sort Age (Merge)");
        JButton btnClear = new JButton("Clear Fields");

        buttons.add(btnAdd); buttons.add(btnDelete);
        buttons.add(btnSortID); buttons.add(btnSortName);
        buttons.add(btnSortAge); buttons.add(btnClear);

        footer.add(inputs);
        footer.add(buttons);

        // Add to main Area
        mainArea.add(searchPanel, BorderLayout.NORTH);
        mainArea.add(scrollPane, BorderLayout.CENTER);
        mainArea.add(footer, BorderLayout.SOUTH);

        // 3. Assemble Frame
        this.add(sidebar, BorderLayout.WEST);
        this.add(mainArea, BorderLayout.CENTER);

        // --- BUTTON ACTIONS ---
        btnAdd.addActionListener(e -> addPet());
        btnDelete.addActionListener(e -> deletePet());
        btnClear.addActionListener(e -> clearFields());
        btnSearch.addActionListener(e -> performLinearSearch());
        btnBinarySearch.addActionListener(e -> performBinarySearch());
        btnSortID.addActionListener(e -> selectionSortByID());
        btnSortName.addActionListener(e -> insertionSortByName());
        btnSortAge.addActionListener(e -> startMergeSort());
    }

    // --- ALGORITHMS & LOGIC ---

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (PetData p : petList) {
            tableModel.addRow(new Object[]{p.id, p.name, p.breed, p.age});
        }
        lblTotalCount.setText("Total Pets: " + petList.size());
    }

    private void addPet() {
        try {
            petList.add(new PetData(txtPetID.getText(), txtPetName.getText(), 
                        txtPetBreed.getText(), Integer.parseInt(txtPetAge.getText())));
            refreshTable();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Age must be a number!");
        }
    }

    private void deletePet() {
        int row = jTable1.getSelectedRow();
        if (row != -1) { 
            petList.remove(row); 
            refreshTable(); 
        }
    }

    private void clearFields() {
        txtPetID.setText(""); txtPetName.setText(""); 
        txtPetBreed.setText(""); txtPetAge.setText("");
    }

    // SEARCH 1: LINEAR SEARCH
    private void performLinearSearch() {
        String s = txtSearchField.getText().toLowerCase();
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).name.toLowerCase().contains(s)) {
                jTable1.setRowSelectionInterval(i, i);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Pet not found!");
    }

    // SEARCH 2: BINARY SEARCH (Requires Name Sort First)
    private void performBinarySearch() {
        insertionSortByName(); // List must be sorted for Binary Search
        String target = txtSearchField.getText().toLowerCase();
        int low = 0, high = petList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = target.compareTo(petList.get(mid).name.toLowerCase());
            if (res == 0) {
                jTable1.setRowSelectionInterval(mid, mid);
                return;
            }
            if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        JOptionPane.showMessageDialog(this, "Pet not found via Binary Search!");
    }

    // SORT 1: SELECTION SORT (By ID)
    private void selectionSortByID() {
        for (int i = 0; i < petList.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < petList.size(); j++) {
                if (petList.get(j).id.compareTo(petList.get(min).id) < 0) min = j;
            }
            Collections.swap(petList, i, min);
        }
        refreshTable();
    }

    // SORT 2: INSERTION SORT (By Name)
    private void insertionSortByName() {
        for (int i = 1; i < petList.size(); i++) {
            PetData key = petList.get(i);
            int j = i - 1;
            while (j >= 0 && petList.get(j).name.compareToIgnoreCase(key.name) > 0) {
                petList.set(j + 1, petList.get(j));
                j--;
            }
            petList.set(j + 1, key);
        }
        refreshTable();
    }

    // SORT 3: MERGE SORT (By Age)
    private void startMergeSort() {
        if (petList.size() > 1) {
            mergeSort(0, petList.size() - 1);
            refreshTable();
        }
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {
        ArrayList<PetData> left = new ArrayList<>(petList.subList(low, mid + 1));
        ArrayList<PetData> right = new ArrayList<>(petList.subList(mid + 1, high + 1));
        int i = 0, j = 0, k = low;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).age <= right.get(j).age) petList.set(k++, left.get(i++));
            else petList.set(k++, right.get(j++));
        }
        while (i < left.size()) petList.set(k++, left.get(i++));
        while (j < right.size()) petList.set(k++, right.get(j++));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }
}