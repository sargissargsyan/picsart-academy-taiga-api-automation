package io.taiga.selenium.pages;

import org.openqa.selenium.WebDriver;

public class NewKanbanProjectPage extends AbstractNewProjectPage {


    private static final String URL_PATH = "/project/new/kanban";

    public void goTo() {
        driver.get(BASE_URL + URL_PATH);
    }




}
