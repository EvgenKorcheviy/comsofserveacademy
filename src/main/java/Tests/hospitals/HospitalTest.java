package Tests.hospitals;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.fail;

/**
 * Created by Evgen on 29.03.2017.
 */
public class HospitalTest extends Tests.hospitals.BeforeTest {

    @Parameters({"url", "countOfUsers"})
    @Test
    private void isPopUpUsersPerPageFunctional(String url, String countOfUsers) {
        TestNavigationOnPage.toAdminPage(url, driver);

        int expected = new Integer(countOfUsers);
        if (testDAO.getCountOfUsers() < expected) expected = testDAO.getCountOfUsers();

        driver.findElement(By.id("userPerPage")).click();
        driver.findElement(By.cssSelector(".form-control option[value=\"" + expected + "\"]")).click();
        driver.findElement(By.id("searchButton")).click();
        int actual = new Integer(driver.findElement(By.cssSelector("table tbody tr:last-child td:first-child")).getText());
        assertEquals(actual, expected);
    }


    @Parameters("url")
    @Test
    public void isTableDataCorrect(String url) {
        List<String> actual  = Parser.parseEmailsFromTable(driver);
        List<String> expected = Parser.parseInfoFromDatabase();
        assertEquals(actual, expected);
    }



    /*
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
    }*/

}
