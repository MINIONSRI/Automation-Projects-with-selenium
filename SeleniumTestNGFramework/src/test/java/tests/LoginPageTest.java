package tests;
import base.BaseTest;
import config.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class LoginPageTest extends BaseTest {
    LoginPage lp;
    RegsiterPage rp;
    HomePage hp;
    DesktopPage dp;
    ShoppingPage sp;
    AddressBookPage abp;

    @BeforeMethod
    public void setupPage() {
        rp = new RegsiterPage(driver);
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        dp = new DesktopPage(driver);
        sp = new ShoppingPage(driver);
        abp = new AddressBookPage(driver);
    }

    @Test(priority = 1)
    public void RegsitesationPage() throws InterruptedException {
        rp.RegsiterButton();
        String title=rp.regsiterPageTitleValidation();
        Assert.assertEquals(title, PropertyReader.get("expected_pagetitle"));
        rp.DetailsFill();
    }
    @Test(priority = 2)
    public void LoginPage() throws InterruptedException {
        lp.LoginButton();
        String title=lp.loginTitleValidation();
        Assert.assertEquals(title,PropertyReader.get("LoginTitle"));
        lp.LoginIntoTheApp();
    }
    @Test(priority = 3,dependsOnMethods = "LoginPage")
    public void HomePage(){
        // Get actual value
        String actualvalue = hp.getHomePageTitle();
        Assert.assertEquals(actualvalue,PropertyReader.get("HomeTitle"));

        Boolean l1 = hp.EditIformation();
        Boolean l2 = hp.ChangePassword();
        Boolean l3 = hp.getModifyAddress();
        Boolean l4 = hp.getModifywish();
        Boolean l5 = hp.getOrderhistroy();
        Boolean l6 = hp.getdownload();
        Boolean l7 = hp.getyorrewardp();
        Boolean l8 = hp.getViewyorRetrun();
        Boolean l9 = hp.getyourTanc();
        Boolean l10 = hp.getrecpayment();
        Boolean l11 = hp.getaffiliateAccount();
        Boolean l12 = hp.getsubscribe();
        Boolean l13 = hp.MyAccount();
        Boolean l14 = hp.EditAccount();
        Boolean l15 = hp.Password();
        Boolean l16 = hp.AddressBook();
        Boolean l17 = hp.getwishList();
        Boolean l18 = hp.getOrderHistroy();
        Boolean l19 = hp.getDownalods();
        Boolean l20 = hp.getRPayement();
        Boolean l21 = hp.getRp();
        Boolean l22 = hp.getReturn();
        Boolean l23 = hp.getTransaction();
        Boolean l24 = hp.getNewsletter();
        Boolean l25 = hp.getlogout();
        //Assertions
        Assert.assertTrue(l1,"MissMatch");
        Assert.assertTrue(l2,"MissMatch");
        Assert.assertTrue(l3,"MissMatch");
        Assert.assertTrue(l4,"MissMatch");
        Assert.assertTrue(l5,"MissMatch");
        Assert.assertTrue(l6,"MissMatch");
        Assert.assertTrue(l7,"MissMatch");
        Assert.assertTrue(l8,"MissMatch");
        Assert.assertTrue(l9,"MissMatch");
        Assert.assertTrue(l10,"MissMatch");
        Assert.assertTrue(l11,"MissMatch");
        Assert.assertTrue(l12,"MissMatch");
        Assert.assertTrue(l13,"MissMatch");
        Assert.assertTrue(l14,"MissMatch");
        Assert.assertTrue(l15,"MissMatch");
        Assert.assertTrue(l16,"MissMatch");
        Assert.assertTrue(l17,"MissMatch");
        Assert.assertTrue(l18,"MissMatch");
        Assert.assertTrue(l19,"MissMatch");
        Assert.assertTrue(l20,"MissMatch");
        Assert.assertTrue(l21,"MissMatch");
        Assert.assertTrue(l22,"MissMatch");
        Assert.assertTrue(l23,"MissMatch");
        Assert.assertTrue(l24,"MissMatch");
        Assert.assertTrue(l25,"MissMatch");
        hp.setFunctionofpass();
    }

    @Test(priority = 4,dependsOnMethods = "LoginPage")
    public void DesktopPage() throws InterruptedException {
        dp.getdesktop();
        String title=dp.getDesktopTitle();
        Assert.assertEquals(title,PropertyReader.get("DesktopTitle"));
        dp.getDesktopItemsCount();
        dp.getItemsareDisplayed();
        dp.AddtoCardOneItem();
        dp.AddtoWishListOneItem();
        dp.CompareProduct();
    }
    @Test(priority = 5)
    public void shoopingPgae() throws InterruptedException {
        sp.getShoppingPage();
        String title=sp.getShoppingTitle();
        Assert.assertEquals(title,PropertyReader.get("shoppingTitle"));
        sp.getDtails();
        sp.getButtonenable();
        sp.setUpdate();
        sp.DeliveryCost();
    }

    @Test(priority = 6,dependsOnMethods = "LoginPage")
    public void addressBookPage() throws InterruptedException {
        abp.setMyaccount();
        abp.AddressBookButton();
        abp.getAddressBook();
        String title=abp.getAddressTitle();
        Assert.assertEquals(title,PropertyReader.get("AddressTitle"));
        abp.NewAddressBookButton();
        abp.EditAddressBookButton();
        abp.DeleteAddressBookButton();
        abp.getOldAddress();
        abp.setAddressBook();
        abp.setAddressFill();
    }
}