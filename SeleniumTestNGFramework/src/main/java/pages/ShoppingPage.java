package pages;

import config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumUtils;

public class ShoppingPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;

    @FindBy(xpath = "//*[@id=\"checkout-cart\"]/ul/li[2]/a")
    private WebElement Title;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
    private WebElement number;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]")
    private WebElement update;

    @FindBy(xpath = "//*[@id=\"checkout-cart\"]/div[1]")
    private WebElement successmessage;

    @FindBy(xpath = "//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
    public WebElement shippingtax;

    @FindBy(xpath = "//*[@id=\"input-country\"]")
    private WebElement getcountry;

    @FindBy(xpath = "//*[@id=\"input-zone\"]")
    private WebElement getzone;

    @FindBy(xpath = "//*[@id=\"input-postcode\"]")
    private WebElement postcode;

    @FindBy(xpath = "//*[@id=\"button-quote\"]")
    public WebElement combutton;

    @FindBy(xpath = "//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")
    private WebElement flatshippingrate;

    @FindBy(xpath = "//*[@id=\"button-shipping\"]")
    private WebElement Applyingshbutton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
    private WebElement checkout;

    @FindBy(xpath = "(//button[@data-toggle=\"dropdown\"])[position()=2]")
    private WebElement cartTotal;

    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
    private WebElement Viewcart;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private WebElement shoppingkg;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[2]/a")
    private WebElement productname;

    @FindBy(xpath = "(//button[@onclick=\"cart.remove('92211');\"])[position()=2]")
    private WebElement remove;

    @FindBy(xpath = "(//td[@class=\"text-right\"])[position()=9]")//11 two product
    private WebElement unitprice;

    @FindBy(xpath = "(//td[@class=\"text-right\"])[position()=14]")//18 two product
    private WebElement getTotal;

    @FindBy(xpath = "//label[text()=\"Flat Shipping Rate - $5.00\"]")
    private WebElement FSrate;

    private PropertyReader Logindata;

    public ShoppingPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }

    public Boolean getShoppingPage() throws InterruptedException {
        Actions actions=new Actions(driver);
        Boolean value=utils.isEnabled(cartTotal);
        System.out.println("cartTotal button is enable:"+value);
        System.out.println(utils.getText(cartTotal));
        utils.click(cartTotal);
        actions.moveToElement(Viewcart).build().perform();
        Viewcart.click();
        Thread.sleep(3000);
        return value;
    }

    public String getShoppingTitle(){
        String text=utils.getText(Title);
        System.out.println("Shopping page Title:"+text);
        return  text;
    }

    public String  getDtails() {
        System.out.println(utils.getText(shoppingkg));
        String text = utils.getText(productname);
        System.out.println("Product Name:" + text);
        return text;
    }
    public Boolean getButtonenable(){
        Boolean check=utils.isDisplayed(update);
        System.out.println("Update Button is Enable:"+check);
        boolean check1=utils.isDisplayed(remove);
        System.out.println("Remove Button is Enable:"+check1);
        return check;
    }

    public void setUpdate() throws InterruptedException {
        number.clear();
        utils.type(number,"3");
        utils.click(update);
        String text=utils.getText(successmessage);
        System.out.println(text);
        Thread.sleep(2000);
        System.out.println("Unit Price:"+utils.getText(unitprice));
        System.out.println("Total Price:"+utils.getText(getTotal));
    }
    
    public Boolean DeliveryCost() throws InterruptedException {
        Actions action=new Actions(driver);
        action.moveToElement(shippingtax).build().perform();
        shippingtax.click();
        action.moveToElement(getcountry).build().perform();
        Select select=new Select(getcountry);
        select.selectByVisibleText("India");
        Select select1=new Select(getzone);
        select1.selectByVisibleText("Tamil Nadu");
        utils.type(postcode,PropertyReader.get("postalcode"));
        utils.click(combutton);
        action.moveToElement(flatshippingrate).build().perform();
        flatshippingrate.click();
        System.out.println(utils.getText(FSrate));
        utils.click(Applyingshbutton);
        Thread.sleep(2000);
        String text=utils.getText(successmessage);
        System.out.println(text);
        Thread.sleep(2000);
        Boolean value=utils.isEnabled(checkout);
        System.out.println("checkout button is enable:"+value);
        utils.click(checkout);
        System.out.println(utils.getText(successmessage));
        return value;
    }
}
