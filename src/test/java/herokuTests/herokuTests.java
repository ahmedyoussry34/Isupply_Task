package herokuTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import helpers.ui.herokuHelper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilis.SystemProperties;
import utilis.browserActions;
import utilis.screenshotUtils;

public class herokuTests {

    private String key;
    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void setup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        SystemProperties.setEnv("heroku app");
        key = String.valueOf(Thread.currentThread().getId());
        browserActions.addWebDriverToMapOfDrivers(browserActions.browser.Chrome, key);
    }

    @AfterMethod
    public void testFinish(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = screenshotUtils.captureScreenshot(browserActions.driverMap.get(key), result.getName());
            test.fail("Test failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            String screenshotPath = screenshotUtils.captureScreenshot(browserActions.driverMap.get(key), result.getName());
            test.pass("Test passed successfully!");
            test.addScreenCaptureFromPath(screenshotPath);
        }
        browserActions.closeDriverAndRemoveFromMap(key);
        report.flush();
    }

    @Test
    public void uploadFileTest(){
        herokuHelper helper = new herokuHelper();
        helper.fileUpload(key);
    }
    @Test
    public void dynamicLoadingTest(){
        herokuHelper helper = new herokuHelper();
        helper.dynamicLoading(key);
    }
}
