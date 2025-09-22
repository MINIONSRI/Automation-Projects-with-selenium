package StepDefinitions;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import config.PropertyReader;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import utils.SeleniumUtils;

public class LoginPageTest extends BaseTest {

    private WebDriver driver;

    private LoginPage lp;
    private HomePage hp;
    private DesktopPage dp;
    private AddressBookPage abp;
    private ShoppingPage sp;
    private RegsiterPage rp;

    // ======================== HOOKS ========================

    @Before
    public void setUp(Scenario scenario) {
        launchBrowser();
        driver = getDriver();

        setTest(extent.createTest(scenario.getName()));
        test.log(Status.INFO, "Starting scenario: " + scenario.getName());

        // Initialize page objects
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        dp = new DesktopPage(driver);
        abp = new AddressBookPage(driver);
        sp = new ShoppingPage(driver);
        rp = new RegsiterPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = SeleniumUtils.takeScreenshot("src/test/resources/Screenshots");
            test.log(Status.FAIL, "Scenario failed");
            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                test.log(Status.WARNING, "Screenshot attachment failed: " + e.getMessage());
            }
        } else {
            test.log(Status.PASS, "Scenario passed");
        }

        closeBrowser();
    }

    @AfterAll
    public static void afterAll() {
        BaseTest base = new BaseTest();
        base.flushExtentReport();
    }

    // ======================== REGISTRATION ========================

    @Given("user navigates to Register Page")
    public void userNavigatesToRegisterPage() throws InterruptedException {
        rp.RegsiterButton();
        test.log(Status.PASS, "Navigated to Register Page successfully");
    }

    @When("Verify the RegisterPage Title")
    public void verifyRegisterPageTitle() {
        Assert.assertEquals(rp.regsiterPageTitleValidation(), PropertyReader.get("expected_pagetitle"));
        test.log(Status.PASS, "Register Page title verified successfully");
    }

    @Then("Enter Valid details")
    public void enterValidDetails() {
        rp.DetailsFill();
        test.log(Status.PASS, "Entered valid registration details successfully");
    }

    // ======================== LOGIN ========================

    @Given("Verify the Loginpage title")
    public void verifyLoginPageTitle() throws InterruptedException {
        lp.LoginButton();
        Assert.assertEquals(lp.loginTitleValidation(), PropertyReader.get("LoginTitle"));
        test.log(Status.PASS, "Login Page title verified successfully");
    }

    @Then("User logged into the application")
    public void userLoggedIntoApplication() throws InterruptedException {
        lp.LoginIntoTheApp();
        test.log(Status.PASS, "Login Successful");
        String filename = SeleniumUtils.takeScreenshot("src/test/resources/Screenshots");
        test.addScreenCaptureFromPath(filename);
    }

    // ======================== HOME PAGE ========================

    @Given("user should see the correct title")
    public void userShouldSeeCorrectTitle() throws InterruptedException {
        lp.LoginIntoTheApp();
        String actualvalue = hp.getHomePageTitle();
        Assert.assertEquals(actualvalue, PropertyReader.get("HomeTitle"));
        test.log(Status.PASS, "Home Page Title validated");
    }

    @When("user check All Link and Button")
    public void userCheckAllLinksAndButtons() {
        Assert.assertEquals(hp.getHomePageTitle(), PropertyReader.get("HomeTitle"));
        Assert.assertTrue(hp.EditIformation());
        Assert.assertTrue(hp.ChangePassword());
        Assert.assertTrue(hp.getModifyAddress());
        Assert.assertTrue(hp.getModifywish());
        Assert.assertTrue(hp.getOrderhistroy());
        Assert.assertTrue(hp.getdownload());
        Assert.assertTrue(hp.getyorrewardp());
        Assert.assertTrue(hp.getViewyorRetrun());
        Assert.assertTrue(hp.getyourTanc());
        Assert.assertTrue(hp.getrecpayment());
        Assert.assertTrue(hp.getaffiliateAccount());
        Assert.assertTrue(hp.getsubscribe());
        Assert.assertTrue(hp.MyAccount());
        Assert.assertTrue(hp.EditAccount());
        Assert.assertTrue(hp.Password());
        Assert.assertTrue(hp.AddressBook());
        Assert.assertTrue(hp.getwishList());
        Assert.assertTrue(hp.getOrderHistroy());
        Assert.assertTrue(hp.getDownalods());
        Assert.assertTrue(hp.getRPayement());
        Assert.assertTrue(hp.getReturn());
        Assert.assertTrue(hp.getTransaction());
        Assert.assertTrue(hp.getNewsletter());
        Assert.assertTrue(hp.getlogout());
        test.log(Status.PASS, "All Home Page elements verified");
    }

    @Then("Verify password change functionality")
    public void verifyPasswordChangeFunctionality() {
        hp.setFunctionofpass();
        test.log(Status.PASS, "Password change functionality verified");
    }

    // ======================== DESKTOP PAGE ========================

    @Given("user navigates to Desktop Page")
    public void userNavigatesToDesktopPage() throws InterruptedException {
        lp.LoginIntoTheApp();
        dp.getdesktop();
        test.log(Status.PASS, "Navigated to Desktop Page");
    }

    @When("Verify the DesktopPage Title")
    public void verifyDesktopPageTitle() {
        Assert.assertEquals(dp.getDesktopTitle(), PropertyReader.get("DesktopTitle"));
        test.log(Status.PASS, "Desktop Page title verified");
    }

    @Then("Verify desktop items are displayed")
    public void verifyDesktopItemsDisplayed() {
        Assert.assertTrue(dp.getItemsareDisplayed());
        Assert.assertTrue(dp.getDesktopItemsCount() > 0);
        test.log(Status.PASS, "Desktop items verified");
    }

    @Then("user Add item to AddtoCard and WishList")
    public void userAddItemToCartAndWishlist() throws InterruptedException {
        Assert.assertTrue(dp.AddtoCardOneItem());
        Assert.assertTrue(dp.AddtoWishListOneItem());
        Assert.assertTrue(dp.CompareProduct());
        test.log(Status.PASS, "Cart and Wishlist actions verified");
    }

    // ======================== SHOPPING PAGE ========================

    @Given("user navigates to Shopping Page")
    public void userNavigatesToShoppingPage() throws InterruptedException {
        lp.LoginIntoTheApp();
        Assert.assertTrue(sp.getShoppingPage());
        test.log(Status.PASS, "Navigated to Shopping Page");
    }

    @When("Verify the ShoppingPage Title")
    public void verifyShoppingPageTitle() {
        Assert.assertEquals(sp.getShoppingTitle(), PropertyReader.get("shoppingTitle"));
        test.log(Status.PASS, "Shopping Page title verified");
    }

    @Then("user can update cart")
    public void userCanUpdateCart() throws InterruptedException {
        Assert.assertEquals(sp.getDtails(), PropertyReader.get("text"));
        Assert.assertTrue(sp.getButtonenable());
        sp.setUpdate();
        test.log(Status.PASS, "Cart updated successfully");
    }

    @Then("user can check delivery cost")
    public void userCanCheckDeliveryCost() throws InterruptedException {
        Assert.assertTrue(sp.DeliveryCost());
        test.log(Status.PASS, "Delivery cost verified");
    }

    // ======================== ADDRESS BOOK ========================

    @Given("user navigates to Address Book Page")
    public void userNavigatesToAddressBookPage() throws InterruptedException {
        lp.LoginIntoTheApp();
        Assert.assertTrue(abp.AddressBookButton());
        abp.getAddressBook();
        test.log(Status.PASS, "Navigated to Address Book Page");
    }

    @When("Verify the AddressBookPage Title")
    public void verifyAddressBookPageTitle() {
        Assert.assertEquals(abp.getAddressTitle(), PropertyReader.get("AddressTitle"));
        test.log(Status.PASS, "Address Book Page title verified");
    }

    @Then("Check All Button is Enable")
    public void checkAllButtonsEnabled() throws InterruptedException {
        Assert.assertTrue(abp.NewAddressBookButton());
        Assert.assertTrue(abp.EditAddressBookButton());
        Assert.assertTrue(abp.DeleteAddressBookButton());
        abp.getOldAddress();
        test.log(Status.PASS, "Address Book buttons verified");
    }

    @And("user can set edit details")
    public void userCanSetEditDetails() {
        abp.setAddressBook();
        Assert.assertTrue(abp.setAddressFill());
        test.log(Status.PASS, "Address edit verified");
    }

    // ======================== PARAMETERIZED LOGIN ========================

    @Given("User Enter the username {string} and password {string}")
    public void userEnterCredentials(String username, String password) {
        lp.getUsernameField().sendKeys(username);
        test.log(Status.PASS, "Entered username: " + username);

        lp.getPasswordField().sendKeys(password);
        test.log(Status.PASS, "Entered password");

        lp.getLoginButton().click();
        test.log(Status.PASS, "Login submitted");
    }

    @Then("Verify the homepage title")
    public void verifyHomepageTitle() {
        String actualvalue = hp.getHomePageTitle();
        Assert.assertEquals(actualvalue, PropertyReader.get("HomeTitle"));
        test.log(Status.PASS, "Home Page title verified");
    }
}
