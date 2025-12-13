package io.taiga.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractNewProjectPage extends PageBase {
    private By backButton = By.cssSelector(".create-project-action-cancel");
    private By submitButton = By.cssSelector(".create-project-action-submit");
    private By projectNameField = By.cssSelector("[name='project-name']");
    private By projectDescriptionField = By.cssSelector("[name='projectForm'] textarea");
    private By projectTemplatesField = By.cssSelector(".create-project-privacity fieldset");

    public void setName(String projectName) {
        type(projectNameField, projectName);
    }

    public void setDescription(String description) {
        type(projectDescriptionField, description);
    }

    public void clickPrivateTemplate() {
        WebElement privateTemplateOption = findElements(projectTemplatesField).get(1);
        click(privateTemplateOption);
    }

    public void clickPublicTemplate() {
        WebElement publicTemplateOption = findElements(projectTemplatesField).get(0);
        click(publicTemplateOption);
    }

    public NewProjectPage clickBackButton() {
        click(backButton);
        return new NewProjectPage(driver);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }
}
