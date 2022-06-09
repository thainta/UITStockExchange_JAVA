/*
 * Created by JFormDesigner on Thu Jun 09 08:48:02 ICT 2022
 */

package views.buyStock;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import utils.*;

/**
 * @author Thái Nguyễn Thừa An
 */


public class buyStock extends JFrame {
    public currentUser currentUser;
    int account_balance = 0;
    String stockName = "";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new buyStock("AAA", new utils.currentUser(2, null, 123)).setVisible(true);
    }

    public buyStock(String stockName, currentUser currentUser) throws SQLException, ClassNotFoundException {
        initComponents();
        setLabel();
        this.currentUser = currentUser;
        label7.setText(String.valueOf(utils.currentUser.getId()));
        this.stockName = stockName;
        label3.setText(stockName);
        label3.setForeground(Color.RED);
        radioButton2.setSelected(false);
        radioButton1.setSelected(true);
        this.getContentPane().setBackground(new Color(52, 52, 52));
        panel2.setBackground(new Color(52, 52, 52));
        this.setResizable(false);
    }
    public void setLabel() throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try {
            int userId = utils.currentUser.getId();
            Statement st = conn.createStatement();
            int account_id = 0;
            ResultSet rs = st.executeQuery("select account_id from user where id =" + userId);
            rs.next();
            account_id =rs.getInt("account_id");
            rs.close();
            ResultSet rs2 = st.executeQuery("select account_balance from account where id =" + account_id);
            rs2.next();
            account_balance = rs2.getInt("account_balance");
            label9.setText(String.valueOf(account_balance)+ " VND");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void radioButton1(ActionEvent e) {
        radioButton2.setSelected(false);
        radioButton1.setSelected(true);
    }

    private void radioButton2(ActionEvent e) {
        radioButton1.setSelected(false);
        radioButton2.setSelected(true);
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
    }

    private void button3MouseClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try {
            if(radioButton1.isSelected()){
                int userId = utils.currentUser.getId();
                Statement st = conn.createStatement();
                int account_id = 0;
                int stock_id = 0;
                int account_balance = 0;
                ResultSet rs = st.executeQuery("select account_id from user where id =" + userId);
                rs.next();
                account_id = rs.getInt("account_id");

                ResultSet rsAccount = st.executeQuery("select account_balance from account where id =" + account_id);
                rsAccount.next();
                account_balance = rsAccount.getInt("account_balance");

                ResultSet rs1 = st.executeQuery("select id from stock where stock_name ='" + stockName + "'");
                rs1.next();
                stock_id = rs1.getInt("id");
                if(account_balance >= Integer.valueOf(textField3.getText()) * Integer.valueOf(textField4.getText())) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = formatter.format(new Date());
                    String query = String.format("insert into exchange(stock_id,user_id, trading_volumn, price,type, create_on) values (%s, %s, %s, %s, '%s', '%s')",
                            String.valueOf(stock_id), String.valueOf(userId), textField4.getText(), textField3.getText(), "buy", date);
                    JOptionPane.showMessageDialog(this, "Order to buy successfully", "Success", JOptionPane.ERROR_MESSAGE);
                    System.out.println(st.executeUpdate(query) + " Row inserted");
//
////                System.out.println(st.executeUpdate(String.format("insert stock_bag(account_id, stock_id, amount, value) values (%s, %s, %s, %s)",
////                        String.valueOf(account_id), String.valueOf(stock_id), textField4.getText(), textField3.getText())) + " Row inserted");
////                st.executeUpdate(String.format("update account set account_balance = %s where id = %s", account_balance - Integer.valueOf(textField3.getText()) * Integer.valueOf(textField4.getText()), account_id));
                }
                else {
                    JOptionPane.showMessageDialog(this, "Don't enough money to buy", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (radioButton2.isSelected()){
                int userId = utils.currentUser.getId();
                Statement st = conn.createStatement();
                int account_id = 0;
                int stock_id = 0;
                ResultSet rs = st.executeQuery("select account_id from user where id =" + userId);
                rs.next();
                account_id = rs.getInt("account_id");

                ResultSet rs1 = st.executeQuery("select id from stock where stock_name ='" + stockName + "'");
                rs1.next();
                stock_id = rs1.getInt("id");

                String rs2query = "select * from stock_bag where stock_id =" + stock_id + " and account_id = " + account_id;
                System.out.println(rs2query);
                ResultSet rs2 = st.executeQuery(rs2query);
                if(rs2.next()){
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = formatter.format(new Date());
                    int availableVolum = rs2.getInt("amount");
                    if(availableVolum > Integer.valueOf(textField4.getText())) {
                        String query = String.format("insert into exchange(stock_id,user_id, trading_volumn, price,type, create_on) values (%s, %s, %s, %s, '%s', '%s')",
                                String.valueOf(stock_id), String.valueOf(userId), textField4.getText(), textField3.getText(), "sell", date);
                        System.out.println(st.executeUpdate(query) + " Row inserted");
                        JOptionPane.showMessageDialog(this, "Order to sell successfully", "Success", JOptionPane.ERROR_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(this, "Not enough stock volume", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Don't have this stock", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An

        //======== this ========
        var contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 400, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
