package com.xalts.test.assignment_xalts_utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.xalts.test.assignment_xalts_base.BaseClass;




public class ListenerClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.captureScreenshot(BaseClass.getDriver(), result.getName());
        ExtentManager.createTest(result.getName()).fail("Test failed: " + result.getThrowable());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createTest(result.getName()).info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.createTest(result.getName()).pass("Test passed.");
    }

    
    
}