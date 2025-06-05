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


public class Tasks_Baris {
RequestSpecification reqSpec;
String account_id="22032105";

@BeforeClass
public void Setup(){
    baseURI = "https://api.themoviedb.org/3";

    reqSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNGU5NDBiYjY1ODczMWI1NGNlOTdhZmUzYmU0MTFjYSIsIm5iZiI6MTc0ODExNTk4NS43MjMsInN1YiI6IjY4MzIyMjExOTQyODJlZTJlNDgzNzdkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iFfxIFaVe0b-GTSFrPIY2gdx_TXbRwGMArNIeV1xg9c")
            .log(LogDetail.URI)
            .build();
}

    @Test
    public void Account3PostAddFavorite(){

    Map<String,String> AddFav=new HashMap<>();
        AddFav.put("media_type","movie");
        AddFav.put("media_id","550");
        AddFav.put("favorite","true");

        given()
                .spec(reqSpec)
                .body(AddFav)

                .when()
                .post("/account/"+account_id+"/favorite")


                .then()
                .log().body()
                .statusCode(201)
                .contentType(ContentType.JSON)
        ;
    }

    @Test
    public void MovieList2GetPopular(){

        given()
                .spec(reqSpec)

                .when()
                .get("/movie/popular")

                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                ;
    }

    @Test
    public void MovieList3GetTopRated(){

        given()
                .spec(reqSpec)

                .when()
                .get("/movie/top_rated")

                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                ;
    }

    @Test
    public void MovieList4GetUpcoming(){

        given()
                .spec(reqSpec)

                .when()
                .get("/movie/upcoming")

                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                ;
    }
}
