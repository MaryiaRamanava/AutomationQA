package QACourseSiteTest;

import QACourseSite.Pages.AQAPractice.SelectPractice;
import constants.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectPracticeTest {

    private static WebDriver driver;
    private static SelectPractice selectPractice;
    static Actions action;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startDriver();
        selectPractice = new SelectPractice(driver);
        action = new Actions(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

   @Test
   public void testWithPositiveResult(){
       selectPractice.openMainPage()
               .openAQAPracticeSelector()
               .openSelectPracticePage()
               .selectLanguage(SelectPractice.Language.English)
               .selectType(SelectPractice.Type.Testing)
               .searchCourses()
               .selectAQAJavaTestingCourse();
       Assert.assertEquals(selectPractice.getApplicationResultText(), "Your application has been accepted!");
   }

    @Test
    public void testWithNegativeResult(){
        selectPractice.openMainPage()
                .openAQAPracticeSelector()
                .openSelectPracticePage()
                .selectCountry(SelectPractice.Country.USA)
                .selectLanguage(SelectPractice.Language.English)
                .selectType(SelectPractice.Type.Testing)
                .startDateCalendar("24", "02", "2025")
                .endDateCalendar("10", "03", "2025")
                .selectCourses()
                .searchCourses();
        Assert.assertEquals(selectPractice.getSearchResultText(), "Unfortunately, we did not find any courses matching your chosen criteria.");
    }
}
