package org.example;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.models.Project;
import org.example.models.ProjectRequestBody;
import org.example.models.RegisterRequestBody;
import org.example.models.User;
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
        String username = "picartacademy" + new Random().nextInt(100);
        String email = "picsartacademy"+ + new Random().nextInt(100) + "@gmail.com";
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
        ProjectRequestBody project = new ProjectRequestBody();
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

        System.out.println(createdProject);
    }
}
