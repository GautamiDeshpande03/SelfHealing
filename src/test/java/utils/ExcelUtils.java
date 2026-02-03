package test.java.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
    /**
     * Reads data from an Excel sheet and returns it as an Iterator of Object arrays.
     * Each Object array represents a row of data.
     *
     * @param filePath the path to the Excel file
     * @param sheetName the sheet name to read data from
     * @return Iterator of Object[] containing the data rows
     * @throws IOException if file reading fails
     */
    public static Iterator<Object[]> getSheetData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rows = sheet.iterator();
        if (rows.hasNext()) {
            rows.next(); // skip header row
        }
        List<Object[]> data = new ArrayList<>();
        while (rows.hasNext()) {
            Row row = rows.next();
            int cellCount = row.getLastCellNum();
            Object[] rowData = new Object[cellCount];
            for (int i = 0; i < cellCount; i++) {
                Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                switch (cell.getCellType()) {
                    case STRING:
                        rowData[i] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            rowData[i] = cell.getDateCellValue();
                        } else {
                            rowData[i] = String.valueOf((int) cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        rowData[i] = cell.getBooleanCellValue();
                        break;
                    case FORMULA:
                        rowData[i] = cell.getCellFormula();
                        break;
                    case BLANK:
                        rowData[i] = "";
                        break;
                    default:
                        rowData[i] = "";
                }
            }
            data.add(rowData);
        }
        workbook.close();
        fis.close();
        return data.iterator();
    }
}