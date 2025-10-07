package org.example;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class Main {
    public static void main(String[] args) throws IOException {
        given().log().all().
        when().
            get("https://jsonplaceholder.typicode.com/posts/1").
        then().
            statusCode(200)
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));


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

    }
}