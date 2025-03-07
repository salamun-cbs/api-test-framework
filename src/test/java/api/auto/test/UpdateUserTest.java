package api.auto.test;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpdateUserTest extends BaseTest {

    @Test
    public void testPatchUser() {

        // Data to update
        int userId = 3;
        String newName = "Salamun updatedUser";

        // Test PATCH userId 3 --> update first name
        // First, Get the first name of userId 3
        String fname = given().when().get("/users/"+userId).getBody().jsonPath().get("data.first_name");
        System.out.println("name before update : " + fname);

        // Change he first name to "updatedUser"
        // create body request with HashMap and Convert it to json
        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("content-Type", "application/json")
                .body(jsonObject.toString())
                .patch("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));
    }
}
