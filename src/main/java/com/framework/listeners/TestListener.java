package com.framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.driver.BaseTest;
import com.framework.reports.ExtentManager;
import com.framework.utils.ScreenshotUtils;

import java.io.IOException;

import org.testng.*;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.initReports();
        extent = ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

        // ✅ Assign browser category
        String browser = BaseTest.getBrowserName();
        extentTest.assignCategory(browser);
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest extentTest = test.get();
        extentTest.pass("Test Passed");

        String screenshotPath = ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
        extentTest.addScreenCaptureFromPath(screenshotPath, "Screenshot on Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = test.get();
        extentTest.fail(result.getThrowable());

        String screenshotPath = ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
        extentTest.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReports();
    }
}
