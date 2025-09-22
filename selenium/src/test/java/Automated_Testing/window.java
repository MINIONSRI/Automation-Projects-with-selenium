package Automated_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class window {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("name")).sendKeys("9898");
        driver.findElement(By.xpath("(//button[@class=\"whButtons\"])[position()=1]")).click();
        Thread.sleep(2000);
        String mainWindow=driver.getWindowHandle();
        Set<String> allWindow=driver.getWindowHandles();
        for(String windowHandle:allWindow)
        {
            if(!windowHandle.equals(mainWindow))
            {
                driver.switchTo().window(windowHandle);
                driver.manage().window().maximize();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//input[@name=\"fName\"]")).sendKeys("foxcon");
                driver.findElement(By.xpath("(//input[@class=\"bcTextBox\"])[position()=2]")).sendKeys("swap");
                driver.findElement(By.xpath("//input[@id=\"englishchbx\"]")).click();
                driver.findElement(By.xpath("//input[@id=\"frenchchbx\"]")).click();
                driver.findElement(By.id("email")).sendKeys("sri@gmail.com");
                driver.findElement(By.id("password")).sendKeys("pop#123");
                driver.findElement(By.xpath("(//button[@class=\"bcButton\"])[1]")).click();
                String text=driver.findElement(By.xpath("//Label[@id=\"msg\"]")).getText();
                System.out.println(text);
            }
        }


    }
}
