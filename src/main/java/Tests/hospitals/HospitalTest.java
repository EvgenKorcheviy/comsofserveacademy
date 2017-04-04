package Tests.hospitals;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.fail;

/**
 * Created by Evgen on 29.03.2017.
 */
public class HospitalTest extends Tests.hospitals.BeforeTest {

    private static final String USER_ROLE = "PATIENT";
    private static final String EMAIL = ".ua";



    @Parameters({"url", "countOfUsers"})
    @Test(priority = 1)
    private void TestPopUpUsersPerPage(String url, String countOfUsers) {
        TestNavigationOnPage.toAdminPage(url, driver);

        int expected = Integer.parseInt(countOfUsers);
        if (testDAO.getCountOfUsers() < expected) expected = testDAO.getCountOfUsers();

        TestNavigationOnPage.chooseCountOnPage(driver, expected);

        int actual = new Integer(driver.findElement(By.cssSelector("table tbody tr:last-child td:first-child")).getText());
        assertEquals(actual, expected);
    }


    @Test(priority = 2)
    public void TestTableDataCorrect() {
        try {
            Thread.sleep(1000);
            List<String> actual  = Parser.parseEmailsFromTable(driver);
            List<String> expected = Parser.getAllEmailsFromDatabase();
            assertEquals(actual, expected);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test(priority = 3)
    public void TestPopUpRole(){
        try {
            Thread.sleep(2000);

            List<String> expected = testDAO.getUsersByRoleFromDatabase(USER_ROLE);
            TestNavigationOnPage.toFirstPage(driver);
            TestNavigationOnPage.chooseRole(driver, USER_ROLE);
            List<String> actual = Parser.parseEmailsFromTable(driver);
            assertEquals(actual, expected);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void TestSearchByEmail() throws InterruptedException {

        Thread.sleep(2000);
        TestNavigationOnPage.toFirstPage(driver);
        List<String> actual;
        TestNavigationOnPage.searchByEmail(driver, EMAIL);
        actual = Parser.parseEmailsFromTable(driver);
        List<String> expected = testDAO.getUsersByEmailFromDatabase(EMAIL);
        assertEquals(actual, expected);
    }

    @Test(priority = 5)
    public void TestSearchByEmailAndRole() throws InterruptedException {
        Thread.sleep(2000);
        TestNavigationOnPage.toFirstPage(driver);
        List<String> actual;
        TestNavigationOnPage.searchByEmailAndRole(driver, EMAIL, USER_ROLE);
        actual = Parser.parseEmailsFromTable(driver);
        List<String> expected = testDAO.getUsersByEmailAndRoleFromDatabase(EMAIL, USER_ROLE);
        assertEquals(actual, expected);
    }

    @Test(priority = 6)
    public void TestView() throws InterruptedException {
        Thread.sleep(2000);
        TestNavigationOnPage.toFirstPage(driver);

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
