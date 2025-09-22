package pages;

import config.PropertyReader;
import io.cucumber.java.ja.但し;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class PaymentPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    private PropertyReader config;

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement title;

    @FindBy(xpath = "(//div[@class=\"summary_value_label\"])[position()=1]")
    private WebElement pi;

    @FindBy(xpath = "(//div[@class=\"summary_value_label\"])[position()=2]")
    private WebElement si;

    @FindBy(xpath = "(//div[@class=\"summary_subtotal_label\"])[position()=1]")
    private WebElement It;

    @FindBy(xpath = "//div[@class=\"summary_tax_label\"]")
    private WebElement Tax;

    @FindBy(xpath = "//div[@class=\"summary_total_label\"]")
    private WebElement Tot;

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement title1;

    @FindBy(xpath = "//button[@id=\"finish\"]")
    private WebElement finish;

    @FindBy(xpath = "//h2[@class=\"complete-header\"]")
    private WebElement om;

    @FindBy(xpath = "//div[@class=\"complete-text\"]")
    private WebElement oi;

    @FindBy(xpath = "//button[@name=\"back-to-products\"]")
    private WebElement bh;

    public PaymentPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.utils = new SeleniumUtils(driver, 10);
        PageFactory.initElements(driver, this);

        this.config = new PropertyReader();
        this.config.loadProperties("src/test/resources/TestData/LoginData.properties");
    }

    public String Titlevalidation() {
        String text = utils.getText(title);
        System.out.println("payment page title:" + text);
        return text;
    }

    public String payementinformation() {
        String text1 = utils.getText(pi);
        System.out.println("Payment Information:" + text1);
        return text1;
    }

    public String ShippingInformation() {
        String text2 = utils.getText(si);
        System.out.println("Shipping Information:" + text2);
        return text2;
    }

    public String itemtotal() {
        String text3 = utils.getText(It);
        System.out.println(text3);
        return text3;
    }

    public String Tax() {
        String text4 = utils.getText(Tax);
        System.out.println(text4);
        return text4;
    }

    public String total() {
        String text5 = utils.getText(Tot);
        System.out.println(text5);
        return text5;
    }

    public void payement() {
        boolean finishbutton = utils.isEnabled(finish);
        System.out.println("Finish button is enable:" + finishbutton);
        utils.click(finish);
    }

    public String orderpagetitlevalidation() {
        String ordertitle=utils.getText(title1);
        System.out.println("orderpage Title:"+ordertitle);
        return ordertitle;
    }
    public String ordermessage1() {
        String Thankmessage=utils.getText(om);
        System.out.println("Sridharn k: "+Thankmessage);
        return Thankmessage;
    }
    public String ordermessage2() {
        String ordermessage=utils.getText(oi);
        System.out.println(ordermessage);
        return ordermessage;
    }

    public void backHomePage(){
        utils.takescreenshot(driver,"orderplaced");
        boolean bhb=utils.isEnabled(bh);
        System.out.println("Backhome button enable:"+bhb);
        utils.click(bh);
    }

}
