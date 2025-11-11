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
        driver.findElement(RelativeLocator.with(By.cssSelector("[myprop='myvalue']")));
        driver.findElement(By.tagName("textarea")).sendKeys("Hello Selenium!");
        driver.findElement(By.cssSelector("[name='my-disabled']"));


    }

    @Test
    public void valueTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement readOnlyElement = driver.findElement(By.name("my-readonly"));
        String readOnlyValue = readOnlyElement.getAttribute("value");

        assertEquals(readOnlyValue, "Readonly input", "Value was Incorrect!");
    }

    @Test
    public void inputValueTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("Hello Selenium!");
        assertEquals(textInput.getAttribute("value"), "Hello Selenium!", "Value was Incorrect!");
    }

    @Test
    public void testRelativeLocators() {
        driver.get( "https://www.selenium.dev/selenium/web/web-form.html");
        driver.findElement(By.id("my-text-id")).sendKeys("Hello Selenium!");
        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
        button.click();

        String message = driver.findElement(By.cssSelector(".lead")).getText();

        assertEquals(message, "Received!", "Label was Incorrect!");
    }


}
