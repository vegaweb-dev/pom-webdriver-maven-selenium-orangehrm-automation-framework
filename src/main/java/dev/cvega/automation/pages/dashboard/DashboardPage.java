package dev.cvega.automation.pages.dashboard;

import dev.cvega.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * DashboardPage represents the Dashboard page in the UI.
 * Provides methods for transitioning from Dashboard to PIM and verify PIM load.
 * Depends on methods defined in BasePage.
 */
public class DashboardPage extends BasePage {
    private final By dashboardTitle = By.xpath("//h6[contains(@class, 'topbar-header') and text()='Dashboard']");
    private final By pimButton = By.xpath("//aside[contains(@class,'sidepanel')]//a[contains(normalize-space(text()),'PIM')]");
    private final By pimTitle = By.xpath("//header[@class='oxd-topbar']//h6[contains(@class,'header') and contains(normalize-space(text()),'PIM')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed(){
        return isElementDisplayed(dashboardTitle);
    }

    /**
     * Selects the PIM button in the sidebar and performs click.
     * Uses BasePage wait methods to ensure element is visible and clickable.
     */
    public void navigateToPim() {
        click(this.pimButton);
    }

    /**
     * Confirms successful transition to PIM
     *
     * @return true if element is found.
     */
    public boolean isPimPageDisplayed() {
        return find(this.pimTitle).isDisplayed();
    }
}
