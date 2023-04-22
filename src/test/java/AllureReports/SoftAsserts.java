package AllureReports;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

public class SoftAsserts extends SoftAssert {

	public static List<String> status = new ArrayList<String>();
	public static Assertion sa = new SoftAssert();

	public static List<String> addStatus(String pf) {
		status.add(pf);
		return status;
	}

	public static void setfail(ITestResult result) {
		result.setStatus(2);
	}

	@Override
	public void onAssertSuccess(IAssert<?> assertCommand) {
		// TODO Auto-generated method stub
		addStatus("success");
		WebDriver driver = TestClass.driver;
		TestClass.test.pass("Screenshot of test",
				MediaEntityBuilder.createScreenCaptureFromBase64String(TestClass.CaptureScreen(driver)).build());
		System.out.println("onAssertSuccess");
		super.onAssertSuccess(assertCommand);
	}

	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		// TODO Auto-generated method stub
		addStatus("fail");
		System.out.println("onAssertFailure");
		super.onAssertFailure(assertCommand, ex);
	}

	@Override
	public void onBeforeAssert(IAssert<?> assertCommand) {
		// TODO Auto-generated method stub
		super.onBeforeAssert(assertCommand);
	}

	@Override
	public void onAfterAssert(IAssert<?> assertCommand) {
		System.out.println("After Soft Assert");
		// TODO Auto-generated method stub
		super.onAfterAssert(assertCommand);
	}

}
