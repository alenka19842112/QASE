package adapters;

import objects.TestSuite;

public class SuiteAdapter extends BaseAdapter {
    private static final String SUITE_URI = "suite/";

    public int create(String token, String projectCode, TestSuite testSuite) {
        return post(token,SUITE_URI + projectCode, converter.toJson(testSuite)).body().path("result.id");
    }

    public int deleteSuite(String token, String projectCode, int createdTestSuiteId) {
        return delete(token,SUITE_URI + projectCode + "/" + createdTestSuiteId).statusCode();
    }
    public Boolean getStatusOfCreateSuite(String token, String projectCode, TestSuite testSuite) {
        return post(token,SUITE_URI + projectCode, converter.toJson(testSuite)).body().path("status");
    }
}
