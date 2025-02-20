package QACourseSiteTest;

import QACourseSite.Pages.Registration.Registration;
import QACourseSite.Pages.SignIn.SignIn;
import constants.DriverSetUp;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {

    private static WebDriver driver;
    private static Registration registration;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startDriver();
        registration = new Registration(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    public void positiveRegistration(){
        registration.openRegistrationPage()
                .setFirstName()
                .setLastName()
                .setDateOfBirth()
                .setEmail()
                .setPassword()
                .setPasswordConfirmation()
                .clickSubmitButton();
        Assert.assertTrue(registration.presenceOfLogo());
    }

}
