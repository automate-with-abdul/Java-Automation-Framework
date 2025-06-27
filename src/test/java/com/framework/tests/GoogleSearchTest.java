package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.driver.BaseTest;
import com.framework.pages.GoogleHomePage;
import com.framework.utils.CommonUtils;
import com.framework.utils.PropertyUtils;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void verifyGoogleSearchAndClickFirstResult() {
        GoogleHomePage google = new GoogleHomePage();

        google.open(PropertyUtils.getProperty("baseUrl"));
        google.acceptCookiesIfVisible();

        String keyword = "Selenium WebDriver";
        google.search(keyword);

        CommonUtils.waitForSeconds(2);
        int count = google.getResultCount();
        Assert.assertTrue(count > 0, "No search results found!");

        google.clickFirstResult();

        CommonUtils.waitForSeconds(2);
        String title = google.getPageTitle();
        Assert.assertTrue(title.toLowerCase().contains("selenium"), "Page title does not contain expected keyword");
    }
}
