package org.agoncal.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldCreateABook() {
        given()
                .formParam("title", "Understanding Quarkus")
                .formParam("author", "Vipul Mehra")
                .formParam("year", 2023)
                .formParam("genre", "IT")
          .when().post("/api/books")
          .then()
             .statusCode(201)
             .body("isbn_13", startsWith("13-"))
             .body("title", startsWith("Understanding Quarkus"))
             .body("author", startsWith("Vipul"))
             .body("year_of_publication", is(2023))
             .body("genre", is("IT"))
             .body("creation_date", startsWith("20"));
    }

}