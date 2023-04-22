package MMA;

import org.openqa.selenium.WebDriver;

public class LandingPageActions {
	
	public static void ClickMetadataManagementButton(WebDriver driver) throws Exception {
		try {
			ExtentLoggerMMA.LOG("User will click Metadata Management button");
			//logger.setExpectedResult("User will be able to click and redirected to metadata managment page");
			GenericJSActions.scrollIntoView(driver, LandingPageObjects.MetadataMangementButton(driver));
			GenericPageWaits.waiteElementToBeClickable(driver, LandingPageObjects.MetadataMangementButton);
			LandingPageObjects.MetadataMangementButton(driver).click();
			ExtentLoggerMMA.PASS("User is able to click metadata management button");
		} catch (Exception e) {
			ExtentLoggerMMA.FAIL("Element is not located");
			e.printStackTrace();
		} finally {
		}
	}

}
