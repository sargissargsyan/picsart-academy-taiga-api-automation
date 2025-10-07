package org.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.Assert.*;

public class Main {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method-----> test is going to be executed");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method-----> Test is executed");
    }

    @Test
    public  void comments() {
        System.out.println("Running the test");
        given().
        when().get("https://jsonplaceholder.typicode.com/posts/1/comments").
        then()
            .assertThat()
            .statusCode(200)
                .body("", hasSize(5))
                .body("[0].email", equalTo("Eliseo@gardner.biz"))
                .body("[0].postId", equalTo(1))
                .body("[0].name", equalTo("id labore ex et quam laborum"))
                .body("[1].email", equalTo("Jayne_Kuhic@sydney.com"));

        assertTrue(false, "True was not True");
        assertFalse(false);

    }

    @Test
    public void postDetails() {
        given().log().all().
                when().
                get("https://jsonplaceholder.typicode.com/posts/1").
                then().
                statusCode(200)
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }
}