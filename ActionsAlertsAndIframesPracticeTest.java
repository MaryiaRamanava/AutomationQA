package QACourseSiteTest;

import QACourseSite.Pages.AQAPractice.ActionsAlertsAndIframesPractice;
import constants.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsAlertsAndIframesPracticeTest {

    private static WebDriver driver;
    private static ActionsAlertsAndIframesPractice actionsAlertsAndIframesPractice;
    static Actions action;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startDriver();
        actionsAlertsAndIframesPractice = new ActionsAlertsAndIframesPractice(driver);
        action = new Actions(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    public static void confirmButtonTest(){
        actionsAlertsAndIframesPractice.openMainPage()
                .openAQAPracticeSelector()
                .openDragAndDropPracticePage()
                .confirmButton()
                .confirmButtonAlert();
        Assert.assertEquals(actionsAlertsAndIframesPractice.getResultText(), "Congratulations, you have successfully enrolled in the course!");
    }

    public static void getDiscountButtonTest(){
        actionsAlertsAndIframesPractice.openMainPage()
                .openAQAPracticeSelector()
                .openDragAndDropPracticePage()
                .getDiscountButton()
                .getDiscountButtonAlert();
        Assert.assertEquals(actionsAlertsAndIframesPractice.getResultText(), "You received a 10% discount on the second course.");
    }

    public static void getCancelCourseButtonTest(){
        actionsAlertsAndIframesPractice.openMainPage()
                .openAQAPracticeSelector()
                .openDragAndDropPracticePage()
                .getCancelCourseButton()
                .getCancelCourseButtonAlert();
        Assert.assertEquals(actionsAlertsAndIframesPractice.getResultText(), "Your course application has been cancelled. Reason: You did not notice any reason.");
    }
}
