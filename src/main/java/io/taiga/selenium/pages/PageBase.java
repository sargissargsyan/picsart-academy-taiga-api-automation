package io.taiga.selenium.pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log
public abstract class PageBase {
    protected WebDriver driver;

    protected static final String BASE_URL = "http://localhost:9000";

    protected String getPlaceholderText(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }

    protected WebElement find(By locator) {
        log.info("Finding element: " + locator);
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        log.info("Finding element: " + locator);
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        log.info("Clicking element: " + locator);
        WebElement element = find(locator);
        click(element);
    }

    protected void click(WebElement element) {
        log.info("Clicking element: " + element);
        element.click();
    }

    protected void type(By locator, String text) {
        log.info("Typing text: " + text + " into element: " + locator);
        WebElement element = find(locator);
        type(element, text);
    }

    protected void type(WebElement element, String text) {
        log.info("Typing text: " + text + " into element: " + element);
        element.sendKeys(text);
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }

    }
}
