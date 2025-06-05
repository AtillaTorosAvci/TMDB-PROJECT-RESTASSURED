package TMDB;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Tasks_Atilla {

    RequestSpecification reqSpec;
    int movieID = 58;
    int accountID=585858;

    @BeforeClass
    public void Setup() {
        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c") // verkort
                .log(LogDetail.URI)
                .build()
        ;
    }

    @Test
    public void testAddMovieToWatchlist() {
        Map<String, Object> addMovie = new HashMap<>();
        addMovie.put("media_type", "movie");
        addMovie.put("media_id", movieID);
        addMovie.put("watchlist", true);

        given()
                .spec(reqSpec)
                .pathParam("account_id", accountID)
                .body(addMovie)

                .when()
                .post("https://api.themoviedb.org/3/account/{account_id}/watchlist")

                .then()
                .statusCode(201)
                .body("success", equalTo(true))
                .body("status_code", equalTo(12))
                .log().body()
        ;
    }


    @Test
    public void getRatedMovies() {
        given()
                .spec(reqSpec)
                .pathParam("account_id", accountID)

                .when()
                .get("https://api.themoviedb.org/3/account/{account_id}/rated/movies")

                .then()
                .statusCode(200)
                .body("results", not(empty()))
                .body("results[0].title", equalTo("Dancer in the Dark"))
                .log().body()
        ;
    }

    @Test
    public void getWatchlistMovies() {
        given()
                .spec(reqSpec)
                .pathParam("account_id", accountID)

                .when()
                .get("https://api.themoviedb.org/3/account/{account_id}/watchlist/movies")

                .then()
                .statusCode(200)
                .body("results.find { it.id == 58 }.title", equalTo("Pirates of the Caribbean: Dead Man's Chest"))
                .log().body()
        ;
    }

    @Test
    public void getGenres() {
        given()
                .spec(reqSpec)

                .when()
                .get("https://api.themoviedb.org/3/genre/movie/list")

                .then()
                .statusCode(200)
                .body("genres.name", hasItems("Action", "Drama", "Comedy"))
                .log().body();
    }



}
