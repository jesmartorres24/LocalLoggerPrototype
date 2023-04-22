package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	public static By AccountNavigationPanel = By.cssSelector("#leftPanel");

	public static WebElement AccountNavigationPanel(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(AccountNavigationPanel);
	}
	
	public static By LogOutButton = By.cssSelector("a[href=\"/parabank/logout.htm\"]");

	public static WebElement LogOutButton(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(LogOutButton);
	}
}
