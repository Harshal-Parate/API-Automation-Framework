package in.org.constants;

import lombok.Getter;

public final class TestApiFilePaths {

    private TestApiFilePaths() {}

    @Getter
    private static final String testApiRespSchemaFor101 = FrameworkPaths.RESOURCES_PATH
            + "/responsejsonschemas/TestSchemas/101.json";

    @Getter
    private static final String testApiRespSchemaFor102105 = FrameworkPaths.RESOURCES_PATH
            + "/";

    @Getter
    private static final String testApiRespSchemaFor400401 = FrameworkPaths.RESOURCES_PATH
            + "/";

    @Getter
    private static final String testApiRespSchemaFor403 = FrameworkPaths.RESOURCES_PATH
            + "/";

    @Getter
    private static final String testApiValidData = "testdata/TestData/101data.json";

    @Getter
    private static final String testApiInvalidData = "";

    @Getter
    private static final String testApiInvalidOrMissingBodyKeysData = "";

    @Getter
    private static final String testApiInvalidOrMissingHeaderKeysData = "";

    @Getter
    private static final String testApiInvalidEndpointData = "";
}
