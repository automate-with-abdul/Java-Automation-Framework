package com.framework.pages;

import com.framework.utils.PageActionUtils;
import com.framework.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends PageActionUtils {

    private WebDriver driver = DriverFactory.getDriver();

    private By expandAll = By.cssSelector("button[title='Expand all']");
    private By checkHome = By.cssSelector("span[class='rct-title']");

    public void open() {
        driver.get("https://demoqa.com/checkbox");
        waitForPageLoad(); // directly inherited from PageActionUtils
    }

    public void expandTree() {
        click(expandAll); // inherited from PageActionUtils
    }

    public void checkHomeOption() {
        click(checkHome);
    }

    public boolean isChecked(String labelText) {
        return driver.getPageSource().toLowerCase().contains(labelText.toLowerCase());
    }
}
