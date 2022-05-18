import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getOracleConnection() throws SQLException, ClassNotFoundException{
                String url = "jdbc:mysql://us-cdbr-east-05.cleardb.net/heroku_f94a9ebb367cd91";
                String username="bc94aa977eb0e9";
                String password = "174eb7ff";
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url, username, password);
    }
}
