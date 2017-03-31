package Tests.hospitals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Evgen on 31.03.2017.
 */
public class TestNavigationOnPage {
    public static void toAdminPage(String url, WebDriver driver) {
        driver.get(url);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@hospitals.ua");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111");
        driver.findElement(By.id("loginSubmit")).click();

    }

}
