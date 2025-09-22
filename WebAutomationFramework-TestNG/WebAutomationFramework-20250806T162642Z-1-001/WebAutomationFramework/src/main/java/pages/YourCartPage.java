package pages;

import config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class YourCartPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;
    private PropertyReader LoginData;

    @FindBy(xpath = "//button[@id=\"checkout\"]")
    private WebElement check;

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement title;

    @FindBy(xpath = "//button[@name=\"continue-shopping\"]")
    private WebElement continueshop;


    public YourCartPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }

    public String cartpageTitlevalidation(){
        String text=utils.getText(title);
        System.out.println("Cart page Title:"+text);
        return text;
    }
    public void buttonvalidation(){
        boolean continueshopbutton=utils.isEnabled(continueshop);
        System.out.println("continueshop button is enable:"+continueshopbutton);
    }
    public void checkout(){
        boolean checkoutbutton=utils.isEnabled(check);
        System.out.println("checkout button is enable:"+checkoutbutton);
        utils.takescreenshot(driver,"CartPage");
        utils.click(check);
    }
}
