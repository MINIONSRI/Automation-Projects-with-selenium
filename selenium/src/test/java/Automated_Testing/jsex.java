package Automated_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class jsex {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='standard_user';",driver.findElement(By.id("user-name")));
        js.executeScript("arguments[0].value='secret_sauce';",driver.findElement(By.id("password")));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='login-button']")));
        js.executeScript("arguments[0].print();",driver.getTitle());
    }
}
