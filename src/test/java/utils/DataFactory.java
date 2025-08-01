package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFactory {

    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public static String gerarNovoPostJson() {
        String title = faker.book().title();
        String body = faker.lorem().paragraph();
        int userId = faker.number().numberBetween(1, 1000);

        return String.format("""
                    {
                      "title": "%s",
                      "body": "%s",
                      "userId": %d
                    }
                """, title, body, userId);
    }

    public static String gerarPostAtualizadoJson(int id) {
        String title = "Atualizado - " + faker.book().title();
        String body = faker.lorem().paragraph();

        return String.format("""
                    {
                      "id": %d,
                      "title": "%s",
                      "body": "%s",
                      "userId": 1
                    }
                """, id, title, body);
    }

    public static String gerarPostJsonInvalido() {
        String title = faker.book().title();
        String body = faker.lorem().paragraph();
        int userId = faker.number().numberBetween(1, 1000);

        return String.format("""
                    {
                      "title": null,
                      "body": null,
                      "userId": null
                    }
                """, title, body, userId);

    }


}
