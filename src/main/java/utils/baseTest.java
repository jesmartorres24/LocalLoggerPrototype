package utils;

import static io.restassured.RestAssured.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class baseTest {

	public static ExtentTest test;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static WebDriver driver;
	public static String suiteName, file;
	public Properties prop;
	String frontend, backend;

	// Extent Reports Other functions
	// Can filter specific tests depending on status (PASS,FAIL,SKIP,FATAL)
	// htmlReporterFailedOnly = new
	// ExtentSparkReporter("path").filter().statusFilter().as(new Status[]
	// {Status.FAIL}).apply();
	// extent attachReporter (htmlReporter, htmlReporterFailedOnly)

	public void extentreporter(ITestContext ctx) throws IOException {
		// Load property file
		prop = new Properties();
		String userDirectory = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(userDirectory + "\\extentreports\\details.properties");
		prop.load(fis);
		String author = prop.getProperty("author");
		String category = prop.getProperty("category");
		frontend = prop.getProperty("frontend");
		backend = prop.getProperty("backend");

		System.out.println(frontend);
		System.out.println(backend);
		// start reporters

		suiteName = ctx.getSuite().getName();
		extent = new ExtentReports();
		file = "extentreports\\" + fileName(suiteName) + ".html";
		htmlReporter = new ExtentSparkReporter(file).viewConfigurer().viewOrder()
				.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();

		// get reporter config from JSON file

		final File CONF = new File("extentreports\\sparkconfig.json"); // path of json file
		htmlReporter.loadJSONConfig(CONF); // initialize json config

		try {
			if (frontend.contains("true") && backend.contains("false")) {
				System.out.println("Initializing WebDriver");
				driver = new ChromeDriver();

				// Get Browser info
				Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
				String browserName = caps.getBrowserName();
				String browserVer = caps.getBrowserVersion();
				String device = browserName + " " + browserVer;

				// Initialize WebDriver
				System.setProperty("webdriver.chrome.driver", "C:\\selenium-drivers\\chromedriver.exe");
				driver.manage().window().maximize();

				// create ExtentReports and attach reporter(s)
				extent.attachReporter(htmlReporter);
				// test = extent.createTest(suiteName, suiteName + "
				// Test").assignAuthor(author).assignDevice(device)
				// .assignCategory(category);
			} else if (backend.contains("true") && frontend.contains("false")) {
				System.out.println("Initializing Backend config..");
				RestAssured.useRelaxedHTTPSValidation();
				config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
				// create ExtentReports and attach reporter(s)
				extent.attachReporter(htmlReporter);
				// test = extent.createTest(suiteName, suiteName + "
				// Test").assignAuthor(author).assignCategory(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	@AfterSuite
	public void tearDown() throws IOException {
		extent.flush();
		if (frontend.contains("true")) {
			driver.close();
		}
		// Desktop.getDesktop().browse(new File(file).toURI());

	}

	/*
	 * @AfterMethod public void scanMethod(ITestResult res) { // if
	 * (test.getStatus().equals(Status.FAIL)) { // res.setStatus(2); //
	 * System.out.println(res.getMethod().getMethodName() + "failed"); // } }
	 */

	public static String CaptureScreen(WebDriver driver) {
		TakesScreenshot newScreen = (TakesScreenshot) driver;
		String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
		return "data:image/jpg;base64, " + scnShot;
	}

	public static Media Screenshot() {
		return MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreen(driver)).build();
	}

	public String fileName(String name) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
		Date date = new Date();
		String getTime = formatter.format(date);
		String reportfileName = getTime + " - " + name;
		return reportfileName;
	}

	public static String date() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
		Date date = new Date();
		String getTime = formatter.format(date);
		String reportfileName = getTime;
		return reportfileName;
	}

}
