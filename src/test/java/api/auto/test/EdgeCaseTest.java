package api.auto.test;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EdgeCaseTest extends BaseTest {

    @Test
    public void testMinimumBoundary() {
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "A");
        requestBody.put("job", "Intern");

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().post("/users")
                .then().log().all()
                .assertThat().statusCode(201);
    }

    @Test
    public void testMaximumBoundary() {
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "A".repeat(50));
        requestBody.put("job", "Senior Developer");

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().post("/users")
                .then().log().all()
                .assertThat().statusCode(201);
    }

    @Test
    public void testOutOfRange() {
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "A".repeat(51));
        requestBody.put("job", "Lead Developer");

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().post("/users")
                .then().log().all()
                .assertThat().statusCode(400);
    }
}
