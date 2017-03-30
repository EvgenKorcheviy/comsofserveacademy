package Tests.hospitals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.fail;

/**
 * Created by Evgen on 29.03.2017.
 */
public class HospitalTest {


    private static WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private TestDAO testDAO;

    public static final String WEB_DRIVER_PROPERTY_TYPE_OF_DRIVER = "webdriver.gecko.driver";
    public static final String WEB_DRIVER_PROPERTY_PATH_TO_GECKODRIVER = "D:\\geckodriver.exe";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile ffProfile = profile.getProfile("default"); // firefox profile **
        ffProfile.setAcceptUntrustedCertificates(true);
        ffProfile.setAssumeUntrustedCertificateIssuer(false);
        System.setProperty(WEB_DRIVER_PROPERTY_TYPE_OF_DRIVER, WEB_DRIVER_PROPERTY_PATH_TO_GECKODRIVER);
        driver = new FirefoxDriver(ffProfile);
        baseUrl = "https://localhost:8443/";
        testDAO = new TestDAO();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

    @Test
    public void testShowUsersPopUp() throws Exception {
        driver.get(baseUrl + "HospitalSeeker/");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@hospitals.ua");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111");
        driver.findElement(By.id("loginSubmit")).click();

        isPopUpFunctional(10);
        isPopUpFunctional(15);
        isPopUpFunctional(20);
        isPopUpFunctional(30);
        isPopUpFunctional(40);
        isPopUpFunctional(50);
    }

    private void isPopUpFunctional(int number) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        int expected = 0;
        if (testDAO.getCountOfUsers() > number) expected = number;
        else expected = testDAO.getCountOfUsers();
        driver.findElement(By.id("userPerPage")).click();
        driver.findElement(By.cssSelector(".form-control option[value=\"" +number + "\"]")).click();
        driver.findElement(By.id("searchButton")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        int actual = new Integer(driver.findElement(By.cssSelector("table tbody tr:last-child td:first-child")).getText());
        assertEquals(actual, expected);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}
