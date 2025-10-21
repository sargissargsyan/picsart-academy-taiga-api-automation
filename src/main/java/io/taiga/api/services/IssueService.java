package io.taiga.api.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.models.Issue;
import io.taiga.utils.Urls;

public class IssueService extends BaseService {
    public static Response createIssue(Issue issue, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.ISSUES_URL);
        requestSpecification.body(issue);
        requestSpecification.headers(setToken(token));
        return post(requestSpecification);

    }
}
