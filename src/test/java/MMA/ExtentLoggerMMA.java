package MMA;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentLoggerMMA {

	private static ExtentReports extent;
	static ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	static Date date = new Date();

	static long startTime, endTime, totalTime;
	static List<String> runTimeList = new ArrayList<String>();
	static int i = 0;
	static int j = 0;

	// Timer

	public static long startTimer() {
		startTime = System.currentTimeMillis();
		return startTime;
	}

	public static long endTime() {
		endTime = System.currentTimeMillis();
		return endTime;
	}

	public static int counter() {
		i++;
		return i;
	}

	public static int counter2() {
		return j++;
	}

	public static long totalTime() {
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		return totalTime;
	}

	public static boolean recordRunTime() {
		return runTimeList.add(Long.toString(totalTime));
	}

	/////////////////////////////////////////////////////

	public static ExtentReports createReport(String reportName) throws IOException {
		extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportName + ".html");
		htmlReporter.config().setDocumentTitle(reportName);
		final File CONF = new File("extentreports\\sparkconfig.json"); // path of json file
		htmlReporter.loadJSONConfig(CONF); // initialize json config
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
		return test;
	}

	public static void LOG(String message) {
		startTimer();
		extentTest.get().info(message);
		System.out.println(test.getStatus().getName());
	}

	public static void PASS(String message) {
		extentTest.get().pass(message, Screenshot());
		totalTime();
		recordRunTime();
	}

	public static void FAIL(String message) {
		test.log(Status.FAIL, message, Screenshot());
		totalTime();
		recordRunTime();
	}

	public static void SKIP(String message) {
		extentTest.get().skip(message);
		totalTime();
		recordRunTime();
	}

	public static void flush() {
		extent.flush();
	}

	public static String CaptureScreen(WebDriver driver) {
		TakesScreenshot newScreen = (TakesScreenshot) driver;
		String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
		return "data:image/jpg;base64, " + scnShot;
	}

	public static Media Screenshot() {
		return MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreen(initializeWebDriver.driver))
				.build();
	}
}
