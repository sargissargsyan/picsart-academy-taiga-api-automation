package io.taiga.selenium.pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected void click(By locator) {
        log.info("Clicking element: " + locator);
        WebElement element = find(locator);
        click(element);
    }

    public void click(WebElement element) {
        log.info("Clicking element: " + element);
        element.click();
    }
}
