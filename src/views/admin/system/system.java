/*
 * Created by JFormDesigner on Sat Jun 11 20:19:52 ICT 2022
 */

package views.admin.system;

import utils.MySQLConnection;
import views.signIn.signIn;
import views.companyInfo.companyInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Le Duy Hoang
 */
public class system extends JFrame {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        system form = new system();
        form.setVisible(true);
    }
    public system() throws SQLException, ClassNotFoundException {
        initComponents();

        // User table
        String col1[] = {"User Id", "First Name", "Last Name", "Id Card", "Sex", "Email", "Type Id", "Status", "Action"};
        DefaultTableModel model = new DefaultTableModel(col1, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        userTable.setModel(model);
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        loadUsers(model);
        userTable.getColumnModel().getColumn(8).setCellRenderer(new views.admin.system.MyRenderer(new Color(48, 112, 209)));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userTable.setFillsViewportHeight(true);
        this.setResizable(false);

        // Company table
        String col2[] = {"Company Id", "Company Name",""};
        DefaultTableModel model2 = new DefaultTableModel(col2, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        comTable.setModel(model2);
        comTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        loadCompanies(model2);
        comTable.getColumnModel().getColumn(2).setCellRenderer(new views.admin.system.MyRenderer(new Color(48, 112, 209)));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        comTable.setFillsViewportHeight(true);
        this.setResizable(false);
    }

    private void userTableMouseClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        int row = userTable.getSelectedRow();
        int col = userTable.getSelectedColumn();
        System.out.println("hello");
        if (userTable.getValueAt(row,col).toString().equals("archive")) {
            String id = userTable.getValueAt(row, 0).toString();
            if ((JOptionPane.showConfirmDialog(this, "Are you sure want to archive this user?", "Archive User", JOptionPane.YES_NO_OPTION) == 0)) {
                Connection conn = MySQLConnection.getMySQLConnection();
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate("UPDATE USER SET isArchived = 1 WHERE id =" + id);
                    DefaultTableModel model =  (DefaultTableModel) userTable.getModel();
                    model.setRowCount(0);
                    loadUsers(model);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } else {
            String id = userTable.getValueAt(row, 0).toString();
            Connection conn = MySQLConnection.getMySQLConnection();
            try {
                Statement st = conn.createStatement();
                st.executeUpdate("UPDATE USER SET isArchived = 0 WHERE id =" + id);
                DefaultTableModel model =  (DefaultTableModel) userTable.getModel();
                model.setRowCount(0);
                loadUsers(model);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        this.dispose();
        signIn signInForm = new signIn();
        signInForm.setVisible(true);
    }

    private void comTableMouseClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        int row = comTable.getSelectedRow();
        int col = comTable.getSelectedColumn();
        if (comTable.getValueAt(row,col).toString().equals("show")) {
            String id = userTable.getValueAt(row, 0).toString();
            Connection conn = MySQLConnection.getMySQLConnection();
            try {
                Statement st = conn.createStatement();
                String query = String.format("SELECT * FROM COMPANY WHERE ID =" + id);
                ResultSet rs = st.executeQuery(query);

                rs.next();
                companyInfo comInfoForm = new companyInfo(rs.getInt("id"), rs.getString("company_name"), rs.getString("company_short_name"));
                comInfoForm.setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Le Duy Hoang
        tabbedPane1 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        userTable = new JTable();
        scrollPane2 = new JScrollPane();
        comTable = new JTable();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== scrollPane1 ========
            {

                //---- userTable ----
                userTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            userTableMouseClicked(e);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                scrollPane1.setViewportView(userTable);
            }
            tabbedPane1.addTab("users", scrollPane1);

            //======== scrollPane2 ========
            {

                //---- comTable ----
                comTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            comTableMouseClicked(e);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                scrollPane2.setViewportView(comTable);
            }
            tabbedPane1.addTab("companies", scrollPane2);
        }

        //---- button1 ----
        button1.setText("logout");
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
                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(754, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Le Duy Hoang
    private JTabbedPane tabbedPane1;
    private JScrollPane scrollPane1;
    private JTable userTable;
    private JScrollPane scrollPane2;
    private JTable comTable;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void loadUsers(DefaultTableModel model) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try{
            Statement st = conn.createStatement();
            String query = "select * from user";
            ResultSet rs = st.executeQuery(query);
            System.out.println(rs.getRow());
            while (rs.next()) {
                int userId= rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String id = rs.getString("identity_card");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                int type = rs.getInt("type_id");
                String status;
                String archive;
                if (rs.getInt("isArchived") == 0) {
                    status = "available";
                    archive = "archive";
                } else {
                    status = "disable";
                    archive = "recover";
                }
                model.addRow(new Object[]{userId, fName, lName, id, sex, email, type, status, archive});
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public void loadCompanies(DefaultTableModel model) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try{
            Statement st = conn.createStatement();
            String query = "select * from company";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int comId = rs.getInt("id");
                String comName = rs.getString("company_name");
                model.addRow(new Object[]{comId, comName, "show"});
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
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