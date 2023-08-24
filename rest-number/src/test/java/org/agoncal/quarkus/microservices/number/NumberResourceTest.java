package org.agoncal.quarkus.microservices.number;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.google.inject.matcher.Matchers.not;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.hasKey;

@QuarkusTest
public class NumberResourceTest {

    @Test
    public void testHelloEndpoint() {
        ValidatableResponse z = given()
                .when().get("/api/numbers")
                .then()
                .statusCode(200)
                .body("isbn_13", startsWith("13-"))
                .body("isbn_10", startsWith("10-"))
                .body(Matchers.not(hasKey("generationDate")));
    }

}