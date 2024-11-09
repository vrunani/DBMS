import javax.swing.*;
import java.awt.*;

public class AdminPage1 {

    public static void main(String[] args) {
        // Setting the Look and Feel to ensure buttons use custom styles
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Creating the main frame
        JFrame frame = new JFrame("Smart Quiz Admin Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);  // Null layout for manual positioning

        // Setting yellow background for the frame
        frame.getContentPane().setBackground(Color.YELLOW);

        // Creating the first panel with a black background
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.setLayout(new FlowLayout());
        panel1.setBounds(0, 0, 600, 100); // Fixed size for the panel

        // Adding a label with a welcome message
        JLabel label1 = new JLabel("Welcome to Smart Quize");
        label1.setFont(new Font("Serif", Font.BOLD, 48));
        label1.setForeground(Color.WHITE);
        panel1.add(label1);

        // Creating the second panel for the form elements
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Vertical layout
        panel2.setBounds(0, 100, 600, 300); // Fixed size for the panel

        // Adding an icon (you can update the path of the image)
        JLabel iconLabel = new JLabel(new ImageIcon("path/to/sq1.png"));
        panel2.add(iconLabel);

        // Creating fields and buttons
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(33, 33, 33));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS)); // Vertical layout
        panel2.add(panel3);

        // Adding Email ID text field
        JTextField emailField = new JTextField("EMAIL ID");
        emailField.setPreferredSize(new Dimension(420, 40));
        panel3.add(emailField);

        // Adding another text field
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(420, 40));
        panel3.add(textField);

        // Creating and styling the login button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(new Color(66, 99, 0)); // Greenish background (#426300)
        loginButton.setForeground(Color.BLACK); // Black text
        loginButton.setFont(new Font("Serif", Font.BOLD, 24)); // Serif font, size 24, bold style
        loginButton.setPreferredSize(new Dimension(500, 40)); // Fixed size for the button
        loginButton.setFocusPainted(false); // Remove focus outline
        loginButton.setOpaque(true); // Ensure the background color is shown
        loginButton.setContentAreaFilled(true); // Ensure content area is filled with background color
        panel3.add(loginButton);

        // Adding the panel2 to the frame
        frame.add(panel1);
        frame.add(panel2);

        // Setting the frame visibility
        frame.setVisible(true);
    }
}
