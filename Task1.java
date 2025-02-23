package lesson15;

import constants.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL.QACOURSE.getUrl());

        driver.findElement(By.name("email")).sendKeys("nonexistedemail@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.navigate().refresh();

        Thread.sleep(2000);

        driver.findElement(By.name("email")).sendKeys("emailemail@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//img[@alt=\"Edit\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("LastName");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);





        driver.quit();
    }
}
