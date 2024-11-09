import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLogin {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Admin Login");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create the white panel
        JPanel panel = new JPanel();
        panel.setBounds(200, 200, 800, 400);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Admin Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBounds(300, 30, 200, 40);
        panel.add(titleLabel);

        // Back label
        JLabel backLabel = new JLabel("Back");
        backLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        backLabel.setForeground(Color.BLUE);
        backLabel.setBounds(10, 10, 50, 30);
        frame.add(backLabel);

        // Add mouse listener to the "Back" label to navigate to StudentLogin
        backLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Close current frame
                UserSelection.main(null); // Open StudentLogin frame
            }
        });

        // Icon label with scaled image
        JLabel iconLabel = new JLabel();
        iconLabel.setBounds(50, 100, 200, 200);
        
        // Load and scale the image
        ImageIcon adminIcon = new ImageIcon("Teacher.jpeg"); // Replace with your actual image path
        Image scaledImage = adminIcon.getImage().getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), Image.SCALE_SMOOTH);
        iconLabel.setIcon(new ImageIcon(scaledImage));
        panel.add(iconLabel);

        // Email Label and Field
        JLabel emailLabel = new JLabel("Email Id");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        emailLabel.setBounds(300, 100, 100, 30);
        panel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(400, 100, 250, 30);
        panel.add(emailField);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setBounds(300, 150, 100, 30);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(400, 150, 250, 30);
        panel.add(passwordField);

        // Show Password Checkbox
        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(400, 190, 150, 30);
        showPassword.setBackground(Color.WHITE);
        panel.add(showPassword);

        // ActionListener to show/hide password
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0); // Show password
                } else {
                    passwordField.setEchoChar('*'); // Hide password
                }
            }
        });

        // Login Button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(new Color(255, 204, 0));
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBounds(400, 230, 100, 40);
        panel.add(loginButton);

        // ActionListener to print email and password on button click
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve and store email and password
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Print email and password to the console
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }
        });

        // Add the white panel to the frame
        frame.add(panel);
        frame.getContentPane().setBackground(new Color(255, 204, 0)); // Background color for main frame
        frame.setVisible(true);
    }
}
