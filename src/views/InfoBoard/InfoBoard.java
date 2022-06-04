package views.InfoBoard;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.currentUser;
import views.userInfo.*;
/*
 * Created by JFormDesigner on Fri May 06 09:34:18 ICT 2022
 */



/**
 * @author unknown
 */
public class InfoBoard extends JFrame {
    public currentUser currentUser;
    public static void main(String[] args) {
    }
    public InfoBoard(currentUser cUser) {
        currentUser = cUser;
        initComponents();
        //-----------------------------table2----------------------------------------------------
        String col[] = {"Mã CK","Giá trị","Giá","Thay đổi"};
        String data[][] = {{"HPG",	"687,635",	"42,350",	"300 (0.71%)"},
                {"VPB",	"576,499",	"34,750",	"-800 (-2.25%)"},
                {"DIG",	"474,648",	"56,000",	"-2,100 (-3.61%)"},
                {"DGC",	"420,257",	"232,000",	"-4,800 (-2.03%)"},
                {"DPM",	"401,586",	"63,400",	"300 (0.48%)"},
                {"VHM",	"355,755",	"67,700",	"-1,100 (-1.6%)"},
                {"GEX",	"355,496",	"27,150",	"-1,350 (-4.74%)"},
                {"FPT",	"354,467",	"102,300",	"-2,400 (-2.29%)"},
                {"VND",	"336,370",	"28,300",	"-700 (-2.41%)"},
                {"TCB",	"310,340",	"41,900",	"-700 (-1.64%)"}};

        DefaultTableModel model = new DefaultTableModel(data, col);
        table2.setModel(model);
        table2.setRowHeight(40);
        table2.setFillsViewportHeight(true);
        table2.setBackground(new Color(41, 55, 66));
        table2.getColumnModel().getColumn(0).setCellRenderer(new MyRenderer(new Color(72, 175, 240)));
        table2.setShowGrid(false);

        //-------------------table2 header------------------------------------------------
        table2.getTableHeader().setBackground(new Color(41, 55, 66));
        table2.getTableHeader().setForeground(new Color(241, 244, 246));
        table2.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));
        ((DefaultTableCellRenderer)table2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        //-----------------------------JPanel----------------------------------------------------
        panel5.setBackground(new Color(41, 55, 66));
        Jpanell k = new Jpanell();
        k.setBackground(Color.red);
        Jpanell t = new Jpanell();
        t.setBackground(Color.blue);
        GroupLayout p7layout = (GroupLayout)panel7.getLayout();
//        p7layout.setHorizontalGroup(
//                p7layout.createParallelGroup()
//                        .addGroup(p7layout.createSequentialGroup()
//                            .addGroup(p7layout.createParallelGroup()
//                                .addComponent(k, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(t, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                            .addContainerGap())
//                );
//        p7layout.setVerticalGroup(
//                p7layout.createParallelGroup()
//                        .addGroup(p7layout.createSequentialGroup()
//                            .addContainerGap()
//                            .addComponent(k, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                            .addComponent(t, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                            .addContainerGap(79, Short.MAX_VALUE))
//                );
        panel7.revalidate();
        panel7.repaint();
        ///////////////////////////////-------------------------------///////////////////////////////////
        setVisible(true);
        pack();
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void myProfileBtnMouseClicked(MouseEvent e) {
        userInfo userInfoForm = new userInfo(this.currentUser);
        this.setVisible(false);
        userInfoForm.setVisible(true);
    }

    


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Le Duy Hoang
        panel4 = new JPanel();
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        myProfileBtn = new JButton();
        panel6 = new JPanel();
        panel7 = new JPanel();

        //======== this ========
        setBackground(UIManager.getColor("ActionButton.focusedBorderColor"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel4 ========
        {
            panel4.setBackground(new Color(41, 55, 66));
            panel4.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel4. getBorder () ) )
            ; panel4. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;

            //======== panel5 ========
            {

                //======== scrollPane2 ========
                {

                    //---- table2 ----
                    table2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    table2.setForeground(new Color(241, 244, 246));
                    scrollPane2.setViewportView(table2);
                }

                //---- button1 ----
                button1.setText("Tang gia");
                button1.setBackground(new Color(57, 75, 89));
                button1.setForeground(new Color(241, 244, 246));
                button1.addActionListener(e -> button1(e));

                //---- button2 ----
                button2.setText("Giam gia");
                button2.setBackground(new Color(57, 75, 89));
                button2.setForeground(new Color(241, 244, 246));

                //---- button3 ----
                button3.setText("NN mua");
                button3.setBackground(new Color(57, 75, 89));
                button3.setForeground(new Color(241, 244, 246));

                //---- button4 ----
                button4.setText("NN ban");
                button4.setBackground(new Color(57, 75, 89));
                button4.setForeground(new Color(241, 244, 246));

                //---- myProfileBtn ----
                myProfileBtn.setText("My Profile");
                myProfileBtn.setBackground(new Color(57, 75, 89));
                myProfileBtn.setForeground(new Color(241, 244, 246));
                myProfileBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        myProfileBtnMouseClicked(e);
                    }
                });

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGroup(panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addComponent(button1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                    .addComponent(myProfileBtn))
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                            .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2)
                                .addComponent(button3)
                                .addComponent(button4)
                                .addComponent(myProfileBtn))
                            .addGap(12, 12, 12)
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
                );
            }

            //======== panel6 ========
            {

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup()
                        .addGap(0, 461, Short.MAX_VALUE)
                );
                panel6Layout.setVerticalGroup(
                    panel6Layout.createParallelGroup()
                        .addGap(0, 374, Short.MAX_VALUE)
                );
            }

            //======== panel7 ========
            {

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGap(0, 461, Short.MAX_VALUE)
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGap(0, 255, Short.MAX_VALUE)
                );
            }

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup()
                            .addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Le Duy Hoang
    private JPanel panel4;
    private JPanel panel5;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton myProfileBtn;
    private JPanel panel6;
    private JPanel panel7;
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



class Jpanell extends JPanel {
    public Jpanell() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
                .EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax
                .swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,
                12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
                .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.
                getPropertyName()))throw new RuntimeException();}});

        //---- label1 ----
        label1.setText("text");

        //---- label2 ----
        label2.setText("text");

        //---- label3 ----
        label3.setText("text");

        //---- label4 ----
        label4.setText("text");

        //---- label5 ----
        label5.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()).addGap(0, 466, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 81, Short.MAX_VALUE)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
}
/*
{"HPG",	"687,635",	"42,350",	"300 (0.71%)"},
{"VPB",	"576,499",	"34,750",	"-800 (-2.25%)"},
{"DIG",	"474,648",	"56,000",	"-2,100 (-3.61%)"},
{"DGC",	"420,257",	"232,000",	"-4,800 (-2.03%)"},
{"DPM",	"401,586",	"63,400",	"300 (0.48%)"},
{"VHM",	"355,755",	"67,700",	"-1,100 (-1.6%)"},
{"GEX",	"355,496",	"27,150",	"-1,350 (-4.74%)"},
{"FPT",	"354,467",	"102,300",	"-2,400 (-2.29%)"},
{"VND",	"336,370",	"28,300",	"-700 (-2.41%)"},
{"TCB",	"310,340",	"41,900",	"-700 (-1.64%)"},

*/
