package TMDB;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Tasks_Diyar {

    RequestSpecification reqSpec;
    String list_id = "879657";

    @BeforeClass
    public void Setup() {
        baseURI = "https://api.themoviedb.org/3";

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c")
                .log(LogDetail.URI)
                .build();
    }

    @Test
    public void searchTVShow() {
        given()
                .spec(reqSpec)
                .queryParam("query", "breaking bad")

                .when()
                .get("/search/tv")

                .then()
                .statusCode(200)
                .body("results.name", hasItem("Breaking Bad"))
                .log().body();
    }

    @Test
    public void searchPerson() {
        given()
                .spec(reqSpec)
                .queryParam("query", "Tom Cruise")

                .when()
                .get("/search/person")

                .then()
                .statusCode(200)
                .body("results.name", hasItem("Tom Cruise"))
                .log().body();
    }

    @Test
    public void searchKeyword() {
        given()
                .spec(reqSpec)
                .queryParam("query", "action")

                .when()
                .get("/search/keyword")

                .then()
                .statusCode(200)
                .body("results.name", hasItem("action"))
                .log().body();
    }

    @Test
    public void addMovieToList() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("media_id", 18);

        given()
                .spec(reqSpec)
                .pathParam("list_id", list_id)
                .queryParam("session_id", "843541")
                .body(requestBody)

                .when()
                .post("/list/{list_id}/add_item")

                .then()
                .statusCode(201)
                .body("status_message", containsString("Success"))
                .log().body();
    }
}