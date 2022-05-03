import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class checkOracleConnection {
    public static Connection getMyConnection()throws SQLException, ClassNotFoundException{
        return OracleConnection.getOracleConnection();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = checkOracleConnection.getMyConnection();
        System.out.println("Get connection " + conn);

        String query = "select * from USER_QL";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String username = rs.getString("USERNAME_QL");
                String password = rs.getString("PASSWORD_QL");
                System.out.println(username + ", " + password);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
