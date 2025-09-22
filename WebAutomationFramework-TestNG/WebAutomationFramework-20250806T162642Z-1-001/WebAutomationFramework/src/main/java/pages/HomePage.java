package pages;

import config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement txt;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]/div")
    private WebElement Specification;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    private WebElement price;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addtocard;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    private WebElement remove;

    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    private WebElement shop;

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

    public String checkProductName(){
        String name = utils.getText(txt);
        System.out.println("Product Name: " + name);
        return name;
    }
    public String checkProductdetails(){
        String details = utils.getText(Specification);
        System.out.println("Product Details: " + details);
        return details;
    }
    public String checkProductprice(){
        String Price = utils.getText(price);
        System.out.println("Product price: " + Price);
        return Price;
    }


    public void addToCart() {
        boolean a=utils.isEnabled(addtocard);
        System.out.println("addtocard button is enable:"+a);
        utils.click(addtocard);
        boolean r=utils.isEnabled(remove);
        System.out.println("addtocard change to Remove:"+r);
        boolean s=utils.isEnabled(shop);
        System.out.println("shop button is enable:"+s);
        utils.takescreenshot(driver,"HomePage");
        utils.click(shop);
    }

}