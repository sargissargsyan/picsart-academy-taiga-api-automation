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
        click(scrumItem);
        waitPageToBeLoaded();
        return new NewScrumProjectPage();
    }

    public NewKanbanProjectPage selectKanban() {
        click(kanbanItem);
        return new NewKanbanProjectPage();
    }

    public NewDuplicateProjectPage selectDuplicate() {
        click(duplicateItem);
        return new NewDuplicateProjectPage();
    }

    public void selectImport() {
        click(importItem);
    }
}
