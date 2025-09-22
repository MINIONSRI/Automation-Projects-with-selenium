package pages;

import config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class AddressPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;
    private PropertyReader LoginData;

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement title;

    @FindBy(xpath = "//input[@id=\"first-name\"]")
    private WebElement fn;

    @FindBy(xpath = "//input[@id=\"last-name\"]")
    private WebElement ln;

    @FindBy(xpath = "//input[@id=\"postal-code\"]")
    private WebElement pin;

    @FindBy(xpath = "//button[@name=\"cancel\"]")
    private WebElement cancel;

    @FindBy(xpath = "//input[@id=\"continue\"]")
    private WebElement con;

    public AddressPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }

    public String addresspageTitlevalidation(){
        String text=utils.getText(title);
        System.out.println("Addresspage title:"+text);
        return text;
    }
    public void pagevalidation(){
        boolean cancelbutton=utils.isEnabled(cancel);
        System.out.println("cancel button enable:"+cancelbutton);
    }


    public void Addressfill(){
        utils.type(fn,LoginData.get("fname"));
        utils.type(ln,LoginData.get("lname"));
        utils.type(pin,LoginData.get("pincode"));
        boolean continuebuuton=utils.isEnabled(con);
        System.out.println("continue button is enable:"+continuebuuton);
        utils.takescreenshot(driver,"AddressPage");
        utils.click(con);
    }
}
