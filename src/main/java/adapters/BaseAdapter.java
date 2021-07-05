package adapters;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BaseAdapter {

    public static final String BASE_URL = "https://api.qase.io/v1/";
    public static final String CONTENT_TYPE = "application/json";
    Gson converter = new Gson();

    public String get(String token, String url) {
        return
                given().contentType(ContentType.JSON)
                        .header("Token", token)
                .when()
                        .get(BASE_URL + url)
                .then()
                        .log().all()
                        .extract().body().asString();
    }

    public Response post(String token, String url, String body){
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", CONTENT_TYPE)
                        .body(body)
                .when()
                        .post(BASE_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }
    public Response delete(String token, String url){
        return
        given()
                .header("Token", token)
                .header("Content-Type", CONTENT_TYPE)
                .log().all()
        .when()
                .delete(BASE_URL + url)
        .then()
                .log().all()
                .extract().response();
    }
}
