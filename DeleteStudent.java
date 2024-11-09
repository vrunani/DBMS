import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent {

    public static void main(String[] args) {
        // Creating the frame (main window)
        JFrame frame = new JFrame("Delete Student");

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

        // Delete button
        JButton deleteButton = new JButton("Delete Student");
        deleteButton.setBounds(350, 80, 150, 30);
        panel.add(deleteButton);

        // Action listener for the Delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = studentIDField.getText(); // Get the UCE number entered

                if (studentID.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid Student ID", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Logic to delete student based on the studentID
                    // For example, you would query the database here and remove the student
                    System.out.println("Student with UCE Number " + studentID + " is deleted.");
                    JOptionPane.showMessageDialog(frame, "Student with UCE Number " + studentID + " has been deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
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
