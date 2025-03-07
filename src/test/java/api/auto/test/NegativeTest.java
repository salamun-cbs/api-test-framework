package api.auto.test;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class NegativeTest extends BaseTest {

    @Test
    public void testInvalidInput() {

    // JSON sebagai String
        String requestBody = "{ \"name\": 1234, \"job\": QA4 }";

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().post("/users")
                .then().log().all()
                .assertThat().statusCode(400);
    }
}

