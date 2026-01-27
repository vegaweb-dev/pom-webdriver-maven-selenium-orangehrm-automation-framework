package dev.cvega.automation.driver;

import dev.cvega.automation.constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    /**
     * Initializes the WebDriver based on the browser configuration.
     * Note: For Chrome, we apply specific arguments to ensure compatibility
     * with CI/CD environments (GitHub Actions) - GUI is not available.
     */
    private static void initializeDriver() {
        if (driver != null) return;
        String browser = FrameworkConstants.BROWSER.toLowerCase();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        // maximize() is redundant in headless mode but kept for local execution
        // where the headless flag might be removed for debugging.
        driver.manage().window().maximize();
    }

    /**
     * Configures Chrome settings for headless execution and CI/CD compatibility.
     */
    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // Runs Chrome without a visible GUI to save resources and work on servers.
        options.addArguments("--headless=new");
        // Prevents "Sandbox" permission errors in Linux environments.
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        // Forces a standard resolution for viewport consistency to ensure elements are visible and clickable.
        options.addArguments("--window-size=1920,1080");

        return options;
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
