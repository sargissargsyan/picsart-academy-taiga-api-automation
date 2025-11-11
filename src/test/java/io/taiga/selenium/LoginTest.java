package io.taiga.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void invalidLogin() throws InterruptedException {
        driver.get("https://tree.taiga.io/login");
        Thread.sleep(3000);
        WebElement usernameFiled = driver.findElement(By.name("username"));

        String usernamePlaceHolderText = usernameFiled.getAttribute("placeholder");
        assertEquals(usernamePlaceHolderText, "Username or email (case sensitive)", "Username placeholder was Incorrect!");

        usernameFiled.sendKeys("invalid");

        WebElement passwordFiled = driver.findElement(By.name("password"));
        String passwordPlaceHolderText = passwordFiled.getAttribute("placeholder");
        assertEquals(passwordPlaceHolderText, "Password (case sensitive)", "Password placeholder was Incorrect!");

        passwordFiled.sendKeys("invalid");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(1500);

        String errorMessage = driver.findElement(By.cssSelector(".notification-message-light-error.active")).getText();
        assertEquals(errorMessage, "Oops, something went wrong...\n" +
                "According to the Taiga, your username/email or password are incorrect.", "Error message was Incorrect!");


    }
}
