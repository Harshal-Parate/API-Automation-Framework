package in.org.services;

import in.org.allurereport.AllureLogger;
//import in.karza.pojos.data.kycocr.KycOcrFormData;
import io.restassured.response.Response;

import static in.org.services.ReqSpecCreationService.requestSpecification;
import static io.restassured.RestAssured.given;

public final class RequestCreationService {

	private RequestCreationService() {}

	private static final String REQUEST_IS_HIT = "Request is hit";

	public static <T> Response post(T payload, String endpoint) {
		Response response = given()
				.spec(requestSpecification())
				.body(payload)
				.when()
				.post(endpoint);
		AllureLogger.addAllureLog(REQUEST_IS_HIT);
		return response;
	}

	public static <T> Response post(T payload, String endpoint, String headerKey, String headerValue) {
		Response response = given()
				.spec(requestSpecification(headerKey, headerValue))
				.body(payload)
				.when()
				.post(endpoint);
		AllureLogger.addAllureLog(REQUEST_IS_HIT);
		return response;
	}

//	public static <T> Response post(T payload, String endpoint, List<KycOcrFormData> formData) {
//		Response response = given()
//				.spec(requestSpecification(formData))
//				.body(payload)
//				.when()
//				.post(endpoint);
//		AllureLogger.addAllureLog(REQUEST_IS_HIT);
//		return response;
//	}
}
