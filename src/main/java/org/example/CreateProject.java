package org.example;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.models.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class CreateProject {
    private User createdUser;
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
        String username = "picartacademy" + new Random().nextInt(1000);
        String email = "picsartacademy"+ new Random().nextInt(1000) + "@gmail.com";
        RegisterRequestBody requestBody = new RegisterRequestBody();
        requestBody.setUsername(username);
        requestBody.setPassword("Picsart12345");
        requestBody.setAccepted_terms(true);
        requestBody.setFull_name("Picsart Academy");
        requestBody.setEmail(email);
        requestBody.setType("public");
        createdUser = given()
                .spec(requestSpecification)
                .body(requestBody).
                when()
                .post("/api/v1/auth/register").
                then().log().all()
                .spec(responseSpecification)
                .statusCode(201)
                .extract().as(User.class);
    }

    @Test
    public void createProject() {
        Project project = new Project();
        project.setName("Test Project Name");
        project.setDescription("Test Project Description");
        project.setCreation_template(1);
        project.setIs_private(false);

        Project createdProject = given()
                    .spec(requestSpecification)
                    .body(project)
                    .header("Authorization", "Bearer " + createdUser.getAuth_token()).
                when()
                    .post("/api/v1/projects")
                .then().log().all()
                    .spec(responseSpecification)
                    .statusCode(201)
                    .extract().as(Project.class);

        Issue issue = new Issue();
        issue.setSubject("Test Issue Subject");
        issue.setProject(createdProject.getId());

        Issue createdIssue = given().spec(requestSpecification).body(issue)
                .when().post("/api/v1/issues")
                .then()
                .spec(responseSpecification)
                .statusCode(201).extract().as(Issue.class);

        IssueStatus[] issueStatuses =  given().spec(requestSpecification)
                .param("project_id", createdProject.getId())
                .header("Authorization", "Bearer " + createdUser.getAuth_token()).
                when().get("/api/v1/issue-statuses")
                .then().log().all()
                .spec(responseSpecification)
                .statusCode(200)
                .extract().as(IssueStatus[].class);

        System.out.println(createdProject);


    }

    @Test
    public void createProjectWithUser() {

    }
}
