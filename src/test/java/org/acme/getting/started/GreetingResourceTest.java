package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy Jacobo"));
    }
    @Test
    void testGreetingEndPoint(){
        String id = UUID.randomUUID().toString();
        given().pathParam("name", id)
                .when().get("/hello/greeting/{name}")
                .then().statusCode(200).body(is("hello "+id));
    }

}