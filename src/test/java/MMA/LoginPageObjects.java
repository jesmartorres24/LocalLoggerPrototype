package MMA;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	public static By EnterUsernameTextField = By.cssSelector("input[name=\"username\"]");

	public static WebElement EnterUsernameTextField(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(EnterUsernameTextField);
	}

	public static By EnterPasswordTextField = By.cssSelector("input[type=\"password\"]");

	public static WebElement EnterPasswordTextField(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(EnterPasswordTextField);
	}

	public static By SignInButton = By.cssSelector("input[id=\"okta-signin-submit\"]");

	public static WebElement SignInButton(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(SignInButton);
	}

	public static By SignInButton_Allure = By.cssSelector("input[id=\"okta-signin-sumit\"]");

	public static WebElement SignInButton_Allure(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(SignInButton_Allure);
	}

	public static By OktaPreviewSignContainer = By.cssSelector("div[id=\"okta-signin-container\"]");

	public static WebElement OktaPreviewSignContainer(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(OktaPreviewSignContainer);
	}

	public static By OktaSecurityQuestionAnswerTextField = By.cssSelector("input[placeholder=\"Answer\"]");

	public static WebElement OktaSecurityQuestionAnswerTextField(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(OktaSecurityQuestionAnswerTextField);
	}

	public static By OktaSecurityQuestionAnswerVerifyButton = By.cssSelector("input[class=\"button button-primary\"]");

	public static WebElement OktaSecurityQuestionAnswerVerifyButton(SearchContext driver)
			throws NoSuchElementException {
		return driver.findElement(OktaSecurityQuestionAnswerVerifyButton);
	}

}
