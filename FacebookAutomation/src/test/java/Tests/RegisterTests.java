package Tests;

import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest{

    RegisterPage registerPage;

    @Test
    public void goodSignUp(){
        registerPage = new RegisterPage(driver);

        registerPage.clickCreate();
        registerPage.insertfName("Sarsoora");
        registerPage.insertlName("ElAmmora");
        registerPage.insertEmail("Sarsooora@gmail.com");
        registerPage.insertConfirmEmail("Sarsooora@gmail.com");
        registerPage.insertPass("1234**Aa");
        registerPage.clickDate();
        registerPage.selectDate(20);
        registerPage.clickGender();
        registerPage.clickSignUp();

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        registerPage.clickLogout();

    }

    @Test
    public void smallPass(){
        registerPage = new RegisterPage(driver);

        registerPage.clickCreate();
        registerPage.insertfName("Sarsoora");
        registerPage.insertlName("ElAmmora");
        registerPage.insertEmail("zarsooora@gmail.com");
        registerPage.insertConfirmEmail("zarsooora@gmail.com");
        registerPage.insertPass("");
        registerPage.clickDate();
        registerPage.selectDate(20);
        registerPage.clickGender();
        registerPage.clickSignUp();

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
    }
    @Test
    public void badConfirmationEmail(){
        registerPage = new RegisterPage(driver);

        registerPage.clickCreate();
        registerPage.insertfName("Sarsoora");
        registerPage.insertlName("ElAmmora");
        registerPage.insertEmail("Sarsora@gmail.com");
        registerPage.insertConfirmEmail("aaa@gmail.com");
        registerPage.insertPass("1234**Aa");
        registerPage.clickDate();
        registerPage.selectDate(20);
        registerPage.clickGender();
        registerPage.clickSignUp();

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
    }

}
