package lesson16.parameters;

import constants.DriverSetUp;
import constants.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.swing.*;
import java.time.Duration;

public class parametersTest {

    private String login;

    @BeforeMethod

    @Test
    @Parameters({"email", "password"})
    public void LoginTest(String email, String password){
        WebDriver driver = DriverSetUp.driverInit();
        driver.get(URL.QACOURSE.getUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"my-auto\"]")));
        driver.quit();
    }
}
