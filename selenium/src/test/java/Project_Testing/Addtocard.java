package Project_Testing;

import Automated_Testing.screen;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addtocard extends screen  {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[text()=\"Add to cart\"])[position()=1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]")).click();

        WebElement LabsName=driver.findElement(By.xpath("//div[text()=\"Sauce Labs Backpack\"]"));
        System.out.println("Name:"+LabsName.getText());

        WebElement details=driver.findElement(By.xpath("(//div[@class=\"inventory_item_desc\"])[position()=1]"));
        System.out.println("Specification:"+details.getText());

        WebElement price=driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])[position()=1]"));
        System.out.println("price="+price.getText());

        WebElement labs= driver.findElement(By.xpath("//div[text()=\"Sauce Labs Bike Light\"]"));
        String name=labs.getText();
        System.out.println("Name:"+name);

        WebElement line= driver.findElement(By.xpath("(//div[@class=\"inventory_item_desc\"])[position()=2]"));
        String detail=line.getText();
        System.out.println("Specification:"+detail);

        WebElement prices= driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])[position()=2]"));
        String amount=prices.getText();
        System.out.println("price="+amount);


        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name=\"checkout\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("sridhar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("k");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys("631102");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();

        WebElement item= driver.findElement(By.xpath("//div[@class=\"summary_subtotal_label\"]"));
        System.out.println(item.getText());

        WebElement Tax= driver.findElement(By.xpath("//div[@class=\"summary_tax_label\"]"));
        System.out.println(Tax.getText());

        WebElement Total= driver.findElement(By.xpath("//div[@class=\"summary_total_label\"]"));
        System.out.println(Total.getText());

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id=\"finish\"]")).click();
        Thread.sleep(2000);

        takescreenshot(driver,"orderscrrenshot");

        WebElement Message= driver.findElement(By.xpath("//h2[@class=\"complete-header\"]"));
        String end= Message.getText();
        System.out.println("Sridhar:"+end);

        driver.findElement(By.xpath("//button[text()=\"Back Home\"]")).click();
        Thread.sleep(2000);

        driver.close();
    }
}

