package GenericActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;



public class GenericBrowserActions {
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public static void openInNewTab(WebDriver driver, WebElement link) {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	public static void openInNewWindow(WebDriver driver, WebElement link) {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	
	public static void switchFrame(WebDriver driver, WebElement frame) {
		driver.switchTo().frame(frame);
	}
	
	public static void switchFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static void switchTab(WebDriver driver, String urlpart) {
		try {
			List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			for (String tab : tabs) {
				driver.switchTo().window(tab);
				if (driver.getCurrentUrl().contains(urlpart)) {
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void switchTab(WebDriver driver,int tabNumber ) {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNumber));
	}
	
	
	public static void navigateToURL(WebDriver driver, String newurl, int seconds) {
		driver.get(newurl);
		GenericPageWaits.waitPageLoad(driver, seconds);
	}
	
	public static void navigateBackOnce(WebDriver driver) {
		driver.navigate().back();
		GenericPageWaits.delay();
	}
	
	public static void closeTab(WebDriver driver, String urlpart) {
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    
		for (String tab : tabs) {
			driver.switchTo().window(tab);
			if (driver.getCurrentUrl().contains(urlpart)) {
				driver.close();
				GenericPageWaits.delay();
				break;
			}
		}
		
	    tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	}
	
	public static void returnToDefaultTab (WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static void acceptAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public static void dismissAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method sets the custom screen size of the window
	 * @param driver  - holds the Webdriver
	 * @param width  - holds the custom width of the window
	 * @param height - holds the custom height of the window
	 * @throws Exception - throws exceptions when there's an error within this method
	 * @author adeguzman
	 */
	public static void setScreenSize(WebDriver driver, int width, int height) throws Exception {
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
	}
	
	/**
	 * This method sets the maximum screen size of the window
	 * @param driver  - holds the Webdriver
	 * @throws Exception - throws exceptions when there's an error within this method
	 * @author adeguzman
	 */
	public static void setScreenMaximize(WebDriver driver) throws Exception {
		driver.manage().window().maximize();
	}
}
