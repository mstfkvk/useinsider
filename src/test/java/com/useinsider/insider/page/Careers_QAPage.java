package com.useinsider.insider.page;

import com.useinsider.insider.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = https://useinsider.com/careers/quality-assurance/
public class Careers_QAPage extends CareersPage {

    @Override
    public boolean verifyTheURL() {
        return Driver.getDriver().getCurrentUrl().contains("https://useinsider.com/careers/quality-assurance");
    }

    @FindBy(xpath = "(//div/a[contains(@href,'open-positions')])[1]")
    private WebElement seeAllQAJobsButton;

    public void clickOnSeeAllQAJobsButton() {
        seeAllQAJobsButton.click();
    }

}