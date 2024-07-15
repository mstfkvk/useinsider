package com.useinsider.insider.page;

import com.useinsider.insider.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

// page_url = https://useinsider.com/careers/
public class CareersPage extends BasePage {
    @Override
    public boolean verifyTheURL() {
        return Driver.getDriver().getCurrentUrl().contains("https://useinsider.com/careers");
    }

    @FindBy(xpath = "//h3[contains(text(),'Find your calling')]")
    public WebElement headerOfTeamBlock;
    @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    public WebElement headerOfLocationBlock;
    @FindBy(xpath = "//h2[contains(text(),'Life at Insider')]")
    public WebElement headerOfLifeAtInsiderBlock;

    public boolean checkTheTeamBlock(){
        return headerOfTeamBlock.isDisplayed();
    }
    public boolean checkTheLocationBlock(){
        return headerOfLocationBlock.isDisplayed();
    }
    public boolean checkTheLifeAtInsiderBlock(){
        return headerOfLifeAtInsiderBlock.isDisplayed();
    }

    public void assertCareerPage(){
        assertTrue(verifyTheURL(), "Careers page URL is checked");
        assertTrue(checkTheTeamBlock(), "Team block is checked");
        assertTrue(checkTheLocationBlock(), "Location block is checked");
        assertTrue(checkTheLifeAtInsiderBlock(), "Life at insider block is checked");
    }

}