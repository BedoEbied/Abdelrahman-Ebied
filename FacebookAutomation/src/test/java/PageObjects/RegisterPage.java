package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    //
    private final By CreateLocator = By.xpath("//*[text()='Create New Account']");

    private final By fNameFieldLocator = By.name("firstname");
    private final By lNameFieldLocator = By.name("lastname");
    private final By emailFieldLocator = By.name("reg_email__");
    private final By confirmEmailFieldLocator = By.name("reg_email_confirmation__");
    private final By passwordFieldLocator = By.name("reg_passwd__");
    private final By dateFieldLocator = By.name("birthday_year");
    private final By genderFieldLocator = By.name("sex");
    private final By signUpButtonLocator = By.name("websubmit");

    private final By accSettingLocator = (By.cssSelector("div[aria-label=\"Account\"]"));
    private final By logoutButtonLocator = (By.xpath("//*[text()='Log Out']"));

    private final int shortWait = 20;

    public RegisterPage(WebDriver _driver) {
        super(_driver);
    }

    public void clickCreate(){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(CreateLocator)).click();
    }

    public void insertfName(String fName){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(fNameFieldLocator)).clear();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(fNameFieldLocator)).sendKeys(fName);
    }
    public void insertlName(String lName){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(fNameFieldLocator)).clear();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(lNameFieldLocator)).sendKeys(lName);
    }
    public void insertEmail(String email){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(fNameFieldLocator)).clear();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(emailFieldLocator)).sendKeys(email);
    }
    public void insertConfirmEmail(String cEmail){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(fNameFieldLocator)).clear();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(confirmEmailFieldLocator)).sendKeys(cEmail);
    }

    public void insertPass(String pass){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(fNameFieldLocator)).clear();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(passwordFieldLocator)).sendKeys(pass);
    }
    public void clickDate(){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(dateFieldLocator)).click();
    }
    public void selectDate(int index){
        new Select(FindElement(dateFieldLocator)).selectByIndex(index);
    }
    public void clickGender(){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(genderFieldLocator)).click();
    }
    public void clickSignUp(){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(signUpButtonLocator)).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(FindElement(signUpButtonLocator)));

    }

    public void clickLogout(){
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(accSettingLocator)).click();
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(logoutButtonLocator)).click();
    }



}
