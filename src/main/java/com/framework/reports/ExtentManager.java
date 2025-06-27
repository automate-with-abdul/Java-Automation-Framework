package com.framework.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public static ExtentReports getInstance() {
        return extentReports;
    }

    public static void initReports() {
        try {
            FileUtils.cleanDirectory(new File("test-output/screenshots"));
        } catch (IOException e) {
        	Reporter.log("Failed: " + e.getMessage(), true); // ✅ Correct

        }

        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentSparkReport.html");
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Execution Summary");

        extentReports.attachReporter(spark);
    }

    public static void flushReports() {
        extentReports.flush();
    }
    
    
}
