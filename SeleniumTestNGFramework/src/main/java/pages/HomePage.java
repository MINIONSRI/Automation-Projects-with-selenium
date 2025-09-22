package pages;

import config.PropertyReader;
import io.cucumber.java.bs.A;
import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class HomePage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;

    @FindBy(xpath = "//*[@id=\"account-account\"]/ul/li[2]/a")
    private WebElement getTitle;

    @FindBy(xpath = "//a[text()=\"Edit your account information\"]")
    private WebElement EditAI;

    @FindBy(xpath = "(//a[1])[position()=59]")
    private WebElement changepass;

    @FindBy(xpath = "(//a[1])[position()=60]")
    public WebElement ModifyAddress;

    @FindBy(xpath = "(//a[1])[position()=61]")
    private WebElement Modifywish;

    @FindBy(xpath = "(//a[1])[position()=62]")
    private WebElement orderhistroy;

    @FindBy(xpath = "(//a[1])[position()=63]")
    private WebElement download;

    @FindBy(xpath = "(//a[1])[position()=64]")
    public WebElement yorrewardp;

    @FindBy(xpath = "(//a[1])[position()=65]")
    private WebElement ViewyorRetrun;

    @FindBy(xpath = "(//a[1])[position()=66]")
    private WebElement yourTanc;

    @FindBy(xpath = "(//a[1])[position()=67]")
    private WebElement recpayment;

    @FindBy(xpath = "(//a[1])[position()=68]")
    private WebElement affiliateAccount;

    @FindBy(xpath = "(//a[1])[position()=69]")
    private WebElement subscribe;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=1]")
    private WebElement MyAccount;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=2]")
    private WebElement EditAccount;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=3]")
    private WebElement Password;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=4]")
    private WebElement AddressBook;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=5]")
    private WebElement wishList;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=6]")
    private WebElement OrderHistroy;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=7]")
    private WebElement Downalods;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=8]")
    private WebElement RPayement;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=9]")
    private WebElement RewardsPoint;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=10]")
    private WebElement Returns;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=11]")
    private WebElement Transaction;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=12]")
    private WebElement Newsletter;

    @FindBy(xpath = "(//a[@class=\"list-group-item\"])[position()=13]")
    private WebElement Logout;

    @FindBy(xpath = "//a[text()=\"Change your password\"]")
    private WebElement functionofpass;

    @FindBy(xpath = "//*[@id=\"account-account\"]/div[1]")
    private WebElement changePassMessage;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    private WebElement inputPass;

    @FindBy(xpath = "//*[@id=\"input-confirm\"]")
    private WebElement inputconform;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    private WebElement continuebutton;

    private PropertyReader Logindata;

    public HomePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }

    public String getHomePageTitle() {
        String value=getTitle.getText();
        String text=utils.getText(getTitle);
        System.out.println("Home Page title:"+text);
        return value;
    }
    public Boolean EditIformation() {
        Boolean value=EditAI.isDisplayed();
        System.out.println(value);
        String text=utils.getText(EditAI);
        System.out.println(text);
        return value;
    }
    public Boolean ChangePassword() {
        Boolean value=changepass.isDisplayed();
        System.out.println(value);
        String text=utils.getText(changepass);
        System.out.println(text);
        return value;
    }
    public Boolean getModifyAddress () {
        Boolean value=ModifyAddress.isDisplayed();
        System.out.println(value);
        String text=utils.getText(ModifyAddress);
        System.out.println(text);
        return value;
    }
    public Boolean getModifywish() {
        Boolean value=Modifywish.isDisplayed();
        System.out.println(value);
        String text=utils.getText(Modifywish);
        System.out.println(text);
        return value;
    }
    public Boolean getOrderhistroy() {
        Boolean value=orderhistroy.isDisplayed();
        System.out.println(value);
        String text=utils.getText(orderhistroy);
        System.out.println(text);
        return value;
    }
    public Boolean getdownload() {
        Boolean value=download.isDisplayed();
        System.out.println(value);
        String text=utils.getText(download);
        System.out.println(text);
        return value;
    }

    public Boolean getyorrewardp() {
        Boolean value=yorrewardp.isDisplayed();
        System.out.println(value);
        String text=utils.getText(yorrewardp);
        System.out.println(text);
        return value;
    }
    public Boolean getViewyorRetrun() {
        Boolean value=ViewyorRetrun.isDisplayed();
        System.out.println(value);
        String text=utils.getText(ViewyorRetrun);
        System.out.println(text);
        return value;
    }
    public Boolean getyourTanc() {
        Boolean value=yourTanc.isDisplayed();
        System.out.println(value);
        String text=utils.getText(yourTanc);
        System.out.println(text);
        return value;
    }
    public Boolean getrecpayment() {
        Boolean value=recpayment.isDisplayed();
        System.out.println(value);
        String text=utils.getText(recpayment);
        System.out.println(text);
        return value;
    }
    public Boolean getaffiliateAccount() {
        Boolean value=affiliateAccount.isDisplayed();
        System.out.println(value);
        String text=utils.getText(affiliateAccount);
        System.out.println(text);
        return value;
    }
    public Boolean getsubscribe() {
        Boolean value=subscribe.isDisplayed();
        System.out.println(value);
        String text=utils.getText(subscribe);
        System.out.println(text);
        return value;
    }
    public Boolean MyAccount() {
        Boolean value=MyAccount.isEnabled();
        System.out.println(value);
        String text=utils.getText(MyAccount);
        System.out.println(text);
        return value;
    }
    public Boolean EditAccount() {
        Boolean value=EditAccount.isEnabled();
        System.out.println(value);
        String text=utils.getText(EditAccount);
        System.out.println(text);
        return value;
    }
    public Boolean Password() {
        Boolean value=Password.isEnabled();
        System.out.println(value);
        String text=utils.getText(Password);
        System.out.println(text);
        return value;
    }
    public Boolean AddressBook() {
        Boolean value=AddressBook.isEnabled();
        System.out.println(value);
        String text=utils.getText(AddressBook);
        System.out.println(text);
        return value;
    }
    public Boolean getwishList() {
        Boolean value=wishList.isEnabled();
        System.out.println(value);
        String text=utils.getText(wishList);
        System.out.println(text);
        return value;
    }
    public Boolean getOrderHistroy() {
        Boolean value=OrderHistroy.isEnabled();
        System.out.println(value);
        String text=utils.getText(OrderHistroy);
        System.out.println(text);
        return value;
    }
    public Boolean getDownalods() {
        Boolean value=Downalods.isEnabled();
        System.out.println(value);
        String text=utils.getText(Downalods);
        System.out.println(text);
        return value;
    }
    public Boolean getRPayement() {
        Boolean value=RPayement.isEnabled();
        System.out.println(value);
        String text=utils.getText(RPayement);
        System.out.println(text);
        return value;
    }
    public Boolean getRp() {
        Boolean value=RewardsPoint.isEnabled();
        System.out.println(value);
        String text=utils.getText(RewardsPoint);
        System.out.println(text);
        return value;
    }
    public Boolean getReturn() {
        Boolean value=Returns.isEnabled();
        System.out.println(value);
        String text=utils.getText(Returns);
        System.out.println(text);
        return value;
    }
    public Boolean getTransaction() {
        Boolean value=Transaction.isEnabled();
        System.out.println(value);
        String text=utils.getText(Transaction);
        System.out.println(text);
        return value;
    }
    public Boolean getNewsletter() {
        Boolean value=Newsletter.isEnabled();
        System.out.println(value);
        String text=utils.getText(Newsletter);
        System.out.println(text);
        return value;
    }
    public Boolean getlogout() {
        Boolean value=Logout.isEnabled();
        System.out.println(value);
        String text=utils.getText(Logout);
        System.out.println(text);
        return value;
    }

    public void setFunctionofpass(){
        utils.click(functionofpass);
        utils.type(inputPass,PropertyReader.get("password"));
        utils.type(inputconform,PropertyReader.get("password"));
        utils.click(continuebutton);
        String text=utils.getText(changePassMessage);
        System.out.println(text);
    }


}



