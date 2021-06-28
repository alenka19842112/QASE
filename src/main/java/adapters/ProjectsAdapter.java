package adapters;

import objects.Project;

public class ProjectsAdapter extends BaseAdapter{

    private static final String PROJECT_URI = "project";

    public String create(Project project){
       return post(PROJECT_URI, converter.toJson(project)).body().path("result.code");
    }
}
