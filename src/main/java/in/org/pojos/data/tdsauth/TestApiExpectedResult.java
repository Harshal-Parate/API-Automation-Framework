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
    public final class TestApiExpectedResult {

        private String expectedStatus;

    }


