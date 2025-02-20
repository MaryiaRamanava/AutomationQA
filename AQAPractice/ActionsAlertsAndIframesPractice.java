package QACourseSite.Pages.AQAPractice;

import constants.URL;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ActionsAlertsAndIframesPractice {

    private WebDriver driver;
    private WebDriverWait wait;

    public ActionsAlertsAndIframesPractice(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    private static WebElement Email;

    @FindBy(name = "password")
    private static WebElement Password;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement SignIn;

    @FindBy(xpath = "//div[contains(text(),'AQA Practice')]")
    private static WebElement AQAPracticeSelector;

    @FindBy(xpath = "//div[normalize-space()='Actions, Alerts & Iframes']")
    private static WebElement ActionsAlertsIframesOption;

    @FindBy(xpath = "//body/div[@id='root']/div[@class='bg-black flex flex-col min-h-screen']/div[@class='bg-slate-950']/div[@class='mx-auto w-full max-w-[1340px]']/main[@class='bg-zinc-50 px-[115px] pt-[100px] pb-[138px]']/section[1]")
    private static WebElement ConfirmButton;

    @FindBy(xpath = "//body/div[@id='root']/div[@class='bg-black flex flex-col min-h-screen']/div[@class='bg-slate-950']/div[@class='mx-auto w-full max-w-[1340px]']/main[@class='bg-zinc-50 px-[115px] pt-[100px] pb-[138px]']/section[1]")
    private static WebElement GetDiscountButton;

    @FindBy(xpath = "//button[@data-test-id=\"PromptButton\"]")
    private static WebElement CancelCourseButton;

    @FindBy(xpath = "//button[@class='h-[42px] w-[180px] bg-[#feda00] hover:bg-[#FEC600] self-end ActionsPageFinishButton flex items-center justify-center font-medium text-sm']")
    private static WebElement FinishButton;

    @FindBy(xpath = "//span[@class=\"font-light flex\"]")
    private static WebElement ResultText;

    @Step("openMainPage")
    public ActionsAlertsAndIframesPractice openMainPage(){
        driver.get(URL.QACOURSE.getUrl());
        Email.sendKeys("user1@user.user");
        Password.sendKeys("password");
        SignIn.click();
        return this;
    }

    @Step("openAQAPracticeSelector")
    public ActionsAlertsAndIframesPractice openAQAPracticeSelector(){
        wait.until(ExpectedConditions.visibilityOf(AQAPracticeSelector));
        new Actions(driver).moveToElement(AQAPracticeSelector).perform();
        return this;
    }

    @Step("openSelectPracticePage")
    public ActionsAlertsAndIframesPractice openDragAndDropPracticePage(){
        wait.until(ExpectedConditions.visibilityOf(ActionsAlertsIframesOption));
        ActionsAlertsIframesOption.click();
        return this;
    }

    @Step("confirmButton")
    public ActionsAlertsAndIframesPractice confirmButton(){
        wait.until(ExpectedConditions.visibilityOf(ConfirmButton));
        ConfirmButton.click();
        return this;
    }

    @Step("confirmButtonAlert")
    public ActionsAlertsAndIframesPractice confirmButtonAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "You have called alert!");
        driver.switchTo().alert().accept();
        return this;
    }

    @Step("GetResultText")
    public String getResultText(){
        return wait.until(ExpectedConditions.visibilityOf(ResultText)).getText();
    }

    @Step("getDiscountButton")
    public ActionsAlertsAndIframesPractice getDiscountButton(){
        wait.until(ExpectedConditions.visibilityOf(GetDiscountButton));
        new Actions(driver).doubleClick(GetDiscountButton).perform();
        return this;
    }

    @Step("getDiscountButtonAlert")
    public ActionsAlertsAndIframesPractice getDiscountButtonAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Are you sure you want to apply the discount?");
        driver.switchTo().alert().accept();
        return this;
    }

    @Step("getCancelCourseButton")
    public ActionsAlertsAndIframesPractice getCancelCourseButton(){
        wait.until(ExpectedConditions.visibilityOf(CancelCourseButton));
        new Actions(driver).contextClick(CancelCourseButton).perform();
        return this;
    }

    @Step("getCancelCourseButtonAlert")
    public ActionsAlertsAndIframesPractice getCancelCourseButtonAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Here you may describe a reason why you are cancelling your registration (or leave this field empty).");
        driver.switchTo().alert().accept();
        return this;
    }
}

