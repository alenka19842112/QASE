package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import objects.Project;
import objects.TestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTest {

    @Test
    public void getAllProjectsTest() {
        new BaseAdapter().get("project");
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
        String createdProjectCode = new ProjectsAdapter().create(project);
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
        int createdTestSuiteId = new SuiteAdapter().create("QAEITESTS", testSuite);
        Assert.assertNotNull(createdTestSuiteId);
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
        int createdTestSuiteId = suiteAdapter.create("QAEITESTS", testSuite);
        int actualDeletedSuiteStatus = suiteAdapter.isDeleteSuite("QAEITESTS", createdTestSuiteId);
        Assert.assertEquals(200, actualDeletedSuiteStatus);
    }
}
