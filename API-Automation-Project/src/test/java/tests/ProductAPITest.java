package tests;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import utils.APIUtils;

public class ProductAPITest extends BaseAPITest {

	@Test
	public void testGetProductDetails() {
		//io.restassured.response.Response response = RestAssured.given().when().get("/products/123"); // Replace with the actual product ID
		io.restassured.response.Response response = RestAssured.given().when().get("");
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200, "Status code is not as expected.");

//		String productName = APIUtils.extractValueFromResponse(response, "name");
//		assertEquals(productName, "Sample Product", "Product name is incorrect.");

		// Add more assertions for other product details
	}

}
