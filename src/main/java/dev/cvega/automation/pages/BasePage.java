package dev.cvega.automation.pages;

import dev.cvega.automation.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage serves as a blueprint for all Page Objects in the project.
 * It centralizes wait logic and WebElement interaction handling.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, FrameworkConstants.WAIT_TIME);
    }

    /**
     * Locates an element, ensuring it is visible before returning it.
     *
     * @param locator The By locator(id, xpath, css) of the element.
     * @return The WebElement found, ready for interaction.
     */
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }
}
