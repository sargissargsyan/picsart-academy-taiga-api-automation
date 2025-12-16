package io.taiga.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import io.taiga.api.models.LoginRequestBody;
import io.taiga.api.models.User;
import io.taiga.api.services.AuthService;
import io.taiga.api.services.RegisterService;
import io.taiga.api.services.UserService;
import io.taiga.selenium.factory.DriverFactory;
import io.taiga.selenium.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestSeleniumBase {
    protected WebDriver driver;

    @BeforeTest
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        DriverFactory.get().quitDriver();
    }

    protected void login(String username, String password) {
        LoginRequestBody loginRequestBody = new LoginRequestBody();
        loginRequestBody.setUsername(username);
        loginRequestBody.setPassword(password);
        loginRequestBody.setType("normal");

        Response response = AuthService.login(loginRequestBody);
        User user = response.body().as(User.class);
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.get().getDriver();
        jsExecutor.executeScript("localStorage.setItem('userInfo', '"+ response.body().asString() +"');");
        jsExecutor.executeScript("localStorage.setItem('token', '\""+ user.getAuth_token() +"\"')");
        UserService.skipNewsletter(user.getAuth_token());
    }
}
