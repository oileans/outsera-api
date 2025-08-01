package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostEndpoint {

    public static Response getPostById(int id) {
        return given().get("/posts/" + id);
    }

    public static Response createPost(String body) {
        return given().contentType(ContentType.JSON).body(body).post("/posts");
    }

    public static Response updatePost(int id, String body) {
        return given().contentType(ContentType.JSON).body(body).put("/posts/" + id);
    }

    public static Response deletePost(int id) {
        return given().delete("/posts/" + id);
    }

    public static Response deleteSemParametro() {
        return given().delete("/posts/");
    }
}
