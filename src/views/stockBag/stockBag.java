/*
 * Created by JFormDesigner on Wed Jun 08 11:50:41 ICT 2022
 */

package views.stockBag;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import utils.*;
import views.buyStock.buyStock;
import views.userInfo.userInfo;

/**
 * @author Le Duy Hoang
 */
public class stockBag extends JFrame {
    int accountId = 0;
    JFrame parentFrame;
    public stockBag(Integer accountId, JFrame parentFrame) throws SQLException, ClassNotFoundException {
        this.accountId = accountId;
        this.parentFrame = parentFrame;
        initComponents();
        String col[]={"Stock Name", "Amount", "Value", "Action"};
        DefaultTableModel model = new DefaultTableModel(col, 0){
            @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
        };
        stockTable.setModel(model);
        stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        loadStockBag(model);
        this.setResizable(false);
    }

    public void loadStockBag(DefaultTableModel model) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try{
            Statement st = conn.createStatement();
            String query = "select * from stock_bag where account_id = " + accountId;
            ResultSet rs = st.executeQuery(query);
            System.out.println(rs.getRow());
            while (rs.next()) {
                int stockId= rs.getInt("stock_id");
                int amount = rs.getInt("amount");
                int value = rs.getInt("value");
                String query1 = "select * from stock where id = " + stockId;
                Statement st2 = conn.createStatement();
                ResultSet rs2 = st2.executeQuery(query1);
                rs2.next();
                String stockName = rs2.getString("stock_name");
                model.addRow(new Object[]{stockName, amount, value, "Exchange"});
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    private void button1MouseClicked(MouseEvent e) {
        this.dispose();
        parentFrame.setVisible(true);
    }

    private void scrollPane1MouseClicked(MouseEvent e) {

    }

    private void stockTableMouseClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        int rowSelected = stockTable.getSelectedRow();
        int columnSelected = stockTable.getSelectedColumn();
        if(String.valueOf(stockTable.getValueAt(rowSelected, columnSelected)).equals("Exchange")) {
            new buyStock(String.valueOf(stockTable.getValueAt(rowSelected, 0)), new utils.currentUser(2, null, 123)).setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
        tabbedPane1 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        stockTable = new JTable();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== scrollPane1 ========
            {
                scrollPane1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        scrollPane1MouseClicked(e);
                    }
                });

                //---- stockTable ----
                stockTable.setModel(new DefaultTableModel(10, 0));
                stockTable.setFillsViewportHeight(true);
                stockTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            stockTableMouseClicked(e);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                scrollPane1.setViewportView(stockTable);
            }
            tabbedPane1.addTab("Stock owned", scrollPane1);
        }

        //---- button1 ----
        button1.setText("Back");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(507, Short.MAX_VALUE))
                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        );
        setSize(625, 420);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
    private JTabbedPane tabbedPane1;
    private JScrollPane scrollPane1;
    private JTable stockTable;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
