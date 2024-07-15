package com.useinsider.insider;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Set;

public class Utility {

    /**
     * Waits until the page is fully loaded.
     *
     * @param seconds refers to how long it'll wait to load the page
     */
    public static void waitUntilPageIsLoaded(long seconds) {
        ExpectedCondition<Boolean> expectation = d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        wait.until(expectation);
    }

    /**
     * Waits until the specified element is visible.
     *
     * @param element the WebElement to wait for
     * @param seconds refers to how long it'll wait for the element to be visible
     */
    public static void waitUntilElementIsVisible(WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until all specified elements are visible.
     *
     * @param elements the list of WebElements to wait for
     * @param seconds  refers to how long it'll wait for the elements to be visible
     */
    public static void waitUntilAllElementIsVisible(List<WebElement> elements, long seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * Waits until the specified number of elements are present.
     *
     * @param by      the locator to find the elements
     * @param count   the number of elements to wait for
     * @param seconds refers to how long it'll wait for the elements to be present
     */
    public static void waitUntilAllElementHas(By by, int count, long seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.numberOfElementsToBe(by, count));
    }

    /**
     * Clicks on the specified element using JavaScript.
     *
     * @param element the WebElement to click
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls to the specified element.
     *
     * @param element the WebElement to scroll to
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls the window by the specified x and y offsets.
     *
     * @param x the horizontal offset to scroll by
     * @param y the vertical offset to scroll by
     */
    public static void scrollBy(int x, int y) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    /**
     * Selects the desired option from a dropdown.
     *
     * @param select   the Select element representing the dropdown
     * @param location the visible text of the option to select
     */
    public static void selectDesiredOption(Select select, String location) {
        List<WebElement> allOptions = select.getOptions();
        try {
            for (WebElement option : allOptions) {
                if (option.getText().equals(location)) {
                    select.selectByVisibleText(location);
                    return; // Exit the loop once the desired option is found and selected
                }
            }
            throw new NoSuchElementException("Option with text '" + location + "' not found in dropdown.");
        } catch (Exception e) {
            throw new RuntimeException("Error selecting option with text '" + location + "': " + e.getMessage());
        }
    }

    /**
     * Gets the text of the currently selected option in a dropdown.
     *
     * @param select the Select element representing the dropdown
     * @return the text of the selected option in lowercase
     */
    public static String getTextSelectedOption(Select select) {
        return select.getFirstSelectedOption().getText().toLowerCase();
    }

    /**
     * Waits for a specified duration while hovering over an element.
     *
     * @param element the WebElement to hover over
     * @param seconds the duration to wait while hovering
     */
    public static void justWait(WebElement element, int seconds) {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).pause(Duration.ofSeconds(seconds)).moveToElement(element).build().perform();
    }

    /**
     * Hovers over an element and then clicks it.
     *
     * @param element the WebElement to hover over and click
     */
    public static void hoverAndClick(WebElement element) {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).pause(1).click().build().perform();
    }

    /**
     * Switches to the newly opened browser window.
     */
    public static void switchToNewWindow() {
        Object[] windowHandles = Driver.getDriver().getWindowHandles().toArray();
        Driver.getDriver().switchTo().window((String) windowHandles[1]);
    }
}

