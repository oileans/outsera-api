package assertions;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class PostAssertions {

    public static void validarPostPorId(Response response, int id, int userId) {
        response.then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("id", equalTo(id))
                .body("userId", equalTo(userId));
    }

    public static void validarPostCriado(Response response, String title, String body, int userId) {
        response.then()
                .statusCode(201)
                .body("title", equalTo(title))
                .body("body", equalTo(body))
                .body("userId", equalTo(userId));
    }

    public static void validarAtualizacao(Response response, String novoTitulo) {
        response.then()
                .statusCode(200)
                .body("title", equalTo(novoTitulo));
    }

    public static void validarDelete(Response response) {
        response.then().statusCode(200);
    }

    public static void validarErro404(Response response) {
        response.then().statusCode(404);
    }

    public static void validarErro500(Response response) {
        response.then().statusCode(500);
    }
}
