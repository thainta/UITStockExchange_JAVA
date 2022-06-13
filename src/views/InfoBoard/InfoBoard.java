package views.InfoBoard;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;
import utils.MySQLConnection;
import utils.currentUser;
import views.companyInfo.companyInfo;
import views.userInfo.userInfo;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;


/*
 * Created by JFormDesigner on Fri May 06 09:34:18 ICT 2022
 */



/**
 * @author unknown
 */
public class InfoBoard extends JFrame {
    public currentUser currentUser;
    private TimeSeries volumeSeries = new TimeSeries("Volume");
    private OHLCSeries ohlcSeries = new OHLCSeries("Price");
    String col[] = {"Symbol","Company","Price","Volume"};
    public static void main(String[] args) {
    }
    public InfoBoard(currentUser cUser) throws SQLException, ClassNotFoundException {
        currentUser = cUser;
        initComponents();
        //-----------------------------table2----------------------------------------------------

        DefaultTableModel model = new DefaultTableModel(col, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        loadStockData(model);
        table2.setModel(model);
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table2.setRowHeight(40);
        table2.setFillsViewportHeight(true);
        table2.setBackground(new Color(41, 55, 66));
        table2.getColumnModel().getColumn(0).setCellRenderer(new MyRenderer(new Color(72, 175, 240)));
        //table2.setShowGrid(false);
        //table2.setEnabled(false);


        //-------------------table2 header------------------------------------------------
        table2.getTableHeader().setBackground(new Color(41, 55, 66));
        table2.getTableHeader().setForeground(new Color(241, 244, 246));
        table2.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));
        ((DefaultTableCellRenderer)table2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        //-----------------------------JPanel----------------------------------------------------
        panel5.setBackground(new Color(41, 55, 66));

        Jpanell k = new Jpanell();
        k.setBackground(Color.red);
        Jpanell t = new Jpanell();
        t.setBackground(Color.blue);

        //Create chart
        OHLCDataset dataset = getDataset("AAA");
        DateAxis dateAxis = new DateAxis("Time");
        dateAxis.setLowerMargin(0.02);
        dateAxis.setUpperMargin(0.02);
        dateAxis.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
        //create price axixs
        NumberAxis priceAxis = new NumberAxis("Price");
        priceAxis.setAutoRangeIncludesZero(false);
        OHLCSeriesCollection candlestickDataset = new OHLCSeriesCollection();
        candlestickDataset.addSeries(ohlcSeries);
        CandlestickRenderer candlestickRenderer = new CandlestickRenderer(CandlestickRenderer.WIDTHMETHOD_AVERAGE,
                false, new CustomHighLowItemLabelGenerator(new SimpleDateFormat("yyyy-MM-dd"), NumberFormat.getInstance()));
        XYPlot candlestickSubplot = new XYPlot(candlestickDataset, null, priceAxis, candlestickRenderer);
        candlestickSubplot.setBackgroundPaint(Color.white);

        ////// volume a
        TimeSeriesCollection volumeDataset = new TimeSeriesCollection();
        volumeDataset.addSeries(volumeSeries);
        // Create volume chart volumeAxis
        NumberAxis volumeAxis = new NumberAxis("Volume");
        volumeAxis.setAutoRangeIncludesZero(false);
        // Set to no decimal
        volumeAxis.setNumberFormatOverride(new DecimalFormat("0"));
        // Create volume chart renderer
        XYBarRenderer timeRenderer = new XYBarRenderer();
        timeRenderer.setShadowVisible(false);
        timeRenderer.setMargin(0.3);
        timeRenderer.setDefaultOutlinePaint(AbstractRenderer.DEFAULT_VALUE_LABEL_PAINT);
        timeRenderer.setDefaultToolTipGenerator(new StandardXYToolTipGenerator("Volume--> Time={1} Size={2}",
                new SimpleDateFormat("yyyy-MM-dd"), new DecimalFormat("0")));
        // Create volumeSubplot
        XYPlot volumeSubplot = new XYPlot(volumeDataset, null, volumeAxis, timeRenderer);
        volumeSubplot.setBackgroundPaint(Color.white);

        //////

        CombinedDomainXYPlot mainPlot = new CombinedDomainXYPlot(dateAxis);

        mainPlot.setGap(10.0);
        mainPlot.add(candlestickSubplot,3);
        mainPlot.add(volumeSubplot, 1);
        mainPlot.setOrientation(PlotOrientation.VERTICAL);
        mainPlot.setDomainGridlinesVisible(true);
//        JFreeChart chart = ChartFactory.createCandlestickChart("MSFT", "Time", "Price", dataset, false);
        JFreeChart chart = new JFreeChart("AAA", JFreeChart.DEFAULT_TITLE_FONT, mainPlot, true);
        chart.removeLegend();

        internalFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        internalFrame1.setContentPane(new ChartPanel(chart));
        ((BasicInternalFrameUI)internalFrame1.getUI()).setNorthPane(null);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Insets insets = kit.getScreenInsets(internalFrame1.getGraphicsConfiguration());
        internalFrame1.setLocation((int) (insets.left), (int) (insets.top));
        internalFrame1.setVisible(true);
        internalFrame1.setResizable(false);
        //this.setResizable(false);
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

        ///////////////////////////////-------------------------------///////////////////////////////////
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }


    public OHLCDataset getDataset(String stockName) throws SQLException, ClassNotFoundException {
        ArrayList<OHLCDataItem> dataItems = new ArrayList<OHLCDataItem>();
        Connection conn = MySQLConnection.getMySQLConnection();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from stock where stock_name ='"+stockName+"'");
            while(rs.next()){
                Statement st2 = conn.createStatement();
                double close = 0;
                double open = 0;
                double high = 0;
                double low = 0;
                java.util.Date date;
                int volume = 0;
                int id = rs.getInt("id");
                int company_id = rs.getInt("company_id");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                ResultSet rs2 = st2.executeQuery("select * from daily_price where stock_id =" + id);
                if(!rs2.next()){ continue;}
                else{
                    do{
                        close = rs2.getBigDecimal("close_price").doubleValue();
                        open = rs2.getBigDecimal("open_price").doubleValue();
                        high = rs2.getBigDecimal("high_price").doubleValue();
                        low = rs2.getBigDecimal("low_price").doubleValue();
                        date = df.parse(rs2.getString("date"));
                        volume = rs2.getInt("volume");
                        OHLCDataItem item = new OHLCDataItem(date, open, high, low, close, volume);
                        dataItems.add(item);
                        volumeSeries.add(new Day(date), volume);
                        ohlcSeries.add(new Day(date),open, high, low, close);
                    }while (rs2.next());
                }
                rs2.close();
            }
            rs.close();
            Collections.reverse(dataItems);
            OHLCDataItem[] data = dataItems.toArray(new OHLCDataItem[dataItems.size()]);
            OHLCDataset dataset = new DefaultOHLCDataset("MSFT", data);
            return dataset;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void loadStockData(DefaultTableModel model) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from stock");
            while(rs.next()){
                Statement st2 = conn.createStatement();
                String maCK = rs.getString("stock_name");
                String company_name = "";
                double close_price = 0;
                int id = rs.getInt("id");
                int company_id = rs.getInt("company_id");
                int volume = 0;
                String query = String.format("select * from daily_price where stock_id=%s order by date desc", id);
                ResultSet rs2 = st2.executeQuery(query);
                rs2.next();
                close_price = rs2.getBigDecimal("close_price").doubleValue();
                volume = rs2.getInt("volume");

                Statement st3 = conn.createStatement();
                ResultSet rs3 = st3.executeQuery("select company_name from company where id=" + company_id);
                if(!rs3.next()){ continue;}
                else{
                    do{
                        company_name = rs3.getString("company_name");
                    }while (rs3.next());
                }
                model.addRow(new Object[]{maCK, company_name, close_price, volume});
            }
            rs.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void myProfileBtnMouseClicked(MouseEvent e) {
        userInfo userInfoForm = new userInfo(this.currentUser, this);
//        this.setVisible(false);
        userInfoForm.setVisible(true);
        this.setEnabled(false);
    }

    private void table2MouseClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        if(e.getClickCount() == 1)
        {
            int row_selected = table2.getSelectedRow();
            volumeSeries = new TimeSeries("Volume");
            ohlcSeries = new OHLCSeries("price");
            String StockName = table2.getValueAt(row_selected, 0).toString();
            OHLCDataset dataset = getDataset(StockName);
            DateAxis dateAxis = new DateAxis("Date");
            dateAxis.setLowerMargin(0.02);
            dateAxis.setUpperMargin(0.02);
            dateAxis.setAutoRange(true);
            dateAxis.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
            //create price axixs
            NumberAxis priceAxis = new NumberAxis("Price");
            priceAxis.setAutoRangeIncludesZero(false);
            OHLCSeriesCollection candlestickDataset = new OHLCSeriesCollection();
            candlestickDataset.addSeries(ohlcSeries);
            CandlestickRenderer candlestickRenderer = new CandlestickRenderer(CandlestickRenderer.WIDTHMETHOD_AVERAGE,
                    false, new CustomHighLowItemLabelGenerator(new SimpleDateFormat("yyyy-MM-dd"), NumberFormat.getInstance()));
            XYPlot candlestickSubplot = new XYPlot(candlestickDataset, null, priceAxis, candlestickRenderer);
            candlestickSubplot.setBackgroundPaint(Color.white);
            ////// volume axis
            TimeSeriesCollection volumeDataset = new TimeSeriesCollection();
            volumeDataset.addSeries(volumeSeries);
            // Create volume chart volumeAxis
            NumberAxis volumeAxis = new NumberAxis("Volume");
            volumeAxis.setAutoRangeIncludesZero(false);
            // Set to no decimal
            volumeAxis.setNumberFormatOverride(new DecimalFormat("0"));
            // Create volume chart renderer
            XYBarRenderer timeRenderer = new XYBarRenderer();
            timeRenderer.setShadowVisible(false);
            timeRenderer.setMargin(0.3);
            timeRenderer.setDefaultToolTipGenerator(new StandardXYToolTipGenerator("Volume--> Time={1} Size={2}",
                    new SimpleDateFormat("yyyy-MM-dd"), new DecimalFormat("0")));
            // Create volumeSubplot
            XYPlot volumeSubplot = new XYPlot(volumeDataset, null, volumeAxis, timeRenderer);
            volumeSubplot.setBackgroundPaint(Color.white);

            //////

            CombinedDomainXYPlot mainPlot = new CombinedDomainXYPlot(dateAxis);
            mainPlot.setGap(10.0);
            mainPlot.add(candlestickSubplot, 4);
            mainPlot.add(volumeSubplot, 2);
            mainPlot.setOrientation(PlotOrientation.VERTICAL);
            mainPlot.setDomainGridlinesVisible(true);
            // JFreeChart chart = ChartFactory.createCandlestickChart("MSFT", "Time", "Price", dataset, false);
            JFreeChart chart = new JFreeChart(StockName, JFreeChart.DEFAULT_TITLE_FONT, mainPlot, true);
            chart.removeLegend();

            internalFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            internalFrame1.setContentPane(new ChartPanel(chart));
            ((BasicInternalFrameUI) internalFrame1.getUI()).setNorthPane(null);
            Toolkit kit = Toolkit.getDefaultToolkit();
            Insets insets = kit.getScreenInsets(internalFrame1.getGraphicsConfiguration());
            internalFrame1.setLocation((int) (insets.left), (int) (insets.top));
            internalFrame1.setVisible(true);
        }
        else {
            Connection conn = MySQLConnection.getMySQLConnection();
            String stockNme = table2.getValueAt(table2.getSelectedRow(),0).toString();
            try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id from stock where stock_name ='"+ stockNme+"'");
                rs.next();
                new companyInfo( rs.getInt("id"), table2.getValueAt(table2.getSelectedRow(),1).toString(), stockNme).setVisible(true);
                rs.close();
            }
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    private void button1MouseClicked(MouseEvent e) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnection.getMySQLConnection();
        try{
            DefaultTableModel model = new DefaultTableModel(col, 0){

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            String Search = textField1.getText();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from stock");
            while(rs.next()){
                Statement st2 = conn.createStatement();
                String maCK = rs.getString("stock_name");
                String company_name = "";
                double close_price = 0;
                int id = rs.getInt("id");
                int company_id = rs.getInt("company_id");
                int volume = 0;
                if(maCK.indexOf(Search) == 0) {
                    ResultSet rs2 = st2.executeQuery("select * from daily_price where date = '2022-05-04' and stock_id =" + id);
                    if (!rs2.next()) {
                        continue;
                    } else {
                        do {
                            close_price = rs2.getBigDecimal("close_price").doubleValue();
                            volume = rs2.getInt("volume");
                        } while (rs2.next());
                    }

                    Statement st3 = conn.createStatement();
                    ResultSet rs3 = st3.executeQuery("select company_name from company where id=" + company_id);
                    if (!rs3.next()) {
                        continue;
                    } else {
                        do {
                            company_name = rs3.getString("company_name");
                        } while (rs3.next());
                    }
                    model.addRow(new Object[]{maCK, company_name, close_price, volume});
                }
                else continue;
            }
            table2.setModel(model);
            table2.getColumnModel().getColumn(0).setCellRenderer(new MyRenderer(new Color(72, 175, 240)));
            rs.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Le Duy Hoang
        panel4 = new JPanel();
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        myProfileBtn = new JButton();
        textField1 = new JTextField();
        button1 = new JButton();
        internalFrame1 = new JInternalFrame();

        //======== this ========
        setBackground(UIManager.getColor("ActionButton.focusedBorderColor"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel4 ========
        {
            panel4.setBackground(new Color(41, 55, 66));
            panel4.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
            .Color.red),panel4. getBorder()));panel4. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".
            equals(e.getPropertyName()))throw new RuntimeException();}});

            //======== panel5 ========
            {

                //======== scrollPane2 ========
                {

                    //---- table2 ----
                    table2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    table2.setForeground(new Color(241, 244, 246));
                    table2.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                table2MouseClicked(e);
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            } catch (ClassNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    scrollPane2.setViewportView(table2);
                }

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

                //---- button1 ----
                button1.setText("Search");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            button1MouseClicked(e);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                            .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addComponent(textField1)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1)
                                    .addGap(35, 35, 35)
                                    .addComponent(myProfileBtn)))
                            .addContainerGap())
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                            .addGroup(panel5Layout.createParallelGroup()
                                .addComponent(myProfileBtn)
                                .addComponent(button1)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
                );
            }

            //======== internalFrame1 ========
            {
                internalFrame1.setVisible(true);
                var internalFrame1ContentPane = internalFrame1.getContentPane();

                GroupLayout internalFrame1ContentPaneLayout = new GroupLayout(internalFrame1ContentPane);
                internalFrame1ContentPane.setLayout(internalFrame1ContentPaneLayout);
                internalFrame1ContentPaneLayout.setHorizontalGroup(
                    internalFrame1ContentPaneLayout.createParallelGroup()
                        .addGap(0, 461, Short.MAX_VALUE)
                );
                internalFrame1ContentPaneLayout.setVerticalGroup(
                    internalFrame1ContentPaneLayout.createParallelGroup()
                        .addGap(0, 604, Short.MAX_VALUE)
                );
            }

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addComponent(internalFrame1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(internalFrame1)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JButton myProfileBtn;
    private JTextField textField1;
    private JButton button1;
    private JInternalFrame internalFrame1;
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
