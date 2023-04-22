package MMA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class initializeWebDriver {

	public static WebDriver driver;

	public static WebDriver loadWebDriver() {
		System.setProperty("webdriver.edge.driver", "C:\\selenium-drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
