import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentManagementSystem extends JFrame {
    private JTextField usernameField, passwordField;
    private JButton loginButton;
    private JPanel loginPanel, studentFormPanel, displayPanel;
    private JTextField nameField, rollNumberField;
    private JList<String> qualificationList;
    private JComboBox<String> subjectComboBox;
    private JTextField pStateField, pDistrictField, pWardField, pStreetField;
    private JTextField tStateField, tDistrictField, tWardField, tStreetField;
    private JButton saveButton, displayButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;

    private Connection connection;

    public StudentManagementSystem() {
        super("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeDatabase();
        createLoginPanel();
        createStudentFormPanel();
        createDisplayPanel();

        setLayout(new CardLayout());
        add(loginPanel, "login");
        add(studentFormPanel, "studentForm");
        add(displayPanel, "display");

        setVisible(true);
    }

    private void initializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }

    private void createLoginPanel() {
        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            if (validateLogin(usernameField.getText(), new String(((JPasswordField) passwordField).getPassword()))) {
                ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "studentForm");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        // Implement your login validation logic here
        return username.equals("admin") && password.equals("password");
    }

    private void createStudentFormPanel() {
        studentFormPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        nameField = new JTextField(20);
        rollNumberField = new JTextField(20);
        qualificationList = new JList<>(new String[]{"High School", "Bachelor's", "Master's", "PhD"});
        subjectComboBox = new JComboBox<>(new String[]{"Mathematics", "Physics", "Chemistry", "Biology", "Computer Science"});

        pStateField = new JTextField(20);
        pDistrictField = new JTextField(20);
        pWardField = new JTextField(20);
        pStreetField = new JTextField(20);

        tStateField = new JTextField(20);
        tDistrictField = new JTextField(20);
        tWardField = new JTextField(20);
        tStreetField = new JTextField(20);

        saveButton = new JButton("Save");
        displayButton = new JButton("Display All");

        gbc.gridx = 0;
        gbc.gridy = 0;
        studentFormPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        studentFormPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        studentFormPanel.add(new JLabel("Roll Number:"), gbc);

        gbc.gridx = 1;
        studentFormPanel.add(rollNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        studentFormPanel.add(new JLabel("Qualification:"), gbc);

        gbc.gridx = 1;
        studentFormPanel.add(new JScrollPane(qualificationList), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        studentFormPanel.add(new JLabel("Subject:"), gbc);

        gbc.gridx = 1;
        studentFormPanel.add(subjectComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        studentFormPanel.add(new JLabel("Permanent Address:"), gbc);

        gbc.gridy = 5;
        studentFormPanel.add(new JLabel("State:"), gbc);
        gbc.gridx = 1;
        studentFormPanel.add(pStateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        studentFormPanel.add(new JLabel("District:"), gbc);
        gbc.gridx = 1;
        studentFormPanel.add(pDistrictField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        studentFormPanel.add(new JLabel("Ward No:"), gbc);
        gbc.gridx = 1;
        studentFormPanel.add(pWardField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        studentFormPanel.add(new JLabel("Street Address:"), gbc);
        gbc.gridx = 1;
        studentFormPanel.add(pStreetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        studentFormPanel.add(new JLabel("Temporary Address:"), gbc);

        gbc.gridy = 10;
        studentFormPanel.add(new JLabel("State:"), gbc);
        gbc.gridx = 1;
        studentFormPanel.add(tStateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        studentFormPanel.add(new JLabel("District:"), gbc);
        gbc.gridx = 1;
        studentFormPanel.add(tDistrictField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        studentFormPanel.add(new JLabel("Ward No:"), gbc);
        gbc.gridx = 1;
        studentFormPanel.add(tWardField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        studentFormPanel.add(new JLabel("Street Address:"), gbc);
        gbc.gridx = 1;
        studentFormPanel.add(tStreetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        studentFormPanel.add(saveButton, gbc);

        gbc.gridy = 15;
        studentFormPanel.add(displayButton, gbc);

        saveButton.addActionListener(e -> saveStudentData());
        displayButton.addActionListener(e -> ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "display"));
    }

    private void createDisplayPanel() {
        displayPanel = new JPanel(new BorderLayout());

        String[] columnNames = {"Name", "Roll Number", "Qualification", "Subject", "Permanent Address", "Temporary Address"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(studentTable);
        displayPanel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Form");
        backButton.addActionListener(e -> ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "studentForm"));
        displayPanel.add(backButton, BorderLayout.SOUTH);
    }

    private void saveStudentData() {
        try {
            String sql = "INSERT INTO students (name, roll_number, qualification, subject, p_state, p_district, p_ward, p_street, t_state, t_district, t_ward, t_street) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, nameField.getText());
            pstmt.setString(2, rollNumberField.getText());
            pstmt.setString(3, qualificationList.getSelectedValue());
            pstmt.setString(4, (String) subjectComboBox.getSelectedItem());
            pstmt.setString(5, pStateField.getText());
            pstmt.setString(6, pDistrictField.getText());
            pstmt.setString(7, pWardField.getText());
            pstmt.setString(8, pStreetField.getText());
            pstmt.setString(9, tStateField.getText());
            pstmt.setString(10, tDistrictField.getText());
            pstmt.setString(11, tWardField.getText());
            pstmt.setString(12, tStreetField.getText());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student data saved successfully");
            clearForm();
            loadStudentData();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving student data: " + e.getMessage());
        }
    }

    private void clearForm() {
        nameField.setText("");
        rollNumberField.setText("");
        qualificationList.clearSelection();
        subjectComboBox.setSelectedIndex(0);
        pStateField.setText("");
        pDistrictField.setText("");
        pWardField.setText("");
        pStreetField.setText("");
        tStateField.setText("");
        tDistrictField.setText("");
        tWardField.setText("");
        tStreetField.setText("");
    }

    private void loadStudentData() {
        tableModel.setRowCount(0);
        try {
            String sql = "SELECT * FROM students";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                String rollNumber = rs.getString("roll_number");
                String qualification = rs.getString("qualification");
                String subject = rs.getString("subject");
                String pAddress = rs.getString("p_state") + ", " + rs.getString("p_district") + ", " + rs.getString("p_ward") + ", " + rs.getString("p_street");
                String tAddress = rs.getString("t_state") + ", " + rs.getString("t_district") + ", " + rs.getString("t_ward") + ", " + rs.getString("t_street");

                tableModel.addRow(new Object[]{name, rollNumber, qualification, subject, pAddress, tAddress});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading student data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementSystem::new);
    }
}