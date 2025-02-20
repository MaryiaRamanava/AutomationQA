package QACourseSiteTest;

import QACourseSite.Pages.AQAPractice.DragAndDropPractice;
import constants.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropPracticeTest {

    private static WebDriver driver;
    private static DragAndDropPractice dragAndDropPractice;
    static Actions action;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startDriver();
        dragAndDropPractice = new DragAndDropPractice(driver);
        action = new Actions(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    public void dragAndDropBlocks(){
        dragAndDropPractice.openMainPage()
                .openAQAPracticeSelector()
                .openDragAndDropPracticePage()
                .dragAndDropWriteTestCasesBlock()
                .dragAndDropWriteTestCasesBlock()
                .dragAndDropTestingRequirementsBlock()
                .dragAndDropFrameworkSetUpBlock()
                .dragAndDropWriteAutomationScriptsBlock()
                .finishButtonClick();
        Assert.assertTrue(dragAndDropPractice.presenceOfLogo());
    }
}
