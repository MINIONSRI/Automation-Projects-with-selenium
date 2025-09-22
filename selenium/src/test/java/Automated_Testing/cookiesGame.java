package Automated_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


public class cookiesGame  {
    public static void main(String[] args)    throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://mrbuilder1961.github.io/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()=\"English\"]")).click();
        Thread.sleep(3000);
        WebElement button = driver.findElement(By.xpath("//button[@id=\"bigCookie\"]"));
        for (int i = 1; i <= 18; i++) {
            button.click();
        }
        Thread.sleep(2000);
        WebElement cursor = driver.findElement(By.xpath("//div[@id=\"product0\"]"));
        cursor.click();
        Thread.sleep(2000);
        for (int i = 1; i <= 18; i++) {
            button.click();
        }
        Thread.sleep(2000);
        cursor.click();

    }

}
