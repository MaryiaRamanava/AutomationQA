package QACourseSite.Pages.Registration;

import QACourseSite.Pages.SignIn.SignIn;
import constants.URL;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.files.DownloadActions.click;

public class Registration {
    static final Logger logger = LoggerFactory.getLogger(Registration.class);


    private WebDriver driver;
    private WebDriverWait wait;

    public Registration(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//span[@class='mt-3 block cursor-pointer hover:underline']")
    private static WebElement RegistrationButton;

    @FindBy(name = "firstName")
    private static WebElement FirstName;

    @FindBy(name = "lastName")
    private static WebElement LastName;

    @FindBy(name = "dateOfBirth")
    private static WebElement DateOfBirth;

    @FindBy(name = "email")
    private static WebElement Email;

    @FindBy(name = "password")
    private static WebElement Password;

    @FindBy(name = "passwordConfirmation")
    private static WebElement PasswordConfirmation;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement SubmitButton;

    @FindBy (xpath = "//img[@alt='logo']")
    private static WebElement Logo;

    @Step("openRegistrationPage")
    public Registration openRegistrationPage() {
        driver.get(URL.QACOURSE.getUrl());
        RegistrationButton.click();
        return this;
    }

    @Step("setFirstName")
    public Registration setFirstName() {
        logger.info("setting first name");
        FirstName.sendKeys("First Name");
        return this;
    }

    @Step("setLastName")
    public Registration setLastName() {
        logger.info("setting last name");
        LastName.sendKeys("Last Name");
        return this;
    }

    @Step("setDateOfBirth")
    public Registration setDateOfBirth() {
        logger.info("setting date of birth");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);
        DateOfBirth.sendKeys(formattedString);
        return this;
    }

    @Step("setEmail")
    public Registration setEmail() {
        logger.info("setting email");
        Email.click();
        String email = "user" + (int)(Math.random()*1234567890) +"@user.user";
        Email.sendKeys(email);
        System.out.println(email);
        return this;
    }

    @Step("setPassword")
    public Registration setPassword(){
        logger.info("setting password");
        Password.sendKeys("password");
        return this;
    }

    @Step("setPasswordConfirmation")
    public Registration setPasswordConfirmation(){
        logger.info("setting password confirmation");
        PasswordConfirmation.sendKeys("password");
        return this;
    }

    @Step("clickSubmitButton")
    public Registration clickSubmitButton(){
        logger.info("clicking submit button");
        wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
        SubmitButton.click();
        return this;
    }

    @Step ("presenceOfLogo")
    public boolean presenceOfLogo() {
        logger.info("checking presence of logo on main page");
        wait.until(ExpectedConditions.visibilityOf(Logo));
        return true;
    }

}
