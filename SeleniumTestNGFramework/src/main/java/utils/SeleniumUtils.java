package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.io.FileUtils;

public class SeleniumUtils {

    private static WebDriver driver;
    private WebDriverWait wait;

    public SeleniumUtils(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    // ✅ Wait for visibility of WebElement
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ✅ Wait for clickability of WebElement
    public WebElement waitForClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // ✅ Click WebElement
    public void click(WebElement element) {
        waitForClickability(element).click();
    }

    // ✅ Type into WebElement
    public void type(WebElement element, String text) {
        WebElement el = waitForVisibility(element);
        el.clear();
        el.sendKeys(text);
    }

    // ✅ Get text from WebElement
    public String getText(WebElement element) {
        return waitForVisibility(element).getText();
    }

    // ✅ Get attribute from WebElement
    public String getAttribute(WebElement element, String attribute) {
        return waitForVisibility(element).getAttribute(attribute);
    }

    // ✅ Select dropdown by visible text
    public void selectByText(WebElement dropdownElement, String visibleText) {
        Select dropdown = new Select(waitForVisibility(dropdownElement));
        dropdown.selectByVisibleText(visibleText);
    }

    // ✅ Select dropdown by value
    public void selectByValue(WebElement dropdownElement, String value) {
        Select dropdown = new Select(waitForVisibility(dropdownElement));
        dropdown.selectByValue(value);
    }

    // ✅ Select dropdown by index
    public void selectByIndex(WebElement dropdownElement, int index) {
        Select dropdown = new Select(waitForVisibility(dropdownElement));
        dropdown.selectByIndex(index);
    }

    // ✅ Hover over WebElement
    public void hoverOver(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitForVisibility(element)).perform();
    }

    // ✅ Drag and drop using WebElements
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(waitForVisibility(source), waitForVisibility(target)).perform();
    }

    // ✅ Scroll to WebElement
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(element));
    }

    // ✅ Highlight WebElement (for debugging)
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", waitForVisibility(element));
    }

    // ✅ Take screenshot
    public static String takeScreenshot(String folderPath) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = folderPath + "/screenshot_" + UUID.randomUUID() + ".jpg";
        try {
            FileUtils.copyFile(src, new File(filename));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }
        return filename;
    }

    // ✅ Check if WebElement is displayed
    public boolean isDisplayed(WebElement element) {
        try {
            return waitForVisibility(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Check if WebElement is enabled
    public boolean isEnabled(WebElement element) {
        try {
            return waitForVisibility(element).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}