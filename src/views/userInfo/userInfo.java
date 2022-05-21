/*
 * Created by JFormDesigner on Sat May 21 08:20:03 ICT 2022
 */

package views.userInfo;

import views.companyInfo.companyInfo;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Le Duy Hoang
 */
public class userInfo extends JFrame {
    public static void main(String[] args) {

        new userInfo().setVisible(true);
    }


    public userInfo() {
        initComponents();
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
        button1 = new JButton();
        label11 = new JLabel();
        button2 = new JButton();
        textPane1 = new JTextPane();
        panel1 = new JPanel();
        textField3 = new JTextField();
        label12 = new JLabel();
        label13 = new JLabel();
        textField1 = new JTextField();
        label14 = new JLabel();
        textField4 = new JTextField();
        label15 = new JLabel();
        textField5 = new JTextField();
        label16 = new JLabel();
        textField6 = new JTextField();
        label17 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label18 = new JLabel();
        label19 = new JLabel();
        textField8 = new JTextField();
        textField9 = new JTextField();
        button3 = new JButton();
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

        //---- label4 ----
        label4.setText("User");
        label4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        label4.setForeground(Color.red);

        //---- label5 ----
        label5.setText("Status:");
        label5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));

        //---- label6 ----
        label6.setText("Online");
        label6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        label6.setForeground(Color.green);

        //---- label7 ----
        label7.setText("CreatedOn:");
        label7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));

        //---- label8 ----
        label8.setText("22/3/2022");
        label8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        label8.setForeground(Color.blue);

        //---- label9 ----
        label9.setText("Balance:");
        label9.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 15));

        //---- label10 ----
        label10.setText("**********");
        label10.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));

        //---- button1 ----
        button1.setText("Visible");
        button1.setFont(new Font("Source Code Pro", Font.BOLD, 12));

        //---- label11 ----
        label11.setText("StockBag:");
        label11.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 15));

        //---- button2 ----
        button2.setText("View");
        button2.setFont(new Font("Source Code Pro", Font.BOLD, 12));

        //======== panel1 ========
        {
            panel1.setBackground(UIManager.getColor("ActionButton.hoverSeparatorColor"));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;

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

            //---- radioButton1 ----
            radioButton1.setText("Male");
            radioButton1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            //---- radioButton2 ----
            radioButton2.setText("Female");
            radioButton2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            //---- label18 ----
            label18.setText("Phone:");
            label18.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- label19 ----
            label19.setText("Email:");
            label19.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

            //---- textField9 ----
            textField9.setEditable(false);

            //---- button3 ----
            button3.setText("Update");

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
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(textField1)
                                    .addComponent(textField3)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label14)
                                    .addComponent(label15)
                                    .addComponent(label16)
                                    .addComponent(label17)
                                    .addComponent(label18)
                                    .addComponent(label19))
                                .addGap(47, 47, 47)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(textField4)
                                    .addComponent(textField5)
                                    .addComponent(textField6, GroupLayout.Alignment.TRAILING)
                                    .addComponent(textField8)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(radioButton1)
                                                .addGap(40, 40, 40)
                                                .addComponent(radioButton2)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(78, 78, 78))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label13)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label14)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label15)
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label16)
                            .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label17)
                                .addComponent(radioButton1))
                            .addComponent(radioButton2))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label18)
                            .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label19))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(627, 627, 627)
                            .addComponent(textPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label4)
                                    .addGap(34, 34, 34)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label6)
                                    .addGap(129, 129, 129)
                                    .addComponent(label8))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label10)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(94, 94, 94)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label7)
                                        .addComponent(label2))))))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label10)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(label5)
                                    .addComponent(label6)
                                    .addComponent(label7)
                                    .addComponent(label8)
                                    .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button2))
                                    .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        setSize(625, 550);
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
    private JButton button1;
    private JLabel label11;
    private JButton button2;
    private JTextPane textPane1;
    private JPanel panel1;
    private JTextField textField3;
    private JLabel label12;
    private JLabel label13;
    private JTextField textField1;
    private JLabel label14;
    private JTextField textField4;
    private JLabel label15;
    private JTextField textField5;
    private JLabel label16;
    private JTextField textField6;
    private JLabel label17;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label18;
    private JLabel label19;
    private JTextField textField8;
    private JTextField textField9;
    private JButton button3;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
