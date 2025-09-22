package Automated_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screen {
    public static void takescreenshot(WebDriver driver,String ScreenshotName){
        String timpstamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destfile=new File("./screenshot/"+ScreenshotName+"_"+timpstamp+".png");
        try
        {
            FileUtils.copyFile(srcfile,destfile);
            System.out.println(destfile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        takescreenshot(driver,"swagladscreenshot");

    }
}
