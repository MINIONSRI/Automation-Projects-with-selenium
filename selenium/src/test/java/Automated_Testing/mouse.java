package Automated_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class mouse {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //airindia web
//        driver.get("https://www.airindia.com/");
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        WebElement els=driver.findElement(By.xpath("//a[@id=\"headernav1\"]"));
//        Actions action=new Actions(driver);
//        action.moveToElement(els).build().perform();
//        els.click();
//        WebElement e= driver.findElement(By.id("header1menu0link1"));
//        action.moveToElement(e).build().perform();
//        e.click();

        //magento web
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
//       WebElement ad= driver.findElement(By.xpath("(//button[@type=\"submit\"])[position()=2]"));
       WebElement a= driver.findElement(By.xpath("(//div[@class=\"product-item-info\"])[position()=1]"));
       Actions action =new Actions(driver);
       action.moveToElement(a).build().perform();
       WebElement ad= driver.findElement(By.xpath("(//button[@type=\"submit\"])[position()=2]"));
       action.moveToElement(ad).build().perform();
       ad.click();

       driver.findElement(By.xpath("(//div[@class=\"swatch-option text\"])[position()=4]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("(//div[@class=\"swatch-option color\"])[position()=1]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[@id=\"product-addtocart-button\"]")).click();




    }
}
