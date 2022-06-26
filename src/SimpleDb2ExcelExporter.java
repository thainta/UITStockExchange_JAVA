import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class SimpleDb2ExcelExporter {

    public static void main(String[] args) throws ClassNotFoundException {
        new SimpleDb2ExcelExporter().export();
    }

    public void export() throws ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/uit_stock_exchange";
        String username = "root";
        String password = "Thai16122001";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String excelFilePath = "Reviews-export.xlsx";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM exchange";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");

            writeHeaderLine(sheet);

            writeDataLines(result, workbook, sheet);

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }

    private void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("ID");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Stock id");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Created on");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Price");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Trading volume");
    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
                                XSSFSheet sheet) throws SQLException {
        int rowCount = 1;

        while (result.next()) {
            String courseName = result.getString("id");
            String studentName = result.getString("stock_id");
            float rating = result.getFloat("price");
            Timestamp timestamp = result.getTimestamp("create_on");
            String comment = result.getString("trading_volumn");

            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(courseName);

            cell = row.createCell(columnCount++);
            cell.setCellValue(studentName);

            cell = row.createCell(columnCount++);

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);

            cell.setCellValue(timestamp);

            cell = row.createCell(columnCount++);
            cell.setCellValue(rating);

            cell = row.createCell(columnCount);
            cell.setCellValue(comment);

        }
    }

}