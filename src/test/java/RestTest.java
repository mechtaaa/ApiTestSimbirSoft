
import io.restassured.RestAssured;

import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestTest {
    @Test
    public void createFolder() {
        RestAssured.given()
                .header("Authorization", "OAuth y0_AgAAAABlgXnDAAiE_wAAAADSCblfnW3q8aIXST2me7F2-UQGygp7os8")
                .when()
                .contentType("application/json")
                .accept("*/*")
                .put("https://cloud-api.yandex.net/v1/disk/resources?path=TestApi")
                .then()
                .assertThat()
                .statusCode(201)
                .body("href", equalTo("https://cloud-api.yandex.net/v1/disk/resources?path=disk%3A%2FTestApi"))
                .body("method", equalTo("GET"))
                .body("templated", equalTo(false));
    }
    @After
    public void deleteFolder(){
        RestAssured.given()
                .header("Authorization", "OAuth y0_AgAAAABlgXnDAAiE_wAAAADSCblfnW3q8aIXST2me7F2-UQGygp7os8")
                .when()
                .contentType("application/json")
                .accept("*/*")
                .delete("https://cloud-api.yandex.net/v1/disk/resources?path=TestApi")
                .then()
                .assertThat()
                .statusCode(204);

    }
}