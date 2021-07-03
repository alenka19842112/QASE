package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import objects.Project;
import objects.TestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class QaseTest {
    String token =System.getenv().getOrDefault("Token", PropertyReader.getProperty("token"));

    @Test
    public void getAllProjectsTest() {
        new BaseAdapter().get(token,"project");
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .title("QAEITESTS")
                .code("QAEITESTS")
                .description("Test project")
                .access("all")
                .group("null")
                .build();
        String createdProjectCode = new ProjectsAdapter().create(token,project);
        Assert.assertEquals(createdProjectCode, "QAEITESTS");
    }

    @Test
    public void createNewTestSuiteTest(){
        TestSuite testSuite = TestSuite.builder()
                .title("test Suite")
                .parentId(null)
                .description("Suite description")
                .preconditions("Preconditions")
                .build();
        boolean isCreate = new SuiteAdapter().getStatusOfCreateSuite(token,"QAEITESTS", testSuite);
        Assert.assertTrue(isCreate);
    }

    @Test
    public void createNewTestSuiteAndDeleteTest(){
        TestSuite testSuite = TestSuite.builder()
                .title("test Suite")
                .parentId(null)
                .description("Suite description")
                .preconditions("Preconditions")
                .build();
        SuiteAdapter suiteAdapter = new SuiteAdapter();
        int createdTestSuiteId = suiteAdapter.create(token,"QAEITESTS", testSuite);
        int actualDeletedSuiteStatus = suiteAdapter.deleteSuite(token,"QAEITESTS", createdTestSuiteId);
        Assert.assertEquals(200, actualDeletedSuiteStatus);
    }
}
