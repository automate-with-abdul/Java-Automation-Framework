package com.framework.pages;

import com.framework.utils.PageActionUtils;
import com.framework.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends PageActionUtils {
	private WebDriver driver = DriverFactory.getDriver();

    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitBtn = By.id("submit");
    private By outputBox = By.id("output");

    public void open() {
        DriverFactory.getDriver().get("https://demoqa.com/text-box");
        waitForPageLoad();
    }

    public void enterFullName(String name) { type(fullName, name); }
    public void enterEmail(String emailText) { type(email, emailText); }
    public void enterCurrentAddress(String address) { type(currentAddress, address); }
    public void enterPermanentAddress(String address) { type(permanentAddress, address); }
    public void clickSubmit() { click(submitBtn); }
    public boolean isOutputVisible() { return isElementVisible(outputBox); }
}