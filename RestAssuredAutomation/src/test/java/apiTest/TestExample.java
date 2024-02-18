package apiTest;

import org.apache.hc.core5.util.Asserts;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestExample {

	private static final Logger Log = LogManager.getLogger(Log.class);
	static ExtentTest test;
	static ExtentReports extent;
	RestAssured baseURI;

	@BeforeTest
	public static void startTest() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("extent-report.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		// Get the method name from ITestContext
		// Get the method name directly
		//String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// test = extent.createTest(methodName);

	}

	@Test
	public void getRequest() {
		try {

			test = extent.createTest("Navigation API");
			
			test.log(Status.INFO, "Hitting API");
			Response response = RestAssured.get("https://www.nykaa.com/getNavigation.php");

            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "Response Code: " + statusCode);
			System.out.println(response.getStatusCode());
			Assert.assertEquals(statusCode, 200);

            long responseTime = response.getTime();
            test.log(Status.INFO, "Response Time: " + responseTime + " milliseconds");
			System.out.println(response.getTime());
			
            String statusLine = response.getStatusLine();
            test.log(Status.INFO, "Status Line: " + statusLine);
			System.out.println(response.getStatusLine());
		
            String headers = response.getHeaders().toString();
            test.log(Status.INFO, "Headers: " + headers);
			System.out.println(response.getHeaders());
/*			
			// Log the response body
            test.log(Status.INFO, "Get Response Body");
            String responseBody = response.getBody().asString();
            test.log(Status.INFO, "Response Body: " + responseBody);
            System.out.println(response.getBody().asString());
*/
		} catch (Exception e) {
			Log.error("Exception occurred: " + e.getMessage());
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
		}

	}
	
	@Test
	public void test2() {
		test = extent.createTest("PD API");
		RestAssured.baseURI = "https://www.nykaa.com/app-api/index.php/products/details?";
		// Make the request
		RestAssured.given()
                .queryParam("app_version", "2.0.6")
                .queryParam("enable_pr", 1)
                .queryParam("product_id", 31074)
                .queryParam("source", "react")
                .queryParam("variants", true)
                .when()
                .get()
                .then()
                .statusCode(200);
        
       /* 
		given().get("app_version=2.0.6&enable_pr=1&product_id=31074&source=react&variants=true").
		then().
		statusCode(200);
		*/
	}

	@AfterTest
	public static void endTest() {
		extent.flush();
	}

}
