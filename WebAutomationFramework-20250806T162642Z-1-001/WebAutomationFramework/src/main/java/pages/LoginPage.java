package pages;

import config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class LoginPage  {

    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class=\"login_logo\"]")
    public WebElement loginpageTitle;

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

    public void LoginIntoApp() {
        utils.takescreenshot(driver,"LoginPage");
        utils.type(usernameField, config.get("username"));
        utils.type(passwordField, config.get("password"));
        utils.click(loginButton);
    }

    public String LoginPageTitleValidation() {
        String text = utils.getText(loginpageTitle);
        System.out.println("Login Page Title: " + text);
        return text;
    }
}