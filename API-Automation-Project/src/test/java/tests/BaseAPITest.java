package tests;
import org.testng.annotations.BeforeClass;
import config.APIConfig;
import io.restassured.RestAssured;

public class BaseAPITest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = APIConfig.getBaseURL();
	}

}
