package Automated_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.menu;

public class Task_2 {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\xxx\\chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class, 'orangehrm-login-button')]"));
        loginButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a")).click();
        WebElement dropdown=driver.findElement(By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[position()=1]"));
        WebElement sel=driver.findElement(By.xpath("//div[text()=\"Indian\"]"));
        Actions action=new Actions(driver);
        action.moveToElement(dropdown).build().perform();
        Thread.sleep(2000);
        dropdown.click();
        Thread.sleep(2000);
        action.scrollToElement(sel).build().perform();
        Thread.sleep(2000);
        sel.click();
        Thread.sleep(2000);


    }
}
