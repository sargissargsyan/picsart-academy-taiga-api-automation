package io.taiga.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.taiga.api.models.Project;
import io.taiga.api.models.RegisterRequestBody;
import io.taiga.api.models.User;
import io.taiga.api.services.ProjectService;
import io.taiga.api.services.RegisterService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ProjectTest {
    private User createdUser;
    private Project createdProject;
    private WebDriver driver;
    private WebDriverWait wait;
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
        createdUser = RegisterService.register(requestBody).then().extract().as(User.class);
        Project project = new Project();
        project.setName("Test Project Name");
        project.setDescription("Test Project Description");
        project.setCreation_template(1);
        project.setIs_private(false);
        createdProject = ProjectService.createProject(project, createdUser.getAuth_token()).then().extract().as(Project.class);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void projectTest() throws InterruptedException {
        driver.get("http://localhost:9000/login");



        driver.get("http://localhost:9000/project/" + createdProject.getSlug());
        System.out.printf("sfdsd");
    }
}
