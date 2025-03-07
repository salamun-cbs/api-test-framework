package api.auto.test;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest extends BaseTest {

    @Test
    public void testPostCreateUsers() {
        String valueName = "Salamun";
        String valueJob = "QA";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", valueName);
        bodyObj.put("job", valueJob);

        RestAssured.given()
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when()
                .post("/users").then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("name", equalTo(valueName));
    }
}
