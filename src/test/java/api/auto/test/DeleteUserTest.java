package api.auto.test;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.given;

public class DeleteUserTest extends BaseTest {

    @Test
    public void testDeleteUser() {

        // Data to Delete
        int userToDelete = 4;

        // Test DELETE api/users/4
        RestAssured.given()
                .log().all()
                .when().delete("users/" + userToDelete)
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }
}
