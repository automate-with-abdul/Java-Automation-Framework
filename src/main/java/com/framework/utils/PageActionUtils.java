package com.framework.utils;

import com.framework.driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class PageActionUtils {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public PageActionUtils() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void click(By locator) {
        Reporter.log("Clicking element: " + locator.toString(), true);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text) {
        Reporter.log("Typing '" + text + "' into: " + locator.toString(), true);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void submit(By locator) {
        Reporter.log("Submitting element: " + locator.toString(), true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).submit();
    }

    public String getText(By locator) {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        Reporter.log("Text from " + locator.toString() + " is: " + text, true);
        return text;
    }

    public boolean isElementVisible(By locator) {
        try {
            boolean visible = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
            Reporter.log("Element visible: " + locator.toString(), true);
            return visible;
        } catch (TimeoutException e) {
            Reporter.log("Element not visible: " + locator.toString(), true);
            return false;
        }
    }

    public void waitForElementVisible(By locator) {
        Reporter.log("Waiting for element to be visible: " + locator.toString(), true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForPageLoad() {
        Reporter.log("Waiting for page to load completely", true);
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void moveToElement(By locator) {
        Reporter.log("Moving to element: " + locator.toString(), true);
        actions.moveToElement(driver.findElement(locator)).perform();
    }
}

