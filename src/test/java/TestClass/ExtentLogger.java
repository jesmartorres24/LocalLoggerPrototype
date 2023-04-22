package TestClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentLogger {

	private static ExtentReports extent;
	static ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static ExtentReports createReport(String reportName) {
		extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportName + ".html");
		htmlReporter.config().setDocumentTitle(reportName);
		extent.attachReporter(htmlReporter);
		return extent;

	}

	public static ExtentReports initializeExtentReporter() {
		extent = new ExtentReports();
		return extent;
	}

	public void setStepDesc(String message) {
		extentTest.get().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
	}

	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		extentTest.set(test);
		System.out.println(testName + " started");
		System.out.println("createTest is called");
		return test;
	}

	public static void log(String message) {
		extentTest.get().info(message);
	}

	public static void PASS(String message) {
		extentTest.get().pass(message);
	}

	public static void FAIL(String message) {
		test.log(Status.FAIL, message);
	}

	public static void SKIP(String message) {
		extentTest.get().skip(message);
	}

	public static void flush() {
		extent.flush();
	}
}
