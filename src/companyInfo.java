import javax.swing.*;
import java.awt.*;

public class companyInfo extends JDialog{
    private JTextField textField1;
    private JRadioButton companyRadioButton;
    private JRadioButton stockRadioButton;
    private JTable historyTable;
    private JPanel comInfoPanel;
    private JCheckBox checkBox1;

    public companyInfo(JFrame parent) {

        super(parent);

        // TODO: place custom component creation code here

        setTitle("Company Info");
        setContentPane(comInfoPanel);
        setMinimumSize(new Dimension(1000, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] columnNames = {"Date", "Price Change", "Exchange Amount", "Sum"};
        String[][] data = {{"12/05", "-3.00 (-3.75%)", "972,300", "79,510,400"},
                {"12/05", "-3.00 (-3.75%)", "972,300", "79,510,400"},
                {"12/05", "-3.00 (-3.75%)", "972,300", "79,510,400"}};
        this.historyTable = new JTable(data, columnNames);
        this.historyTable.setEnabled(false);

    }
    public static void main(String[] args) {
        companyInfo comInfo = new companyInfo(null);
    }


}