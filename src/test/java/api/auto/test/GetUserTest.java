package api.auto.test;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetUserTest extends BaseTest {

    @Test
    public void testGetListUsers() {
        RestAssured
                .given().when()
                .get("/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("per_page", equalTo(6))
                .assertThat().body("page", equalTo(2));

    }

}
