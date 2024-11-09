import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent {

    public static void main(String[] args) {
        // Creating the frame (main window)
        JFrame frame = new JFrame("Add Student");

        // Setting the frame's size (1200x800)
        frame.setSize(1200, 800);

        // Preventing the user from resizing the window
        frame.setResizable(false);

        // Setting the layout to null to allow custom positioning
        frame.setLayout(null);

        // Creating a JPanel with a white background and fixed size of 800x400
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(800, 400); // Setting the size of the panel
        panel.setLayout(null); // We will use null layout for manual positioning

        // Manually calculate the position to center the panel
        int x = (frame.getWidth() - panel.getWidth()) / 2;
        int y = (frame.getHeight() - panel.getHeight()) / 2;

        // Position the panel at the calculated (x, y)
        panel.setLocation(x, y);

        // Creating components for the panel
        JLabel studentIDLabel = new JLabel("Student ID (UCE Number): ");
        studentIDLabel.setBounds(20, 20, 180, 30);
        panel.add(studentIDLabel);

        JTextField studentIDField = new JTextField();
        studentIDField.setBounds(200, 20, 200, 30);
        panel.add(studentIDField);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(20, 60, 100, 30);
        panel.add(firstNameLabel);

        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(120, 60, 200, 30);
        panel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(20, 100, 100, 30);
        panel.add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(120, 100, 200, 30);
        panel.add(lastNameField);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(20, 140, 100, 30);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120, 140, 200, 30);
        panel.add(passwordField);

        // Create a JCheckBox to toggle password visibility
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(120, 180, 150, 30);
        panel.add(showPasswordCheckBox);

        // Add action listener to show/hide password when checkbox is checked/unchecked
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField.setEchoChar((char) 0); // Show password
                } else {
                    passwordField.setEchoChar('*'); // Hide password
                }
            }
        });

        JLabel classLabel = new JLabel("Class: ");
        classLabel.setBounds(20, 220, 100, 30);
        panel.add(classLabel);

        // Create a JComboBox for class selection with predefined values
        String[] classOptions = {"First Year", "Second Year", "Third Year", "Last Year"};
        JComboBox<String> classComboBox = new JComboBox<>(classOptions);
        classComboBox.setBounds(120, 220, 200, 30);
        panel.add(classComboBox);

        // Add button
        JButton addButton = new JButton("Add Student");
        addButton.setBounds(350, 280, 150, 30);
        panel.add(addButton);

        // Variables to store values
        final String[] studentID = new String[1];
        final String[] firstName = new String[1];
        final String[] lastName = new String[1];
        final String[] password = new String[1];
        final String[] studentClass = new String[1];

        // Action listener for the Add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Store values in variables
                studentID[0] = studentIDField.getText();
                firstName[0] = firstNameField.getText();
                lastName[0] = lastNameField.getText();
                password[0] = new String(passwordField.getPassword());
                studentClass[0] = (String) classComboBox.getSelectedItem(); // Get selected class from combo box

                // Output the added student details to the console (or process them as needed)
                System.out.println("Student ID: " + studentID[0]);
                System.out.println("First Name: " + firstName[0]);
                System.out.println("Last Name: " + lastName[0]);
                System.out.println("Password: " + password[0]);
                System.out.println("Class: " + studentClass[0]);
            }
        });

        // Adding the white panel to the frame
        frame.add(panel);

        // Setting the background color of the entire frame (main background) to yellow
        frame.getContentPane().setBackground(Color.YELLOW);

        // Setting the frame to exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centering the frame on the screen
        frame.setLocationRelativeTo(null);

        // Making the frame visible
        frame.setVisible(true);
    }
}
