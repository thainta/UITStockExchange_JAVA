/*
 * Created by JFormDesigner on Sat May 21 21:29:09 ICT 2022
 */

package views.companyInfo;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.plaf.*;
import utils.*;
import views.buyStock.buyStock;

/**
 * @author Le Duy Hoang
 */
public class companyInfo extends JFrame {
    private int stockId;
    String companyName;
    String CompanyShortName;
    public companyInfo(int stockId, String CompanyName, String CompanyShortName) throws SQLException, ClassNotFoundException {
        this.stockId = stockId;
        this.companyName = CompanyName;
        this.CompanyShortName = CompanyShortName;
        initComponents();
        label2.setText(companyName);
        label1.setText(CompanyShortName);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(52,52,52));
        panel4.setBackground(new Color(52,52,52));
        panel6.setBackground(new Color(52,52,52));
        button2.setFocusPainted(false);
        loadData();

    }

    public void loadData() throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try{
            Statement st = conn.createStatement();
            String query = String.format("select * from daily_price where date = '2022-06-07' and stock_id=%s", stockId);
            ResultSet rs = st.executeQuery(query);

            rs.next();
            label15.setText(String.valueOf(rs.getInt("volume")));
            label16.setText(String.valueOf(rs.getInt("volume")));
            label17.setText(String.valueOf(rs.getInt("open_price")));
            label18.setText(String.valueOf(rs.getInt("high_price")));
            label19.setText(String.valueOf(rs.getInt("low_price")));
            rs.close();
            query = "select count(*) from exchange where stock_id ="+stockId;
            ResultSet rs2 = st.executeQuery(query);
            rs2.next();
            label14.setText(String.valueOf(rs2.getInt("count(*)")));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void button2MouseClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        this.setVisible(false);
        new buyStock(CompanyShortName, new utils.currentUser(2, null, 123)).setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
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

        //======== this ========
        setBackground(UIManager.getColor("SplitPane.shadow"));
        setResizable(false);
        setMinimumSize(new Dimension(14, 29));
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(UIManager.getColor("ActionButton.pressedBackground"));
//            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
//            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax
//            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,
//            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
//            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .
//            getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("VCB");
            label1.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 25));
            label1.setForeground(Color.red);
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label2 ----
            label2.setText("Ngan hang thuong mai co phan ngoai thuong VN");
            label2.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 15));
            label2.setForeground(Color.blue);
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            label6.setForeground(Color.white);

            //---- label7 ----
            label7.setText("15:15 20/05/2022");
            label7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
            label7.setForeground(Color.white);

            //======== panel6 ========
            {
                panel6.setBackground(UIManager.getColor("ColorPalette.lightBorder"));

                //---- label8 ----
                label8.setText("Exchange quantity:");
                label8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
                label8.setForeground(Color.white);

                //---- label9 ----
                label9.setText("Volume");
                label9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
                label9.setForeground(Color.white);

                //---- label10 ----
                label10.setText("Value");
                label10.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
                label10.setForeground(Color.white);

                //---- label11 ----
                label11.setText("Open price:");
                label11.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
                label11.setForeground(Color.white);

                //---- label12 ----
                label12.setText("Highest price:");
                label12.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
                label12.setForeground(Color.white);

                //---- label13 ----
                label13.setText("Lowest price:");
                label13.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
                label13.setForeground(Color.white);

                //---- label14 ----
                label14.setText("76");
                label14.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label14.setForeground(new Color(255, 153, 0));
                label14.setHorizontalAlignment(SwingConstants.RIGHT);

                //---- label15 ----
                label15.setText("81.3");
                label15.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label15.setForeground(Color.magenta);
                label15.setHorizontalAlignment(SwingConstants.RIGHT);

                //---- label16 ----
                label16.setText("70.7");
                label16.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label16.setForeground(new Color(0, 102, 153));
                label16.setHorizontalAlignment(SwingConstants.RIGHT);

                //---- label17 ----
                label17.setText("75.1");
                label17.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label17.setForeground(new Color(204, 0, 0));
                label17.setHorizontalAlignment(SwingConstants.RIGHT);

                //---- label18 ----
                label18.setText("76.5");
                label18.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label18.setForeground(new Color(0, 165, 0));
                label18.setHorizontalAlignment(SwingConstants.RIGHT);

                //---- label19 ----
                label19.setText("75");
                label19.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
                label19.setForeground(new Color(204, 0, 0));
                label19.setHorizontalAlignment(SwingConstants.RIGHT);

                //---- button2 ----
                button2.setText("Exchange");
                button2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
                button2.setForeground(Color.white);
                button2.setBackground(new Color(52, 52, 52));
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            button2MouseClicked(e);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label8)
                                                .addComponent(label9))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label15, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label11)
                                                .addComponent(label12)
                                                .addComponent(label10))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label16, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                                .addComponent(label18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(GroupLayout.Alignment.LEADING, panel6Layout.createSequentialGroup()
                                            .addComponent(label13)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                                            .addComponent(label19, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap())
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
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                        .addContainerGap(67, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        setSize(450, 550);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
