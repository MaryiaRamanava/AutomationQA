package lesson16.dataProvider;

import constants.DriverSetUp;
import constants.URL;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class dataProviderTest {

    @DataProvider
    public static Object[][] loginData() {
        return new Object[][]{ {"user_1@user.user", "password"}, {"user_2@user.user", "password"}, {"user_3@user.user", "password"}};
    }

    @Test(dataProvider = "loginData")
    public void LoginTest(String email, String passwd){
        WebDriver driver = DriverSetUp.driverInit();
        driver.get(URL.QACOURSE.getUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"my-auto\"]")));
        driver.quit();
    }
}
