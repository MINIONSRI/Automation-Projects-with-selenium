package Automated_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//
//          System.out.println("Automated Testing");
//          WebDriverManager.chromedriver().setup();
//          WebDriver driver = new ChromeDriver();
          driver.get("https://opensource-demo.orangehrmlive.com/");
//        driver.manage().window().fullscreen();
//        Thread.sleep(4000);
//        driver.manage().window().minimize();
//        Thread.sleep(4000);
          driver.manage().window().maximize();
          Thread.sleep(4000);
          String title=driver.getTitle();
          System.out.println(title);
          String expectedTitle="OrangeHRM";

          if (title.equals(expectedTitle))
          {
              System.out.println("Tilte checked Successfully");

          }
          else System.out.println("Invaild Title");


//       WebElement text=driver.findElement(By.name("username"));
//       text.sendKeys("Admin");
         driver.findElement(By.name("username")).sendKeys("Admin");
         driver.findElement(By.name("password")).sendKeys("admin123");
         WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class, 'orangehrm-login-button')]"));
         loginButton.click();
         Thread.sleep(3000);
         String current_url=driver.getCurrentUrl();
         System.out.println(current_url);
       /*  driver.navigate().to("https://www.amazon.com");
         driver.navigate().back();
         Thread.sleep(3000);
         driver.navigate().forward();
         Thread.sleep(3000);*/



         driver.close();
    }
}