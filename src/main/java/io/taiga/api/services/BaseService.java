package io.taiga.api.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.utils.ConfigManager;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {
    private static final ConfigManager CONFIG = ConfigManager.getInstance();

    protected static RequestSpecification configBaseRequest() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(CONFIG.getBaseUrl())
                .port(CONFIG.getBasePort());
    }

    protected static Map<String, String> setToken(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    protected static Response get(RequestSpecification requestSpecification) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.get();
    }

    protected static Response post(RequestSpecification requestSpecification) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.post();
    }

    protected static Response patch(RequestSpecification requestSpecification) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.patch();
    }

    protected static Response delete(RequestSpecification requestSpecification) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.delete();
    }

}
