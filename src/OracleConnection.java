import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    public static Connection getOracleConnection() throws SQLException, ClassNotFoundException{
        String hostName = "localhost";
        String sid = "orcl";
        String userName = "QuanLyXe";
        String password = "quanlixe";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
