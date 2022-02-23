package Tests;

import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {

    RegisterPage registerPage;


    @BeforeClass
    public void CreateBtnClick(){
        registerPage = new RegisterPage(driver);
        registerPage.clickCreate();
    }

    @Test
    public void goodSignUp() {
        registerPage = new RegisterPage(driver);

        registerPage.insertfName("Sarsoora");
        registerPage.insertlName("ElAmmora");
        registerPage.insertEmail("Sarsooora@gmail.com");
        registerPage.insertConfirmEmail("Sarsooora@gmail.com");
        registerPage.insertPass("1234**Aa");
        registerPage.clickDate();
        registerPage.selectDate(20);
        registerPage.clickGender();
        registerPage.clickSignUp();

        Assert.assertTrue(registerPage.signupDone());
        registerPage.clickLogout();
        registerPage.clickCreate();

    }

    @Test
    public void smallPass() {
        registerPage = new RegisterPage(driver);

        registerPage.insertfName("Sarsoora");
        registerPage.insertlName("ElAmmora");
        registerPage.insertEmail("zarsooora@gmail.com");
        registerPage.insertConfirmEmail("zarsooora@gmail.com");
        registerPage.insertPass("123");
        registerPage.clickDate();
        registerPage.selectDate(20);
        registerPage.clickGender();
        registerPage.clickSignUp();

        Assert.assertTrue(registerPage.passError());

//        String passErr = registerPage.getExpectedText();
//        Assert.assertEquals(passErr,"Your password must be at least 6 characters long. Please try another.");
    }

    @Test
    public void badConfirmationEmail() {
        registerPage = new RegisterPage(driver);

        registerPage.insertfName("Sarsoora");
        registerPage.insertlName("ElAmmora");
        registerPage.insertEmail("Sarsora@gmail.com");
        registerPage.insertConfirmEmail("aaa@gmail.com");
        registerPage.insertPass("1234**Aa");
        registerPage.clickDate();
        registerPage.selectDate(20);
        registerPage.clickGender();
        registerPage.clickSignUp();

        Assert.assertTrue(registerPage.confirmError());
    }

}
