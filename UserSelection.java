import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserSelection {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("User Selection");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create the white panel
        JPanel panel = new JPanel();
        panel.setBounds(200, 200, 800, 400);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Choose Login Type");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBounds(300, 30, 300, 40);
        panel.add(titleLabel);

        // Student Image and Label
        JLabel studentLabel = new JLabel("Student Login", JLabel.CENTER);
        studentLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        studentLabel.setBounds(100, 300, 200, 40);
        panel.add(studentLabel);

        JLabel studentIconLabel = new JLabel();
        studentIconLabel.setBounds(100, 100, 200, 200);

        ImageIcon studentIcon = new ImageIcon("student.jpeg"); // Replace with the actual path
        Image scaledStudentImage = studentIcon.getImage().getScaledInstance(studentIconLabel.getWidth(), studentIconLabel.getHeight(), Image.SCALE_SMOOTH);
        studentIconLabel.setIcon(new ImageIcon(scaledStudentImage));
        panel.add(studentIconLabel);

        // Admin Image and Label
        JLabel adminLabel = new JLabel("Admin Login", JLabel.CENTER);
        adminLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        adminLabel.setBounds(500, 300, 200, 40);
        panel.add(adminLabel);

        JLabel adminIconLabel = new JLabel();
        adminIconLabel.setBounds(500, 100, 200, 200);

        ImageIcon adminIcon = new ImageIcon("teacher.jpeg"); // Replace with the actual path
        Image scaledAdminImage = adminIcon.getImage().getScaledInstance(adminIconLabel.getWidth(), adminIconLabel.getHeight(), Image.SCALE_SMOOTH);
        adminIconLabel.setIcon(new ImageIcon(scaledAdminImage));
        panel.add(adminIconLabel);

        // Mouse listeners for navigating to StudentLogin and AdminLogin
        studentIconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Close current frame
                StudentLogin.main(null); // Open StudentLogin frame
            }
        });

        adminIconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Close current frame
                AdminLogin.main(null); // Open AdminLogin frame
            }
        });

        // Add the panel to the frame
        frame.add(panel);
        frame.getContentPane().setBackground(new Color(255, 204, 0)); // Background color for main frame
        frame.setVisible(true);
    }
}
