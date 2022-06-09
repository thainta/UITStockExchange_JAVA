/*
 * Created by JFormDesigner on Sat May 21 21:29:09 ICT 2022
 */

package views.companyInfo;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Le Duy Hoang
 */
public class companyInfo extends JFrame {
    public static void main(String[] args) {

        new companyInfo().setVisible(true);
    }

    public companyInfo() {
        initComponents();
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Le Duy Hoang
        createUIComponents();

        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        panel3 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel4 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        panel6 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        button2 = new JButton();
        panel5 = new JPanel();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setBackground(UIManager.getColor("BigSpinner.background"));
        setResizable(false);
        setMinimumSize(new Dimension(14, 29));
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(UIManager.getColor("ActionButton.pressedBackground"));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("VCB");
            label1.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 25));
            label1.setForeground(Color.red);

            //---- label2 ----
            label2.setText("Ngan hang thuong mai co phan ngoai thuong VN");
            label2.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 24));
            label2.setForeground(Color.blue);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(label2))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {
            panel2.setBackground(UIManager.getColor("ActionButton.pressedBorderColor"));

            //---- label3 ----
            label3.setText("Search");
            label3.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- button1 ----
            button1.setText("Search");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(129, Short.MAX_VALUE)
                        .addComponent(button1)
                        .addGap(123, 123, 123))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1)
                        .addContainerGap())
            );
        }

        //======== panel3 ========
        {

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(table2);
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
            );
        }

        //======== panel4 ========
        {
            panel4.setBackground(UIManager.getColor("SplitPane.shadow"));

            //---- label4 ----
            label4.setText("75.3");
            label4.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 32));
            label4.setForeground(Color.red);

            //---- label5 ----
            label5.setText("-0.7 (-0.92%)");
            label5.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 16));
            label5.setForeground(Color.red);

            //---- label6 ----
            label6.setText("Update:");
            label6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));

            //---- label7 ----
            label7.setText("15:15 20/05/2022");
            label7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));

            //======== panel6 ========
            {
                panel6.setBackground(UIManager.getColor("ColorPalette.lightBorder"));

                //---- label8 ----
                label8.setText("Exchange quantity:");
                label8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));

                //---- label9 ----
                label9.setText("Compare price:");
                label9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));

                //---- label10 ----
                label10.setText("Top price:");
                label10.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));

                //---- label11 ----
                label11.setText("Bottom price:");
                label11.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));

                //---- label12 ----
                label12.setText("Highest price:");
                label12.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));

                //---- label13 ----
                label13.setText("Lowest price:");
                label13.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));

                //---- label14 ----
                label14.setText("76");
                label14.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label14.setForeground(new Color(255, 153, 0));

                //---- label15 ----
                label15.setText("81.3");
                label15.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label15.setForeground(Color.magenta);

                //---- label16 ----
                label16.setText("70.7");
                label16.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label16.setForeground(new Color(0, 102, 153));

                //---- label17 ----
                label17.setText("75.1");
                label17.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label17.setForeground(new Color(204, 0, 0));

                //---- label18 ----
                label18.setText("76.5");
                label18.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label18.setForeground(new Color(0, 165, 0));

                //---- label19 ----
                label19.setText("75");
                label19.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label19.setForeground(new Color(204, 0, 0));

                //---- button2 ----
                button2.setText("Back");
                button2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label8)
                                                .addComponent(label9))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label15)
                                                .addComponent(label14, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(label16)
                                            .addGap(7, 7, 7))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label11)
                                                .addComponent(label12)
                                                .addComponent(label10))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label18)
                                                .addComponent(label17, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap())
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addComponent(label13)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label19)
                                    .addGap(24, 24, 24))))
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 36, Short.MAX_VALUE))
                );
                panel6Layout.setVerticalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label8)
                                .addComponent(label14))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label9)
                                .addComponent(label15))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label10)
                                .addComponent(label16))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label11)
                                .addComponent(label17, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label12)
                                .addComponent(label18))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label13)
                                .addComponent(label19))
                            .addGap(27, 27, 27)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(17, Short.MAX_VALUE))
                );
            }

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5))
                            .addComponent(label6)
                            .addComponent(label7))
                        .addContainerGap(116, Short.MAX_VALUE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(label5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel5 ========
        {

            GroupLayout panel5Layout = new GroupLayout(panel5);
            panel5.setLayout(panel5Layout);
            panel5Layout.setHorizontalGroup(
                panel5Layout.createParallelGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
            );
            panel5Layout.setVerticalGroup(
                panel5Layout.createParallelGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
            );
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                                .addComponent(panel4, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                            .addContainerGap())))
        );
        setSize(1080, 525);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Le Duy Hoang
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel2;
    private JLabel label3;
    private JTextField textField1;
    private JButton button1;
    private JPanel panel3;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel4;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JPanel panel6;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JButton button2;
    private JPanel panel5;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
