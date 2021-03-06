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

    public static List<String> parseEmailsFromTable(WebDriver driver) throws InterruptedException {
        List<String> result = new LinkedList<>();
        Thread.sleep(1000);
        while (true) {
            for (int i = 1; i <= driver.findElements(By.cssSelector("table tbody tr")).size(); i++) {
                if(!result.contains(driver.findElement(By.cssSelector("tbody tr:nth-child(" + i + ") td:nth-child(2)")).getText()))
                result.add(driver.findElement(By.cssSelector("tbody tr:nth-child(" + i + ") td:nth-child(2)")).getText());
            }

            if (driver.findElements(By.id("nextPage")).size() > 0) {
                Thread.sleep(1000);
                driver.findElement(By.id("nextPage")).click();
                Thread.sleep(1000);
            }
            else break;
        }

        return result;

    }



    public static List<String> getAllEmailsFromDatabase(){
        TestDAO testDAO = new TestDAO();
        return testDAO.getUsersEmailsFromDatabase();
    }

}
