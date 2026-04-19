import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "insert into users(name, email) values(?, ?);"))
        {
            String name ="Charlone Gianne";
            String email = "charlonegianne.cruz@cit.edu";
            statement.setString(1, name);
            statement.setString(2, email);
            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("Update Successful");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
