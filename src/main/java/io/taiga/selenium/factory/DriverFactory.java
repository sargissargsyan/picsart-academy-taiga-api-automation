package io.taiga.selenium.factory;

import io.taiga.utils.ConfigManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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
    @SneakyThrows
    public WebDriver getDriver() {
        if (driverThead.get() == null) {
            if (ConfigManager.getInstance().getSeleniumBrowser().equals("chrome")){
                if (ConfigManager.getInstance().isRemote()) {
                    URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setPlatformName("Windows 11");
                    browserOptions.setBrowserVersion("latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("username", ""); //set your usernamae
                    sauceOptions.put("accessKey", ""); // set your access key
                    sauceOptions.put("build", "selenium-build-N0PCX");
                    sauceOptions.put("name", "TaigaTests");
                    sauceOptions.put("screenResolution", "1280x1024");

                    browserOptions.setCapability("sauce:options", sauceOptions);
                    driverThead.set(new RemoteWebDriver(url,browserOptions));
                } else {
                    driverThead.set(newChromeDriver());
                }
            } else if (ConfigManager.getInstance().getSeleniumBrowser().equals("firefox")) {
                if (ConfigManager.getInstance().isRemote()) {
                    driverThead.set(new RemoteWebDriver(new URL(ConfigManager.getInstance().getRemoteUrl()), new FirefoxOptions()));
                } else {
                    driverThead.set(newFirefoxDriver());
                }
            }
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
