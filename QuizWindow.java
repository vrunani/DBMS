import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuizWindow {
    private static int questionIndex = 0; // Track the current question
    private static int selectedOption = -1; // Track the selected option number
    private static ArrayList<String[]> questions; // Placeholder for questions from database

    public static void main(String[] args) {
        // Fetch questions from the database
        questions = DatabaseHelper.fetchQuestions();
        
        if (questions.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No questions found in the database.");
            return;
        }

        // Create the main frame
        JFrame frame = new JFrame("Quiz");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create the white panel
        JPanel panel = new JPanel();
        panel.setBounds(200, 200, 800, 400);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        // Question number label
        JLabel questionNoLabel = new JLabel("Question No. " + (questionIndex + 1));
        questionNoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionNoLabel.setBounds(50, 20, 200, 30);
        panel.add(questionNoLabel);

        // Question text label
        JLabel questionLabel = new JLabel("Question: " + questions.get(questionIndex)[0]);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setBounds(50, 60, 700, 30);
        panel.add(questionLabel);

        // Grouped checkboxes for options
        ButtonGroup optionsGroup = new ButtonGroup();
        JRadioButton option1 = new JRadioButton(questions.get(questionIndex)[1]);
        JRadioButton option2 = new JRadioButton(questions.get(questionIndex)[2]);
        JRadioButton option3 = new JRadioButton(questions.get(questionIndex)[3]);
        JRadioButton option4 = new JRadioButton(questions.get(questionIndex)[4]);

        option1.setBounds(50, 120, 700, 30);
        option2.setBounds(50, 160, 700, 30);
        option3.setBounds(50, 200, 700, 30);
        option4.setBounds(50, 240, 700, 30);

        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);

        // Action listeners to track selected option
        option1.addActionListener(e -> selectedOption = 1);
        option2.addActionListener(e -> selectedOption = 2);
        option3.addActionListener(e -> selectedOption = 3);
        option4.addActionListener(e -> selectedOption = 4);

        // Next Button
        JButton nextButton = new JButton("NEXT");
        nextButton.setBackground(new Color(255, 204, 0));
        nextButton.setForeground(Color.BLACK);
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBounds(600, 300, 100, 40);
        panel.add(nextButton);

        // ActionListener for Next Button to go to the next question
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedOption == -1) {
                    JOptionPane.showMessageDialog(frame, "Please select an option.");
                    return;
                }

                System.out.println("Selected Option for Question " + (questionIndex + 1) + ": Option " + selectedOption);

                // Reset selection for next question
                optionsGroup.clearSelection();
                selectedOption = -1;

                // Load the next question if available
                questionIndex++;
                if (questionIndex < questions.size()) {
                    questionNoLabel.setText("Question No. " + (questionIndex + 1));
                    questionLabel.setText("Question: " + questions.get(questionIndex)[0]);
                    option1.setText(questions.get(questionIndex)[1]);
                    option2.setText(questions.get(questionIndex)[2]);
                    option3.setText(questions.get(questionIndex)[3]);
                    option4.setText(questions.get(questionIndex)[4]);
                } else {
                    JOptionPane.showMessageDialog(frame, "End of Quiz!");
                    frame.dispose(); // Close the frame at the end of the quiz
                }
            }
        });

        // Add the white panel to the frame
        frame.add(panel);
        frame.getContentPane().setBackground(new Color(255, 204, 0)); // Background color for main frame
        frame.setVisible(true);
    }
}
