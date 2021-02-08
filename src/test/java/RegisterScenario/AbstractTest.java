package RegisterScenario;

import PageObject.GeneralPage;
import common.CommonWait;
import common.GlobalContants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    protected GeneralPage generalPage;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public String RUN_ID, screenshotPath;
    public static Map<WebDriver, String> className = new HashMap<>();
    private static int failCount = 0;
    public static String homeURL;
    CommonWait wait;
    public synchronized static WebDriver getDriver() {
        return driver.get();
    }
    @BeforeTest
    @Parameters("browser")
    public void setUp(String BrowserName) {
        initBrowser(BrowserName);
        generalPage = new GeneralPage(getDriver());
    }
    @BeforeClass
    public void beforeClass() {
        try {
            RUN_ID = String.valueOf(System.currentTimeMillis());

        } catch (Exception e) {
        }
    }
    private void initBrowser(String BrowserName) {
            WebDriver localDriver = null;
            if (BrowserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                localDriver = new ChromeDriver();
            } else if (BrowserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                localDriver = new FirefoxDriver();
            }
            driver.set(localDriver);
            getDriver().manage().window().maximize();
            getDriver().get(GlobalContants.URL);

    }

}
