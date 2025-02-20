package QACourseSite.Pages.AQAPractice;

import constants.URL;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class SelectPractice {

    private WebDriver driver;
    private WebDriverWait wait;

    public SelectPractice(WebDriver driver) {
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

    @FindBy(xpath = "//div[normalize-space()='Select']")
    private static WebElement SelectOption;

    @FindBy(xpath = "//h1[@class='mb-[35px] text-[56px] leading-[65.63px] font-thin']")
    private static WebElement ChooseYourCourseText;

    @FindBy(xpath = "//select[@title='Select country']")
    private static WebElement SelectCountry;

    @FindBy(id = "SelectLanguage")
    private static WebElement SelectLanguage;

    @FindBy(xpath = "//select[@title=\"Select type\"]")
    private static WebElement SelectType;

    @FindBy(id = "MultipleSelect")
    private static WebElement SelectCourses;

    @FindBy(name = "SelectPageSearchButton")
    private static WebElement SelectPageSearchButton;

    @FindBy(xpath = "//input[@title='Start date']")
    private static WebElement StartDateCalendar;

    @FindBy(xpath = "//input[@title='End date']")
    private static WebElement EndDateCalendar;

    @FindBy(xpath = "//h2[@class=\"mb-[35px] text-[24px] leading-[28.13px]\"]")
    private static WebElement SearchResultText;

    @FindBy(xpath = "//h1[@class='mb-[35px] text-[56px] leading-[65.63px] font-thin']")
    private static WebElement ApplicationResultText;

    @FindBy(xpath = "//div[normalize-space()='AQA Java']")
    private static WebElement AQAJavaTestingCourse;


    public enum Country {
        Italy, Hungary, China, Belarus, USA, UnitedKingdom, Netherlands, Brazil, Australia, Germany, Canada, SouthKorea, Spain, Georgia, India, France, Poland, Japan
    }

    public enum Language {
        Dutch, Spanish, Japanese, French, Korean, Russian, German, Italian, Chinese, Portuguese, English
    }

    public enum Type {
        Media, Design, PerformanceTesting, Testing, Marketing, DataAnalytics, Programming
    }


    @Step("openMainPage")
    public SelectPractice openMainPage(){
        driver.get(URL.QACOURSE.getUrl());
        Email.sendKeys("user1@user.user");
        Password.sendKeys("password");
        SignIn.click();
        return this;
    }

    @Step("openAQAPracticeSelector")
    public SelectPractice openAQAPracticeSelector(){
        wait.until(ExpectedConditions.visibilityOf(AQAPracticeSelector));
        new Actions(driver).moveToElement(AQAPracticeSelector).perform();
        return this;
    }

    @Step("openSelectPracticePage")
    public SelectPractice openSelectPracticePage(){
        wait.until(ExpectedConditions.visibilityOf(SelectOption));
        SelectOption.click();
        return this;
    }

    @Step("selectCountry")
    public SelectPractice selectCountry(Country country){
        Select countrySelect = new Select(wait.until(ExpectedConditions.visibilityOf(SelectCountry)));
        countrySelect.selectByVisibleText(country.toString());
        return this;
    }

    @Step("SelectLanguage")
    public SelectPractice selectLanguage(Language language){
        Select languageSelect = new Select(SelectLanguage);
        languageSelect.selectByVisibleText(language.toString());
        return this;
    }

    @Step("SelectType")
    public SelectPractice selectType(Type type){
        Select typeSelect = new Select(SelectType);
        typeSelect.selectByVisibleText(type.toString());
        return this;
    }

    @Step("SelectCourses")
    public SelectPractice selectCourses(){
        Select coursesSelect = new Select(SelectCourses);
        coursesSelect.selectByValue("AQA Java");
        coursesSelect.selectByValue("AQA Python");
        return this;
    }

    @Step("StartDateCalendar")
    public SelectPractice startDateCalendar(String startDay, String startMonth, String startYear){
        StartDateCalendar.click();
        new Actions(driver).keyDown(StartDateCalendar, Keys.ARROW_LEFT)
                .keyUp(Keys.ARROW_LEFT)
                .keyDown(Keys.ARROW_LEFT)
                .keyUp(Keys.ARROW_LEFT)
                .sendKeys(startDay)
                .sendKeys(startMonth)
                .sendKeys(startYear)
                .build().perform();
        return this;
    }

    @Step("EndDateCalendar")
    public SelectPractice endDateCalendar(String endDay, String endMonth, String endYear){
        EndDateCalendar.click();
        new Actions(driver).keyDown(EndDateCalendar, Keys.ARROW_LEFT)
                .keyUp(Keys.ARROW_LEFT)
                .keyDown(Keys.ARROW_LEFT)
                .keyUp(Keys.ARROW_LEFT)
                .sendKeys(endDay)
                .sendKeys(endMonth)
                .sendKeys(endYear)
                .build().perform();
        return this;
    }

    @Step("SearchCourses")
    public SelectPractice searchCourses(){
        SelectPageSearchButton.click();
        return this;
    }

    @Step("GetSearchResultText")
    public String getSearchResultText(){
        return wait.until(ExpectedConditions.visibilityOf(SearchResultText)).getText();
    }

    @Step("GetAQAJavaTestingCourse")
    public SelectPractice selectAQAJavaTestingCourse(){
        wait.until(ExpectedConditions.visibilityOf(AQAJavaTestingCourse));
        AQAJavaTestingCourse.click();
        return this;
    }

    @Step("GetApplicationResultText")
    public String getApplicationResultText(){
        return wait.until(ExpectedConditions.visibilityOf(ApplicationResultText)).getText();
    }
}
