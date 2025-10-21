package io.taiga;
import io.taiga.api.services.AccountService;
import io.taiga.api.services.ProjectService;
import io.taiga.models.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateProject {
    private User createdUser;

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
        createdUser = AccountService.register(requestBody).then().extract().as(User.class);
    }

    @Test
    public void createProject() {
        Project project = new Project();
        project.setName("Test Project Name");
        project.setDescription("Test Project Description");
        project.setCreation_template(1);
        project.setIs_private(false);

        Project createdProject = ProjectService.createProject(project, createdUser.getAuth_token())
                .then()
                    .statusCode(201)
                    .extract().as(Project.class);

        System.out.println(createdProject);


    }
}
