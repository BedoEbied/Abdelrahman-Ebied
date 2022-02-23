package Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import utilities.ReadExcelData;

import java.io.IOException;

public class BaseTest {
    public static WebDriver driver;

    public WebDriver GetChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        return new ChromeDriver();
    }

    @BeforeTest
    public void Setup() {
        driver = GetChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.facebook.com/";
        driver.get(url);
    }

    @AfterTest
    public void Teardown() {
        driver.close();
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException, InvalidFormatException {
        ReadExcelData readExcelData = new ReadExcelData();
        return readExcelData.readSheet();

    }
}
