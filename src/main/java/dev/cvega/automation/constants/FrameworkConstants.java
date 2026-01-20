package dev.cvega.automation.constants;

import dev.cvega.automation.config.ConfigReader;

import java.time.Duration;

/**
 * Global constants for the automation framework.
 * Values are initialized from the configuration properties file.
 */
public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    /**
     * Default application URL retrieved from properties.
     */
    public static final String BASE_URL = ConfigReader.getProperty("url");
    /**
     * Target browser for execution (e.g., chrome, firefox).
     */
    public static final String BROWSER = ConfigReader.getProperty("browser");
    /**
     * Standard explicit wait time.
     * Used across all Page Objects to ensure element synchronization.
     */
    public static final Duration WAIT_TIME = Duration.ofSeconds(
            Long.parseLong(ConfigReader.getProperty("timeout.standard"))
    );
}
