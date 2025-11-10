
package productsalesapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ProductSalesApplication {

   // Two dimensional array
   double[][] productSales = {
        {300, 150, 700}, // sales for year 1
        {250, 200, 600}, // sales for year 2
    };

      String[] years = {"Sales for year 1", "Sales for year 2"};
      String[] equipment = {"Microphone", "Speakers", "Mixing Desk"};
      
      int limit = 500;

    
    
      // Method to calculate total sales
    public static double calculateTotalSales(double[][] productSales) {
        double total = 0;

        for (double[] year : productSales) {
            for (double sale : year) {
                total += sale;
            }
        }

        return total;
    }
     

   // Method to calculate average sales
    public  double calculateAverageSales(double[][] productSales) {
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
    
    
    // Get sales over limit as a String
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
    
    
    // Get sales under limit as a String
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

    
  
    
    public static void main(String[] args) {
        
    
        
        JFrame frame = new JFrame("Product Sales Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());
        
        
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem loadProductData = new JMenuItem("Load Product Data");
        JMenuItem saveProductData = new JMenuItem("Save Product Data");
        JMenuItem clear = new JMenuItem("Clear");
        
        file.add(exit);
        tools.add(loadProductData);
        tools.add(saveProductData);
        tools.add(clear);
        
        menuBar.add(file);
        menuBar.add(tools);
        frame.setJMenuBar(menuBar);
        
        
        // Header
        JPanel header = new JPanel();
        header.setBackground(Color.LIGHT_GRAY);
        JLabel lblTitle = new JLabel("Calculator");
        header.add(lblTitle);
        frame.add(header, BorderLayout.NORTH);
        
        // TEXT AREA
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        
         //Declear Buttons
         JPanel buttonPanel = new JPanel();
        JButton btnLoadProductData = new JButton("Load Product Data");
        JButton btnSaveProductData = new JButton("Save Product Data");
        
        
        
        // Components to the frame
        buttonPanel.add(btnLoadProductData);
        buttonPanel.add(btnSaveProductData);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        
        
        
        // Actions
        
        // Save answer to file
        save.addActionListener(e -> {
            String path = "answer.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
                writer.write(.getText());
                writer.newLine();
                JOptionPane.showMessageDialog(frame, "Answer saved to file!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
            }
        });

        // Exit
        exit.addActionListener(e -> System.exit(0));
        
        
        
        
        frame.setVisible(true);
    }
    
}
