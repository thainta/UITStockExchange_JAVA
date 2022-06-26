/*
 * Created by JFormDesigner on Thu Jun 09 08:48:02 ICT 2022
 */

package views.buyStock;

import utils.MySQLConnection;
import utils.currentUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public boolean isHasStock(int stockId) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try {
            Statement st = conn.createStatement();
            String query = "";
                query = String.format("select * from stock_bag where stock_id = %s", stockId);
                ResultSet rs = st.executeQuery(query);
                if (rs.next()) {
                    return true;
                }
                else return false;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public void exchangeHash(int userId, String date, int stock_id, String price, String volumn, String preVolumn, int account_id, int account_balance) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try {
            ResultSet finnalRun;
            Statement st = conn.createStatement();
            ResultSet rsExchange = st.executeQuery("select * from exchange where status = 'pending' and  type = 'sell' and stock_id ='" + stock_id + "' and price = " + price + " order by id DESC limit 1");

            int k = 0;
            int exchange_id = 0;
            String trading_volumn = "";
            int sellUserId = 0;
            int sellAccountId = 0;
            while (rsExchange.next()) {
                System.out.println(Integer.valueOf(volumn) == Integer.valueOf(rsExchange.getString("trading_volumn")));
                if (Integer.valueOf(volumn) == Integer.valueOf(rsExchange.getString("trading_volumn"))) {
                    System.out.println("running...");
                    exchange_id = rsExchange.getInt("id");
                    sellUserId = rsExchange.getInt("user_id");
                    k = 1;
                    System.out.println("hmmm!!!");
                } else {
                    if (Integer.valueOf(volumn) < Integer.valueOf(rsExchange.getString("trading_volumn"))) {
                        exchange_id = rsExchange.getInt("id");
                        trading_volumn = rsExchange.getString("trading_volumn");
                        sellUserId = rsExchange.getInt("user_id");
                        k = 2;
                    } else {
                        Statement stT = conn.createStatement();
                        exchange_id = rsExchange.getInt("id");
                        trading_volumn = rsExchange.getString("trading_volumn");
                        k = 3;
                    }
                }
            }
            rsExchange.close();

            if (k == 1) {
                Statement newSt = conn.createStatement();
                newSt.executeUpdate(String.format("update exchange set status = 'success' where id = " + exchange_id));
                String query = String.format("insert into stock_bag(account_id, stock_id, amount, value) values (%s, %s, %s, %s)",
                        account_id, stock_id, Integer.valueOf(volumn) + Integer.valueOf(preVolumn), price);
                Statement stFinal = conn.createStatement();
                stFinal.executeUpdate(query);
                query = String.format("select * from user where id = %s", sellUserId);
                ResultSet kkk = stFinal.executeQuery(query);
                kkk.next();
                sellAccountId = kkk.getInt("account_id");
                query = String.format("delete stock_bag where account_id = %s and stock_id = %s", sellAccountId, stock_id);
                stFinal.executeUpdate(query);
                query = String.format("update account set account_balance = %s where id = %s", String.valueOf(account_balance - (Integer.valueOf(price) * Integer.valueOf(volumn))), String.valueOf(account_id));
                stFinal.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Exchange success!");
                ResultSet rsAccount = st.executeQuery("select account_balance from account where id =" + account_id);
                rsAccount.next();
                account_balance = rsAccount.getInt("account_balance");
                label9.setText(account_balance + " VND");
            }
            if (k == 2) {
                String query = String.format("insert into stock_bag(account_id, stock_id, amount, value) values (%s, %s, %s, %s)",
                        account_id, stock_id, Integer.valueOf(volumn) + Integer.valueOf(preVolumn), price);
                JOptionPane.showMessageDialog(this, "Exchange success!!");
                Statement stFinal = conn.createStatement();
                stFinal.executeUpdate(query);
                query = String.format("select * from user where id = %s", sellUserId);
                ResultSet kkk = stFinal.executeQuery(query);
                kkk.next();
                sellAccountId = kkk.getInt("account_id");
                query = String.format("update stock_bag set amount = %s where account_id = %s", Integer.valueOf(trading_volumn) - Integer.valueOf(volumn), sellAccountId);
                stFinal.executeUpdate(query);
                query = String.format("insert into exchange(stock_id,user_id,status, trading_volumn, price,type, create_on) values (%s, %s,'%s', %s, %s, '%s', '%s')",
                        stock_id, userId,"success", Integer.valueOf(volumn) + Integer.valueOf(preVolumn), price, "buy", date);
                stFinal.executeUpdate(query);
                query = String.format("update account set account_balance = %s where id = %s", account_balance - (Integer.valueOf(price) * Integer.valueOf(volumn)), account_id);
                stFinal.executeUpdate(query);
                query = String.format("update exchange set trading_volumn = %s where id = %s", String.format(String.valueOf(Integer.valueOf(trading_volumn) - Integer.valueOf(volumn))), String.format(String.valueOf(exchange_id)));
                stFinal.executeUpdate(query);
                ResultSet rsAccount = st.executeQuery("select account_balance from account where id =" + account_id);
                rsAccount.next();
                account_balance = rsAccount.getInt("account_balance");
                label9.setText(account_balance + " VND");
            }
            if (k == 3) {
                st.executeUpdate(String.format("update exchange set status = 'sucess' where id = %s", String.format(String.valueOf(exchange_id))));
                int kk = Integer.valueOf(volumn) - Integer.valueOf(trading_volumn);
                System.out.println(kk);
                preVolumn = volumn;
                volumn = String.format(String.valueOf(Integer.valueOf(volumn) - Integer.valueOf(trading_volumn)));
                System.out.println(volumn);
                exchangeHash(userId, date, stock_id, price, volumn, preVolumn, account_id, account_balance);
            }
            if (k == 0) {
                String query = String.format("insert into exchange(stock_id,user_id,status, trading_volumn, price,type, create_on) values (%s, %s,'%s', %s, %s, '%s', '%s')",
                        stock_id, userId,"pending", volumn, price, "buy", date);
                JOptionPane.showMessageDialog(this, "Order to buy success!!");
                System.out.println(st.executeUpdate(query) + " Row inserted");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }
    public void exchangeSellHash(int userId, String date, int stock_id, String price, String volumn, String preVolumn, int account_id, int account_balance) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try {
            ResultSet finnalRun;
            Statement st = conn.createStatement();
            ResultSet rsExchange = st.executeQuery("select * from exchange where status = 'pending' and  type = 'buy' and stock_id ='" + stock_id + "' and price = " + price + " order by id ASC limit 1");

            int k = 0;
            int exchange_id = 0;
            String trading_volumn = "";
            int sellUserId = 0;
            int sellAccountId = 0;
            while (rsExchange.next()) {
                if (Integer.valueOf(volumn) == Integer.valueOf(rsExchange.getString("trading_volumn"))) {
                    exchange_id = rsExchange.getInt("id");
                    k = 1;
                } else {
                    if (Integer.valueOf(volumn) < Integer.valueOf(rsExchange.getString("trading_volumn"))) {
                        exchange_id = rsExchange.getInt("id");
                        trading_volumn = rsExchange.getString("trading_volumn");
                        sellUserId = rsExchange.getInt("user_id");
                        k = 2;
                    } else {
                        Statement stT = conn.createStatement();
                        exchange_id = rsExchange.getInt("id");
                        trading_volumn = rsExchange.getString("trading_volumn");
                        k = 3;
                    }
                }
            }
            rsExchange.close();

            if (k == 1) {
                Statement newSt = conn.createStatement();
                newSt.executeUpdate(String.format("update exchange set status = 'success' where id = " + exchange_id));

                String query = String.format("select * from user where id = %s", sellUserId);
                ResultSet kkk = newSt.executeQuery(query);
                kkk.next();
                sellAccountId = kkk.getInt("account_id");

                query = String.format("insert into stock_bag(account_id, stock_id, amount, value) values (%s, %s, %s, %s)",
                        sellAccountId, stock_id, Integer.valueOf(volumn), price);
                Statement stFinal = conn.createStatement();
                stFinal.executeUpdate(query);
                query = String.format("update account set account_balance = %s where id = %s", account_balance + (Integer.valueOf(price) * Integer.valueOf(volumn)), account_id);
                stFinal.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Exchange success!");
                ResultSet rsAccount = st.executeQuery("select account_balance from account where id =" + account_id);
                rsAccount.next();
                account_balance = rsAccount.getInt("account_balance");
                label9.setText(account_balance + " VND");
            }
            if (k == 2) {
                Statement stFinal = conn.createStatement();
                String query = String.format("select * from user where id = %s", sellUserId);
                ResultSet kkk = stFinal.executeQuery(query);
                kkk.next();
                sellAccountId = kkk.getInt("account_id");

                query = String.format("insert into stock_bag(account_id, stock_id, amount, value) values (%s, %s, %s, %s)", sellAccountId, stock_id, Integer.valueOf(volumn), price);
                stFinal.executeUpdate(query);
                query = String.format("delete from stock_bag where account_id = %s and stock_id = %s",
                        account_id, stock_id);
                stFinal.executeUpdate(query);

                query = String.format("update exchange set trading_volumn = %s where id = %s", Integer.valueOf(trading_volumn) - Integer.valueOf(volumn), exchange_id);
                stFinal.executeUpdate(query);
                query = String.format("delete from stock_bag where account_id = %s and stock_id = %s", account_id, stock_id);
                stFinal.executeUpdate(query);

                JOptionPane.showMessageDialog(this, "Exchange success!!");

                ResultSet rsAccount = st.executeQuery("select account_balance from account where id =" + account_id);
                rsAccount.next();
                account_balance = rsAccount.getInt("account_balance");
                label9.setText(account_balance + " VND");
            }
            if (k == 3) {
                st.executeUpdate(String.format("update exchange set status = 'sucess' where id = %s", String.format(String.valueOf(exchange_id))));
                preVolumn = volumn;
                volumn = String.format(String.valueOf(Integer.valueOf(volumn) - Integer.valueOf(trading_volumn)));
                exchangeSellHash(userId, date, stock_id, price, volumn, preVolumn, account_id, account_balance);
            }
            if (k == 0) {
                String query = String.format("insert into exchange(stock_id,user_id,status, trading_volumn, price,type, create_on) values (%s, %s,'%s', %s, %s, '%s', '%s')",
                        stock_id, userId,"pending", volumn, price, "sell", date);
                JOptionPane.showMessageDialog(this, "Order to sell success!!");
                System.out.println(st.executeUpdate(query) + " Row inserted");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

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
                ResultSet finnalRun;
                if(account_balance >= Integer.valueOf(textField3.getText()) * Integer.valueOf(textField4.getText())) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = formatter.format(new Date());
                    exchangeHash(userId, date, stock_id, textField3.getText(), textField4.getText(), "0", account_id, account_balance);
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
                ResultSet finalRun = st.executeQuery(String.format("select * from stock_bag where account_id = %s", account_id));
                int check = 0;
                while(finalRun.next()) {
                    if(finalRun.getInt("stock_id") == stock_id) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String date = formatter.format(new Date());
                        exchangeSellHash(userId, date, stock_id, textField3.getText(), textField4.getText(), "0", account_id, account_balance);
                        check = 1;
                    }
                }
                if (check == 0) {
                    JOptionPane.showMessageDialog(this, "You don't have that stock!", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        panel2 = new JPanel();
        textField3 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textField4 = new JTextField();
        button3 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();

        //======== this ========
        setBackground(new Color(52, 52, 52));
        var contentPane = getContentPane();

        //---- radioButton1 ----
        radioButton1.setText("Buy");
        radioButton1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        radioButton1.setBackground(new Color(52, 52, 52));
        radioButton1.setForeground(Color.white);
        radioButton1.addActionListener(e -> radioButton1(e));

        //---- radioButton2 ----
        radioButton2.setText("Sell");
        radioButton2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        radioButton2.setBackground(new Color(52, 52, 52));
        radioButton2.setForeground(Color.white);
        radioButton2.addActionListener(e -> radioButton2(e));

        //======== panel2 ========
        {
            panel2.setBackground(new Color(52, 52, 52));
            panel2.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel2. getBorder( )) ); panel2. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- textField3 ----
            textField3.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label4 ----
            label4.setText("Price");
            label4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            label4.setForeground(Color.white);

            //---- label5 ----
            label5.setText("Volume");
            label5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            label5.setForeground(Color.white);

            //---- textField4 ----
            textField4.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- button3 ----
            button3.setText("Order");
            button3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            button3.setBackground(new Color(255, 0, 51));
            button3.setForeground(Color.white);
            button3.addActionListener(e -> button3(e));
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        button3MouseClicked(e);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            //---- button2 ----
            button2.setText("Cancel");
            button2.setBackground(new Color(52, 52, 52));
            button2.setForeground(Color.white);
            button2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(72, Short.MAX_VALUE)
                        .addComponent(button3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2)
                        .addGap(70, 70, 70))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(button3)
                            .addComponent(button2))
                        .addContainerGap(23, Short.MAX_VALUE))
            );
        }

        //---- label3 ----
        label3.setText("text");
        label3.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label6 ----
        label6.setText("Account");
        label6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label6.setForeground(Color.white);

        //---- label7 ----
        label7.setText("Text");
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        label7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label7.setForeground(Color.white);

        //---- label8 ----
        label8.setText("Available Collateral");
        label8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label8.setForeground(Color.white);

        //---- label9 ----
        label9.setText("Text");
        label9.setHorizontalAlignment(SwingConstants.RIGHT);
        label9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label9.setForeground(Color.white);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label8, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addComponent(radioButton1)
                            .addGap(18, 18, 18)
                            .addComponent(radioButton2)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton1)
                        .addComponent(radioButton2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JPanel panel2;
    private JTextField textField3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField4;
    private JButton button3;
    private JButton button2;
    private JLabel label3;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
