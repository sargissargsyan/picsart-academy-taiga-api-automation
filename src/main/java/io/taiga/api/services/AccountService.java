package io.taiga.api.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.models.LoginRequestBody;
import io.taiga.models.RegisterRequestBody;
import io.taiga.utils.Urls;

public class AccountService extends BaseService {
    public static Response register(RegisterRequestBody requestBody) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.REGISTER_URL);
        requestSpecification.body(requestBody);
        return post(requestSpecification);
    }

    public static Response login(LoginRequestBody requestBody) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.LOGIN_URL);
        requestSpecification.body(requestBody);
        return post(requestSpecification);
    }


}
