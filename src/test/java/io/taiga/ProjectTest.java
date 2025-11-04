package io.taiga;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.taiga.api.services.AccountService;
import io.taiga.api.services.ProjectService;
import io.taiga.api.models.Project;
import io.taiga.api.models.RegisterRequestBody;
import io.taiga.api.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class ProjectTest extends TestBase {
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

    @Test(priority = 1)
    @Owner("Sargis Sargsyan")
    @Description("Create project and check the status code")
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
    }
}
