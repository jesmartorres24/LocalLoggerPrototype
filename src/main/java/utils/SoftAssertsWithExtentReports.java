package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;


public class SoftAssertsWithExtentReports extends SoftAssert {

	public static List<String> status = new ArrayList<String>();
	public static Assertion sa = new SoftAssert();
	WebDriver driver = baseTest.driver;

	public static List<String> addStatus(String pf) {
		status.add(pf);
		return status;
	}

	@Override
	public void onAssertSuccess(IAssert<?> assertCommand) {
		// TODO Auto-generated method stub
		addStatus("success");
		System.out.println("Soft Assert Success");
		super.onAssertSuccess(assertCommand);
	}

	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		// TODO Auto-generated method stub
		addStatus("fail");
		super.onAssertFailure(assertCommand, ex);
	}

	@Override
	public void onBeforeAssert(IAssert<?> assertCommand) {
		// TODO Auto-generated method stub
		super.onBeforeAssert(assertCommand);
	}

	@Override
	public void onAfterAssert(IAssert<?> assertCommand) {
		// TODO Auto-generated method stub
		// sa.assertAll();
		super.onAfterAssert(assertCommand);
	}

}
