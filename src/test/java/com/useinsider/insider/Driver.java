package com.useinsider.insider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    // Private constructor to prevent instantiation
    private Driver() {
    }

    // Static WebDriver instance
    private static WebDriver driver;

    // Method to get the single WebDriver instance
    public static WebDriver getDriver() {
        // Initialize WebDriver if it hasn't been initialized yet
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            // Disable browser notifications
            options.addArguments("--disable-notifications");
            // Disable extensions in the browser
            options.addArguments("--disable-extensions");
            // Start the browser maximized
            options.addArguments("--start-maximized");

            // Initialize the WebDriver with the specified options
            driver = new ChromeDriver(options);
        }
        // Return the single WebDriver instance
        return driver;
    }

    // Method to quit the WebDriver and close the browser
    public static void quit() {
        // Safely quit the WebDriver instance
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

