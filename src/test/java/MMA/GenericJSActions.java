package MMA;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericJSActions {
	public static void jsElementClick(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
	}
	
	public static void pseudoElementClick(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0],':before'.click();", element);
	}

	/** Used to return the 'content' value of the psuedoelement
	 * @param driver
	 * @param element
	 * @param psuedoelement - :after, :before
	 * @return
	 * @throws Exception
	 */
	public static String getPsuedoElementContent(WebDriver driver, WebElement element, String psuedoelement) throws Exception {
		String webElem = element.toString();
		webElem = webElem.substring(webElem.indexOf("css selector: ") + 14, webElem.length() - 1);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		return (String) jse.executeScript("return window.getComputedStyle(document.querySelector('" + webElem + "'),':" + psuedoelement + "').getPropertyValue('content')");
	}

	/** Used to check if the psuedoelement is visible
	 * @param driver
	 * @param element
	 * @param psuedoelement - :after, :before
	 * @return
	 * @throws Exception
	 */
	public static boolean psuedoElementCheckVisibility(WebDriver driver, WebElement element, String psuedoelement) throws Exception {
		String webElem = element.toString();
		webElem = webElem.substring(webElem.indexOf("css selector: ") + 14, webElem.length() - 1);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String text = (String) jse.executeScript("return window.getComputedStyle(document.querySelector('" + webElem + "'),':" + psuedoelement + "').getPropertyValue('visibility')");
		if (text.equals("visible")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void changeElementText(WebDriver driver, WebElement element, String text) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].innerText = '" + text + "';", element);
	}
	
	public static void jsAudioPlay(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].play();", element);
	}
	
	public static void jsAudioPause(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].pause();", element);
	}
	
	public static void jsAudioMute(WebDriver driver, WebElement element, boolean mute) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].muted = " + Boolean.toString(mute).toLowerCase(), element);
	}
	
	public static void jsAudioVolume(WebDriver driver, WebElement element, String volume) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].volume = " + volume + ";", element);
	}
	
	public static boolean jsCheckAudioPauseState(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		return Boolean.valueOf(jse.executeScript("return arguments[0].paused", element).toString());
	}
	
	public static boolean jsCheckAudioMuteState(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		return Boolean.valueOf(jse.executeScript("return arguments[0].muted", element).toString());
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement elem) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(false);", elem);
	}
	
	public static void scrollDownToDesiredLength(WebDriver driver, String height) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, "+ height +");");
	}
	
	public static void scrollToBottom (WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
	
	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, 0);");
	}
	
	public static String JsRunner(WebDriver driver,String JsScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		return (String) js.executeScript(JsScript);
	}
}
