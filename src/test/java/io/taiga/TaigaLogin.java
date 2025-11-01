package io.taiga;

import io.taiga.api.models.LoginRequestBody;
import io.taiga.api.models.RegisterRequestBody;
import io.taiga.api.models.User;
import io.taiga.api.services.AccountService;
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

    private final static String PASSWORD = TestUtils.randomPassword(8);
    private String username;
    private String email;
    private String fullName;
    private RegisterRequestBody requestBody;

    @BeforeMethod
    public void beforeMethod() {
        fullName =TestUtils.randomNumber(4) + " " + TestUtils.randomNumber(4);
        username = TestUtils.randomUsername(8);
        email = TestUtils.randomEmail();

        requestBody = new RegisterRequestBody();
        requestBody.setUsername(username);
        requestBody.setPassword(PASSWORD);
        requestBody.setAccepted_terms(true);
        requestBody.setFull_name(fullName);
        requestBody.setEmail(email);
        requestBody.setType("public");
    }

    @Test
    public void registerUser() {
        User newUser = AccountService.register(requestBody).
        then()
                .statusCode(201)
                .extract().as(User.class);

        assertEquals(newUser.getUsername(), username, "Incorrect username!");
        assertEquals(newUser.getEmail(), email, "Incorrect email!");
        assertEquals(newUser.getFull_name(), fullName, "Incorrect full name!");
        assertTrue(newUser.getAccepted_terms(), "Incorrect accepted terms!");
        assertFalse(newUser.getVerified_email(), "Incorrect verified email!");
    }

    @Test
    public void login() {
        AccountService.register(requestBody);
        LoginRequestBody loginRequestBody = new LoginRequestBody();
        loginRequestBody.setUsername(username);
        loginRequestBody.setPassword(PASSWORD);
        loginRequestBody.setType("normal");

        AccountService.login(loginRequestBody).
        then()
                .statusCode(200)
                .extract().body().as(User.class);
    }
}
