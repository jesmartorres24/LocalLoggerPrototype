package MMA;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class MMA_TS001 {

	static WebDriver driver;

	@BeforeTest
	public static WebDriver initializeDriver() {
		driver = initializeWebDriver.loadWebDriver();
		driver.get("https://meta-qa.cambridgeone.org/login");
		return driver;
	}

	@BeforeTest
	public static ExtentReports createTest() throws IOException {
		return ExtentLoggerMMA.createReport("MMA TEST");
	}

	@AfterSuite
	public void tearDown() {
		ExtentLoggerMMA.flush();
		driver.quit();
		System.out.println("Log Test");
	}

	@Test
	public void UserLogin() {
		try {
			ExtentLoggerMMA.createTest("LoginTest");
			LoginPageActions.EnterLoginCredentialsAndClickLogin(driver);
			GenericPageWaits.delay(5);
			LoginPageActions.EnterOktaSecurityQuestionAnswerAndClickVerify(driver);
			GenericPageWaits.waiteElementToBeClickable(driver, LandingPageObjects.MetadataMangementButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void NavigateToMetadataManagementPage() {
		try {
			ExtentLoggerMMA.createTest("User will click metadata management");
			GenericPageWaits.waitElementVisible(driver, MetadataManagerPageObjects.MetadataManagerHeader);
			LandingPageActions.ClickMetadataManagementButton(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
