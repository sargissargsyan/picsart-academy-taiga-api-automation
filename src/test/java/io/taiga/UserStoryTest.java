package io.taiga;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.taiga.api.services.AccountService;
import io.taiga.api.services.ProjectService;
import io.taiga.api.services.UserStoryService;
import io.taiga.models.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Random;

public class UserStoryTest {
    private User createdUser;
    private Project createdProject;


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

        Project project = new Project();
        project.setName("Test Project Name");
        project.setDescription("Test Project Description");
        project.setCreation_template(1);
        project.setIs_private(false);

        createdProject = ProjectService.createProject(project, createdUser.getAuth_token()).then().extract().as(Project.class);
    }

    @Test
    public void createUserStory() {
        UserStory userStory = new UserStory();
        userStory.setProject(createdProject.getId());
        userStory.setSubject("Test Subject " + new Random().nextInt(1000));
        UserStory createdUserStory = UserStoryService
                .createUserStory(userStory, createdUser.getAuth_token())
                .then().log().all().extract().as(UserStory.class);

        //make assertions
    }
    @Test
    public void editUserStory() {
        UserStory userStory = new UserStory();
        userStory.setProject(createdProject.getId());
        userStory.setSubject("Test Subject " + new Random().nextInt(1000));
        UserStory createdUserStory = UserStoryService
                .createUserStory(userStory, createdUser.getAuth_token())
                .then().log().all().extract().as(UserStory.class);
        createdUserStory.setSubject("New Updated Subject " + new Random().nextInt(1000));
        createdUserStory = UserStoryService.editUserStory(createdUserStory, createdUser.getAuth_token())
                .then().log().all()
                .extract().as(UserStory.class);
        System.out.println("Created UserStory: ");

        //make assertions
    }
}
