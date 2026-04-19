import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "create table users(uid int auto_increment primary key, name varchar(255), email varchar(255));");
        ){
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
