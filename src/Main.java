import javax.swing.*;

import com.stimulsoft.base.drawing.StiColorEnum;
import com.stimulsoft.base.drawing.StiSolidBrush;
import com.stimulsoft.base.drawing.enums.StiBorderSides;
import com.stimulsoft.base.drawing.enums.StiTextHorAlignment;
import com.stimulsoft.base.exception.StiException;
import com.stimulsoft.base.system.geometry.StiRectangle;
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
import com.stimulsoft.report.utils.data.StiDataColumnsUtil;
import com.stimulsoft.report.utils.data.StiSqlField;
import com.stimulsoft.report.utils.data.StiTableFieldsRequest;
import utils.currentUser;
import views.signIn.signIn;
import com.stimulsoft.report.*;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

        public static void main(String[] args) {
        // login page load.
        signIn signInForm = new signIn();
        signInForm.setVisible(true);
    }
}
