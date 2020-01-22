import java.sql.*;

public class transaction {
    final static String USER = "root";
    final static String PASSWORD = "Asassin2305";
    final static String URL = "jdbc:mysql://localhost/bank?serverTimezone=UTC";

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        printAccount();
        updateAmounts();

        printAccount();
    }

    private static void updateAmounts() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.executeUpdate("update account set amount=100 where id=1");
            statement.executeUpdate("update account set amount=200 where id=2");

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void printAccount(){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from account");

            while(resultSet.next()) {

                System.out.println("id: "+ resultSet.getInt("id"));
                System.out.println("amount: "+ resultSet.getInt("amount"));
                System.out.println("\n========================================\n");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

