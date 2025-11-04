package io.taiga.api.services;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.api.models.LoginRequestBody;
import io.taiga.api.models.RegisterRequestBody;
import io.taiga.utils.Urls;

public class AccountService extends BaseService {
    @Step("Register a user")
    public static Response register(RegisterRequestBody requestBody) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.REGISTER_URL);
        requestSpecification.body(requestBody);
        return post(requestSpecification);
    }

    @Step("Login with a user")
    public static Response login(LoginRequestBody requestBody) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.LOGIN_URL);
        requestSpecification.body(requestBody);
        return post(requestSpecification);
    }


}
