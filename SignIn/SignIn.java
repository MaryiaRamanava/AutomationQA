package QACourseSite.Pages.SignIn;

import constants.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.qameta.allure.Step;

import java.time.Duration;

public class SignIn {

    static final Logger logger = LoggerFactory.getLogger(SignIn.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    private static WebElement Email;

    @FindBy (name = "password")
    private static WebElement Password;

    @FindBy (xpath = "//button[@type='submit']")
    private static WebElement SignInButton;

    @FindBy (xpath = "//span[@class=\"absolute right-0 text-rose-500 text-sm\"]")
    private static WebElement NotValidEmailOrPasswordText;

    /*@FindBy (xpath = "//div[contains(text(),'Sign Out')]")
    private static WebElement SignOutButton;*/

    @FindBy (xpath = "(//div[@class=\"mt-1.5 text-base leading-6 text-black\"])[2]")
    private static WebElement EmailText;

    @FindBy (xpath = "//span[@class=\"absolute right-0 text-rose-500 text-sm\"]")
    private static WebElement InvalidMessage;


    @Step("openSignInPage")
    public SignIn openSignInPage() {
        driver.get(URL.QACOURSE.getUrl());
        return this;
    }

    @Step("setEmail")
    public SignIn setEmail(String email){
        logger.info("setting up email");
        Email.sendKeys(email);
        return this;
    }

    @Step("setPassword")
    public SignIn setPassword(String password){
        logger.info("setting up password");
        Password.sendKeys(password);
        return this;
    }

    @Step("clickSignIn")
    public SignIn clickSignIn(){
        logger.info("clicking sign in");
        SignInButton.click();
        return this;
    }


    @Step("getFailedMessage")
    public String getFailedMessage() {
        return wait.until(ExpectedConditions.visibilityOf(NotValidEmailOrPasswordText)).getText();
    }

   /* @Step("clickSignOutButton")
    public SignIn clickSignOutButton(){
        logger.info("clicking sign out button");
        SignOutButton.click();
        return this;
    }*/

    @Step ("getTextFromHeader")
    public String getTextFromHeader() {
        logger.info("getting Andersen text from header");
        System.out.println(wait.until(ExpectedConditions.visibilityOf(EmailText)).getText());
        return EmailText.getText();
    }

    @Step("getInvalidEmailTextMessage")
    public String getInvalidEmailTextMessage(){
        return wait.until(ExpectedConditions.visibilityOf(InvalidMessage)).getText();
    }

    @Step("getShortPasswordMessage")
    public String getShortPasswordMessage(){
        return wait.until(ExpectedConditions.visibilityOf(InvalidMessage)).getText();
    }
}
