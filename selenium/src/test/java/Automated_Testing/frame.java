package Automated_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
            // 1. Open site and login
            driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            WebElement frame2=driver.findElement(By.id("frm2"));
            driver.switchTo().frame(frame2);
            driver.findElement(By.xpath("//input[@name=\"fName\"]")).sendKeys("foxcon");
            driver.findElement(By.xpath("(//input[@class=\"bcTextBox\"])[position()=2]")).sendKeys("swap");
            driver.findElement(By.xpath("//input[@id=\"englishchbx\"]")).click();
            driver.findElement(By.xpath("//input[@id=\"frenchchbx\"]")).click();
            driver.findElement(By.id("email")).sendKeys("sri@gmail.com");
            driver.findElement(By.id("password")).sendKeys("pop#123");
            driver.switchTo().defaultContent();
            WebElement frame3=driver.findElement(By.id("frm3"));
            driver.switchTo().frame(frame3);
            WebElement f2= driver.findElement(By.id("frm2"));
            driver.switchTo().frame(f2);
            driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Zogo");
            driver.findElement(By.xpath("(//input[@class=\"bcTextBox\"])[position()=2]")).sendKeys("login");
            driver.close();

    }
}
