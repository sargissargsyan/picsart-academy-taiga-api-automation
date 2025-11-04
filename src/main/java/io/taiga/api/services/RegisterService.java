package io.taiga.api.services;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.api.models.LoginRequestBody;
import io.taiga.api.models.RegisterRequestBody;
import io.taiga.utils.Urls;

public class RegisterService extends BaseService {
    @Step("Register a user")
    public static Response register(RegisterRequestBody requestBody) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.REGISTER_URL);
        requestSpecification.body(requestBody);
        return post(requestSpecification);
    }
}
