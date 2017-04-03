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

    @Parameters({"url", "countOfUsers"})
    @Test(priority = 1)
    private void isPopUpUsersPerPageFunctional(String url, String countOfUsers) {
        TestNavigationOnPage.toAdminPage(url, driver);

        int expected = new Integer(countOfUsers);
        if (testDAO.getCountOfUsers() < expected) expected = testDAO.getCountOfUsers();

        TestNavigationOnPage.chooseCountOnPage(driver, expected);

        int actual = new Integer(driver.findElement(By.cssSelector("table tbody tr:last-child td:first-child")).getText());
        assertEquals(actual, expected);
    }


    @Test(priority = 2)
    public void isTableDataCorrect() {
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
    public void isPopUpRoleFunctional(){
        try {
            Thread.sleep(2000);
            //List<String> expected = testDAO.getUsersByRoleFromDatabase("ADMIN");

            /*TestNavigationOnPage.toFirstPage(driver);
            TestNavigationOnPage.chooseRole(driver, "ADMIN");
            List<String> actual = Parser.parseEmailsFromTable(driver);
            assertEquals(actual, expected);*/

            Thread.sleep(2000);
            List<String> expected = testDAO.getUsersByRoleFromDatabase("PATIENT");
            TestNavigationOnPage.toFirstPage(driver);
            TestNavigationOnPage.chooseRole(driver, "PATIENT");
            List<String> actual = Parser.parseEmailsFromTable(driver);
            assertEquals(actual, expected);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
