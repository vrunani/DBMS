import java.sql.*;
import java.util.ArrayList;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/quiz_db";
    private static final String USER = "root"; // Use your MySQL username
    private static final String PASSWORD = "password"; // Use your MySQL password

    public static ArrayList<String[]> fetchQuestions() {
        ArrayList<String[]> questions = new ArrayList<>();
        String query = "SELECT question, option1, option2, option3, option4 FROM questions";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String question = resultSet.getString("question");
                String option1 = resultSet.getString("option1");
                String option2 = resultSet.getString("option2");
                String option3 = resultSet.getString("option3");
                String option4 = resultSet.getString("option4");

                questions.add(new String[]{question, option1, option2, option3, option4});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }
}
