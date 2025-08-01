package tests;

import base.BaseApiTest;
import endpoints.PostEndpoint;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import payloads.PostPayloads;

import static assertions.PostAssertions.*;


import utils.DataFactory;

@Epic("Testes API")
@Feature("Posts Endpoint")
public class PostTests extends BaseApiTest {

    @Test
    @Story("POST")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Criar post com dados aleatórios")
    public void criarPostComDadosDinamicos() {
        String payload = DataFactory.gerarNovoPostJson();
        var response = PostEndpoint.createPost(payload);

        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");
        int userId = response.jsonPath().getInt("userId");

        validarPostCriado(response, title, body, userId);
    }

    @Test
    @Story("POST inválido")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Criar post com payload inválido")
    public void deveFalharAoCriarPostInvalido() {
        String payload = DataFactory.gerarPostJsonInvalido();
        var response = PostEndpoint.createPost(payload);
        // falha, pois o endpoint aceita qualquer dado no body
        validarErro500(response);
    }


    @Test
    @Story("GET")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Buscar post por ID")
    public void buscarPostPorId() {
        var response = PostEndpoint.getPostById(1);
        validarPostPorId(response, 1, 1);
    }

    @Test
    @Story("GET inválido")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Buscar post inexistente")
    public void buscarPorDadoInexistente() {
        var response = PostEndpoint.getPostById(9999);
        validarErro404(response);
    }

    @Test
    @Story("PUT")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Atualizar post existente")
    public void atualizarPost() {
        var response = PostEndpoint.updatePost(1, PostPayloads.postAtualizado());
        validarAtualizacao(response, "Atualizado");
    }

    @Test
    @Story("PUT inválido")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Atualizar post inexistente")
    public void deveFalharAoAtualizarPostInexistente() {
        String payload = DataFactory.gerarPostAtualizadoJson(999);

        var response = PostEndpoint.updatePost(999, payload);
        validarErro500(response);
    }

    @Test
    @Story("DELETE")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Deletar post")
    public void deletarPost() {
        var response = PostEndpoint.deletePost(1);
        validarDelete(response);

        var getResponse = PostEndpoint.getPostById(1);
        validarErro404(getResponse); // falha, pois o endpoint não permite executar o delete.
    }

    @Test
    @Story("DELETE")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Tentativa de DELETE sem passagem de parametro")
    public void deletarSemId() {
        var response = PostEndpoint.deleteSemParametro();
        validarErro404(response);
    }
}
