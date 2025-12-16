package io.taiga.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import io.taiga.api.models.Project;
import io.taiga.api.models.RegisterRequestBody;
import io.taiga.api.models.User;
import io.taiga.api.services.ProjectService;
import io.taiga.api.services.RegisterService;
import io.taiga.selenium.base.TestSeleniumBase;
import io.taiga.selenium.pages.*;
import io.taiga.selenium.pages.components.TopNavigationComponent;
import io.taiga.utils.TestUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ProjectTest extends TestSeleniumBase {
    private User createdUser;
    private Project createdProject;
    private WebDriverWait wait;
    private Response response;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void beforeMethod() {
        String username = "picartacademy" + new Random().nextInt(1000);
        String email = "picsartacademy"+ new Random().nextInt(1000) + "@gmail.com";
        RegisterRequestBody requestBody = new RegisterRequestBody();
        requestBody.setUsername(username);
        requestBody.setPassword("Picsart12345");
        requestBody.setAccepted_terms(true);
        requestBody.setFull_name("Picsart Academy");
        requestBody.setEmail(email);
        requestBody.setType("public");
        response = RegisterService.register(requestBody);
        createdUser = response.then().extract().as(User.class);
        Project project = new Project();
        project.setName("Test Project Name");
        project.setDescription("Test Project Description");
        project.setCreation_template(1);
        project.setIs_private(false);
        createdProject = ProjectService.createProject(project, createdUser.getAuth_token())
                .then()
                .statusCode(201)
                .extract().as(Project.class);
        login(createdUser);
    }

    @Test
    public void projectTest() throws InterruptedException {
        ProjectDetailsPage projectPage = new ProjectDetailsPage();
        projectPage.goTo(createdProject);
        System.out.printf("sfdsd");
    }

    @Test
    public void createProject() throws InterruptedException {
        new LoginPage().refresh();
        TopNavigationComponent navBar = new TopNavigationComponent();
        NewScrumProjectPage newScrumProjectPage = new TopNavigationComponent()
                .clickCreateProject()
                .selectScrum();
        newScrumProjectPage.setName("Project Scrum " + TestUtils.randomString(5));
        newScrumProjectPage.setDescription("Project Scrum " + TestUtils.randomString(5));
        newScrumProjectPage.clickPublicTemplate();
        newScrumProjectPage.clickSubmitButton();

        System.out.printf("sfdsd");
    }

    @Test
    public void duplicateProject() {
        new LoginPage().refresh();
        TopNavigationComponent navBar = new TopNavigationComponent();
        NewProjectPage newProjectPage = navBar.clickCreateProject();
        NewDuplicateProjectPage newScrumProjectPage = newProjectPage.selectDuplicate();
        newScrumProjectPage.selectTargetProject();
        newScrumProjectPage.setName("Project Scrum " + TestUtils.randomString(5));
        newScrumProjectPage.setDescription("Project Scrum " + TestUtils.randomString(5));
        newScrumProjectPage.clickPublicTemplate();
        newScrumProjectPage.clickSubmitButton();

        System.out.printf("sfdsd");
    }
}
