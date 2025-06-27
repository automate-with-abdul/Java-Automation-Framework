package com.framework.driver;

import com.framework.listeners.TestListener;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest {

    protected static ThreadLocal<String> currentBrowser = new ThreadLocal<>();

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browserName) {
        currentBrowser.set(browserName);
        DriverFactory.initDriver(browserName);
    }

    public static String getBrowserName() {
        return currentBrowser.get();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

