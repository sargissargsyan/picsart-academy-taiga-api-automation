package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TaigaLogin {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void beforeMethod() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost").setPort(9000)
                .setContentType(ContentType.JSON)
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void registerUser() {
        String body ="{\n    \"accepted_terms\": true,\n    \"username\": \"picsartacademy1759823663\",\n    \"full_name\": \"Picsart Academy\",\n    \"email\": \"picsartacademy1759823663@gmail.com\",\n    \"password\": \"Picsart12345!\",\n    \"type\": \"public\"\n}";

        String username = given()
                .spec(requestSpecification).
        when()
                .body(body)
                .post("/api/v1/auth/register").
        then()
                .spec(responseSpecification)
                .statusCode(201)
                .extract().path("username");
        System.out.println(username);

    }

    @Test
    public void login() {
        String body = "{\"username\": \"picsartacademy1759822485\",\"password\": \"Picsart12345!\",\"type\": \"normal\"}";

        String token = given()
                .spec(requestSpecification).
        when()
                .body(body)
                .post("api/v1/auth").
        then()
                .spec(responseSpecification)
                .statusCode(200)
                .extract().path("auth_token");
        System.out.println(token);
    }




}
