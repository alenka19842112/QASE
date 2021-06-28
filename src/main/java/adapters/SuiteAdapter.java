package adapters;

import objects.TestSuite;

public class SuiteAdapter extends BaseAdapter {
    private static final String SUITE_URI = "suite/";
    private static final String DELETE_URI ="";

    public int create(String projectCode, TestSuite testSuite) {
        return post(SUITE_URI + projectCode, converter.toJson(testSuite)).body().path("result.id");
    }

    public int isDeleteSuite(String projectCode, int createdTestSuiteId) {
        return delete(SUITE_URI + projectCode + "/" + createdTestSuiteId).statusCode();
    }
}
