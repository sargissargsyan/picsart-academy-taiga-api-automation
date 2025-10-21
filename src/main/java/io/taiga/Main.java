package io.taiga;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.Assert.*;

public class Main {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void beforeMethod() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com").build();
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method-----> Test is executed");
    }

    @Test
    public  void comments() {System.out.println("Running the test");
    given().spec(requestSpecification).
        when().get("/posts/1/comments").
        then()
            .spec(responseSpecification)
            .and()
            .assertThat()
                .body("", hasSize(5))
                .body("[0].email", equalTo("Eliseo@gardner.biz"))
                .body("[0].postId", equalTo(1))
                .body("[0].name", equalTo("id labore ex et quam laborum"))
                .body("[1].email", equalTo("Jayne_Kuhic@sydney.com"));
    }

    @Test
    public void postDetails() {
        int postId = given().spec(requestSpecification).
                when().
                    get("/posts/1").
                then().
                    spec(responseSpecification)
                .and()
                    .body("id", equalTo(1))
                    .body("userId", equalTo(1))
                    .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                    .body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))
                    .extract().path("id");
        System.out.println("Post Id is ----->" + postId);
        assertEquals(postId, 1, "Post id was not equal to 1");
    }
}