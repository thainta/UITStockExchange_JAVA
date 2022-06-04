/*
 * Created by JFormDesigner on Sat May 21 07:57:35 ICT 2022
 */

package views.signIn;

import java.awt.event.*;
import utils.MySQLConnection;
import utils.currentUser;
import views.InfoBoard.*;
import org.mindrot.jbcrypt.BCrypt;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.GroupLayout;


/**
 * @author Le Duy Hoang
 */
public class signIn extends JFrame {

    public currentUser currentUser;
    public currentUser getCurrentUser() {
        return currentUser;
    }
    public static void main(String[] args) {
        signIn form = new signIn();
        form.setVisible(true);
    }

    public static Connection getMyConnection()throws SQLException, ClassNotFoundException{
        return MySQLConnection.getOracleConnection();
    }

    public signIn() {
        initComponents();
    }

    private void loginBtnMouseClicked(MouseEvent e) {
        try {
            Connection conn = getMyConnection();
            Statement st = conn.createStatement();
            try {
                ResultSet rs = st.executeQuery("select * from user where email=" + emailnput.getText());

                while(rs.next()){
                    if (BCrypt.checkpw(String.valueOf(passwordInput.getPassword()), rs.getString("password")) == true) {
                        JOptionPane.showMessageDialog(this, "Login success");
                        this.dispose();

                        currentUser = new currentUser(rs.getInt("id"), "", rs.getInt("type_id"));
                        if (currentUser.getRoleId() == 1) {
                            InfoBoard infoBoardForm = new InfoBoard(currentUser);
                            infoBoardForm.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong password");
                    }
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Le Duy Hoang
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        passwordInput = new JPasswordField();
        emailnput = new JTextField();
        button3 = new JButton();
        loginBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/images/logoUIT.png")));

        //---- label2 ----
        label2.setIcon(new ImageIcon(getClass().getResource("/images/stockLogo.png")));

        //---- label3 ----
        label3.setText("Welcome to UIT Stock Exchange");
        label3.setFont(new Font("Tahoma", Font.BOLD, 32));

        //---- label4 ----
        label4.setText("Email:");
        label4.setFont(new Font("Tahoma", Font.PLAIN, 24));

        //---- label5 ----
        label5.setText("Password:");
        label5.setFont(new Font("Tahoma", Font.PLAIN, 24));

        //---- button3 ----
        button3.setText("Register");

        //---- loginBtn ----
        loginBtn.setText("Login");
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginBtnMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label5)
                                        .addComponent(label4))
                                    .addGap(30, 30, 30)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(emailnput)
                                        .addComponent(passwordInput))))))
                    .addGap(34, 34, 34))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(128, 128, 128)
                    .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                    .addGap(72, 72, 72)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label3)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(emailnput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Le Duy Hoang
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JPasswordField passwordInput;
    private JTextField emailnput;
    private JButton button3;
    private JButton loginBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
