import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame implements ActionListener {

    private JButton createExamButton;
    private JButton deleteExamButton;
    private JButton updateQuestionButton;
    private JButton addStudentButton;
    private JButton deleteQuestionButton;
    private JButton viewResultButton;

    public AdminPage() {
        // Set up the frame
        setTitle("Admin Page");
        setSize(1200, 800); // Increased frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main yellow panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.YELLOW);
        mainPanel.setLayout(new GridBagLayout()); // Center the white panel

        // White panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new GridLayout(6, 1, 10, 10)); // Adjusted for 6 rows and 1 column
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding inside white panel
        buttonPanel.setPreferredSize(new Dimension(400, 400)); // Set a larger preferred size for the white panel

        // Create the buttons
        createExamButton = new JButton("Create Exam");
        deleteExamButton = new JButton("Delete Exam");
        updateQuestionButton = new JButton("Update Question");
        addStudentButton = new JButton("Add Student");
        deleteQuestionButton = new JButton("Delete Question");
        viewResultButton = new JButton("View Result");

        // Apply style to each button
        styleButton(createExamButton);
        styleButton(deleteExamButton);
        styleButton(updateQuestionButton);
        styleButton(addStudentButton);
        styleButton(deleteQuestionButton);
        styleButton(viewResultButton);

        // Add buttons to the white panel in 6x1 layout
        buttonPanel.add(createExamButton);
        buttonPanel.add(deleteExamButton);
        buttonPanel.add(updateQuestionButton);
        buttonPanel.add(addStudentButton);
        buttonPanel.add(deleteQuestionButton);
        buttonPanel.add(viewResultButton);

        // Add white panel to main yellow panel
        mainPanel.add(buttonPanel);

        // Add main panel to frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        // Show which button was clicked
        JOptionPane.showMessageDialog(this, "You clicked: " + source.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminPage());
    }
}
