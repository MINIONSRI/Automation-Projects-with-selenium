package Project_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class magento
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//li[@class=\"authorization-link\"])[position()=1]/a")).click();
        driver.findElement(By.xpath("//input[@name=\"login[username]\"]")).sendKeys("minionsri@gmail.com");
        driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("minionsri@123");
        driver.findElement(By.xpath("//button[@class=\"action login primary\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class=\"action showcart\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id=\"top-cart-btn-checkout\"]")).click();
        Thread.sleep(3000);
        WebElement io=driver.findElement(By.xpath("//button[@class=\"action action-show-popup\"]"));
        io.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("tony pvt");
        driver.findElement(By.xpath("//input[@name=\"street[0]\"]")).sendKeys("25");
        driver.findElement(By.xpath("//input[@name=\"street[1]\"]")).sendKeys("demo st");
        driver.findElement(By.xpath("//input[@name=\"street[2]\"]")).sendKeys("finland");
        driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys("oralando");
        driver.findElement(By.xpath("//input[@name=\"postcode\"]")).sendKeys("632203");
        WebElement ele=driver.findElement(By.xpath("//select[@name=\"country_id\"]"));
        Select sc=new Select(ele);
        sc.selectByVisibleText("India");

        WebElement st= driver.findElement(By.xpath("//select[@name=\"region_id\"]"));
        Select s=new Select(st);
        s.selectByVisibleText("Tamil Nadu");

        driver.findElement(By.xpath("//input[@name=\"telephone\"]")).sendKeys("8798745461");




    }
}
