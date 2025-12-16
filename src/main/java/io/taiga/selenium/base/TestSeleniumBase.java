package io.taiga.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.taiga.selenium.factory.DriverFactory;
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

    @BeforeMethod
    public void initDriver() {
        driver = DriverFactory.get().getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        DriverFactory.get().quitDriver();
    }
}
