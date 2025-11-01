package io.taiga;

import io.taiga.api.services.AccountService;
import io.taiga.api.services.ProjectService;
import io.taiga.api.services.UserStoryService;
import io.taiga.api.models.Project;
import io.taiga.api.models.RegisterRequestBody;
import io.taiga.api.models.User;
import io.taiga.api.models.UserStory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class UserStoryTest extends TestBase {
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
    public void getUserStory() {
        UserStory userStory = new UserStory();
        userStory.setProject(createdProject.getId());
        userStory.setSubject("Test Subject " + new Random().nextInt(1000));
        UserStory createdUserStory = UserStoryService
                .create(userStory, createdUser.getAuth_token())
                .then().extract().as(UserStory.class);

        UserStory getUserstory = UserStoryService.get(createdUserStory.getId(), createdUser.getAuth_token())
                .then().extract().as(UserStory.class);
        assertEquals(createdUserStory.getId(), getUserstory.getId());
        //make assertions
    }
    @Test
    public void createUserStory() {
        UserStory userStory = new UserStory();
        userStory.setProject(createdProject.getId());
        userStory.setSubject("Test Subject " + new Random().nextInt(1000));
        UserStory createdUserStory = UserStoryService
                .create(userStory, createdUser.getAuth_token())
                .then().extract().as(UserStory.class);

        //make assertions
    }
    @Test
    public void editUserStory() {
        UserStory userStory = new UserStory();
        userStory.setProject(createdProject.getId());
        userStory.setSubject("Test Subject " + new Random().nextInt(1000));
        UserStory createdUserStory = UserStoryService
                .create(userStory, createdUser.getAuth_token())
                .then().extract().as(UserStory.class);
        createdUserStory.setSubject("New Updated Subject " + new Random().nextInt(1000));
        createdUserStory = UserStoryService.edit(createdUserStory, createdUser.getAuth_token())
                .then()
                .extract().as(UserStory.class);
        System.out.println("Created UserStory: ");

        //make assertions
    }

    @Test
    public void deleteUserStory() {
        UserStory userStory = new UserStory();
        userStory.setProject(createdProject.getId());
        userStory.setSubject("Test Subject " + new Random().nextInt(1000));
        UserStory createdUserStory = UserStoryService
                .create(userStory, createdUser.getAuth_token())
                .then().extract().as(UserStory.class);

        UserStoryService.delete(createdUserStory, createdUser.getAuth_token())
                .then().assertThat().statusCode(204);

        UserStoryService.get(createdUserStory.getId(), createdUser.getAuth_token())
                .then().statusCode(404);

        System.out.printf("Deleted UserStory: %s\n", createdUserStory);
        //make assertions
    }
}
