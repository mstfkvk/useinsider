package com.useinsider.insider.page;

import com.useinsider.insider.Driver;
import com.useinsider.insider.Utility;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

// page_url = https://useinsider.com/careers/open-positions/?department=qualityassurance
public class CareersOpenPositionsPage extends CareersPage {

    @Override
    public boolean verifyTheURL() {
        return Driver.getDriver().getCurrentUrl().contains("https://useinsider.com/careers/open-positions");
    }

    @FindBy(css = "#filter-by-location")
    public WebElement filterByLocationWithSelect;

    @FindBy(css = "#filter-by-location option")
    public List<WebElement> filterByLocationOptionsInSelect;


    Select selectLocation;

    public void selectDesiredLocation(String location) {
        Utility.waitUntilAllElementHas(By.cssSelector("#filter-by-location option"), 26, 10);
        //Utility.justWait(filterByLocationWithSelect, 1);

        selectLocation = new Select(filterByLocationWithSelect);
        Utility.selectDesiredOption(selectLocation, location);
    }

    public String getSelectedLocation() {
        return Utility.getTextSelectedOption(selectLocation);
    }


    @FindBy(css = "#filter-by-department")
    public WebElement filterByDepartmentWithSelect;

    @FindBy(css = "#filter-by-location option")
    public List<WebElement> filterByDepartmentOptionsInSelect;

    Select selectDepartment;

    public void selectDesiredDepartment(String department) {
        Utility.waitUntilAllElementHas(By.cssSelector("#filter-by-department option"), 16, 10);
        //Utility.justWait(filterByLocationWithSelect, 1);

        selectDepartment = new Select(filterByDepartmentWithSelect);
        Utility.selectDesiredOption(selectDepartment, department);
    }

    public String getSelectedDepartment() {
        return Utility.getTextSelectedOption(selectDepartment);
    }

    public void assertSelectedFilters(String location, String department) {
        assertEquals(location.toLowerCase(), getSelectedLocation().toLowerCase());
        assertEquals(department.toLowerCase(), getSelectedDepartment().toLowerCase());
    }

    @FindBy(css = ".position-list-item-wrapper")
    public List<WebElement> listOfOpenPositions;

    @FindBy(css = "#deneme")
    public WebElement numberOfOpenPositions;


    @FindBy(css = ".position-list-item-wrapper p")
    public List<WebElement> listOfPositionTitles;

    @FindBy(css = ".position-list-item-wrapper span")
    public List<WebElement> listOfPositionDepartments;

    @FindBy(css = ".position-list-item-wrapper div")
    public List<WebElement> listOfPositionLocations;

    public void checkPresenceOfOpenPositions() {
        Utility.justWait(numberOfOpenPositions, 5);
        boolean b = listOfOpenPositions.size() > 0;
        assertTrue(b, "There are more than one open positions in the list");
        assertEquals(numberOfOpenPositions.getText(), "4", "Another verification, There are 4 open positions in the list");
    }

    /**
     * Asserts that each position title in the list contains either the "full title" or its "abbreviation".
     * <p>
     * This method waits until all position title elements are visible, then it checks each element's text to ensure it contains
     * either the specified full title or the abbreviation formed from the first letters of each word in the title.
     *
     * @param title The full title to be checked against each position title.
     */
    public void assertPositionTitle(String title) {
        // Wait until all elements in the list are visible
        Utility.waitUntilAllElementIsVisible(listOfPositionTitles, 5);

        // Create a string from the first letter of each word (e.g., "Quality Assurance" -> "QA")
        String[] words = title.split(" ");
        StringBuilder firstLetterEachWord = new StringBuilder();

        Arrays.stream(words)
                .map(word -> word.charAt(0))
                .forEach(firstLetterEachWord::append);

        String abbreviation = firstLetterEachWord.toString();

        // Check each position title against the full title and its abbreviation
        for (WebElement positionTitleElement : listOfPositionTitles) {
            boolean containsFullTitle = positionTitleElement.getText().toLowerCase().contains(title.toLowerCase());
            boolean containsAbbreviation = positionTitleElement.getText().toLowerCase().contains(abbreviation.toLowerCase());

            assertTrue(containsFullTitle || containsAbbreviation,
                    "Position title does not contain expected title or abbreviation: " + title + " or " + abbreviation);
        }
    }

    public void assertPositionDepartment(String department) {
        Utility.waitUntilAllElementIsVisible(listOfPositionDepartments, 5);
        for (WebElement listOfPositionDepartment : listOfPositionDepartments) {
            assertTrue(listOfPositionDepartment.getText().toLowerCase().contains(department.toLowerCase()));
        }
    }

    public void assertPositionLocation(String location) {
        Utility.waitUntilAllElementIsVisible(listOfPositionLocations, 5);
        for (WebElement listOfPositionLocation : listOfPositionLocations) {
            assertTrue(listOfPositionLocation.getText().toLowerCase().contains(location.toLowerCase()));
        }
    }

    @FindBy(xpath = "//a[contains(text(),'View Role')]")
    public List<WebElement> listOfViewRoleButtons;


    /**
     * Randomly selects a "View Role" button from the list and clicks it.
     * If the list is empty, it logs a message.
     */
    public void viewRoleRandomly() {
        if (listOfViewRoleButtons.isEmpty()) {
            System.out.println("There are no 'View Role' buttons in the list");
            return; // Exit the method if the list is empty
        }

        // Generate a random index within the bounds of the list size
        Random rand = new Random();
        int randomIndex = rand.nextInt(listOfViewRoleButtons.size());

        // Hover over the randomly selected element and click it
        Utility.hoverAndClick(listOfViewRoleButtons.get(randomIndex));
    }

}