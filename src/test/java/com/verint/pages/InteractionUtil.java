package com.verint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public abstract class InteractionUtil {
    /**
     * This abstract class directly interacts with the page
     */
    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
        return element;
    }

    public WebElement setElement(By by, String input) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        for (char i : input.toCharArray()) {
            element.sendKeys(String.valueOf(i));
        }
        return element;
    }

    public boolean validateElementsText(By by, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }

        List<WebElement> list = driver.findElements(by);
        boolean textExists = false;

        for (WebElement e : list) {
            if (e.getText().toLowerCase().contains(expectedText.toLowerCase())) {
                textExists = true;
                break;
            }
        }
        return textExists;
    }

    public boolean validateText(By by, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, expectedText));
        } catch (TimeoutException e) {
            return false;
        }
    }
}
