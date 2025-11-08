package io.taiga.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstSeleniumTest {
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
    public void uiTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        assertEquals(driver.getTitle(), "Web form", "Title was Incorrect!");

        driver.findElement(By.id("my-text-id")).sendKeys("Hello Selenium!");
        driver.findElement(By.cssSelector("#my-text-id"));
        driver.findElement(By.cssSelector("[id='my-text-id']"));
        driver.findElement(By.xpath("//*[@id=\"my-text-id\"]"));
        driver.findElement(By.name("my-text"));
        driver.findElement(By.cssSelector("[myprop='myvalue']"));


    }
}
