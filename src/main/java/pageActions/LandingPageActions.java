package pageActions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GenericActions.GenericPageWaits;
import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObject;
import utils.SoftAssertsWithExtentReports;
import utils.baseTest;

public class LandingPageActions extends SoftAssertsWithExtentReports {

	public static void enterCredentialsAndClickLogin(WebDriver driver, ExtentTest logger) throws Exception {
		try {
			logger.log(Status.INFO, "Enter Credential and click login");

			String name = "john";
			String password = "1234";

			LandingPageObjects.usernameField(driver).sendKeys(name);
			LandingPageObjects.passwordField(driver).sendKeys(password);
			LandingPageObjects.loginButton(driver).click();
			Thread.sleep(1000);
			GenericPageWaits.waitElementVisible(driver, LoginPageObject.LogOutButton, 3);

			logger.log(Status.PASS, "Successfully login", baseTest.Screenshot());
		} catch (Exception e) {
			logger.log(Status.FAIL, "Login unsucessful", baseTest.Screenshot());
//			logger.fail(MarkupHelper.createLabel("Login unsucessful", ExtentColor.RED));
//			logger.fail(baseTest.Screenshot());
			e.printStackTrace();
		} finally {

		}
	}

}
