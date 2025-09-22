package pages;

import config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

import java.util.List;

public class DesktopPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;

    @FindBy(xpath = "//*[@id=\"content\"]/h2")
    private WebElement Title;

    @FindBy(xpath ="(//a[text()=\"Desktops\"])[position()=1]")
    private WebElement desktop;

    @FindBy(xpath = "(//a[text()=\"Show All Desktops\"])[position()=1]")
    private WebElement alldesktop;

    @FindBy(xpath = "(//button[@type=\"button\"])[position()=15]")
    private WebElement HPaddtocart;

    @FindBy(xpath = "//button[@onclick=\"cart.add('28', '1');\"]")
    private WebElement HTCaddtocart;

    @FindBy(xpath = "//button[@onclick=\"wishlist.add('28');\"]")
    private WebElement Wishlist;

    @FindBy(xpath = "//button[@onclick=\"compare.add('28');\"]")
    private WebElement compare;

    @FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
    private WebElement success;

    @FindBy(xpath = "//div[@class='product-thumb']")
    List<WebElement> desktopItems;

    @FindBy(xpath = "//div[@class='product-thumb']")
    private WebElement desktopItem;

    public DesktopPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }

    public String getDesktopTitle(){
        String text=utils.getText(Title);
        System.out.println("Desktop Page Title:"+text);
        return text;
    }

    public void getdesktop() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(desktop).build().perform();
        action.moveToElement(alldesktop).build().perform();
        alldesktop.click();
    }

    public int getDesktopItemsCount() {
        System.out.println("Number of Items:"+desktopItems.size());
        return desktopItems.size();
    }
    public Boolean getItemsareDisplayed(){
        Boolean value=utils.isDisplayed(desktopItem);
        System.out.println("items are displayed:"+value);
        return value;
    }

    public Boolean  AddtoCardOneItem() throws InterruptedException {
        Actions action = new Actions(driver);
        action.scrollToElement(HTCaddtocart).build().perform();
        Boolean value = utils.isEnabled(HTCaddtocart);
        System.out.println("Cart Button Enable:" + value);
        utils.click(HTCaddtocart);
        Thread.sleep(2000);
//        boolean check = utils.isDisplayed(success);
//        System.out.println("success message is enable:" + check);
        String text = utils.getText(success);
        System.out.println(text);
        Thread.sleep(2000);
        return value;
    }
    public Boolean AddtoWishListOneItem() throws InterruptedException {
        Boolean value=utils.isEnabled(Wishlist);
        System.out.println("Wishlist button is enable:"+value);
        utils.click(Wishlist);
        Thread.sleep(2000);
        String text = utils.getText(success);
        System.out.println(text);
        Thread.sleep(2000);
        return value;
    }
    public Boolean CompareProduct() throws InterruptedException {
        Boolean value=utils.isEnabled(compare);
        System.out.println("compare button is enable:"+value);
        utils.click(compare);
        Thread.sleep(2000);
        String text = utils.getText(success);
        System.out.println(text);
        Thread.sleep(2000);
        return value;
    }
}
