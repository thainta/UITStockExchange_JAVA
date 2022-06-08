/*
 * Created by JFormDesigner on Sat May 21 08:20:03 ICT 2022
 */

package views.userInfo;

import java.awt.event.*;
import utils.currentUser;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import views.signIn.*;
import views.stockBag.*;
import utils.MySQLConnection;

/**
 * @author Le Duy Hoang
 */
public class userInfo extends JFrame {
    private Double accountBalance;
    private Integer accountId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public currentUser cUser;
    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public static void main(String[] args) {

    }

    public static Connection getMyConnection()throws SQLException, ClassNotFoundException{
        return MySQLConnection.getOracleConnection();
    }

    public void showInfo() {
        try {
            Connection conn = getMyConnection();
            Statement st = conn.createStatement();
            try {
                ResultSet rs = st.executeQuery(String.format("select * from user where id = %2d", cUser.getId()));
                while (rs.next()) {
                    this.fnInput.setText(rs.getString("first_name"));
                    this.lnInput.setText(rs.getString("last_name"));
                    this.dobInput.setText(rs.getString("date_of_birth").split(" ",15)[0]);
                    this.addrInput.setText(rs.getString("address"));
                    this.idInput.setText(rs.getString("identity_card"));
                    if (rs.getString("sex").equals("male")) {
                        this.maleInput.setSelected(true);
                        this.femaleInput.setSelected(false);
                    } else {
                        this.maleInput.setSelected(false);
                        this.femaleInput.setSelected(true);
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                ResultSet rs = st.executeQuery(String.format("select * from account where user_id = %2d", currentUser.getId()));
                while (rs.next()) {
                    setAccountId(rs.getInt("id"));
                    setAccountBalance(rs.getDouble("account_balance"));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void updateInfo() {
        String query =
                "UPDATE USER SET first_name=?, last_name=?, date_of_birth=?, address=?, identity_card=?, sex=?, phone=? WHERE id=?";
        try {
            Connection conn = getMyConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.fnInput.getText());
            ps.setString(2, this.lnInput.getText());
            ps.setString(3, this.dobInput.getText());
            ps.setString(4, this.addrInput.getText());
            ps.setString(5, this.idInput.getText());
            if (this.maleInput.isSelected()) {
                ps.setString(6, "male");
            } else {
                ps.setString(6, "female");
            }
            ps.setString(7, this.phoneInput.getText());
            ps.setInt(8, cUser.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Update success!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public userInfo(currentUser currentUser) {
        initComponents();
        cUser = currentUser;
        showInfo();
    }

    private void visibleBtnMouseReleased(MouseEvent e) {
        if (this.visibleBtn.getText().equals("Visible")) {
            this.balanceLabel.setText(getAccountBalance().toString() + " VND");
            this.visibleBtn.setText("Hide");
        } else {
            this.balanceLabel.setText("**********");
            this.visibleBtn.setText("Visible");
        }
    }

    private void visibleBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void updateBtnMouseClicked(MouseEvent e) {
        updateInfo();
        showInfo();
    }

    private void logoutBtnMouseClicked(MouseEvent e) {
        this.dispose();
        signIn signInForm = new signIn();
        signInForm.setVisible(true);
    }

    private void viewStockBtnMouseClicked(MouseEvent e) {
        stockBag stockBagForm = new stockBag(accountId);
        stockBagForm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Le Duy Hoang
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        roleLabel = new JLabel();
        label5 = new JLabel();
        statusLabel = new JLabel();
        label7 = new JLabel();
        createdOnLabel = new JLabel();
        label9 = new JLabel();
        balanceLabel = new JLabel();
        visibleBtn = new JButton();
        label11 = new JLabel();
        viewStockBtn = new JButton();
        textPane1 = new JTextPane();
        panel1 = new JPanel();
        lnInput = new JTextField();
        label12 = new JLabel();
        label13 = new JLabel();
        fnInput = new JTextField();
        label14 = new JLabel();
        dobInput = new JTextField();
        label15 = new JLabel();
        addrInput = new JTextField();
        label16 = new JLabel();
        idInput = new JTextField();
        label17 = new JLabel();
        maleInput = new JRadioButton();
        femaleInput = new JRadioButton();
        label18 = new JLabel();
        phoneInput = new JTextField();
        updateBtn = new JButton();
        logoutBtn = new JButton();
        textField2 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/images/avatar-modified.png")));

        //---- label2 ----
        label2.setText("Le Duy Hoang");
        label2.setFont(new Font("Goudy Old Style", Font.BOLD, 48));

        //---- label3 ----
        label3.setText("Role: ");
        label3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));

        //---- roleLabel ----
        roleLabel.setText("User");
        roleLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        roleLabel.setForeground(Color.red);

        //---- label5 ----
        label5.setText("Status:");
        label5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));

        //---- statusLabel ----
        statusLabel.setText("Online");
        statusLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        statusLabel.setForeground(Color.green);

        //---- label7 ----
        label7.setText("CreatedOn:");
        label7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));

        //---- createdOnLabel ----
        createdOnLabel.setText("22/3/2022");
        createdOnLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        createdOnLabel.setForeground(Color.blue);

        //---- label9 ----
        label9.setText("Balance:");
        label9.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 15));

        //---- balanceLabel ----
        balanceLabel.setText("**********");
        balanceLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));

        //---- visibleBtn ----
        visibleBtn.setText("Visible");
        visibleBtn.setFont(new Font("Source Code Pro", Font.BOLD, 12));
        visibleBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visibleBtnMouseClicked(e);
                visibleBtnMouseClicked(e);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                visibleBtnMouseReleased(e);
            }
        });

        //---- label11 ----
        label11.setText("StockBag:");
        label11.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 15));

        //---- viewStockBtn ----
        viewStockBtn.setText("View");
        viewStockBtn.setFont(new Font("Source Code Pro", Font.BOLD, 12));
        viewStockBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewStockBtnMouseClicked(e);
            }
        });

        //======== panel1 ========
        {
            panel1.setBackground(UIManager.getColor("ActionButton.hoverSeparatorColor"));
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax .
            swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border
            . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog"
            , java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder
            () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java
            . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException
            ( ) ;} } );

            //---- label12 ----
            label12.setText("Last Name:");
            label12.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- label13 ----
            label13.setText("First Name:");
            label13.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- label14 ----
            label14.setText("DOB:");
            label14.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- label15 ----
            label15.setText("Address:");
            label15.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- label16 ----
            label16.setText("ID:");
            label16.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- label17 ----
            label17.setText("Sex:");
            label17.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- maleInput ----
            maleInput.setText("Male");
            maleInput.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            //---- femaleInput ----
            femaleInput.setText("Female");
            femaleInput.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            //---- label18 ----
            label18.setText("Phone:");
            label18.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- updateBtn ----
            updateBtn.setText("Update");
            updateBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    updateBtnMouseClicked(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label13)
                                    .addComponent(label12))
                                .addGap(24, 24, 24)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(lnInput, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                                    .addComponent(fnInput, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label14)
                                    .addComponent(label15)
                                    .addComponent(label16)
                                    .addComponent(label17)
                                    .addComponent(label18))
                                .addGap(47, 47, 47)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(dobInput)
                                    .addComponent(addrInput)
                                    .addComponent(idInput, GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneInput)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(maleInput)
                                        .addGap(40, 40, 40)
                                        .addComponent(femaleInput)
                                        .addGap(0, 166, Short.MAX_VALUE)))))
                        .addGap(78, 78, 78))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label13)
                            .addComponent(fnInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12)
                            .addComponent(lnInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label14)
                            .addComponent(dobInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label15)
                            .addComponent(addrInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label16)
                            .addComponent(idInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label17)
                                .addComponent(maleInput))
                            .addComponent(femaleInput))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label18)
                            .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
            );
        }

        //---- logoutBtn ----
        logoutBtn.setText("logout");
        logoutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutBtnMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(627, 627, 627)
                    .addComponent(textPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roleLabel)
                            .addGap(34, 34, 34)
                            .addComponent(label5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(statusLabel)
                            .addGap(129, 129, 129)
                            .addComponent(createdOnLabel))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(balanceLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(visibleBtn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(viewStockBtn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label7)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                            .addComponent(logoutBtn))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(balanceLabel)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label2)
                                    .addComponent(logoutBtn))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(roleLabel)
                                    .addComponent(label5)
                                    .addComponent(statusLabel)
                                    .addComponent(label7)
                                    .addComponent(createdOnLabel)
                                    .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewStockBtn))
                                    .addComponent(visibleBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        setSize(645, 550);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Le Duy Hoang
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel roleLabel;
    private JLabel label5;
    private JLabel statusLabel;
    private JLabel label7;
    private JLabel createdOnLabel;
    private JLabel label9;
    private JLabel balanceLabel;
    private JButton visibleBtn;
    private JLabel label11;
    private JButton viewStockBtn;
    private JTextPane textPane1;
    private JPanel panel1;
    private JTextField lnInput;
    private JLabel label12;
    private JLabel label13;
    private JTextField fnInput;
    private JLabel label14;
    private JTextField dobInput;
    private JLabel label15;
    private JTextField addrInput;
    private JLabel label16;
    private JTextField idInput;
    private JLabel label17;
    private JRadioButton maleInput;
    private JRadioButton femaleInput;
    private JLabel label18;
    private JTextField phoneInput;
    private JButton updateBtn;
    private JButton logoutBtn;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
