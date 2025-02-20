package QACourseSite.Pages.AQAPractice;

import QACourseSite.Pages.SignIn.SignIn;
import constants.URL;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPractice {

    private WebDriver driver;
    private WebDriverWait wait;

    public DragAndDropPractice(WebDriver driver) {
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

    @FindBy(xpath = "//div[normalize-space()='Drag & Drop']")
    private static WebElement DragAndDropOption;

    @FindBy(id = "manual1")
    private static WebElement WriteTestCasesDraggableElement;

    @FindBy(id = "manual2")
    private static WebElement TestingRequirementsDraggableElement;

    @FindBy(id = "auto1")
    private static WebElement WriteAutomationScriptsDraggableElement;

    @FindBy(id = "auto2")
    private static WebElement FrameworkSetUpDraggableElement;

    @FindBy(id = "target-manual1")
    private static WebElement ManualWorkSectionOne;

    @FindBy(id = "target-manual2")
    private static WebElement ManualWorkSectionTwo;

    @FindBy(id = "target-auto1")
    private static WebElement AutomationWorkSectionOne;

    @FindBy(id = "target-auto2")
    private static WebElement AutomationWorkSectionTwo;

    @FindBy(xpath = "//button[@id='DragNDropPageFinishButton']")
    private static WebElement FinishButton;

    @FindBy(xpath = "//div[@class='text-lg flex absolute -top-10 right-0 px-10 py-8 shadow-custom transition-opacity duration-500 opacity-100']")
    private static WebElement CongratulationTextField;

    @FindBy (xpath = "//img[@alt='Logo']")
    private static WebElement Logo;

    @Step("openMainPage")
    public DragAndDropPractice openMainPage(){
        driver.get(URL.QACOURSE.getUrl());
        Email.sendKeys("user1@user.user");
        Password.sendKeys("password");
        SignIn.click();
        return this;
    }

    @Step("openAQAPracticeSelector")
    public DragAndDropPractice openAQAPracticeSelector(){
        wait.until(ExpectedConditions.visibilityOf(AQAPracticeSelector));
        new Actions(driver).moveToElement(AQAPracticeSelector).perform();
        return this;
    }

    @Step("openSelectPracticePage")
    public DragAndDropPractice openDragAndDropPracticePage(){
        wait.until(ExpectedConditions.visibilityOf(DragAndDropOption));
        DragAndDropOption.click();
        return this;
    }

    @Step("dragAndDropWriteTestCasesBlock")
    public DragAndDropPractice dragAndDropWriteTestCasesBlock(){
        wait.until(ExpectedConditions.visibilityOf(WriteTestCasesDraggableElement));
        new Actions(driver).dragAndDrop(WriteTestCasesDraggableElement, ManualWorkSectionOne).perform();
        return this;
    }

    @Step("dragAndDropTestingRequirementsBlock")
    public DragAndDropPractice dragAndDropTestingRequirementsBlock(){
        wait.until(ExpectedConditions.visibilityOf(TestingRequirementsDraggableElement));
        new Actions(driver).dragAndDrop(TestingRequirementsDraggableElement, ManualWorkSectionTwo).perform();
        return this;
    }

    @Step("dragAndDropWriteAutomationScriptsBlock")
    public DragAndDropPractice dragAndDropWriteAutomationScriptsBlock(){
        wait.until(ExpectedConditions.visibilityOf(WriteAutomationScriptsDraggableElement));
        new Actions(driver).dragAndDrop(WriteAutomationScriptsDraggableElement, AutomationWorkSectionOne).perform();
        return this;
    }

    @Step("dragAndDropFrameworkSetUpBlock")
    public DragAndDropPractice dragAndDropFrameworkSetUpBlock(){
        wait.until(ExpectedConditions.visibilityOf(FrameworkSetUpDraggableElement));
        new Actions(driver).dragAndDrop(FrameworkSetUpDraggableElement, AutomationWorkSectionTwo).perform();
        return this;
    }

    @Step("finishButtonClick")
    public DragAndDropPractice finishButtonClick(){
        FinishButton.click();
        return this;
    }

    @Step ("presenceOfLogo")
    public boolean presenceOfLogo() {
        wait.until(ExpectedConditions.visibilityOf(Logo));
        return true;
    }




}
