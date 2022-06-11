/*
 * Created by JFormDesigner on Thu Jun 09 18:10:07 ICT 2022
 */

package views.history;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import utils.*;
import views.userInfo.userInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Thái Nguyễn Thừa An
 */
public class history extends JFrame {
    currentUser currentUser;
    JFrame parentFrame;
    String col[] = {"id", "Symbol", "Volume", "Price", "Type", "Status", "Action"};
    public history(currentUser currentUser, JFrame parentFrame) throws SQLException, ClassNotFoundException {
        this.currentUser = currentUser;
        this.parentFrame = parentFrame;
        initComponents();
        DefaultTableModel model = new DefaultTableModel(col, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        loadData(model);
        table1.getColumnModel().getColumn(0).setMinWidth(0);
        table1.getColumnModel().getColumn(0).setMaxWidth(0);
        table1.getColumnModel().getColumn(0).setWidth(0);
        table1.getColumnModel().getColumn(6).setCellRenderer(new MyRenderer(new Color(48, 112, 209)));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        table1.setFillsViewportHeight(true);
    }

    private void table1MouseClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        int row = table1.getSelectedRow();
        int col =   table1.getSelectedColumn();

        if(table1.getValueAt(row,col).toString().equals("Cancel"))
        {
            String id = table1.getValueAt(row, 0).toString();
            if((JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this order", "Delete Order", JOptionPane.YES_NO_OPTION) == 0))
            {
                Connection conn = MySQLConnection.getMySQLConnection();
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate("delete from exchange where id =" + id);
                    DefaultTableModel model =  (DefaultTableModel) table1.getModel();
                    model.setRowCount(0);
                    loadData(model);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    private void thisWindowClosed(WindowEvent e) {
        parentFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        table1MouseClicked(e);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            scrollPane1.setViewportView(table1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public void loadData(DefaultTableModel model) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from exchange where user_id ="+currentUser.getId());
            while(rs.next()){
                int id = rs.getInt("id");
                int stock_id = rs.getInt("stock_id");
                int volume = rs.getInt("trading_volumn");
                int price = rs.getInt("price");
                String status = rs.getString("status");
                String type = rs.getString("type");

                Statement st2 = conn.createStatement();
                ResultSet rs2 = st2.executeQuery("select stock_name from stock where id =" + stock_id);
                rs2.next();
                String stockName = rs2.getString("stock_name");
                if(status.equals("pending"))
                    model.addRow(new Object[]{id, stockName,volume,price,type, status, "Cancel"});
                else {
                    model.addRow(new Object[]{id, stockName,volume,price,type, status, ""});
                }
                rs2.close();
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
class MyRenderer extends DefaultTableCellRenderer
{
    Color fg;
    public MyRenderer(Color fg) {
        super();
        this.fg = fg;
    }
    public Component getTableCellRendererComponent(JTable table, Object
            value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cell = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        cell.setForeground(fg);
        return cell;
    }
}