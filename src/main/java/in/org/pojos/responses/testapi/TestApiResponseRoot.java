package in.org.pojos.responses.testapi;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public final class TestApiResponseRoot {

        private TestApiResponseRoot() {}

        @JsonProperty("request_id")
        private String requestId;

        private TestApiResponseResult result;

        @JsonProperty("error")
        private String errorMsg;

        private String message;

        @JsonAlias({"status-code", "status"})
        private String internalStatusCode;

    }

