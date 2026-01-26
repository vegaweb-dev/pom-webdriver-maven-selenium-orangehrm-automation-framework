package tests.dashboard;

import base.BaseTest;
import dev.cvega.automation.pages.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardToPinNavigationTest extends BaseTest {
    @Test
    public void navigateFromDashboardToPim_shouldDisplayPimPage() {
        new LoginPage(driver).loginAs("Admin", "admin123").navigateToPim();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl, "Url should not be null");
        Assert.assertTrue(currentUrl.contains("viewEmployeeList"), "Url does not match PIM page after clicking on PIM");
    }
}
