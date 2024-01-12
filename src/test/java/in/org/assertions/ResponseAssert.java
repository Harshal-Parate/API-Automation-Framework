package in.org.assertions;

import static in.org.allurereport.AllureLogger.addAllureLog;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import io.restassured.response.Response;

public final class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

    SoftAssertions assertions = new SoftAssertions();

    private ResponseAssert(Response response) {
        super(response, ResponseAssert.class);
    }

    public static ResponseAssert assertThat(Response response) {
        return new ResponseAssert(response);
    }

    public ResponseAssert hasHttpStatusCode(int expectedStatusCode) {
        int actualHttpStatusCode = actual.getStatusCode();
        Assertions.assertThat(actualHttpStatusCode)
                .withFailMessage(() -> "Actual HTTP status code is '" + actualHttpStatusCode
                        + "' instead of expected HTTP status code '" + expectedStatusCode + "'")
                .isEqualTo(expectedStatusCode);

        addAllureLog("Actual HTTP status code as '" + expectedStatusCode + "' is asserted");
        return this;
    }

    public ResponseAssert hasResponseJsonSchemaAsPer(String expectedResponseSchemaFilePath) {
        //		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(getAddressMatchRespSchemaFor101())));
        Assertions.assertThatCode(() -> matchesJsonSchema(new File(expectedResponseSchemaFilePath)).matches(actual.body()))
                .withFailMessage(() -> "Actual response schema does not match the expected schema")
                .doesNotThrowAnyException();

        addAllureLog("Actual response schema validation is asserted");
        return this;
    }

    public ResponseAssert containsExpectedHeader(String headerType, String expectedHeader) {
        assertions.assertThat(actual.header(headerType))
                .withFailMessage(() -> "Actual response does not contain " + headerType + " as '" + expectedHeader + "'")
                .containsIgnoringCase(expectedHeader);

        addAllureLog(expectedHeader + " as one of the response headers is asserted");
        return this;
    }

    public ResponseAssert hasResponseTimeWithin(long expectedTimeInSecs) {
        long actualResponseTimeInSecs = actual.getTimeIn(TimeUnit.SECONDS);
        assertions.assertThat(actualResponseTimeInSecs)
                .withFailMessage(() -> "Actual response time is not within '" + expectedTimeInSecs + "' seconds."
                        + " It took '" + actualResponseTimeInSecs + "' seconds.")
                .isLessThanOrEqualTo(expectedTimeInSecs);

        addAllureLog("Response time being within " + expectedTimeInSecs + " secs is asserted");
        return this;
    }

    public void verify() {
        assertions.assertAll();
    }
}