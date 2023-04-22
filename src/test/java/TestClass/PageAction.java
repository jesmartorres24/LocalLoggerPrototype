package TestClass;

public class PageAction {

	public static void Pass() {
		try {
			ExtentLogger.PASS("Pass");
		} catch (Exception e) {
			ExtentLogger.FAIL("Fail");
		}
	}

	public static void Fail() {
		ExtentLogger.FAIL("Fail");
	}
}
