package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private final By emailFieldLocator = By.id("email");
    private final By passwordFieldLocator = By.id("pass");
    private final By loginButtonLocator = By.xpath("//*[text()='Log In']");
    private final By accSettingLocator = (By.cssSelector("div[aria-label=\"Account\"]"));
    private final By logoutButtonLocator = (By.xpath("//*[text()='Log Out']"));
    private final By loginErrorMsg = (By.className("_9ay7"));

    private final int shortWait = 20;


    public LoginPage(WebDriver _driver) {
        super(_driver);
    }

    public void insertEmail(String email){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(emailFieldLocator)).clear();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(emailFieldLocator)).sendKeys(email);
    }
    public void insertPass(String pass){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(passwordFieldLocator)).clear();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(passwordFieldLocator)).sendKeys(pass);
    }
    public void clickLogin(){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(loginButtonLocator)).click();
    }
    public void clickLogout(){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(accSettingLocator)).click();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(logoutButtonLocator)).click();
    }

    public String getExpectedText() {

        new WebDriverWait(driver, shortWait).until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginErrorMsg));
        WebElement msg = driver.findElement(loginErrorMsg);
        return msg.getText();
    }
//    public String getUrl() {
//
//        new WebDriverWait(driver, shortWait).until(ExpectedConditions.);
//        WebElement msg = driver.findElement(loginErrorMsg);
//        return msg.getText();
//    }

}
