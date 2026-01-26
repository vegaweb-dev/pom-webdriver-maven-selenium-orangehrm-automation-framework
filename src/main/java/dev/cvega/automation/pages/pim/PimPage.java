package dev.cvega.automation.pages.pim;

import dev.cvega.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage extends BasePage {
    private final By pimPageTitle = By.xpath("//h6[contains(@class, 'header') and normalize-space(.)='PIM']");

    public PimPage(WebDriver driver) {
        super(driver);
        if (!isElementDisplayed(pimPageTitle)) {
            throw new IllegalStateException("This is not PimPage. Current URL: " + driver.getCurrentUrl());
        }
    }
}
