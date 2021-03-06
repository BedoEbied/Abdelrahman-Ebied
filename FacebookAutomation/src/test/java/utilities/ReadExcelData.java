package utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadExcelData {

    //Reading Data from Excel file
    public String[][] readSheet() throws IOException, InvalidFormatException {
        File myFile = new File("src/test/resources/loginData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(myFile);
        XSSFSheet mySheet = wb.getSheet("Sheet1");
        int numberOfRows = mySheet.getPhysicalNumberOfRows();
        int numberOfColumns = mySheet.getRow(0).getLastCellNum();
        String[][] myArray = new String[numberOfRows - 1][numberOfColumns];
        for (int i = 1; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                XSSFRow row = mySheet.getRow(i);
                myArray[i - 1][j] = row.getCell(j).getStringCellValue();
            }
        }
        return myArray;
    }
}
