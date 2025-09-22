package pages;

import config.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class LoginPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=13]")
    private WebElement logout;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=1]")
    private WebElement login;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=1]")
    private WebElement usernameField;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=2]")
    public WebElement passwordField;

    @FindBy(xpath = "(//input[@type=\"submit\"])[position()=1]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/h2")
    private WebElement loginpageTitle;

    @FindBy(xpath ="(//a[text()=\"Desktops\"])[position()=1]")
    private WebElement desktop;

    @FindBy(xpath = "(//a[text()=\"Show All Desktops\"])[position()=1]")
    private WebElement alldesktop;

    @FindBy(xpath = "(//button[@type=\"button\"])[position()=15]")
    private WebElement HPaddtocart;

    @FindBy(xpath = "(//button[@type=\"button\"])[position()=18]")
    private WebElement HTCaddtocart;

    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }

    public void LoginButton() throws InterruptedException {
//        utils.click(logout);
        boolean loginbutton = utils.isDisplayed(login);
        System.out.println("Login Button is Enable:" +loginbutton);
        utils.click(login);
        Thread.sleep(2000);
    }
    public String loginTitleValidation() throws InterruptedException {
        String text = utils.getText(loginpageTitle);
        System.out.println("Login Page Title: " + text);
        return text;
    }
    public void LoginIntoTheApp() throws InterruptedException {
        utils.type(usernameField, PropertyReader.get("username"));
        utils.type(passwordField, PropertyReader.get("password"));
        utils.click(loginButton);
    }

    public WebElement getUsernameField()
    {
        return usernameField;
    }
    public WebElement getPasswordField()
    {
        return passwordField;
    }
    public WebElement getLoginButton(){

        return loginButton;
    }


}