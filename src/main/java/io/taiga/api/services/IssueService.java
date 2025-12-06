package io.taiga.api.services;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.api.models.Issue;
import io.taiga.api.Urls;

public class IssueService extends BaseService {
    @Step("Create an issue")
    public static Response createIssue(Issue issue, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.ISSUES_URL);
        requestSpecification.body(issue);
        requestSpecification.headers(setToken(token));
        return post(requestSpecification);

    }
}
