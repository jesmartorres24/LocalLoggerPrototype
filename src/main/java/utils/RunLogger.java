package utils;

import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.Status;

public class RunLogger extends baseTest {

	public static List<String> failtest = new ArrayList<String>();

	public void PASS(String Stepdesc) {
		System.out.println(Stepdesc);
		test.log(Status.PASS, Stepdesc);
	}

	public void INFO(String Stepdesc) {
		System.out.println(Stepdesc);
		test.log(Status.INFO, Stepdesc);
	}

	public static void fail(String stepdesc) {
		test.log(Status.FAIL, stepdesc);
		failtest.add(stepdesc);
	}
	
	public static void createTest(String Name) {
		test= extent.createTest(Name, Name + " description");
	}
}
