/*
 * Created by JFormDesigner on Sat Jun 25 10:24:12 ICT 2022
 */

package REPORT;

import com.stimulsoft.base.drawing.StiColorEnum;
import com.stimulsoft.base.drawing.StiSolidBrush;
import com.stimulsoft.base.drawing.enums.StiBorderSides;
import com.stimulsoft.base.drawing.enums.StiTextHorAlignment;
import com.stimulsoft.base.exception.StiException;
import com.stimulsoft.base.system.geometry.StiRectangle;
import com.stimulsoft.flex.interactionObject.StiTableDataRequest;
import com.stimulsoft.report.StiReport;
import com.stimulsoft.report.components.StiPage;
import com.stimulsoft.report.components.bands.StiDataBand;
import com.stimulsoft.report.components.simplecomponents.StiText;
import com.stimulsoft.report.dictionary.StiDataColumn;
import com.stimulsoft.report.dictionary.StiDataColumnsCollection;
import com.stimulsoft.report.dictionary.StiDictionary;
import com.stimulsoft.report.dictionary.adapters.StiMySqlAdapter;
import com.stimulsoft.report.dictionary.dataSources.StiMySqlSource;
import com.stimulsoft.report.dictionary.databases.StiMySqlDatabase;
import com.stimulsoft.report.saveLoad.StiDocument;
import com.stimulsoft.report.utils.data.StiDataColumnsUtil;
import com.stimulsoft.report.utils.data.StiSqlField;
import com.stimulsoft.report.utils.data.StiTableFieldsRequest;
import com.stimulsoft.viewer.StiViewerFx;
import com.stimulsoft.viewer.events.StiViewCommonEvent;


import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Thái Nguyễn Thừa An
 */
public class report extends JFrame {
    public report() throws SQLException, FileNotFoundException, ClassNotFoundException, StiException {
        initComponents();
        StiReport report = createReport();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(1000, 1000));
        StiViewerFx viewerPanel = new StiViewerFx(this);
        panel.add(viewerPanel);
        this.setContentPane(panel);
        this.setSize(new Dimension(1000, 1000));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        viewerPanel.getStiViewModel().getEventDispatcher()
                .dispatchStiEvent(new StiViewCommonEvent(StiViewCommonEvent.DOCUMENT_FILE_LOADED, new StiDocument(report), null));
    }


    public static void main(String[] args) throws SQLException, FileNotFoundException, ClassNotFoundException, StiException {
        new report();
    }

    public static StiReport createReport() throws ClassNotFoundException, SQLException, StiException, FileNotFoundException, StiException, SQLException {
        StiReport report = StiReport.newInstance();
        StiPage page = report.getPages().get(0);
        report.setDictionary(new StiDictionary(report));
        StiMySqlDatabase db = new StiMySqlDatabase(
                "uit_stock_exchange", "uit_stock_exchange", "jdbc:mysql://localhost:3306/uit_stock_exchange;user=root;password=Thai16122001;database=uit_stock_exchange");
        report.getDictionary().getDatabases().add(db);
        StiMySqlSource source = new StiMySqlSource("uit_stock_exchange.exchange", "exchanges", "exchanges", "select * from exchange");
        source.setDictionary(report.getDictionary());
        report.getDictionary().getDataSources().add(source);
        source.setColumns(new StiDataColumnsCollection());
        StiMySqlAdapter adapter = new StiMySqlAdapter(db.getConnectionString());
        Class.forName(adapter.getDriverName());
        Connection con = com.stimulsoft.webdesigner.helper.StiDictionaryHelper.getConnection(adapter.getJdbcParameters());
        StiTableDataRequest rq = new StiTableDataRequest(source.toString());

        StiTableFieldsRequest request = StiDataColumnsUtil.getFields(con, source.getQuery(), source);
        for (StiSqlField field : request.getColumns()) {
            source.getColumns().add(new StiDataColumn(field.getName(), field.getName(), field.getSystemType()));
        }

        StiDataBand dataBand = new StiDataBand();
        dataBand.setDataSourceName("exchange");
        dataBand.setHeight(0.5);
        dataBand.setName("DataBand");
        page.getComponents().add(dataBand);
        double pos = 0;
        double columnWidth = page.getWidth() / source.getColumns().size();
        Integer nameIndex = 1;
        source.getDictionary().getDatabases();
        System.out.println();
        for (StiDataColumn dataColumn : source.getColumns()) {
            // Create text on header
            StiText hText = new StiText(new StiRectangle(pos, 0, columnWidth, 0.5));

            hText.setTextInternal(dataColumn.getName());
            hText.setHorAlignment(StiTextHorAlignment.Center);
            hText.setName("HeaderText" + nameIndex.toString());
            hText.setBrush(new StiSolidBrush(StiColorEnum.Orange.color()));
            hText.getBorder().setSide(StiBorderSides.All);

            StiText dataText = new StiText(new StiRectangle(pos, 0, columnWidth, 0.5));
            dataText.setText("{exchanges." + dataColumn.getName());
            dataText.setName("DataText" + nameIndex.toString());
            dataText.getBorder().setSide(StiBorderSides.All);
            dataBand.getComponents().add(dataText);
            pos = pos + columnWidth;
            nameIndex++;
        }
        report.Render();
        return report;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An

        //======== this ========
        var contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 400, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Thái Nguyễn Thừa An
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
