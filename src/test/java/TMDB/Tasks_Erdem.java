package TMDB;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Tasks_Erdem {
    RequestSpecification reqSpec;

    @BeforeClass
    public void Specs() {
        baseURI = "https://api.themoviedb.org/3";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c";

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    @Test
    public void PostAddRating() {
        Map<String, Double> rating = new HashMap<>();
        rating.put("value", 8.5);

        given()
                .spec(reqSpec)
                .body(rating)

                .when()
                .post("/movie/16/rating")

                .then()
                .statusCode(201)
                .log().body()
        ;
    }

    @Test
    public void GetNowPlaying() {
        given()
                .spec(reqSpec)

                .when()
                .get("/movie/now_playing")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }

    @Test
    public void GetTVList() {
        given()
                .spec(reqSpec)

                .when()
                .get("/genre/tv/list")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }

    @Test
    public void GetMovieList() {
        given()
                .spec(reqSpec)

                .when()
                .get("/genre/movie/list")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }
}
