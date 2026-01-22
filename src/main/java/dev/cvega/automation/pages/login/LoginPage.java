package dev.cvega.automation.pages.login;

import dev.cvega.automation.pages.BasePage;
import dev.cvega.automation.pages.dashboard.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage manages the UI components and business logic for the application.
 */
public class LoginPage extends BasePage {
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Performs a complete login sequence.
     *
     * @param username The account identifier.
     * @param password Secret credential of the account.
     * @return A new instance of {@link DashboardPage} representing the landing page after login.
     */
    public DashboardPage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new DashboardPage(driver);
    }

    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }
}
