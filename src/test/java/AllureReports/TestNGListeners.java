package AllureReports;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;

import utils.RunLogger;
import utils.baseTest;

public class TestNGListeners extends TestListenerAdapter implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	@Override
	public void onFinish(ITestContext testContext) {
		System.out.println("TEST IS DONE");
		System.out.println(RunLogger.failtest);
		super.onFinish(testContext);
	}

	public void onTestSkipped(ITestContext testContext) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + ": FAILED");
//		sandbox_Test.test.fail("Screenshot of " + result.getMethod().getMethodName(), MediaEntityBuilder
//				.createScreenCaptureFromBase64String(sandbox_Test.CaptureScreen(sandbox_Test.driver)).build());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		System.out.println(result.getMethod().getMethodName() + ": SUCCESS");
//		sandbox_Test.test.pass("Screenshot of " + result.getMethod().getMethodName(), MediaEntityBuilder
//				.createScreenCaptureFromBase64String(sandbox_Test.CaptureScreen(sandbox_Test.driver)).build());
	}

}
