package io.taiga.selenium.pages.components;

import io.taiga.selenium.factory.DriverFactory;
import io.taiga.selenium.pages.NewProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopNavigationComponent {
    private WebDriver driver;
    By projectItem = By.cssSelector("[tg-nav='projects']");
    By discoverItem = By.cssSelector("[tg-nav='discover']");
    By notificationsItem = By.cssSelector("[tg-nav='notifications']");
    By profileItem = By.cssSelector("[tg-nav='profile']");
    By createProjectItem = By.cssSelector("[tg-nav='create-project']");
    By seeMoreItem = By.cssSelector(".see-more-projects-btn");

    public TopNavigationComponent() {
        this.driver = DriverFactory.get().getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navbar")));
    }

    public NewProjectPage clickCreateProject() {
        Actions actions = new Actions(driver);
        //Hover to projects item
        actions.moveToElement(driver.findElement(projectItem)).build().perform();
        //Click on New project item
        driver.findElement(createProjectItem).click();
        return new NewProjectPage(driver);
    }


}
