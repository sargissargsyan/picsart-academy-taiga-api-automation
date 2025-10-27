package io.taiga.api.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.utils.ConfigManager;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Log
public class BaseService {
    private static final ConfigManager CONFIG = ConfigManager.getInstance();

    protected static RequestSpecification configBaseRequest() {
        log.info("Configuring base request with URL: " + CONFIG.getBaseUrl() + ":" + CONFIG.getBasePort());
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
        log.info("Executing GET request");
        requestSpecification.log().ifValidationFails();
        Response response = requestSpecification.get();
        log.info("GET request completed with status: " + response.getStatusCode());
        return response;
    }

    protected static Response post(RequestSpecification requestSpecification) {
        log.info("Executing POST request");
        requestSpecification.log().ifValidationFails();
        Response response = requestSpecification.post();
        log.info("POST request completed with status: " + response.getStatusCode());
        return response;
    }

    protected static Response patch(RequestSpecification requestSpecification) {
        log.info("Executing PATCH request");
        requestSpecification.log().ifValidationFails();
        Response response = requestSpecification.patch();
        log.info("PATCH request completed with status: " + response.getStatusCode());
        return response;
    }

    protected static Response delete(RequestSpecification requestSpecification) {
        log.info("Executing DELETE request");
        requestSpecification.log().ifValidationFails();
        Response response = requestSpecification.delete();
        log.info("DELETE request completed with status: " + response.getStatusCode());
        return response;
    }

}
