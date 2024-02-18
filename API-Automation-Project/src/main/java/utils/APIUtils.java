package utils;

import io.restassured.response.Response;

public class APIUtils {

	public static String extractValueFromResponse(Response response, String key) {
		return response.path(key);
	}

}
