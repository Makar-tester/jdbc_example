import java.io.IOException;
import java.sql.*;


public class first_of_all {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        executeUpdate();

    }

    private static void executeQuery() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop?serverTimezone=UTC", "root", "Asassin2305");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from user")) {

            System.out.println("\nUsers:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("\n=================\n");
                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("email: " + email);
            }
        }
    }

    private static void executeUpdate() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop?serverTimezone=UTC", "root", "Asassin2305");
                Statement statement = connection.createStatement()) {
            int update = statement.executeUpdate("update user set email = 'makar@gmail.com'");
            System.out.println("rows changed:" + update);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

