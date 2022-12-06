import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;

public class testAPI {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://catfact.ninja/";
    }
    @Test
    public void checkFreeAPI() {
        Response response = get("/fact");
        response.getBody().prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        String fact = jsonPath.getString("fact");

        System.out.println("Fact: " + fact);

        response.then().body("fact", containsString("cat"));
        response.then().statusCode(200);
    }
}
