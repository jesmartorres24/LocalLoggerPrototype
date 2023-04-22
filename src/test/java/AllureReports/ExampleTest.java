package AllureReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;

import org.testng.annotations.*;

public class ExampleTest {
    
    ExtentReports extent;
    ExtentTest logger;
    
    @BeforeTest
    public void beforeTest() {
        // Create ExtentReports and attach the HTML reporter
        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/extent-report.html");
        extent.attachReporter(htmlReporter);
    }
    
    @BeforeMethod
    public void beforeMethod(Method method) {
        // Create ExtentTest and set the test name
        logger = extent.createTest(method.getName());
    }
    
    @Test
    public void testMethod1() {
        // Log test steps and status to ExtentTest
        logger.log(Status.INFO, "Starting test method 1");
        logger.pass("Test method 1 passed");
    }
    
    @Test
    public void testMethod2() {
        // Log test steps and status to ExtentTest
        logger.log(Status.INFO, "Starting test method 2");
        logger.fail("Test method 2 failed");
    }
    
    @AfterMethod
    public void afterMethod() {
        // End the test and flush the ExtentReports object
        extent.flush();
    }
    
    @AfterTest
    public void afterTest() {
        // Close the ExtentReports object
      //  extent.close();
    }
}
