package tests.dashboard;

import base.BaseTest;
import dev.cvega.automation.pages.dashboard.DashboardPage;
import org.testng.annotations.Test;

public class DashboardToPinNavigationTest extends BaseTest {
    @Test
    public void navigateFromDashboardToPim_shouldDisplayPimPage() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToPim();
    }
}
