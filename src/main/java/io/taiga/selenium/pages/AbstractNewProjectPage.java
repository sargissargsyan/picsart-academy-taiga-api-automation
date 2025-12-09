package io.taiga.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractNewProjectPage extends PageBase {
    private By backButton = By.cssSelector(".create-project-action-cancel");
    private By submitButton = By.cssSelector(".create-project-action-submit");
    private By projectNameField = By.cssSelector("[name='project-name']");
    private By projectDescriptionField = By.cssSelector("[name='projectForm'] textarea");
    private By projectTemplatesField = By.cssSelector(".create-project-privacity fieldset");

    public void setName(String projectName) {
        driver.findElement(projectNameField).sendKeys(projectName);
    }

    public void setDescription(String description) {
        driver.findElement(projectDescriptionField).sendKeys(description);
    }

    public void clickPrivateTemplate() {
        driver.findElements(projectTemplatesField).get(1).click();
    }

    public void clickPublicTemplate() {
        driver.findElements(projectTemplatesField).get(0).click();
    }

    public NewProjectPage clickBackButton() {
        driver.findElement(backButton).click();
        return new NewProjectPage(driver);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
