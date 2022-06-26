
import java.sql.*;

public class MysqlConnector {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("im woRking");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sakila","root","123456");
            //here sonoo is database name, root is username and password


          /*  PreparedStatement insert = con.prepareStatement("insert into leaderboard values(300,'giorgi')");
            insert.execute();
*/
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select score from leaderboard where nickname = 'giorgi'");
            String result = null;
            while(rs.next())
               result  = rs.getString(1);

            
            System.out.println(result);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
