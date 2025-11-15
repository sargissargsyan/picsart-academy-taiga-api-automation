package io.taiga.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.testng.Assert.*;

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


    @Test
    public void checkbox() {
        driver.get( "https://www.selenium.dev/selenium/web/web-form.html");

        driver.findElement(new ByIdOrName("my-text-id")).click();

        WebElement checkbox1 =  driver.findElement(By.id("my-check-1"));
        WebElement checkbox2 =  driver.findElement(By.id("my-check-2"));
        assertTrue(checkbox1.isSelected(), "Checkbox was not selected!");
        assertFalse(checkbox2.isSelected(), "Checkbox was selected!");

        checkbox1.click();
        checkbox2.click();
        assertFalse(checkbox1.isSelected(), "Checkbox was selected!");
        assertTrue(checkbox2.isSelected(), "Checkbox was not selected!");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".form-check-label"));

        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals("Default radio")) {
                checkbox.click();

            }

        }
        driver.findElement(By.cssSelector(".form-check"))
                .findElements(By.tagName("label")).get(0)
                .findElement(By.tagName("input")).isSelected();

    }

    @Test
    public void select() {

        driver.get( "https://www.selenium.dev/selenium/web/web-form.html");
        Select select = new Select(driver.findElement(By.name("my-select")));
        select.selectByValue("2");
        assertEquals(select.getFirstSelectedOption().getText(), "Two", "Selected value was Incorrect!");
    }

    @Test
    public void fileUpload() throws IOException {

        driver.get( "https://www.selenium.dev/selenium/web/web-form.html");
        WebElement fileInput = driver.findElement(By.name("my-file"));

        Path path = Files.createTempFile("temp", ".png");
        String absalutePath = path.toAbsolutePath().toString();

        fileInput.sendKeys(absalutePath);
    }


    @Test
    public void slider() throws IOException {

        driver.get( "https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = driver.findElement(By.name("my-range"));
        String value = slider.getAttribute("value");
        String maxValue = slider.getAttribute("max");
        String minValue = slider.getAttribute("min");

        for (int i = 0; i < 4; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

    }

}
