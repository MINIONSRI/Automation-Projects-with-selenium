package base;

import config.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {

    protected static WebDriver driver;
    protected static PropertyReader config;

    @BeforeSuite
    public void launchBrowser() throws InterruptedException {

        config=new PropertyReader();

       PropertyReader.loadProperties("src/test/resources/ConfigDatas/config.properties");
       String browser=config.get("browser").toLowerCase();//chrome
        switch (browser) {
            case "chrome":
                // Set Chrome options
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-extensions");

                // Setup ChromeDriver
                WebDriverManager.chromedriver().setup(); // Or specify version if needed
                driver = new ChromeDriver(options);

                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.get("baseUrl"));
        Thread.sleep(2000);
    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}