import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/jdbc_learning";
    public static final String USER = "root";
    public static final String PASS = "gnncrz.MySQL";
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection successful");
        } catch(ClassNotFoundException | SQLException e ) {
            System.out.println("Not found driver");
        }
        return connection;
    }
}
