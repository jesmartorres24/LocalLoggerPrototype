package AllureReports;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
 
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;
import pageActions.LandingPageActions;
import utils.RunLogger;
import utils.baseTest;

@Listeners(TestNGListeners.class)
public class TestClass extends baseTest {

	@Test
	public void NavigateToParabank() throws Exception {
		RunLogger.createTest("NavigateToParabank");
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		LandingPageActions.enterCredentialsAndClickLogin(driver, test);
		test.log(Status.INFO, "INFO");
		test.log(Status.PASS, "PASS");
		test.log(Status.FAIL, "FAIL");
		test.log(Status.SKIP, "SKIP");
		test.log(Status.WARNING, "WARNING");
	}

	@Test
	public void Something() {
		RunLogger.createTest("2nd @Test Method");
		test.log(Status.INFO, "INFO");
		test.log(Status.PASS, "PASS");
		test.log(Status.FAIL, "FAIL");
		test.log(Status.SKIP, "SKIP");
		test.log(Status.WARNING, "WARNING");
	}

	@Test
	public void RestAssuredTest() {
		String url = "https://mma-api-alb-qa-1601287166.ap-northeast-1.elb.amazonaws.com/v2/resources";
		baseURI = url;

		// Retrieve the body of the Response

		String WithCategoryID = given().header("x-api-key", "secret").when().get("/categories/a1b7f7f6-a850-fa8d-acf2-18bcf0655187").getBody().asPrettyString();
		
	
	
		System.out.println(WithCategoryID);
		String getJSONBodyContent = given().header("x-api-key", "secret").when()
				.get("/categories/a1b7f7f6-a850-fa8d-acf2-18bcf0655187").then().body("data.name", equalTo("English")).toString();
		System.out.println(getJSONBodyContent);


//		test.log(Status.INFO, Templates.jsonPrettyFormat(WithCategoryID));
//		test.log(Status.PASS, Templates.jsonPrettyFormat(WithCategoryID));
//		test.log(Status.FAIL, Templates.jsonPrettyFormat(WithCategoryID));
//		test.log(Status.WARNING, Templates.jsonPrettyFormat(WithCategoryID));
//		test.log(Status.SKIP, Templates.jsonPrettyFormat(WithCategoryID));
	}
}
