package io.taiga;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.taiga.models.LoginRequestBody;
import io.taiga.models.RegisterRequestBody;
import io.taiga.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

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
        String username = "picartacademy" + new Random().nextInt(100);
        String email = "picsartacademy"+ + new Random().nextInt(100) + "@gmail.com";
        RegisterRequestBody requestBody = new RegisterRequestBody();
        requestBody.setUsername(username);
        requestBody.setPassword("Picsart12345");
        requestBody.setAccepted_terms(true);
        requestBody.setFull_name("Picsart Academy");
        requestBody.setEmail(email);
        requestBody.setType("public");
        User newUser = given()
                .spec(requestSpecification)
                .body(requestBody).
         when()
                .post("/api/v1/auth/register").
        then().log().all()
                .spec(responseSpecification)
                .statusCode(201)
                .extract().as(User.class);

        assertEquals(newUser.getUsername(), username, "Incorrect username!");
        assertEquals(newUser.getEmail(), email, "Incorrect email!");
        assertEquals(newUser.getFull_name(), "Picsart Academy", "Incorrect full name!");
        assertTrue(newUser.getAccepted_terms(), "Incorrect accepted terms!");
        assertFalse(newUser.getVerified_email(), "Incorrect verified email!");

    }

    @Test
    public void login() {
        LoginRequestBody loginRequestBody = new LoginRequestBody();
        loginRequestBody.setUsername("picsartacademy1759822485");
        loginRequestBody.setPassword("Picsart12345!");
        loginRequestBody.setType("normal");

        User user = given()
                .spec(requestSpecification)
                .body(loginRequestBody).
        when()
                .post("api/v1/auth").
        then().log().all()
                .spec(responseSpecification)
                .statusCode(200)
                .extract().body().as(User.class);
        System.out.println(user.getAuth_token());
    }
}
