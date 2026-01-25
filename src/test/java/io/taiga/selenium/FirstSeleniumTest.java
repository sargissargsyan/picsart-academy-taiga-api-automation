package io.taiga.selenium;

import io.taiga.selenium.base.TestSeleniumBase;
import io.taiga.selenium.factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v142.performance.Performance;
import org.openqa.selenium.devtools.v142.performance.model.Metric;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static org.testng.Assert.*;

public class FirstSeleniumTest extends TestSeleniumBase {
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.get().getDriver();
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
        assertTrue(false);


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
    public void fileUpload() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement fileInput = driver.findElement(By.name("my-file"));

        // Volume mount: docker-compose mounts .:/app, so file is at /app/...
        String filePath = "/app/src/main/resources/test.png";

        fileInput.sendKeys(filePath);
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

        DevTools devTools = ((ChromeDriver) driver).getDevTools();

        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        List<Metric> metrics = devTools.send(Performance.getMetrics());

        metrics.forEach(metric -> System.out.printf("{}: {}", metric.getName(), metric.getValue()));

    }
    @Test
    public void rightClick() throws IOException {

        Actions actions = new Actions(driver);

        driver.get( "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
        WebElement dropdown1 = driver.findElement(By.id("my-dropdown-1"));
        dropdown1.click();

        WebElement dropdown2 = driver.findElement(By.id("my-dropdown-2"));
        actions.contextClick(dropdown2).build().perform();

        WebElement dropdown3 = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropdown3).build().perform();


    }

    @Test
    public void hover() {

        Actions actions = new Actions(driver);

        driver.get( "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");


        WebElement compass = driver.findElement(By.cssSelector("[src='img/compass.png']"));
        actions.moveToElement(compass).build().perform();
        WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("div")).near(compass));

        assertEquals(caption.getText(), "Compass", "Caption was Incorrect!");

        WebElement calendar = driver.findElement(By.cssSelector("[src='img/calendar.png']"));
        actions.moveToElement(calendar).build().perform();
        caption = driver.findElement(RelativeLocator.with(By.tagName("div")).near(calendar));

        assertEquals(caption.getText(), "Calendar", "Caption was Incorrect!");

        WebElement award = driver.findElement(By.cssSelector("[src='img/award.png']"));
        actions.moveToElement(award).build().perform();
        caption = driver.findElement(RelativeLocator.with(By.tagName("div")).near(award));

        assertEquals(caption.getText(), "Award", "Caption was Incorrect!");
        WebElement landscape = driver.findElement(By.cssSelector("[src='img/landscape.png']"));
        actions.moveToElement(landscape).build().perform();
        caption = driver.findElement(RelativeLocator.with(By.tagName("div")).near(landscape));

        assertEquals(caption.getText(), "Landscape", "Caption was Incorrect!");
    }


    @Test
    public void dragAndDrop() {
        Actions actions = new Actions(driver);
        driver.get( "https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("target"));

        actions.dragAndDrop(draggable, droppable).build().perform();

        actions.dragAndDropBy(draggable, 100, 0)
                .dragAndDropBy(draggable, 0, 100)
                .dragAndDropBy(draggable, -100, -50)
                .dragAndDropBy(draggable, 0,0).build().perform();

        actions.dragAndDropBy(draggable, driver.manage().window().getSize().getHeight()-100, driver.manage().window().getSize().getWidth()-300).build().perform();

    }

    @Test
    public void draw() {
        Actions actions = new Actions(driver);
        driver.get( "https://bonigarcia.dev/selenium-webdriver-java/draw-in-canvas.html");
        WebElement canvas = driver.findElement(By.id("my-canvas"));


        actions.moveToElement(canvas);
        actions.clickAndHold();
        int radius = 50;
        int numberOfPoints = 36;

        for (int i = 0; i < numberOfPoints; i++) {
            double angle = Math.toDegrees(360/ 36 * i);
            double x = Math.sin(angle) * radius;
            double y = Math.cos(angle) * radius;
            actions.moveByOffset((int)x, (int)y);
        }
        actions.release().build().perform();

        System.out.printf("jh");
    }

    @Test
    public void implicitWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement compass = driver.findElement(By.id("compass"));
        assertTrue(compass.getAttribute("src").contains("img/compass.png"), "Src was Incorrect!");

    }

    @Test
    public void explicitWait() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,1000);");
        Thread.sleep(500);
        jsExecutor.executeScript("window.scrollBy(0,10);");
        jsExecutor.executeScript("window.scrollBy(0,10);");
        jsExecutor.executeScript("window.scrollBy(0,10);");
        jsExecutor.executeScript("window.scrollBy(0,10);");
        jsExecutor.executeScript("window.scrollBy(0,10);");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='3']")));

        driver.findElement(By.xpath("//span[text()='3']")).click();
        driver.findElement(By.xpath("//span[text()='+']")).click();
        driver.findElement(By.xpath("//span[text()='2']")).click();
        driver.findElement(By.xpath("//span[text()='=']")).click();


        wait.until(ExpectedConditions.textToBe(By.cssSelector(".screen"), "5"));

        Wait<WebDriver> fluentWait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        assertEquals(driver.findElement(By.cssSelector(".screen")).getText(), "5", "Result was Incorrect!");

    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement lastP = driver.findElement(By.cssSelector("p:last-child"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", lastP);

        jsExecutor.executeScript("window.scrollBy(0,1000);");
        jsExecutor.executeScript("window.scrollBy(0,1000);");
        jsExecutor.executeScript("window.scrollBy(0,1000);");

    }

    @Test
    public void alerts() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "cheese", "Alert was Incorrect!");
        alert.accept();

        driver.findElement(By.id("prompt")).click();
        alert.sendKeys("cheese");
        alert.dismiss();



    }
    @Test
    public void cookies() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
        driver.manage().getCookies();
        driver.manage().getCookieNamed("username");

        Cookie cookie = new Cookie("username", "admin");
        driver.manage().addCookie(cookie);
    }

    @Test
    public void localStorage() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-storage.html");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("localStorage.setItem('username', 'admin');");

        driver.findElement(By.id("display-local")).click();
        String localStorageText = driver.findElement(By.id("local-storage")).getText();

        assertEquals(localStorageText, "{\"username\":\"admin\"}", "LocalStorage was Incorrect!");

    }

    @Test
    public void newTab() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/xhtmlTest.html");
        driver.findElement(By.name("windowOne")).click();
        Set<String> initTabHandlers = driver.getWindowHandles();
        driver.switchTo().window(initTabHandlers.toArray()[1].toString());
        System.out.printf(driver.findElement(By.cssSelector(".items")).getText()) ;
    }
    @Test
    public void iFrame() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/click_tests/click_in_iframe.html");
//        driver.switchTo().frame("ifr");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("ifr")));
        driver.findElement(By.id("link")).click();
    }

    @Test
    public void iFrameMove() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");
//        driver.switchTo().frame("ifr");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("my-iframe")));
        //move to initial fream
        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector(".display-4"));
    }
}
