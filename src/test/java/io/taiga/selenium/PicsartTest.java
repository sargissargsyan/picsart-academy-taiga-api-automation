package io.taiga.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.taiga.selenium.base.TestSeleniumBase;
import io.taiga.selenium.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PicsartTest extends TestSeleniumBase {
    private WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.get().getDriver();
    }


    @Test
    public void uiTest() throws InterruptedException {
        driver.get("https://picsartstage2.com/");
//        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[data-pulse-section='authentication'] [data-testid='button']")).click();
        driver.findElement(By.cssSelector("[data-pulse-name='Continue with email | username']")).click();

//        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[data-testid='email-field-input']")).sendKeys("picsartacademy2025@test.am");
        driver.findElement(By.cssSelector("[data-testid='reg-continue-button']")).click();
//        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[data-testid='insertPassword-input']")).sendKeys("picsartacademy20");
        driver.findElement(By.cssSelector("[data-testid='reg-continue-button']")).click();
        Thread.sleep(3000);

        driver.get("https://picsartstage2.com/create/editor?category=photos&projectId=691c09b952ebc41368ad10d6");

//        Thread.sleep(2000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Actions actions = new Actions(driver);
//        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.cssSelector("[class^= 'canvasWrapper'][data-testid='canvas-wrapper']"))).build().perform();
//        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.cssSelector("[data-testid='highlight-rect']"))).click().build().perform();

        driver.findElement(By.cssSelector("[data-testid='toolbar-more-button']")).click();
//        Thread.sleep(500);
        driver.findElement(By.cssSelector("[data-testid='animation']")).click();
//        Thread.sleep(2000);

        driver.findElements(By.cssSelector("[data-testid='animationShelveHeader'] button")).get(1).click();
        WebElement basicScrollable = driver.findElements(By.cssSelector("[data-testid='body'] [data-testid='scrollbox']")).get(1);

        actions.moveToElement(basicScrollable).build().perform();
        basicScrollable.findElement(By.cssSelector("[class^='rightArrow']")).click();
//        Thread.sleep(1000);
        basicScrollable.findElement(By.cssSelector("[class^='rightArrow']")).click();
//        Thread.sleep(1000);
        basicScrollable.findElement(By.cssSelector("[class^='rightArrow']")).click();
//        Thread.sleep(1000);
        basicScrollable.findElement(By.cssSelector("[class^='rightArrow']")).click();

        System.out.printf("Test");





    }
}
