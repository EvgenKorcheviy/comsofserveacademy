package Tests.hospitals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by Evgen on 30.03.2017.
 */
public class BeforeTest {
    protected static WebDriver driver;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected TestDAO testDAO;

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
}
