package MMA;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.baseTest;

//@Listeners(extentReportListeners.class)
public class test1{
	
	ExtentTest test;
	
	@Test
	public void testMethod1() {
	    // Create an instance of ExtentTest
	    // Add logs to the test
	    test.log(Status.INFO, "Test started");
	    // Perform test steps
	    // Add assertion to the test
	    // Mark the test as pass
	    test.pass("Test passed");
	}
	
	@Test
	public void testMethod2() {
	    // Create an instance of ExtentTest
	    // Add logs to the test
	    test.log(Status.INFO, "Test started");
	    // Perform test steps
	    // Add assertion to the test
	    // Mark the test as pass
	    test.fail("Test failed");
	}


}
