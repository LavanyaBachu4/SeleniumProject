package listener;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import factory.BrowserFactory;
import helper.ExtentManager;
import helper.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BrowserFactory implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result){
        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.pass("Test Executed Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result){
        String screenShot = Utility.takeScreenShotForReport(driver);
//        test.fail("Test Failed "+result.getThrowable().getMessage());
        test.fail("test failed"+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        test.skip("Test Skipped "+result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context)
    {

        extent.flush();
    }
}
