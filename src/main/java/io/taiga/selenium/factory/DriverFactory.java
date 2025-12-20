package io.taiga.selenium.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThead = new ThreadLocal<>();

    public static DriverFactory get() {
        return new DriverFactory();
    }
    public WebDriver newChromeDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }
    public WebDriver newFirefoxDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }
    public WebDriver getDriver() {
        if (driverThead.get() == null) {
            driverThead.set(newFirefoxDriver());
        }
        return driverThead.get();
    }
    public void quitDriver() {
        if (driverThead.get() != null) {
            driverThead.get().quit();
            driverThead.remove();
        }
    }
}
