package in.org.testdatabuilders;

import in.org.pojos.data.tdsauth.TestApiRoot;

public final class TestApiTestDataBuilder
{
    private TestApiTestDataBuilder(){

    }
    public static TestApiRoot getTestApiPayload(TestApiRoot data)
    {
        return TestApiRoot.builder()
                .setAmount(data.getAmount())
                .setCert_no(data.getCert_no())
                .setConsent(data.getConsent())
                .setTan(data.getTan())
                .setPan(data.getPan())
                .setFiscal_year(data.getFiscal_year())
                .build();
    }
}
