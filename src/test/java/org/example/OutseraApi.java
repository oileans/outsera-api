package org.example;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@Epic("Testes Api")
@Feature("Testando Metodos")
public class OutseraApi {

    /**
     * Configuração inicial do endpoint base da API antes da execução dos testes.
     */
    @BeforeAll
    public static void setup() {
        baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.filters(new AllureRestAssured(), new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    /**
     * Testa a recuperação de um post específico pelo ID
     * validando o status HTTP, tipo de conteúdo, headers e valores do corpo.
     */
    @Test
    @Story("Get single post")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verifica o Post com ID 1")
    public void testGetComId() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .body("userId", equalTo(1))
                .body("id", equalTo(1));
    }

    /**
     * Testa a recuperação correta do post com ID = 1, validando status 200 e conteúdo esperado.
     */

    @Test
    public void testGet() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .body("userId", equalTo(1))
                .body("id", equalTo(1));
    }

    /**
     * Testa a listagem de todos os posts da API.
     * Verifica se o retorno possui uma quantidade mínima de elementos (> 0) e responde com sucesso (200 OK).
     */
    @Test
    public void testGetTodos() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    /**
     * Testa a criação de um novo post com dados válidos usando o metodo HTTP POST.
     */
    @Test
    public void testPost() {
        String requestBody = """
                    {
                      "title": "Willians",
                      "body": "Willians Ferreira",
                      "userId": 1
                    }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("Willians"))
                .body("body", equalTo("Willians Ferreira"))
                .body("userId", equalTo(1));
    }

    /**
     * Testa a atualização (total) de um post existente (ID = 1) utilizando o metodo HTTP PUT.
     */
    @Test
    public void testPut() {
        String updatedBody = """
                    {
                      "id": 1,
                      "title": "updated title",
                      "body": "updated body",
                      "userId": 1
                    }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("updated title"));
    }

}
