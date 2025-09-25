package tests;

import base.BaseTest;
import config.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SwagLabTest extends BaseTest  {

    LoginPage lp;
    HomePage hp;
    YourCartPage cp;
    AddressPage ap;
    PaymentPage pp;
    private PropertyReader Logindata;

    @BeforeMethod
    public void setupPage() {
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        cp = new YourCartPage(driver);
        ap = new AddressPage(driver);
        pp = new PaymentPage(driver);
    }

    @Test(priority = 1)
    public void logIntoTheApp() throws InterruptedException {
        String title = lp.LoginPageTitleValidation();
        Assert.assertEquals(title,Logindata.get("expected_pagetitle"));
        lp.LoginIntoApp();
        Thread.sleep(3000);
    }

    @Test(priority = 2,dependsOnMethods = "logIntoTheApp")
    public void homePageTest() throws InterruptedException {
        // Get actual value
        String productname = hp.checkProductName();
        String productdetails = hp.checkProductdetails();
        String productprice = hp.checkProductprice();

        // Assertions
        Assert.assertEquals(productname,Logindata.get("pname"), "❌ Title does not match!");
        Assert.assertEquals(productdetails,Logindata.get("pdetails"),"❌ details does not match!");
        Assert.assertEquals(productprice,Logindata.get("pamount"), "❌ Price does not match!");

        hp.addToCart();
    }

    @Test(priority = 3, dependsOnMethods = "homePageTest")
    public void YourCartPageTest() {
        String cartpagetitle=cp.cartpageTitlevalidation();
        Assert.assertEquals(cartpagetitle,Logindata.get("cartTitle"));
        cp.buttonvalidation();
        cp.checkout();
    }

    @Test(priority = 4, dependsOnMethods = "YourCartPageTest")
    public void AddressPageTest(){
        String addresspagetitle=ap.addresspageTitlevalidation();
        Assert.assertEquals(addresspagetitle,Logindata.get("addressTitle"));
        ap.pagevalidation();
        ap.Addressfill();
    }

    @Test(priority = 5, dependsOnMethods = "AddressPageTest")
    public void PaymentTest()
    {
        String paymentTitle=pp.Titlevalidation();
        String payementinformation=pp.payementinformation();
        String shippingInformation=pp.ShippingInformation();
        String itemtotal=pp.itemtotal();
        String tax=pp.Tax();
        String Total=pp.total();

        Assert.assertEquals(paymentTitle,Logindata.get("paymentTitle"));
        Assert.assertEquals(payementinformation,Logindata.get("payment"));
        Assert.assertEquals(shippingInformation,Logindata.get("shipping"));
        Assert.assertEquals(itemtotal,Logindata.get("itemprice"));
        Assert.assertEquals(tax,Logindata.get("tax"));
        Assert.assertEquals(Total,Logindata.get("Totalamount"));
        pp.payement();
        pp.orderpagetitlevalidation();

        String ordermessage1=pp.ordermessage1();
        String ordermessage2=pp.ordermessage2();

        Assert.assertEquals(ordermessage1,Logindata.get("Thanksmessage"));
        Assert.assertEquals(ordermessage2,Logindata.get("ordermessage"));

        pp.backHomePage();
    }
    }




