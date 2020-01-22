
import java.sql.*;

public class Execute_only {
    final static String USER = "root";
    final static String PASSWORD = "Asassin2305";
    final static String URL = "jdbc:mysql://localhost/eshop?serverTimezone=UTC";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        executeUpdating();
    }

    private static void executeSelect() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            boolean exec = statement.execute("select * from user");
            ResultSet resultSet = statement.getResultSet();
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


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void executeUpdating() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                  Statement statement = connection.createStatement()) {
            boolean exec1 = statement.execute("update user set email='mak@gmail.com'");
            int up=statement.getUpdateCount();
            System.out.println("rows changed:" + up);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}