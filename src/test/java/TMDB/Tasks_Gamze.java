package TMDB;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Tasks_Gamze {
    String account_id="16";
    @Test
    public void Account_10(){


        given()
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c")
                .when()
                .get("https://api.themoviedb.org/3/account/"+account_id+"/watchlist/tv")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test

    public void Movies_1(){
        String movie_id="16";
        given()
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c")
                .when()
                .get("https://api.themoviedb.org/3/movie/"+movie_id)

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test

    public void Movies_2(){
        String movie_id="16";
        given()
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c")
                .when().get("https://api.themoviedb.org/3/movie/"+movie_id+"/lists")
                .then()
                .log().body()
                .statusCode(200)
        ;

    }

    @Test

    public void Movies_4(){
        given()
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c")
                .when().delete("https://api.themoviedb.org/3/movie/18/rating")
                .then().log().body()
                .statusCode(200)
        ;


    }
}
