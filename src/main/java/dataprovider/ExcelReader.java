package dataprovider;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream file;
    static Workbook wb;
    static Sheet sheet;

    public static Object[][] readXlData(String filePath,String sheetName) {

        try {
            file = new FileInputStream(System.getProperty("user.dir")+filePath);
            wb = new XSSFWorkbook(file);
            sheet = wb.getSheet(sheetName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount-1][colCount];

        for (int i = 1 ; i < rowCount ; i++){
            for (int j = 0 ; j < colCount ; j++){
                Cell cell = sheet.getRow(i).getCell(j);
                data[i - 1][j] = (cell != null) ? cell.toString() : "";
            }
        }
        try {
            file.close();
            wb.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
