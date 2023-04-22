package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {

	public static By usernameField = By.cssSelector("input[name=username]");

	public static WebElement usernameField(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(usernameField);
	}

	public static By passwordField = By.cssSelector("input[name=password]");

	public static WebElement passwordField(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(passwordField);
	}

	public static By loginButton = By.cssSelector("input[type=submit]");

	public static WebElement loginButton(SearchContext driver) throws NoSuchElementException {
	
		return driver.findElement(loginButton);
	}

	

}


