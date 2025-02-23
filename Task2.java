package lesson15;

import constants.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(URL.AUTO_PRACTICE.getUrl());
        String autoWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get(URL.ZOO.getUrl());
        String zooWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get(URL.W3SCHOOL.getUrl());
        String w3schoolWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get(URL.CLICK_SPEED_TESTER.getUrl());
        String clickSpeedTesterWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get(URL.ANDERSENLAB.getUrl());
        String andersenlabWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);


        int n = 1;
        for(int i = 0; i <= n; i++){
            driver.switchTo().window(autoWindowHandle);
            System.out.println(driver.getTitle() + ", " + driver.getCurrentUrl());
            if (driver.getTitle().contains("Zoo")){
                driver.close();
            }

            driver.switchTo().window(zooWindowHandle);
            System.out.println(driver.getTitle() + ", " + driver.getCurrentUrl());
            if (driver.getTitle().contains("Zoo")){
                driver.quit();
            }

            driver.switchTo().window(w3schoolWindowHandle);
            System.out.println(driver.getTitle() + ", " + driver.getCurrentUrl());
            if (driver.getTitle().contains("Zoo")){
                driver.quit();
            }

            driver.switchTo().window(clickSpeedTesterWindowHandle);
            System.out.println(driver.getTitle() + ", " + driver.getCurrentUrl());
            if (driver.getTitle().contains("Zoo")){
                driver.close();
            }

            driver.switchTo().window(andersenlabWindowHandle);
            System.out.println(driver.getTitle() + ", " + driver.getCurrentUrl());
            if (driver.getTitle().contains("Zoo")){
                driver.quit();
            }
        }
    }
}
