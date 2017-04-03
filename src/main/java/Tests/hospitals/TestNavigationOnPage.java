package Tests.hospitals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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

    public static void toFirstPage(WebDriver driver) {
        driver.get("https://localhost:8443/HospitalSeeker/admin/users?status=true&page=1&sort=email&asc=true");
    }

    public static void chooseRole(WebDriver driver, String role) throws InterruptedException {

        new Select(driver.findElement(By.id("pref-roleby"))).selectByVisibleText(role);
        driver.findElement(By.id("searchButton")).click();

    }

    public static void chooseCountOnPage(WebDriver driver, int count) {
        driver.findElement(By.id("userPerPage")).click();
        driver.findElement(By.cssSelector(".form-control option[value=\"" + count + "\"]")).click();
        driver.findElement(By.id("searchButton")).click();
    }

    public static void searchByEmail(WebDriver driver, String value) {
        new Select(driver.findElement(By.id("searchBy"))).selectByVisibleText("Email");
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys(value);
        driver.findElement(By.id("searchButton")).click();
    }

    public static void logOut(WebDriver driver) {

    }

}
