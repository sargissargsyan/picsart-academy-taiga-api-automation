package io.taiga.api.services;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.api.models.User;
import io.taiga.api.Urls;

import java.util.HashMap;
import java.util.Map;

public class UserService extends BaseService {
    @Step("Delete the User")
    public static Response delete(User project, String token) {
        return delete(project.getId(), token);
    }

    @Step("Delete the User")
    public static Response delete(Integer userID, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.USERS_URL + "/" + userID);
        requestSpecification.headers(setToken(token));
        return delete(requestSpecification);
    }

    public static void skipNewsletter(String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.USER_STORAGE_URL);
        Map<String, Object> params = new HashMap<>();
        params.put("key", "dont_ask_premise_newsletter");
        params.put("value", true);
        requestSpecification.headers(setToken(token));
        requestSpecification.body(params);
        post(requestSpecification);

    }


}
