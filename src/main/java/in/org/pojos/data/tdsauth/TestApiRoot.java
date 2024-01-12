package in.org.pojos.data.tdsauth;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
    @Builder(setterPrefix = "set")
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public final class TestApiRoot {

        private String testcase;
        private String karzaKeyHeaderName;
        private String karzaKeyHeaderValue;
        private String tan;
        private String pan;
        private String amount;
        private String cert_no;
        private String fiscal_year;
        private String consent;
        private TestApiExpectedResult expectedResult;
        private String expectedError;
        private String expectedInternalStatusCode;
        private String expectedMessage;
}
