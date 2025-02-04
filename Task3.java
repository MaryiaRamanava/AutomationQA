package lesson15;

import constants.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL.ZOO.getUrl());
        WebElement PJMIcon = driver.findElement(By.xpath("//img[@alt=\"PJM\"]"));
        WebElement facebookIcon = driver.findElement(By.xpath("//img[@alt=\"Facebook\"]"));
        webElements(PJMIcon, facebookIcon);

        driver.quit();
    }

    public static void webElements(WebElement firstElement, WebElement secondElement) {
        int firstElementX = firstElement.getLocation().getX();
        int secondElementX = secondElement.getLocation().getX();
        int firstElementY = firstElement.getLocation().getY();
        int secondElementY = secondElement.getLocation().getY();

        if (firstElementY<secondElementY){
            System.out.println("Height " + firstElement.getAccessibleName() + " " + firstElementX);
        }
        else if (firstElementY>secondElementY) {
            System.out.println(("Height " + secondElement.getAccessibleName() + " " + firstElementY));
        }
        else {
            System.out.println("Height " + "Equal");
        }

        if (firstElementX<secondElementX){
            System.out.println("Left " + firstElement.getAccessibleName() + " " + firstElementX);
        }
        else if (firstElementX>secondElementY) {
            System.out.println(("Left " + secondElement.getAccessibleName() + " " + secondElementY));
        }
        else {
            System.out.println("Left " + "Equal");
        }

        int firstElementSize = firstElement.getSize().getHeight() * firstElement.getSize().getWidth();
        int secondElementSize = secondElement.getSize().getHeight() * secondElement.getSize().getWidth();

        if (firstElementSize>secondElementSize){
            System.out.println("Area " + firstElement.getAccessibleName() + " " + firstElementSize);
        }
        else if (firstElementSize<secondElementSize){
            System.out.println("Area " + secondElement.getAccessibleName() + " " + secondElementSize);
        }
        else {
            System.out.println("Area " + "Equal");
        }
    }
}