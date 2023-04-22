package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class extentReportListeners implements ITestListener {

	ExtentReports extent = baseTest.extent;
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extent_test.set(test);
	}

	public void onTestSkipped(ITestResult result) {
		extent_test.get().skip(result.getThrowable());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Successful");
	}

	public void onTestFailure(ITestResult result) {
		extent_test.get().fail(result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
