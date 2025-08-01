package payloads;

public class PostPayloads {

    public static String novoPost() {
        return """
            {
              "title": "Livro Novo",
              "body": "Livro Novo",
              "userId": 1
            }
        """;
    }

    public static String postAtualizado() {
        return """
            {
              "id": 1,
              "title": "Atualizado",
              "body": "Novo conteúdo",
              "userId": 1
            }
        """;
    }
}
