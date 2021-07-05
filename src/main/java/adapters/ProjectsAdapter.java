package adapters;

import objects.Project;

public class ProjectsAdapter extends BaseAdapter{

    private static final String PROJECT_URI = "project";

    public String create(String token, Project project){
       return post(token, PROJECT_URI, converter.toJson(project)).body().path("result.code");
    }
}
