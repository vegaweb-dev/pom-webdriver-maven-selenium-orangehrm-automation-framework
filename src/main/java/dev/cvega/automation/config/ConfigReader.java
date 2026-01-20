package dev.cvega.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties PROPERTIES = new Properties();
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    static {
        try (FileInputStream file = new FileInputStream(CONFIG_PATH)) {
            PROPERTIES.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration at: " + CONFIG_PATH, e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static int getTimeout() {
        String timeout = getProperty("timeout.standard");
        try {
            return (timeout != null) ? Integer.parseInt(timeout) : 10;
        } catch (NumberFormatException e) {
            return 10;
        }
    }
}