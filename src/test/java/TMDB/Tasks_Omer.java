package TMDB;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Tasks_Omer {

    RequestSpecification reqSpec ;
    int Account_id = 22032105;

    @BeforeClass
    public void Specs () {
        baseURI = "https://api.themoviedb.org";
        String Token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c";

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer " + Token)
                .build();
    }

    @Test
    public void GetAccount () {
        given()

                .spec(reqSpec)

                .when()
                .get("/3/account")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }
    @Test
    public void GetFavoriteMovies () {
        given()

                .spec(reqSpec)
                .pathParam("Account_id", Account_id)

                .when()
                .get("/3/account/{Account_id}/favorite/movies")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }
    @Test
    public void GetFavoriteTV () {
        given()

                .spec(reqSpec)
                .pathParam("Account_id", Account_id)

                .when()
                .get("/3/account/{Account_id}/favorite/tv")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }
    @Test
    public void GetSearchMovie () {
        given()

                .spec(reqSpec)
                .queryParam("query","Fight Club")

                .when()
                .get("/3/search/movie")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }
}
