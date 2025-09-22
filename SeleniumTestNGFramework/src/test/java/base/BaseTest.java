package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.ExtentManager;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    protected static PropertyReader config;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    // Static initializer (runs once per suite)
    static {
        config = new PropertyReader();
        config.loadProperties("src/test/resources/ConfigDatas/config.properties");
        extent = ExtentManager.getInstance();
    }

    public void launchBrowser() {
        String browser = config.get("browser");
        String baseUrl = config.get("baseUrl");

        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser not specified in config.properties");
        }
        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new RuntimeException("Base URL not specified in config.properties");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized", "--disable-gpu", "--no-sandbox", "--disable-extensions");

                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver(options);
                log.info("Launched Chrome browser");
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(baseUrl);
        log.info("Navigated to: {}", baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed");
        }
    }

    public void flushExtentReport() {
        if (extent != null) {
            extent.flush();
            log.info("Extent report flushed");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest testInstance) {
        test = testInstance;
    }
}
