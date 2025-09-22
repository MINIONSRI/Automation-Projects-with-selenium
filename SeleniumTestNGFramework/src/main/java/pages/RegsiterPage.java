package pages;

import config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class RegsiterPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;

    @FindBy(xpath = "//h1[text()=\"Register Account\"]")
    private WebElement resTitle;

    @FindBy(xpath = "(//a[text()=\"Register\"])[position()=2]")
    private WebElement regsiterbutton;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=1]")
    private WebElement fname;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=2]")
    public WebElement lname;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=3]")
    private WebElement email;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=4]")
    private WebElement pnumber;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=5]")
    private WebElement password;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=6]")
    public WebElement compassword;

    @FindBy(xpath = "(//input[@name=\"newsletter\"])[position()=1]")
    private WebElement radiobox;

    @FindBy(xpath = "//input[@name=\"agree\"]")
    private WebElement checkbox;

    @FindBy(xpath = "//input[@value=\"Continue\"]")
    private WebElement Continue;
    private PropertyReader Logindata;

    public RegsiterPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }


    public void RegsiterButton() throws InterruptedException {
        boolean resbutton = utils.isDisplayed(regsiterbutton);
        System.out.println("Regsiter Button is Enable:" + resbutton);
        utils.click(regsiterbutton);
    }

    public String regsiterPageTitleValidation() {
        String text = utils.getText(resTitle);
        System.out.println("Regsiter Page Title: " + text);
        return text;
    }
        public void DetailsFill() {
            utils.type(fname, Logindata.get("fristname"));
            utils.type(lname, Logindata.get("lastname"));
            utils.type(email, Logindata.get("e-mail"));
            utils.type(pnumber, Logindata.get("phonenumber"));
            utils.type(password, Logindata.get("password"));
            utils.type(compassword, Logindata.get("compassword"));
            utils.click(radiobox);
            utils.click(checkbox);
            utils.click(Continue);
        }
}