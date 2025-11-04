package io.taiga.api.services;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.api.models.LoginRequestBody;
import io.taiga.api.models.Project;
import io.taiga.api.models.User;
import io.taiga.utils.Urls;

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


}
