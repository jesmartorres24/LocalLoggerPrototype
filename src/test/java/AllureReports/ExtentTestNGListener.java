package AllureReports;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestNGListener implements ITestListener {

	private ExtentReports extent;
	private Map<Long, ExtentTest> parentTestMap = new HashMap<Long, ExtentTest>();

	@Override
	public synchronized void onStart(ITestContext context) {
		String reportName = context.getCurrentXmlTest().getName() + ".html";
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/test-output/" + reportName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest parent = extent.createTest(result.getMethod().getMethodName());
		parentTestMap.put(Thread.currentThread().getId(), parent);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		parentTestMap.get(Thread.currentThread().getId()).pass("Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		parentTestMap.get(Thread.currentThread().getId()).fail(result.getThrowable());
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		parentTestMap.get(Thread.currentThread().getId()).skip(result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
}