package in.org.pojos.responses.testapi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public final class TestApiResponseResult {

        private TestApiResponseResult() {}

        private String status;

    }

