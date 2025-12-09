package io.taiga.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewScrumProjectPage extends AbstractNewProjectPage {


    private static final String URL_PATH = "/project/new/scrum";

    public NewScrumProjectPage(WebDriver driver) {
        super.driver = driver;
    }

    public void goTo() {
        driver.get(BASE_URL + URL_PATH);
    }




}
