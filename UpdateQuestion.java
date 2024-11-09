import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateQuestion {

    public static void main(String[] args) {
        // Creating the frame (main window)
        JFrame frame = new JFrame("Update Question");

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
        JLabel questionNoLabel = new JLabel("Question No: ");
        questionNoLabel.setBounds(20, 20, 100, 30);
        panel.add(questionNoLabel);

        JTextField questionNoField = new JTextField();
        questionNoField.setBounds(120, 20, 50, 30);
        panel.add(questionNoField);

        JLabel questionLabel = new JLabel("Question: ");
        questionLabel.setBounds(20, 60, 100, 30);
        panel.add(questionLabel);

        JTextField questionField = new JTextField();
        questionField.setBounds(120, 60, 600, 30);
        panel.add(questionField);

        JLabel option1Label = new JLabel("Option 1: ");
        option1Label.setBounds(20, 100, 100, 30);
        panel.add(option1Label);

        JTextField option1Field = new JTextField();
        option1Field.setBounds(120, 100, 600, 30);
        panel.add(option1Field);

        JLabel option2Label = new JLabel("Option 2: ");
        option2Label.setBounds(20, 140, 100, 30);
        panel.add(option2Label);

        JTextField option2Field = new JTextField();
        option2Field.setBounds(120, 140, 600, 30);
        panel.add(option2Field);

        JLabel option3Label = new JLabel("Option 3: ");
        option3Label.setBounds(20, 180, 100, 30);
        panel.add(option3Label);

        JTextField option3Field = new JTextField();
        option3Field.setBounds(120, 180, 600, 30);
        panel.add(option3Field);

        JLabel option4Label = new JLabel("Option 4: ");
        option4Label.setBounds(20, 220, 100, 30);
        panel.add(option4Label);

        JTextField option4Field = new JTextField();
        option4Field.setBounds(120, 220, 600, 30);
        panel.add(option4Field);

        JLabel correctOptionLabel = new JLabel("Correct Option Number: ");
        correctOptionLabel.setBounds(20, 260, 200, 30);
        panel.add(correctOptionLabel);

        JTextField correctOptionField = new JTextField();
        correctOptionField.setBounds(200, 260, 50, 30);
        panel.add(correctOptionField);

        // Update button
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(350, 320, 100, 30);
        panel.add(updateButton);

        // Variables to store values
        final String[] questionNo = new String[1];
        final String[] question = new String[1];
        final String[] option1 = new String[1];
        final String[] option2 = new String[1];
        final String[] option3 = new String[1];
        final String[] option4 = new String[1];
        final String[] correctOption = new String[1];

        // Action listener for the Update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Store values in variables
                questionNo[0] = questionNoField.getText();
                question[0] = questionField.getText();
                option1[0] = option1Field.getText();
                option2[0] = option2Field.getText();
                option3[0] = option3Field.getText();
                option4[0] = option4Field.getText();
                correctOption[0] = correctOptionField.getText();

                // Output the updated values to the console (or process them as needed)
                System.out.println("Updated Question No: " + questionNo[0]);
                System.out.println("Updated Question: " + question[0]);
                System.out.println("Updated Option 1: " + option1[0]);
                System.out.println("Updated Option 2: " + option2[0]);
                System.out.println("Updated Option 3: " + option3[0]);
                System.out.println("Updated Option 4: " + option4[0]);
                System.out.println("Updated Correct Option: " + correctOption[0]);
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
