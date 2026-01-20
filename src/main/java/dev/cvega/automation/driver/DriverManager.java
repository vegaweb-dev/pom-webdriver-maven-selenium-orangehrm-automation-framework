package dev.cvega.automation.driver;

import dev.cvega.automation.constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Manager class responsible for WebDriver lifecycle.
 * It uses a centralized logic to instantiate the driver and
 * implements the Singleton pattern to ensure only one instance exists.
 */
public final class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    /**
     * Returns the current instance of the WebDriver.
     * If no instance exists, it triggers the initialization.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        if (driver != null) return;
        String browser = FrameworkConstants.BROWSER.toLowerCase();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
    }

    /**
     * Closes the browser and resets the singleton instance.
     * Ensures the next test execution starts with a clean state.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
