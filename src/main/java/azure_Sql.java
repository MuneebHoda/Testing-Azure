import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class azure_Sql {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/learning_azure";
        String user = "root";
        String password = "folio3";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established: " + url);
            String insertQuery = "Insert into test_azuredb(id,Name,Age,Gender) values(103,'Muneeb',21,'M')";
            Statement statement = connection.createStatement();
            statement.execute(insertQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
