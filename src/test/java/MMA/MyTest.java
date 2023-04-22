package MMA;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import TestClass.ExtentLogger;

public class MyTest {

    @BeforeSuite
    public void setUp() {
        ExtentLogger.createReport("extent-report.html");
    }

    @AfterSuite
    public void tearDown() {
        ExtentLogger.flush();
    }

    @Test
    public void testMethod1() {
        ExtentLogger.createTest("Test Method 1");

        // Perform test actions and log results using ExtentLogger
        ExtentLogger.log("Test action 1");
        ExtentLogger.PASS("Test action 1 passed");
        ExtentLogger.log("Test action 2");
        ExtentLogger.FAIL("Test action 2 failed");
    }

    @Test
    public void testMethod2() {
        ExtentLogger.createTest("Test Method 2");

        // Perform test actions and log results using ExtentLogger
        ExtentLogger.log("Test action 1");
        ExtentLogger.PASS("Test action 1 passed");
        ExtentLogger.log("Test action 2");
        ExtentLogger.PASS("Test action 2 passed");
    }
}
