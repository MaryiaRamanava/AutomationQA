package stepDefs;

import constants.URL;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StepDefinitionsClass {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (xpath = "//input[@placeholder='Enter email']")
    private static WebElement Email;

    @FindBy (xpath = "//input[@placeholder='Enter password']")
    private static WebElement Password;

    @FindBy (xpath = "//button[@type='submit']")
    private static WebElement SignInButton;

    @FindBy (xpath = "(//div[@class=\"mt-1.5 text-base leading-6 text-black\"])[2]")
    private static WebElement EmailText;

    @FindBy (xpath = "//span[@class='mt-3 block cursor-pointer hover:underline']")
    private static WebElement RegistrationButton;

    @FindBy(name = "firstName")
    private static WebElement FirstName;

    @FindBy(name = "lastName")
    private static WebElement LastName;

    @FindBy(name = "dateOfBirth")
    private static WebElement DateOfBirth;

    @FindBy(name = "passwordConfirmation")
    private static WebElement PasswordConfirmation;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement SubmitButton;

    @FindBy (xpath = "//img[@alt='logo']")
    private static WebElement Logo;

    @FindBy(xpath = "//div[contains(text(),'AQA Practice')]")
    private static WebElement AQAPracticeSelector;

    @FindBy(xpath = "//div[normalize-space()='Select']")
    private static WebElement SelectOption;

    @FindBy(xpath = "//select[@title='Select country']")
    private static WebElement SelectCountry;

    @FindBy(xpath = "//select[@title=\"Select type\"]")
    private static WebElement SelectType;

    @FindBy(name = "SelectPageSearchButton")
    private static WebElement SelectPageSearchButton;

    @FindBy(xpath = "//h2[@class=\"mb-[35px] text-[24px] leading-[28.13px]\"]")
    private static WebElement SearchResultText;

    @FindBy(xpath = "//h1[@class='mb-[35px] text-[56px] leading-[65.63px] font-thin']")
    private static WebElement ApplicationResultText;

    @FindBy(xpath = "//div[@class='p-10 bg-white flex cursor-pointer hover:bg-[#EFEFF0]']")
    private static WebElement CourseResult;

    @Given("Set up driver")
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        driver.get("https://qa-course-01.andersenlab.com/login");
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

    /// Test1

    @When("enter valid Email {string}")
    public void enterValidEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(Email));
        Email.sendKeys(email);
    }

    @When ("enter valid Password")
    public void enterValidPassword() {
        Password.sendKeys("password");
    }

    @And("click SignIn Button")
    public void clickSignInButton() {
        SignInButton.click();
    }

    @Then("I see Profile Page {string}")
    public void iSeeProfilePage(String email) {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(EmailText)).getText(), email);
    }

    ///Test2

    @When("open registration page")
    public void openRegistrationPage() {
        wait.until(ExpectedConditions.visibilityOf(RegistrationButton));
        RegistrationButton.click();
    }

    @And("enter First Name")
    public void enterFirstName() {
        wait.until(ExpectedConditions.visibilityOf(FirstName));
        FirstName.sendKeys("First Name");
    }

    @And("enter Last Name")
    public void enterLastName() {
        LastName.sendKeys("Last Name");
    }

    @And("enter Date of birth")
    public void enterDateOfBirth() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);
        DateOfBirth.sendKeys(formattedString);
    }

    @And("enter generated  Email")
    public void enterGeneratedEmail() {
        Email.click();
        String emailForReg = "user" + (int)(Math.random()*1234567890) +"@user.user";
        Email.sendKeys(emailForReg);
    }

    @And("enter Confirm password")
    public void enterConfirmPassword() {
        PasswordConfirmation.sendKeys("password");
    }

    @And("click Submit")
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
        SubmitButton.click();
    }

    @Then("I see Profile Page with Logo")
    public void iSeeProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(Logo));
    }

    /// Test3

    @When("sign in")
    public void signIn() {
        wait.until(ExpectedConditions.visibilityOf(Email));
        Email.sendKeys("user_1@user.user");
        Password.sendKeys("password");
        SignInButton.click();
    }

    @And("open AQAPractice")
    public void openAQAPractice() {
        wait.until(ExpectedConditions.visibilityOf(AQAPracticeSelector));
        new Actions(driver).moveToElement(AQAPracticeSelector).perform();
    }

    @And("open Select practice page")
    public void openSelectPracticePage() {
        wait.until(ExpectedConditions.visibilityOf(SelectOption));
        SelectOption.click();
    }

    @And("select country {string}")
    public void selectCountry(String country) {
        Select countrySelect = new Select(wait.until(ExpectedConditions.visibilityOf(SelectCountry)));
        countrySelect.selectByVisibleText(country);
    }

    @And("select type {string}")
    public void selectType(String type) {
        Select typeSelect = new Select(SelectType);
        typeSelect.selectByVisibleText(type);
    }

    @And("click search")
    public void clickSearch() {
        SelectPageSearchButton.click();
    }

    @And("choose course")
    public void chooseCourse() {
        wait.until(ExpectedConditions.visibilityOf(CourseResult));
        CourseResult.click();
    }

    @Then("get right result text")
    public void getRightResultText() {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(ApplicationResultText)).getText(),
                "Your application has been accepted!");
    }
}
