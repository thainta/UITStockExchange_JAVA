package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class checkMySQLConnection {
    public static Connection getMyConnection()throws SQLException, ClassNotFoundException{
        return MySQLConnection.getMySQLConnection();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = checkMySQLConnection.getMyConnection();
        System.out.println("Get connection " + conn);
    }
}
