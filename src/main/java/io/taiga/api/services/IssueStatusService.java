package io.taiga.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.utils.Urls;

public class IssueStatusService extends BaseService {
    public static Response getIssueStatuses(int projectId, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.ISSUES_STATUSES_URL);
        requestSpecification.headers(setToken(token));
        requestSpecification.params("project", projectId);
        return get(requestSpecification);
    }
}
