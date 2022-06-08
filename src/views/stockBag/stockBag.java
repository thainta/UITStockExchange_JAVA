/*
 * Created by JFormDesigner on Wed Jun 08 11:50:41 ICT 2022
 */

package views.stockBag;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author Le Duy Hoang
 */
public class stockBag extends JFrame {
    public stockBag(Integer accountId) {
        initComponents();
        
    }

    private void button1MouseClicked(MouseEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Le Duy Hoang
        tabbedPane1 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        stockTable = new JTable();

        //======== this ========
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== scrollPane1 ========
            {

                //---- stockTable ----
                stockTable.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                        {null, null, null, "Sell"},
                    },
                    new String[] {
                        "Stock Name", "Amount", "Value", "Action"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = stockTable.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(0).setMaxWidth(200);
                    cm.getColumn(0).setPreferredWidth(200);
                    cm.getColumn(1).setResizable(false);
                    cm.getColumn(1).setMaxWidth(120);
                    cm.getColumn(1).setPreferredWidth(120);
                    cm.getColumn(2).setResizable(false);
                    cm.getColumn(2).setMaxWidth(160);
                    cm.getColumn(2).setPreferredWidth(160);
                    cm.getColumn(3).setMaxWidth(50);
                    cm.getColumn(3).setPreferredWidth(50);
                    cm.getColumn(3).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "Sell"
                        }))));
                }
                scrollPane1.setViewportView(stockTable);
            }
            tabbedPane1.addTab("Stock owned", scrollPane1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                    .addGap(46, 46, 46))
        );
        setSize(625, 340);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Le Duy Hoang
    private JTabbedPane tabbedPane1;
    private JScrollPane scrollPane1;
    private JTable stockTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
