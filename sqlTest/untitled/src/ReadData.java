import javax.xml.transform.Result;
import java.sql.*;

public class ReadData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            Statement statement = c.createStatement()
        ){
          String query = "select * from users";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + " " + name + " " + email);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
