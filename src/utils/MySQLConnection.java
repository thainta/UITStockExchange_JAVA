package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException{
                String url = "jdbc:mysql://localhost:3306/uit_stock_exchange";
                String username="root";
                String password = "Thai16122001";
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url, username, password);
    }
}
