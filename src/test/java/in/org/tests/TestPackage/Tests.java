package in.org.tests.TestPackage;

import static in.org.constants.TestApiFilePaths.*;
import static in.org.constants.StringEndpoints.*;
import in.org.allurereport.AllureManager;
import in.org.datasupplier.DataSupplierUtils;
import in.org.pojos.data.tdsauth.TestApiRoot;
import in.org.pojos.responses.testapi.TestApiResponseRoot;
import in.org.services.RequestCreationService;
import in.org.services.ResponseParserService;
import in.org.testdatabuilders.TestApiTestDataBuilder;
import io.github.sskorol.core.DataSupplier;
import io.qameta.allure.*;
import io.restassured.response.Response;
import in.org.assertions.ResponseAssert;
import in.org.assertions.TestApiAssert;
import one.util.streamex.StreamEx;
import org.apache.http.HttpStatus;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Tests Package")
@Feature("Test Api")
@Owner("QA: ; Dev: ")
public final class Tests {

    private Tests() {}

    @Story("When all valid details are given in the input")
    @Description("Testing API for 200 when all the valid details are given")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "getData", groups = { "Sanity", "Regression"}, priority = 1)
    public void verifyTestApiApiForAllGivenValidDetailsTest(TestApiRoot data, ITestContext testContext) {
        AllureManager.setAllureReportPrerequisites(data.getTestcase(), testContext);

        TestApiRoot payloadData = TestApiTestDataBuilder.getTestApiPayload(data);
        Response response = RequestCreationService.post(payloadData, getValidTestApiEndpoint());
        TestApiResponseRoot parsedResponse = ResponseParserService.parse(response, TestApiResponseRoot.class);

        ResponseAssert.assertThat(response)
                .hasHttpStatusCode(HttpStatus.SC_OK)
                .hasResponseJsonSchemaAsPer(getTestApiRespSchemaFor101())
                .containsExpectedHeader("Content-Type", "application/Json")
                .hasResponseTimeWithin(30L)
                .verify();

        TestApiAssert.assertThat(parsedResponse)
                .hasInternalStatusCode(data.getExpectedInternalStatusCode())
                .hasReqIdWithPattern("^[a-z0-9-]{36}$")
                .hasStatus(data.getExpectedResult().getExpectedStatus())
                .verify();
    }

//    /*
//        Trying the GET http method infusion
//     */
//    @Test(dataProvider = "getData")
//    public void getTheResponseUsingGETMEthod(TestApiRoot data, ITestContext testContext) {
//        AllureManager.setAllureReportPrerequisites(data.getTestcase(), testContext);
//
//        Response response = RequestCreationService.get(getValidGetEndpoint());
//        TestApiResponseRoot parsedResponse = ResponseParserService.parse(response, TestApiResponseRoot.class);
//        System.out.println(parsedResponse);
//
//    }
//


    @DataSupplier(name = "getData")
    public StreamEx<TestApiRoot> getData (Method method) {
        return DataSupplierUtils.getData(getTestApiValidData(),
                getTestApiInvalidData(), getTestApiInvalidOrMissingBodyKeysData(),
                getTestApiInvalidOrMissingHeaderKeysData(), getTestApiInvalidEndpointData(),
                TestApiRoot.class, method);
    }
}