package dev.cvega.automation.pages.login;

import dev.cvega.automation.pages.BasePage;
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
    private final By dashboardTitle = By.xpath("//h6[contains(@class, 'topbar-header') and text()='Dashboard']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Performs a complete login sequence.
     *
     * @param username The account identifier.
     * @param password Secret credential of the account.
     */
    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
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

    /**
     * Acts as a sync point to confirm successful login.
     * It waits for the 'dashboardTitle' locator defined in the Page Object.
     * * @return true if the element is found within the configured timeout.
     *
     * @throws TimeoutException if the dashboard fails to load.
     */
    public boolean isDashboardDisplayed() {
        return find(dashboardTitle).isDisplayed();
    }

}
