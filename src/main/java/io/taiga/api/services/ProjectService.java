package io.taiga.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.models.Project;
import io.taiga.utils.Urls;

public class ProjectService extends BaseService {
    public static Response createProject(Project project, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.PROJECTS_URL);
        requestSpecification.body(project);
        requestSpecification.headers(setToken(token));
        return post(requestSpecification);
    }
}
