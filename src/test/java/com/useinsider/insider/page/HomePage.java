package com.useinsider.insider.page;

import com.useinsider.insider.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

// page_url = https://useinsider.com/
public class HomePage extends BasePage {
    @FindBy(css = "#wt-cli-reject-btn")
    public WebElement linkReject;

    @FindBy(css = "div[class='slide-text'] span")
    public WebElement spanInsiderSummerReportLeader;


    public void declineAllCookies() {
        linkReject.click();
    }

    public boolean checkTheAnnounce() {
        return spanInsiderSummerReportLeader.isDisplayed();
    }

    @Override
    public boolean verifyTheURL() {
        return Driver.getDriver().getCurrentUrl().contains("https://useinsider.com");
    }

    public void assertHomePageOpen(){
        assertTrue(checkTheAnnounce(),"Existing of an announce on the page header is checked");
        assertTrue(verifyTheURL());
    }
}