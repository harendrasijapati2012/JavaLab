import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class CustomerTable {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:sqlite:customers.db"; // Update this URL to match your database
        String user = ""; // Not required for SQLite
        String password = ""; // Not required for SQLite

        // Query to fetch customer data
        String query = "SELECT id, name, email, phone FROM customer";

        // Frame setup
        JFrame frame = new JFrame("Customer Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Table setup
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone");

        // Scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Fetch data and add to table model
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                tableModel.addRow(new Object[]{id, name, email, phone});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error fetching data", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Display the frame
        frame.setVisible(true);
    }
}

