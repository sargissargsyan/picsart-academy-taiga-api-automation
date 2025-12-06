package io.taiga.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class PageBase {
    protected WebDriver driver;

    protected static final String BASE_URL = "http://localhost:9000";

    protected String getPlaceholderText(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }
}
