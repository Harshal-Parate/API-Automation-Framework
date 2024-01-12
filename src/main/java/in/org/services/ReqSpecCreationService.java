package in.org.services;

//import in.karza.pojos.data.kycocr.KycOcrFormData;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Optional;

import static in.org.config.FrameworkConfigFactory.createConfigFactory;

public final class ReqSpecCreationService {

	private ReqSpecCreationService() {}

	private static RequestSpecification request;

	public static RequestSpecification requestSpecification() {
		return Optional.ofNullable(request)
				.orElse(buildRequestSpecification());
	}

	private static RequestSpecification buildRequestSpecification() {
		return new RequestSpecBuilder()
				.setBaseUri(createConfigFactory().baseURI())
				.setContentType(ContentType.JSON)
				.addHeader("x-karza-key", createConfigFactory().xkarzakey())
				.addFilter(new AllureRestAssured())
				.build();
	}

	public static RequestSpecification requestSpecification(String headerKey, String headerValue) {
		return Optional.ofNullable(request)
				.orElse(buildRequestSpecification(headerKey, headerValue));
	}

	private static RequestSpecification buildRequestSpecification(String headerKey, String headerValue) {
		return new RequestSpecBuilder()
				.setBaseUri(createConfigFactory().baseURI())
				.addHeader(headerKey, headerValue)
				.addFilter(new AllureRestAssured())
				.build();
	}

//	public static RequestSpecification requestSpecification(List<KycOcrFormData> formData) {
//		return Optional.ofNullable(request)
//				.orElse(buildRequestSpecification(formData));
//	}

//	private static RequestSpecification buildRequestSpecification(List<KycOcrFormData> formData) {
//		RequestSpecBuilder reqSpecbuilder =  new RequestSpecBuilder()
//				.setBaseUri(createConfigFactory().baseURI())
//				.addHeader("x-karza-key", createConfigFactory().xkarzakey())
//				.addFilter(new AllureRestAssured());
//
//		List<MultiPartSpecification> multiParts = getMultiPartSpecifications(formData);
//
//		for(MultiPartSpecification multiPart : multiParts) {
//			reqSpecbuilder.addMultiPart(multiPart);
//		}
//		return reqSpecbuilder.build();
//	}

//	private static List<MultiPartSpecification> getMultiPartSpecifications(List<KycOcrFormData> formData) {
//		List<MultiPartSpecification> multiParts = new ArrayList<>();
//
//		for(int i=0; i<formData.size(); i++) {
//			multiParts.add(new MultiPartSpecBuilder(formData.get(i).getValue())
//					.controlName(formData.get(i).getKey())
//					.build());
//		}
//		return multiParts;
//	}
}
