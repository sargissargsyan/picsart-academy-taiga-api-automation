package io.taiga;
import io.taiga.api.services.AccountService;
import io.taiga.api.services.ProjectService;
import io.taiga.models.*;
import io.taiga.utils.TestRetryAnalyzer;
import lombok.extern.java.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

@Log
public class ProjectTest {
    private User createdUser;

    @BeforeMethod
    public void beforeMethod() {
        log.info("Setting up test data - creating new user");
        String username = "picartacademy" + new Random().nextInt(1000);
        String email = "picsartacademy"+ new Random().nextInt(1000) + "@gmail.com";
        log.info("Generated test username: " + username);
        
        RegisterRequestBody requestBody = new RegisterRequestBody();
        requestBody.setUsername(username);
        requestBody.setPassword("Picsart12345");
        requestBody.setAccepted_terms(true);
        requestBody.setFull_name("Picsart Academy");
        requestBody.setEmail(email);
        requestBody.setType("public");
        
        createdUser = AccountService.register(requestBody).then().extract().as(User.class);
        log.info("User created successfully with ID: " + createdUser.getId());
    }

    @Test(retryAnalyzer = TestRetryAnalyzer.class)
    public void createProject() {
        log.info("Starting project creation test");
        
        Project project = new Project();
        project.setName("Test Project Name");
        project.setDescription("Test Project Description");
        project.setCreation_template(1);
        project.setIs_private(false);
        log.info("Project object created with name: " + project.getName());

        Project createdProject = ProjectService.createProject(project, createdUser.getAuth_token())
                .then()
                    .statusCode(201)
                    .extract().as(Project.class);

        log.info("Project created successfully with ID: " + createdProject.getId());
        log.warning("Forcing test failure for retry demonstration");
        assertTrue(false);
    }
}
