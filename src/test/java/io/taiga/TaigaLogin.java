package io.taiga;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.taiga.api.models.LoginRequestBody;
import io.taiga.api.models.RegisterRequestBody;
import io.taiga.api.models.User;
import io.taiga.utils.TestUtils;
import io.taiga.utils.Urls;
import lombok.extern.java.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;
@Log
public class TaigaLogin extends TestBase {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;
    private final static String PASSWORD = TestUtils.randomPassword(8);
    private String username;

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
        log.info(username);
        log.info(PASSWORD);
        username = TestUtils.randomUsername(8);
        String email = TestUtils.randomEmail();
        RegisterRequestBody requestBody = new RegisterRequestBody();
        requestBody.setUsername(username);
        requestBody.setPassword(PASSWORD);
        requestBody.setAccepted_terms(true);
        requestBody.setFull_name(TestUtils.randomNumber(4) + " " + TestUtils.randomNumber(4));
        requestBody.setEmail(email);
        requestBody.setType("public");
        User newUser = given()
                .spec(requestSpecification)
                .body(requestBody).
         when()
                .post(Urls.REGISTER_URL).
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
        loginRequestBody.setUsername(username);
        loginRequestBody.setPassword(PASSWORD);
        loginRequestBody.setType("normal");

        User user = given()
                .spec(requestSpecification)
                .body(loginRequestBody).
        when()
                .post(Urls.LOGIN_URL).
        then().log().all()
                .spec(responseSpecification)
                .statusCode(200)
                .extract().body().as(User.class);
        System.out.println(user.getAuth_token());
    }
}
