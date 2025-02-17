package lesson17;

import constants.DriverSetUp;
import constants.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lesson17Test {

    public static class Locators {
        private static final By Email = By.name("email");
        private static final By Password = By.name("password");
        private static final By SignIn = By.xpath("//button[@type=\"submit\"]");
        private static final By AQAPracticeSelector = By.xpath("//div[contains(text(),'AQA Practice')]");
        private static final By SelectOption = By.cssSelector("div[class='flex flex-col text-sm text-black bg-white shadow-custom absolute mt-12 cursor-pointer'] div:nth-child(1)");
        private static final By ChooseYourCourseText = By.xpath("//h1[@class='mb-[35px] text-[56px] leading-[65.63px] font-thin']");
        private static final By SelectCountry = By.xpath("//select[@title='Select country']");
        private static final By SelectLanguage = By.id("SelectLanguage");
        private static final By SelectType = By.xpath("//select[@title=\"Select type\"]");
        private static final By SelectCourses = By.id("MultipleSelect");
        private static final By SelectPageSearchButton = By.name("SelectPageSearchButton");
        private static final By DragAndDropOption = By.xpath("//div[normalize-space()='Drag & Drop']");
        private static final By WriteTestCasesDraggableElement = By.id("manual1");
        private static final By TestingRequirementsDraggableElement = By.id("manual2");
        private static final By WriteAutomationScriptsDraggableElement = By.id("auto1");
        private static final By FrameworkSetUpDraggableElement = By.id("auto2");
        private static final By ManualWorkSectionOne = By.id("target-manual1");
        private static final By ManualWorkSectionTwo = By.id("target-manual2");
        private static final By AutomationWorkSectionOne = By.id("target-auto1");
        private static final By AutomationWorkSectionTwo = By.id("target-auto2");
        private static final By CongratulationTextField = By.xpath("//div[@class='text-lg flex absolute -top-10 right-0 px-10 py-8 shadow-custom transition-opacity duration-500 opacity-100']");
        private static final By ActionsAlertsIframesOption = By.xpath("//div[normalize-space()='Actions, Alerts & Iframes']");
        private static final By ConfirmButton = By.xpath("//body/div[@id='root']/div[@class='bg-black flex flex-col min-h-screen']/div[@class='bg-slate-950']/div[@class='mx-auto w-full max-w-[1340px]']/main[@class='bg-zinc-50 px-[115px] pt-[100px] pb-[138px]']/section[1]");
        private static final By GetDiscountButton = By.xpath("//body/div[@id='root']/div[@class='bg-black flex flex-col min-h-screen']/div[@class='bg-slate-950']/div[@class='mx-auto w-full max-w-[1340px]']/main[@class='bg-zinc-50 px-[115px] pt-[100px] pb-[138px]']/section[1]");
        private static final By CancelCourseButton = By.xpath("//button[@data-test-id=\"PromptButton\"]");
        private static final By StartDateCalendar = By.xpath("//input[@title='Start date']");
        private static final By EndDateCalendar = By.xpath("//input[@title='End date']");
        private static final By SearchResultText = By.xpath("//h2[@class='mb-[35px] text-[24px] leading-[28.13px]']");
        private static final By ResultText = By.xpath("//span[@class=\"font-light flex\"]");

    }

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeMethod
    public void driverInit() {
        driver = DriverSetUp.driverInitFireFox();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void SignIn(){
        driver.get(URL.QACOURSE.getUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Email));
        actions.sendKeys((driver.findElement(Locators.Email)), "user_1@user.user")
                .sendKeys((driver.findElement(Locators.Password)), "password")
                .click(driver.findElement(Locators.SignIn))
                .build().perform();
    }

    @Test
    public void SelectTest() throws InterruptedException {
        SignIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.AQAPracticeSelector));
        actions.moveToElement(driver.findElement(Locators.AQAPracticeSelector)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SelectOption));
        actions.click(driver.findElement(Locators.SelectOption)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ChooseYourCourseText));
        actions.click(driver.findElement(Locators.SelectCountry)).perform();
        Select countrySelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SelectCountry)));
        countrySelect.selectByVisibleText("USA");
        Select languageSelect = new Select(driver.findElement(Locators.SelectLanguage));
        languageSelect.selectByVisibleText("English");
        Select typeSelect = new Select(driver.findElement(Locators.SelectType));
        typeSelect.selectByVisibleText("Testing");
        Select coursesSelect = new Select((driver.findElement(Locators.SelectCourses)));
        coursesSelect.selectByValue("AQA Java");
        coursesSelect.selectByValue("AQA Python");
        String startDay = "24"; String startMonth = "02"; String startYear = "2025";
        String endDay = "10"; String endMonth = "03"; String endYear = "2025";
        actions.click(driver.findElement(Locators.StartDateCalendar))
                .sendKeys(startDay+startMonth+startYear)
                .build().perform();
        actions.click(driver.findElement(Locators.EndDateCalendar))
                .sendKeys(endDay+endMonth+endYear)
                .build().perform();
        actions.click(driver.findElement(Locators.SelectPageSearchButton)).perform();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SearchResultText)).getText(), "Unfortunately, we did not find any courses matching your chosen criteria.");
}

    @Test
    public void DragAndDropTest() {
        SignIn();
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.AQAPracticeSelector))).perform();
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DragAndDropOption))).perform();
        actions.dragAndDrop(wait.until(ExpectedConditions.presenceOfElementLocated(Locators.WriteTestCasesDraggableElement)), driver.findElement(Locators.ManualWorkSectionOne))
                //повторное действие в Хроме
                //.dragAndDrop(driver.findElement(Locators.WriteTestCasesDraggableElement), driver.findElement(Locators.ManualWorkSectionOne))
                .dragAndDrop(driver.findElement(Locators.TestingRequirementsDraggableElement), driver.findElement(Locators.ManualWorkSectionTwo))
                .dragAndDrop(driver.findElement(Locators.WriteAutomationScriptsDraggableElement), driver.findElement(Locators.AutomationWorkSectionOne))
                .dragAndDrop(driver.findElement(Locators.FrameworkSetUpDraggableElement), driver.findElement(Locators.AutomationWorkSectionTwo))
                .build().perform();
        Assert.assertEquals(driver.findElement(Locators.CongratulationTextField).getText(), "Congratulations! Let's test for the best!");
    }

    @Test
    public void IFrameActionsAlertTest() throws InterruptedException {
        SignIn();
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.AQAPracticeSelector))).perform();
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ActionsAlertsIframesOption))).perform();
        ConfirmAction();
        GetDiscount();
        CancelCourse();
    }
    public void ConfirmAction(){
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ConfirmButton))).perform();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "You have called alert!");
        driver.switchTo().alert().accept();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ResultText)).getText(), "Congratulations, you have successfully enrolled in the course!");
    }

    public void GetDiscount(){
        actions.doubleClick(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GetDiscountButton))).perform();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Are you sure you want to apply the discount?");
        driver.switchTo().alert().accept();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ResultText)).getText(), "You received a 10% discount on the second course.");
    }

    public void CancelCourse(){
        actions.contextClick(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CancelCourseButton))).perform();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Here you may describe a reason why you are cancelling your registration (or leave this field empty).");
        String text = "Test";
        driver.switchTo().alert().sendKeys(text);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ResultText)).getText(), "Your course application has been cancelled. Reason:" + text);
    }
}

