import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    public Connection getConnection() throws SQLException {
        return getConnection("persona");
    }

    public Connection getConnection(String dbName) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("driver not found");
            System.exit(0);
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, "root", "root");
    }
}
