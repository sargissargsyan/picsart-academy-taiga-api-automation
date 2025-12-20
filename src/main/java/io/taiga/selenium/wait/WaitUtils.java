package io.taiga.selenium.wait;

import io.taiga.selenium.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static WebDriver driver;
    private WaitUtils() {
        this.driver = DriverFactory.get().getDriver();
    }
    public static WebElement waitUntilClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitUntilVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static Boolean waitTextToBe( By locator, String text) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBe(locator, text));
    }
}
