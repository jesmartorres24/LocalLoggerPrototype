package AllureReports;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class sandbox_PageActions  {

	public static Assertion sa = new SoftAsserts();
	
	public static void getLogin() {
		System.out.println("getLogin is initiated");
	}

	@Test
	public static void SoftAssertFail() {
		try {
			sa.assertTrue(false);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
		}
	}

	@Test
	public static void passtest() {
		try {
			sa.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
		}
	}

	public static void hardAssert1(String one) {
		sa.assertEquals(one, "onew");
	}

	public static void softAssert1pass() {
		try {
			sa.assertTrue(true);
			System.out.println("soft pass");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
	}

	public static void softAssert2fail() {
		try {
			sa.fail();
			System.out.println("Fail");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
		}
	}

}
