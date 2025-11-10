package productsalesapplication;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class ProductSalesApplication {

    // Two-dimensional array for product sales data
    private final double[][] productSales = {
        {300, 150, 700}, // Sales for year 1
        {250, 200, 600}  // Sales for year 2
    };

    private final String[] years = {"Sales for Year 1", "Sales for Year 2"};
    private final String[] equipment = {"Microphone", "Speakers", "Mixing Desk"};
    private final int limit = 500;

    // Method to calculate total sales
     double calculateTotalSales(double[][] productSales) {
        double total = 0;
        for (double[] year : productSales) {
            for (double sale : year) {
                total += sale;
            }
        }
        return total;
    }

    // Method to calculate average sales
    public double calculateAverageSales(double[][] productSales) {
        double total = 0;
        int count = 0;

        for (double[] year : productSales) {
            for (double sale : year) {
                total += sale;
                count++;
            }
        }
        return (count > 0) ? total / count : 0;
    }

    // Get sales over limit as a string
    public String getSalesOverLimit(double[][] productSales, int limit) {
        StringBuilder result = new StringBuilder();
        for (int year = 0; year < productSales.length; year++) {
            result.append("Year ").append(year + 1).append(": ");
            for (double sale : productSales[year]) {
                if (sale > limit) {
                    result.append(sale).append(" ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    // Get sales under limit as a string
    public String getSalesUnderLimit(double[][] productSales, int limit) {
        StringBuilder result = new StringBuilder();
        for (int year = 0; year < productSales.length; year++) {
            result.append("Year ").append(year + 1).append(": ");
            for (double sale : productSales[year]) {
                if (sale < limit) {
                    result.append(sale).append(" ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    // Main entry point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApplication().createAndShowGUI());
    }

    // Create and display GUI
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Product Sales Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem loadProductData = new JMenuItem("Load Product Data");
        JMenuItem saveProductData = new JMenuItem("Save Product Data");
        JMenuItem clear = new JMenuItem("Clear");

        fileMenu.add(exit);
        toolsMenu.add(loadProductData);
        toolsMenu.add(saveProductData);
        toolsMenu.add(clear);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        frame.setJMenuBar(menuBar);

        // Header
        JPanel header = new JPanel();
        header.setBackground(Color.LIGHT_GRAY);
        JLabel lblTitle = new JLabel("Product Sales Calculator");
        header.add(lblTitle);
        frame.add(header, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton btnLoadProductData = new JButton("Load Product Data");
        JButton btnSaveProductData = new JButton("Save Product Data");
        buttonPanel.add(btnLoadProductData);
        buttonPanel.add(btnSaveProductData);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        
        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // === Actions ===

        // Exit
        exit.addActionListener(e -> System.exit(0));

        // Clear text area
        clear.addActionListener(e -> textArea.setText(""));

        // Load product data
        ActionListener loadAction = e -> {
            double totalSales = calculateTotalSales(productSales);
            double averageSales = calculateAverageSales(productSales);
            String overLimit = getSalesOverLimit(productSales, limit);
            String underLimit = getSalesUnderLimit(productSales, limit);

            StringBuilder output = new StringBuilder();
            output.append("=== PRODUCT SALES REPORT ===\n\n");
            output.append("Total Sales: ").append(totalSales).append("\n");
            output.append("Average Sales: ").append(String.format("%.2f", averageSales)).append("\n\n");
            output.append("Sales Over Limit (").append(limit).append("):\n").append(overLimit).append("\n");
            output.append("Sales Under Limit (").append(limit).append("):\n").append(underLimit);

            textArea.setText(output.toString());
        };

        btnLoadProductData.addActionListener(loadAction);
        loadProductData.addActionListener(loadAction);

        // Save product data
        ActionListener saveAction = e -> {
            String path = "data.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(frame, "Data saved successfully to " + path);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
            }
        };

        btnSaveProductData.addActionListener(saveAction);
        saveProductData.addActionListener(saveAction);

        // Show frame
        frame.setVisible(true);
    }
}
