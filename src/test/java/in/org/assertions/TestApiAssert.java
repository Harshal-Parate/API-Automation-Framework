package in.org.assertions;

import in.org.pojos.responses.testapi.TestApiResponseRoot;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

import static in.org.allurereport.AllureLogger.addAllureLog;

public class TestApiAssert extends AbstractAssert<TestApiAssert, TestApiResponseRoot> {

    SoftAssertions assertions = new SoftAssertions();

    private TestApiAssert(TestApiResponseRoot TestApiResponseRoot) {
        super(TestApiResponseRoot, TestApiAssert.class);
    }

    public static TestApiAssert assertThat(TestApiResponseRoot TestApiParsedResponse) {
        return new TestApiAssert(TestApiParsedResponse);
    }

    public TestApiAssert hasInternalStatusCode(String expectedInternalStatusCode) {
        String actualInternalStatusCode = actual.getInternalStatusCode();
        assertions.assertThat(actualInternalStatusCode)
                .withFailMessage(() -> "Actual internal status code '" + actualInternalStatusCode +
                        "' is not equal to expected internal status code '" + expectedInternalStatusCode + "'")
                .isEqualTo(expectedInternalStatusCode);

        addAllureLog("Actual Internal status code as '" + expectedInternalStatusCode + "' is asserted");
        return this;
    }

    public TestApiAssert hasReqIdWithPattern(String expectedPattern) {
        assertions.assertThat(actual.getRequestId())
                .withFailMessage(() -> "Actual Pattern does not match with " + expectedPattern)
                .matches(expectedPattern);

        addAllureLog("Request id generation is asserted");
        return this;
    }

    public TestApiAssert hasStatus(String expectedStatus) {
        String actualStatus = actual.getResult().getStatus();
        assertions.assertThat(actualStatus)
                .withFailMessage(() -> "Actual Status '" + actualStatus +
                        "' does not match with expected Status '" + expectedStatus)
                .isEqualTo(expectedStatus);

        addAllureLog("Actual Status '" + actualStatus + "' is valid " +
                " and correct as per the expected Status '" + expectedStatus + "'");
        return this;
    }

    public TestApiAssert hasEmptyResult() {
        String actualResultStatus = actual.getResult().getStatus();
        assertions.assertThat(actualResultStatus)
                .withFailMessage(() -> "Actual result " + actual.getResult()
                        + " is not empty as expected. It contains " + actualResultStatus)
                .isNotIn(actual.getResult());

        addAllureLog("Result is empty as expected");
        return this;
    }

    public TestApiAssert givesErrorMsgAs(String expectedErrorMsg) {
        String actualErrorMsg = actual.getErrorMsg();
        assertions.assertThat(actualErrorMsg)
                .withFailMessage(() -> "Actual error msg is '" + actualErrorMsg + "' "
                        + "instead of expected error msg '" + expectedErrorMsg + "'")
                .isEqualToIgnoringCase(expectedErrorMsg);

        addAllureLog("Actual error msg as '" + expectedErrorMsg + "' is asserted");
        return this;
    }

    public TestApiAssert givesMsgAs(String expectedMsg) {
        String actualMsg = actual.getMessage();
        assertions.assertThat(actualMsg)
                .withFailMessage(() -> "Actual msg is '" + actualMsg + "' "
                        + "instead of expected msg '" + expectedMsg + "'")
                .isEqualToIgnoringCase(expectedMsg);

        addAllureLog("Actual message as '" + expectedMsg + "' is asserted");
        return this;
    }

    public void verify() {
        assertions.assertAll();
    }
}
