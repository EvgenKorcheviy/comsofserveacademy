package Tests.hospitals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Evgen on 31.03.2017.
 */
public class Parser {

    public static List<String> parseEmailsFromTable(WebDriver driver){
        List<String> result = new LinkedList<>();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        while (true) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table tbody tr td")));
            for (int i = 1; i <= driver.findElements(By.cssSelector("table tbody tr")).size(); i++) {
                result.add(driver.findElement(By.cssSelector("tbody tr:nth-child(" + i + ") td:nth-child(2)")).getText());
            }

            if (driver.findElements(By.id("nextPage")).size() > 0) {
                driver.findElement(By.id("nextPage")).click();
            }
            else break;
        }

        return result;

    }

    public static List<String> parseInfoFromDatabase(){
        TestDAO testDAO = new TestDAO();
        return testDAO.getUsersEmailsFromDatabase();
    }
}
