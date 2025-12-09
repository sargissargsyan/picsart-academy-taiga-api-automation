package io.taiga.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectPage extends PageBase {
    private By scrumItem = By.cssSelector("[tg-nav='create-project-scrum']");
    private By kanbanItem = By.cssSelector("[tg-nav='create-project-kanban']");
    private By duplicateItem = By.cssSelector("[tg-nav='create-project-duplicate']");
    private By importItem = By.cssSelector("[tg-nav='create-project-import']");

    private static final String URL_PATH = "/project/new";

    public NewProjectPage(WebDriver driver) {
        super.driver = driver;
    }

    public void goTo() {
        driver.get(BASE_URL + URL_PATH);
    }

    public NewScrumProjectPage selectScrum() {
        driver.findElement(scrumItem).click();
        return new NewScrumProjectPage(driver);
    }

    public NewKanbanProjectPage selectKanban() {
        driver.findElement(kanbanItem).click();
        return new NewKanbanProjectPage(driver);
    }

    public NewDuplicateProjectPage selectDuplicate() {
        driver.findElement(duplicateItem).click();
        return new NewDuplicateProjectPage(driver);
    }

    public void selectImport() {
        driver.findElement(importItem).click();
    }
}
