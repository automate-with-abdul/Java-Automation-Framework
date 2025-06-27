package com.framework.pages;

import com.framework.driver.DriverFactory;
import com.framework.utils.PageActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends PageActionUtils{

    private WebDriver driver = DriverFactory.getDriver();
    private By searchBox = By.name("q");
    private By resultLinks = By.cssSelector("a h3");
    private By acceptCookies = By.xpath("//div[text()='Accept all' or text()='I agree']");

    public void open(String url) {
        driver.get(url);
        waitForPageLoad();
    }

    public void acceptCookiesIfVisible() {
        if (isElementVisible(acceptCookies)) {
            click(acceptCookies);
        }
    }

    public void search(String keyword) {
        type(searchBox, keyword);
        submit(searchBox);
    }

    public int getResultCount() {
        return driver.findElements(resultLinks).size();
    }

    public void clickFirstResult() {
        driver.findElements(resultLinks).get(0).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
