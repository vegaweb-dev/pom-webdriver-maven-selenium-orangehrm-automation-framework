package tests.login;

import base.BaseTest;
import dev.cvega.automation.pages.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard should be visible after login");
    }
}
