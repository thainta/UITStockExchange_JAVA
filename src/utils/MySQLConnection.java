package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException{
                String url = "jdbc:mysql://localhost:3306/sys";
                String username="root";
                String password = "ldh@2210";
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url, username, password);
    }
}
