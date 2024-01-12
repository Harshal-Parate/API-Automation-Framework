package in.org.services;

import in.org.allurereport.AllureLogger;
import io.restassured.response.Response;

public final class ResponseParserService {

	private ResponseParserService() {}

	public static <T> T parse(Response response, Class<T> className) {
		T extractedResponse = response.as(className);
		AllureLogger.addAllureLog("Response is deserialized");
		return extractedResponse;
	}
}
