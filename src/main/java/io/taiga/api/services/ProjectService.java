package io.taiga.api.services;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.api.models.Project;
import io.taiga.api.Urls;

public class ProjectService extends BaseService {
    @Step("Create a Project")
    public static Response createProject(Project project, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.PROJECTS_URL);
        requestSpecification.body(project);
        requestSpecification.headers(setToken(token));
        return post(requestSpecification);
    }

    @Step("Delete the Project")
    public static Response delete(Project project, String token) {
        return delete(project.getId(), token);
    }

    @Step("Delete the Project")
    public static Response delete(Integer projectId, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.PROJECTS_URL + "/" + projectId);
        requestSpecification.headers(setToken(token));
        return delete(requestSpecification);
    }
}
