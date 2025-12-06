package io.taiga.selenium.base;

import io.taiga.selenium.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSeleniumBase {
    protected WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = DriverFactory.newChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }
}
