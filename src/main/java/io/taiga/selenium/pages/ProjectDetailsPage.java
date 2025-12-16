package io.taiga.selenium.pages;

import io.taiga.api.models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectDetailsPage extends PageBase {
    private static final String URL_PATH = "/project/";
    private By projectNameTitle = By.cssSelector(".intro-title .project-name");
    private By likeButton = By.cssSelector(".track-buttons-container tg-like-project-button");


    public void goTo(Project project) {
        driver.get(BASE_URL + URL_PATH + project.getSlug());
    }

    public void goTo(String slug) {
        driver.get(BASE_URL + URL_PATH + slug);
    }


}
