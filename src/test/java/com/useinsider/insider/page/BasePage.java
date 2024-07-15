package com.useinsider.insider.page;

import com.useinsider.insider.Driver;
import com.useinsider.insider.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

// page_url = https://useinsider.com/
public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public abstract boolean verifyTheURL();

    @FindBy(css="li.dropdown a.nav-link")
    public List<WebElement> navs;

    @FindBy(xpath = "(//div/div[contains(@class,'mid')])[4]/a[2]")
    public WebElement careersLink;

    public void goToInsider(){
        Driver.getDriver().get("https://useinsider.com/");
    }
    public void goToInsiderCareer(){
        Driver.getDriver().navigate().to("https://useinsider.com/careers/quality-assurance/");
    }
    public void navigateToCareerPage(){
        String main="Company";
        String sub="Careers";

        for (WebElement nav : navs) {
            if (nav.getText().equalsIgnoreCase("Company")) {
                nav.click();
            }
        }
        Utility.waitUntilElementIsVisible(careersLink,5);
        careersLink.click();
    }

    public void assertLeverAppPage(){
        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("jobs.lever"));
    }
}