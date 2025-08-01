package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) throw new RuntimeException("Arquivo config.properties não encontrado.");
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        String env = System.getProperty("env", getProperty("env"));
        return getProperty("base.url." + env);
    }
}
