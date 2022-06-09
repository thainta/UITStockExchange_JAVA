/*
 * Created by JFormDesigner on Sat May 21 08:09:34 ICT 2022
 */

package views.signUp;

import java.awt.event.*;
import views.companyInfo.companyInfo;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import controllers.register;

/**
 * @author Le Duy Hoang
 */
public class signUp extends JFrame {
    public static void main(String[] args) {

        new signUp().setVisible(true);
    }


    public signUp() {
        initComponents();
    }

    private void registerBtnMouseClicked(MouseEvent e) {
        if (String.valueOf(passInput.getPassword()).equals(String.valueOf(confirmPassInput.getPassword()))) {
            String sexInput = "male";
            if (femaleInput.isSelected()) {
                sexInput = "female";
            }
            if (!register.isExist(emailInput.getText())) {
                register.createUser(
                    fnInput.getText(),
                    lnInput.getText(),
                    dobInput.getText(),
                    addrInput.getText(),
                    idcInput.getText(),
                    sexInput,
                    phoneInput.getText(),
                    emailInput.getText(),
                    passInput.getText()
                );
                register.createAccount(emailInput.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Email already taken!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Wrong password confirmation");
        }

    }

    private void maleInputMouseClicked(MouseEvent e) {
        femaleInput.setSelected(false);
    }

    private void femaleInputMouseClicked(MouseEvent e) {
        maleInput.setSelected(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Le Duy Hoang
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        fnInput = new JTextField();
        lnInput = new JTextField();
        dobInput = new JTextField();
        addrInput = new JTextField();
        idcInput = new JTextField();
        phoneInput = new JTextField();
        emailInput = new JTextField();
        passInput = new JPasswordField();
        confirmPassInput = new JPasswordField();
        registerBtn = new JButton();
        button2 = new JButton();
        maleInput = new JRadioButton();
        femaleInput = new JRadioButton();

        //======== this ========
        setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/images/register.png")));

        //---- label2 ----
        label2.setText("Register");
        label2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 48));

        //---- label3 ----
        label3.setText("First Name:");
        label3.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("Last Name:");
        label4.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label5 ----
        label5.setText("DOB:");
        label5.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label6 ----
        label6.setText("Address:");
        label6.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label7 ----
        label7.setText("ID:");
        label7.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label8 ----
        label8.setText("Sex:");
        label8.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label9 ----
        label9.setText("Phone:");
        label9.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label10 ----
        label10.setText("Email:");
        label10.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label11 ----
        label11.setText("Password:");
        label11.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- label12 ----
        label12.setText("Confirm:");
        label12.setFont(new Font("JetBrains Mono", Font.BOLD, 20));

        //---- registerBtn ----
        registerBtn.setText("Register Now!");
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerBtnMouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("Login");

        //---- maleInput ----
        maleInput.setText("Male");
        maleInput.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        maleInput.setSelected(true);
        maleInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                maleInputMouseClicked(e);
            }
        });

        //---- femaleInput ----
        femaleInput.setText("Female");
        femaleInput.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        femaleInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                femaleInputMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(96, 96, 96)
                            .addComponent(label2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label9)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idcInput, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addrInput, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dobInput, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lnInput, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)
                                    .addComponent(fnInput, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label8)
                                    .addGap(168, 168, 168)
                                    .addComponent(maleInput)
                                    .addGap(37, 37, 37)
                                    .addComponent(femaleInput))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label10)
                                        .addComponent(label11)
                                        .addComponent(label12))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(confirmPassInput, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(passInput, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                            .addComponent(emailInput, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(177, 177, 177)
                            .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(16, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(fnInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(lnInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(label2)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label5)
                        .addComponent(dobInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label6)
                        .addComponent(addrInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label7)
                        .addComponent(idcInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8)
                        .addComponent(maleInput)
                        .addComponent(femaleInput))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label9)
                        .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label10)
                        .addComponent(emailInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label11)
                        .addComponent(passInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label12)
                        .addComponent(confirmPassInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 19, Short.MAX_VALUE))
        );
        setSize(565, 665);
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
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JTextField fnInput;
    private JTextField lnInput;
    private JTextField dobInput;
    private JTextField addrInput;
    private JTextField idcInput;
    private JTextField phoneInput;
    private JTextField emailInput;
    private JPasswordField passInput;
    private JPasswordField confirmPassInput;
    private JButton registerBtn;
    private JButton button2;
    private JRadioButton maleInput;
    private JRadioButton femaleInput;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
