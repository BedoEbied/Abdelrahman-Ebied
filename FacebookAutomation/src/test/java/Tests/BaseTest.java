package Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class BaseTest
{
    public WebDriver driver;

    public WebDriver GetChromeDriver()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");

        return new ChromeDriver();
    }

    //Reading Data from Excel file
    public String[][]readSheet() throws IOException, InvalidFormatException {
        File myFile = new File("src/test/resources/loginData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(myFile);
        XSSFSheet mySheet = wb.getSheet("Sheet1");
        int numberOfRows = mySheet.getPhysicalNumberOfRows();
        int numberOfColumns = mySheet.getRow(0).getLastCellNum();
        String[][]myArray = new String[numberOfRows-1][numberOfColumns];
        for (int i =1; i<numberOfRows; i++){
            for (int j = 0; j < numberOfColumns; j++){
                XSSFRow row = mySheet.getRow(i);
                myArray[i-1][j] = row.getCell(j).getStringCellValue();
            }
        }
        return myArray;
    }

    @BeforeTest
    public void Setup() {
        driver = GetChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.facebook.com/";
        driver.get(url);
    }

    @AfterTest
    public void Teardown()
    {
        driver.close();
    }
    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException, InvalidFormatException {
        return readSheet();

    }
}
