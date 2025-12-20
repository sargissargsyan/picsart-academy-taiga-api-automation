package io.taiga.selenium.wait;

import io.taiga.selenium.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static WebElement waitUntilClickable(By locator) {
        return new WebDriverWait(DriverFactory.get().getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitUntilVisible(By locator) {
        return new WebDriverWait(DriverFactory.get().getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static Boolean waitUntilInVisible(By locator) {
        return new WebDriverWait(DriverFactory.get().getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static Boolean waitTextToBe( By locator, String text) {
        return new WebDriverWait(DriverFactory.get().getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBe(locator, text));
    }
}
