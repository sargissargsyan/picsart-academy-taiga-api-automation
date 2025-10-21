package io.taiga;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.taiga.api.services.AccountService;
import io.taiga.api.services.ProjectService;
import io.taiga.models.*;
import io.taiga.utils.Urls;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static io.taiga.utils.Urls.*;
import static org.testng.Assert.*;

public class IssueTest {
    private User createdUser;
    private User loggedInUser;
    private Project createdProject;
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void beforeMethod() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost").setPort(9000)
                .setContentType(ContentType.JSON)
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
        String username = "picartacademy" + new Date().getTime();
        String email = "picsartacademy"+ + new Date().getTime() + "@gmail.com";
        RegisterRequestBody requestBody = new RegisterRequestBody();
        requestBody.setUsername(username);
        requestBody.setPassword("Picsart12345");
        requestBody.setAccepted_terms(true);
        requestBody.setFull_name("Picsart Academy");
        requestBody.setEmail(email);
        requestBody.setType("public");
        createdUser = AccountService.register(requestBody).
                then()
                .spec(responseSpecification)
                .statusCode(201)
                .extract().as(User.class);
        LoginRequestBody loginRequestBody = new LoginRequestBody();
        loginRequestBody.setUsername(createdUser.getUsername());
        loginRequestBody.setPassword("Picsart12345");
        loginRequestBody.setType("normal");
        loggedInUser = AccountService.login(loginRequestBody)
            .then()
                .statusCode(200)
                    .extract().as(User.class);

        Project project = new Project();
        project.setName("Test Project Name");
        project.setDescription("Test Project Description");
        project.setCreation_template(1);
        project.setIs_private(false);

        createdProject = ProjectService.createProject(project, createdUser.getAuth_token())
                .then()
                .spec(responseSpecification)
                .statusCode(201)
                .extract().as(Project.class);
        requestSpecification.header("Authorization", "Bearer " + loggedInUser.getAuth_token());
    }
    @Test
    public void createIssue() {
        Issue issue = new Issue();
        issue.setSubject("Test Issue Subject");
        issue.setProject(createdProject.getId());

        Issue createdIssue = given().spec(requestSpecification).body(issue)
                .when().post(ISSUES_URL)
                .then()
                .spec(responseSpecification)
                .statusCode(201).extract().as(Issue.class);

        IssueStatus[] issueStatuses =  given().spec(requestSpecification)
                .param("project_id", createdProject.getId()).
                when().get(ISSUES_STATUSES_URL)
                .then().log().all()
                .spec(responseSpecification)
                .statusCode(200)
                .extract().as(IssueStatus[].class);

        assertEquals(createdIssue.getProject(), createdProject.getId(), "Incorrect project id!");
        assertEquals(createdIssue.getProject_extra_info().getName(), createdProject.getName(), "Incorrect project name!");
        assertEquals(createdIssue.getStatus_extra_info().getName(), "New", "Incorrect issue status!");
        assertEquals(createdIssue.getOwner_extra_info().getUsername(), createdUser.getUsername(), "Incorrect issue owner username!");
        assertFalse(createdIssue.getIs_watcher(), "Incorrect issue watcher status!");
        assertNull(createdIssue.getGenerated_user_stories(), "Incorrect issue generated user stories!");
        assertNotNull(createdIssue.getCreated_date(), "Incorrect issue created date!");
    }
}
