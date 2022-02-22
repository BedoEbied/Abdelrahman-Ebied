package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
    protected WebDriver driver;

    private final int shortWait = 20;

    public BasePage(WebDriver _driver)
    {
        driver = _driver;
    }

    public void ClickElement(By locator)
    {
        new WebDriverWait(driver, shortWait).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement FindElement(By locator)
    {
        return new WebDriverWait(driver, shortWait).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}