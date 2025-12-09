package io.taiga.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewDuplicateProjectPage extends AbstractNewProjectPage {
    private By targetProjectSelect = By.id("project-selector-dropdown");

    private static final String URL_PATH = "/project/new/duplicate";

    public NewDuplicateProjectPage(WebDriver driver) {
        super.driver = driver;
    }

    public void goTo() {
        driver.get(BASE_URL + URL_PATH);
    }


    public void selectTargetProject() {
        Select select = new Select(driver.findElement(targetProjectSelect));
        select.selectByIndex(1);
    }



}
