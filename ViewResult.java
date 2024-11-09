import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewResult {

    public static void main(String[] args) {
        // Create the frame (main window)
        JFrame frame = new JFrame("Show Student Results");

        // Set the frame's size (1200x800)
        frame.setSize(1200, 800);

        // Prevent the user from resizing the window
        frame.setResizable(false);

        // Set the layout to null to allow custom positioning
        frame.setLayout(null);

        // Create a JPanel with a white background and fixed size of 800x400
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(800, 400); // Setting the size of the panel
        panel.setLayout(null); // We will use null layout for manual positioning

        // Manually calculate the position to center the panel
        int x = (frame.getWidth() - panel.getWidth()) / 2;
        int y = (frame.getHeight() - panel.getHeight()) / 2;

        // Position the panel at the calculated (x, y)
        panel.setLocation(x, y);

        // Title label
        JLabel titleLabel = new JLabel("Student Results", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 10, 200, 30); // Fixed position within form panel
        panel.add(titleLabel);

        // Column names for the table
        String[] columnNames = { "UCE No", "Name", "Obtain Marks", "Total Marks" };

        // Create the table model and set the data (fetched from the database)
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // Fetch data from the database and populate the table
        fetchDataFromDatabase(model);

        // Set up table properties like fixed column widths and the ability to scroll
        table.setPreferredScrollableViewportSize(new Dimension(700, 300));
        table.setFillsViewportHeight(true);

        // Wrapping the table in a JScrollPane to add scroll functionality
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 60, 700, 300); // Positioning the table

        // Add the scrollPane (containing the table) to the panel
        panel.add(scrollPane);

        // Adding the panel to the frame
        frame.add(panel);

        // Set the background color of the entire frame (main background) to yellow
        frame.getContentPane().setBackground(Color.YELLOW);

        // Set the frame to exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Making the frame visible
        frame.setVisible(true);
    }

    // Method to fetch data from the database and update the table model
    private static void fetchDataFromDatabase(DefaultTableModel model) {
        // Set up database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database";  // Replace with your DB URL
        String user = "your_user";  // Replace with your DB username
        String password = "your_password";  // Replace with your DB password

        // SQL query to fetch student results
        String query = "SELECT uce_number, name, obtain_marks, total_marks FROM student_results";

        // Establish database connection
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Iterate through the result set and populate the table
            while (rs.next()) {
                String uceNo = rs.getString("uce_number");
                String name = rs.getString("name");
                int obtainMarks = rs.getInt("obtain_marks");
                int totalMarks = rs.getInt("total_marks");

                // Add the row to the table model
                model.addRow(new Object[] { uceNo, name, obtainMarks, totalMarks });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    // private static Object[][] fetchDataFromDatabase() {
    //     // Set up database connection parameters
    //     String url = "jdbc:mysql://localhost:3306/your_database";
    //     String user = "your_user";
    //     String password = "your_password";
    //     String query = "SELECT uce_number, name, obtain_marks, total_marks FROM student_results";
        
    //     Object[][] data = new Object[100][4];  // Adjust size based on expected data
    
    //     try (Connection conn = DriverManager.getConnection(url, user, password);
    //          Statement stmt = conn.createStatement();
    //          ResultSet rs = stmt.executeQuery(query)) {
    
    //         int row = 0;
    //         while (rs.next()) {
    //             data[row][0] = rs.getString("uce_number");
    //             data[row][1] = rs.getString("name");
    //             data[row][2] = rs.getInt("obtain_marks");
    //             data[row][3] = rs.getInt("total_marks");
    //             row++;
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    
    //     return data;
    // }
        