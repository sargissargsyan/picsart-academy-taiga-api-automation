package io.taiga.selenium.pages;

import io.taiga.selenium.wait.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static final String BASE_URL = "http://localhost:9000";
    private static final String URL_PATH = "/login";
    private WebDriver driver;
    private By usernameFiled = By.name("username");
    private By passwordFiled = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".notification-message-light-error.active");
    private By errorWarningMessage = By.cssSelector(".notification-light.notification-message-light-error .warning");
    private By cookieWarning = By.cssSelector("cookie-warning");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get(BASE_URL + URL_PATH);
    }

    public void fillUsername(String username) {
        driver.findElement(usernameFiled).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordFiled).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        WaitUtils.waitTextToBe(driver, errorWarningMessage, "Oops, something went wrong...");
        return driver.findElement(errorMessage).getText();
    }

    public boolean isCookiesWarningDisplayed() {
        return driver.findElement(cookieWarning).isDisplayed();
    }

    private String getPlaceholderText(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }

    public String getUsernamePlaceholderText() {
        return getPlaceholderText(usernameFiled);
    }

    public String getPasswordPlaceholderText() {
        return getPlaceholderText(passwordFiled);
    }

}
