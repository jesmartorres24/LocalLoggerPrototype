package MMA;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {

	public static By MetadataMangementButton = By.cssSelector("a[class*=\"metadata-user-option\"]");

	public static WebElement MetadataMangementButton(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(MetadataMangementButton);
	}

	public static By LandingPageHeader = By.cssSelector("InsertCSS");

	public static WebElement LandingPageHeader(SearchContext driver) throws NoSuchElementException {
		return driver.findElement(LandingPageHeader);
	}

}
