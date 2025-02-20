package QACourseSiteTest;

import QACourseSite.Pages.SignIn.SignIn;
import constants.DriverSetUp;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SignInTest {
    private static WebDriver driver;
    private static SignIn signIn;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startDriver();
        signIn = new SignIn(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    public void positiveSignIn() {
        String email = "user_1@user.user";
        signIn.openSignInPage()
                .setEmail(email)
                .setPassword("password")
                .clickSignIn();
        Assert.assertEquals(signIn.getTextFromHeader(), email);
    }

    @Test
    public void negativeSignInWithInvalidPassword() {
        signIn.openSignInPage()
                .setEmail("user_1@user.user")
                .setPassword("passworddddd")
                .clickSignIn();
        Assert.assertEquals(signIn.getFailedMessage(), "Email or password is not valid");
    }

    @Test
    public void negativeSignInWithInvalidEmailForm() {
        signIn.openSignInPage()
                .setEmail("useruseruser")
                .setPassword("password")
                .clickSignIn();
        Assert.assertEquals(signIn.getInvalidEmailTextMessage(), "Invalid email address");
    }

    @Test
    public void negativeSignInWithShortPassword() {
        signIn.openSignInPage()
                .setEmail("user_1@user.user")
                .setPassword("pass")
                .clickSignIn();
        Assert.assertEquals(signIn.getShortPasswordMessage(), "Minimum 8 characters");
    }
}
