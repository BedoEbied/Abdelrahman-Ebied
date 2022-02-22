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
import utilities.ReadExcelData;

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

    @BeforeTest(alwaysRun = true)
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
        ReadExcelData readExcelData = new ReadExcelData();
        return readExcelData.readSheet();

    }
}
