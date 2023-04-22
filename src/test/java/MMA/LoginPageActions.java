package MMA;

import org.openqa.selenium.WebDriver;

public class LoginPageActions {

	public static void EnterLoginCredentialsAndClickLogin(WebDriver driver) throws Exception {
		try {
			ExtentLoggerMMA.LOG("Login to MMA v2");
			// logger.setExpectedResult("Users will be able to enter their login credentials
			// and click Sign In button.");
			GenericPageWaits.waitElementVisible(driver, LoginPageObjects.EnterUsernameTextField);
			LoginPageObjects.EnterUsernameTextField(driver).sendKeys(MMADataFactory.email);
			LoginPageObjects.EnterPasswordTextField(driver).sendKeys(MMADataFactory.pw);
			GenericJSActions.scrollIntoView(driver, LoginPageObjects.SignInButton(driver));
			LoginPageObjects.SignInButton(driver).click();
			GenericPageWaits.waitElementVisible(driver, LoginPageObjects.OktaPreviewSignContainer);
			ExtentLoggerMMA.PASS("User Entered login credentials and click Sign In button successfully.");
		} catch (Exception e) {
			ExtentLoggerMMA.FAIL(
					"User is not able to enter Sign In credentials.User is not able to enter Sign In credentials.");
		}
	}

	public static void EnterOktaSecurityQuestionAnswerAndClickVerify(WebDriver driver) throws Exception {
		try {
			ExtentLoggerMMA.LOG("User will input the answer to the Security Question then click verify");
			// ExtentLogger.setExpectedResult("User will be able to input answer and click
			// verify");
			LoginPageObjects.OktaSecurityQuestionAnswerTextField(driver).sendKeys(MMADataFactory.okta);
			LoginPageObjects.OktaSecurityQuestionAnswerVerifyButton(driver).click();
			ExtentLoggerMMA.PASS("User successfully entered security question answer and click verify");
		} catch (Exception e) {
			ExtentLoggerMMA.FAIL("User did not successfully enter security question or click verify");
			e.printStackTrace();
		} finally {
		}
	}

}
