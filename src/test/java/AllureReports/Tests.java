package AllureReports;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class Tests {

	WebDriverWait wait;
	WebDriver driver;
	String email, pass;

	@BeforeClass
	public void initiateDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driver = driver;
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@AfterClass
	public void tearDown() {
		try {
			Process p = Runtime.getRuntime()
					.exec("cmd /c allure serve " + System.getProperty("user.dir") + "/allure-results");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		File folder = new File(System.getProperty("user.dir") + "/allure-results");
//		for (File f : folder.listFiles()) {
//		    if (f.getName().endsWith(".json")) {
//		        f.delete(); // may fail mysteriously - returns boolean you may want to check
//		    }
//		}
		driver.quit();
	}

	@Test
	@Description("enter email and password")
	@Epic("EP001")
	@Feature("Check image and search")
	@Story("Check image and search")
	@Step("check google logo")
	@Severity(SeverityLevel.MINOR)
	public void step01() {
		try {
			if (driver.findElement(By.cssSelector("[class=\"lnXdpd\"]")).isDisplayed()) {
				System.out.println("pass");
			} else {
				System.out.println("fail");
			}
		} catch (Exception e) {

		}
	}

	@Test
	@Description("Click login button and check if image appears on redirected page")
	@Epic("EP001")
	@Feature("Check image and search")
	@Story("Check image and search")
	@Step("click search")
	@Severity(SeverityLevel.BLOCKER)
	public void step02() {
		try {
			String text = "something";
			driver.findElement(By.cssSelector("[class=\"gLFyf\"]")).sendKeys(text);
		} catch (Exception e) {

		}
	}

	@Test
	@Description("enter login credentials in other page")
	@Epic("EP001")
	@Feature("Check image and search")
	@Story("Story: enter login credentials in other page")
	@Step("Check image and search")
	public void step03() {
		try {

		} catch (Exception e) {

		}
	}

//	@Test
//	public void step04() {
//
//	}
//
//	@Test
//	public void step05() {
//
//	}
}
