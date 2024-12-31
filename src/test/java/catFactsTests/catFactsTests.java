package catFactsTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import helpers.api.catFacts;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilis.SystemProperties;

public class catFactsTests {

    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void setup() {
        // Set environment before each test
        SystemProperties.setEnv("cat facts");
        // Initialize ExtentReports and attach the SparkReporter
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ApiTests.html");
        report = new ExtentReports();
        report.attachReporter(spark);
    }

    @Test
    public void assertFactsIsNotEmpty() {
        // Create a new ExtentTest instance for the test method
        test = report.createTest("assertFactsIsNotEmpty");
        // Create an instance of catFacts and pass the test instance for logging
        catFacts facts = new catFacts(test);
        facts.getRandomCatFacts();  // Call the API and log results
    }

    @AfterMethod
    public void finish(ITestResult result) {
        // Log the test result in ExtentReports
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed.");
        }
        // Write the report to the file after the test completes
        report.flush();
    }
}
