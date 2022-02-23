package Tests;

import PageObjects.BasePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;


    // Data Driven Login
    @Test(dataProvider = "testData")
    public void goodSignIn(String email, String pass) {
        loginPage = new LoginPage(driver);
        loginPage.insertEmail(email);
        loginPage.insertPass(pass);
        loginPage.clickLogin();
        Assert.assertFalse(driver.getPageSource().contains("\"Normal Login Pass\""));
        //Assert.assertEquals(driver.getTitle(), "Facebook");
        loginPage.clickLogout();
    }

    @Test
    public void badEmailPassword() {
        loginPage = new LoginPage(driver);
        loginPage.insertEmail("lgh;dsh;jdfgnb");
        loginPage.insertPass("AnyPassword");
        loginPage.clickLogin();
        //System.out.println(driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("Forgotten password"));

        //Assert.assertEquals(loginPage.getExpectedText(), "The email address or mobile number you entered isn't connected to an account. Find your account and log in.");
    }

    @Test
    public void emailBadPassword() {
        loginPage = new LoginPage(driver);
        loginPage.insertEmail("ebied_zmohyex_test@tfbnw.net");
        loginPage.insertPass("invalidPass");
        loginPage.clickLogin();
        Assert.assertTrue(driver.getPageSource().contains("Forgotten password"));

        //Assert.assertEquals(loginPage.getExpectedText(), "The password that you've entered is incorrect. Forgotten password?");
    }

}
