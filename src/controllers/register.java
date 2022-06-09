package controllers;

import org.mindrot.jbcrypt.BCrypt;
import utils.MySQLConnection;

import java.sql.*;

public class register {
    public static Connection getMyConnection()throws SQLException, ClassNotFoundException{
        return MySQLConnection.getMySQLConnection();
    }
    public static boolean isExist (String email) {
        try {
            Connection conn = getMyConnection();
            Statement st = conn.createStatement();
            try {
                ResultSet rs = st.executeQuery("select email from user");
                while (rs.next()) {
                    if (email.equals(rs.getString("email"))) {
                        return true;
                    }
                }
                return false;

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void createAccount(String email) {
        Integer userID = 0;
        String query = "SELECT id FROM USER WHERE EMAIL=" + email;
        try {
            Connection conn = getMyConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                userID = rs.getInt("ID");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        query = "INSERT INTO ACCOUNT(account_balance, user_id) VALUES(0, ?)";
        try {
            Connection conn = getMyConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void createUser(String fn, String ls, String dob, String addr, String idc, String sex, String phone, String email, String pass) {
        String hash = BCrypt.hashpw(pass, BCrypt.gensalt(10));
        String query =
            "INSERT INTO USER(first_name, last_name, date_of_birth, address, indentity_card, sex, phone, email, password, type_id, isArchived) VALUES(?,?,?,?,?,?,?,?,?,1,0)";
        try {
            Connection conn = getMyConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, fn);
            ps.setString(2, ls);
            ps.setString(3, dob);
            ps.setString(4, addr);
            ps.setString(5, idc);
            ps.setString(6, sex);
            ps.setString(7, phone);
            ps.setString(8, email);
            ps.setString(9, hash);
            ps.executeUpdate();
            createAccount(email);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
