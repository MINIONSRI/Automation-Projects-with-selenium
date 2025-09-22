package pages;

import config.PropertyReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import utils.SeleniumUtils;

public class AddressBookPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;


    @FindBy(xpath = "//*[@id=\"account-address\"]/ul/li[3]/a")
    private WebElement Title;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
    private WebElement myaccount;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement getMyaccount;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[4]")
    private WebElement addressbook;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]/a[1]")
    private WebElement edit;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/a")
    public WebElement newaddressbook;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=1]")
    private WebElement fname;

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    private WebElement lname;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=3]")
    private WebElement company;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=4]")
    public WebElement address1;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=5]")
    private WebElement address2;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=6]")
    private WebElement city;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[position()=7]")
    private WebElement postcode;

    @FindBy(xpath = "//*[@id=\"input-country\"]")
    private WebElement getcountry;

    @FindBy(xpath = "//*[@id=\"input-zone\"]")
    private WebElement getstate;

    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[10]/div/label[1]/input")
    private WebElement radiobutton;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    private WebElement continuebutton;

    @FindBy(xpath = "(//a[text()=\"Delete\"])[position()=1]")
    private WebElement deleteAddress;

    @FindBy(xpath = "//*[@id=\"account-address\"]/div[1]")
    private WebElement updateAddress;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]")
    private WebElement oldAddress;

    private PropertyReader Logindata;

    public AddressBookPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }

    public String getAddressTitle(){
        String text=utils.getText(Title);
        System.out.println("Address Page Title:"+text);
        return text;
    }
    public void setMyaccount(){
        Actions action=new Actions(driver);
        action.moveToElement(myaccount).build().perform();
        myaccount.click();
        getMyaccount.click();
    }
    public Boolean AddressBookButton() throws InterruptedException {
        Boolean value = utils.isEnabled(addressbook);
        System.out.println("AddressBook Button is enable:" + value);
        return value;
    }

    public  void  getAddressBook() {
        utils.click(addressbook);
    }

    public void getOldAddress(){
        String text=utils.getText(oldAddress);
        System.out.println("Old Address is:"+text);
    }

    public Boolean EditAddressBookButton() throws InterruptedException {
        Boolean value = utils.isEnabled(edit);
        System.out.println("EditAddressBook Button is enable:" + value);
        return value;
    }

    public Boolean DeleteAddressBookButton() throws InterruptedException {
        Boolean value = utils.isEnabled(deleteAddress);
        System.out.println("DeleteAddressBook Button is enable:" + value);
        return value;
    }

    public Boolean NewAddressBookButton() throws InterruptedException {
        Boolean value = utils.isEnabled(newaddressbook);
        System.out.println("newAddressBook Button is enable:" + value);
        return value;
    }

    public  void  setAddressBook(){
//        utils.click(deleteAddress);
//        Alert alert=driver.switchTo().alert();
//        System.out.println("Alert message:"+alert.getText());
//        alert.accept();
//        String text=utils.getText(updateAddress);
//        System.out.println(text);
        utils.click(edit);
//        utils.click(newaddressbook);
    }
    public Boolean setAddressFill(){
        utils.type(fname,PropertyReader.get("fristname"));
        utils.type(lname,PropertyReader.get("lastname"));
        utils.type(company,PropertyReader.get("company"));
        utils.type(address1,PropertyReader.get("address1"));
        utils.type(address2,PropertyReader.get("address2"));
        utils.type(city,PropertyReader.get("ctiy"));
        utils.type(postcode,PropertyReader.get("code"));
        Select select=new Select(getcountry);
        select.selectByVisibleText("United States");
        Select select1=new Select(getstate);
        select1.selectByVisibleText("Colorado");
        utils.click(radiobutton);
        Boolean value=utils.isEnabled(continuebutton);
        System.out.println("continue button is enable:"+value);
        utils.click(continuebutton);
        return value;
    }
}
