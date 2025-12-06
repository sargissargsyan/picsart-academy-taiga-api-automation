package io.taiga.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.taiga.api.TestBase;
import io.taiga.selenium.base.TestSeleniumBase;
import io.taiga.selenium.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends TestSeleniumBase {
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        assertEquals(loginPage.getUsernamePlaceholderText(),
                "Username or email (case sensitive)", "Username placeholder was Incorrect!");
        loginPage.fillUsername("invalid");

        assertEquals(loginPage.getPasswordPlaceholderText(),
                "Password (case sensitive)", "Password placeholder was Incorrect!");
        loginPage.fillPassword("invalid");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorMessage(), "Oops, something went wrong...\n" +
                "According to the Taiga, your username/email or password are incorrect.",
                "Error message was Incorrect!");
    }

    @Test
    public void cookieTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();

        assertTrue(loginPage.isCookiesWarningDisplayed());

        Set<Cookie> cookieSet = driver.manage().getCookies();
        assertEquals(cookieSet.size(), 0, "Cookie was not set!");

        Cookie cookie = new Cookie("cookieConsent", "1");
        driver.manage().addCookie(cookie);
        cookieSet = driver.manage().getCookies();
        assertEquals(cookieSet.size(), 1, "Cookie was not set!");

        driver.navigate().refresh();

    }
}
