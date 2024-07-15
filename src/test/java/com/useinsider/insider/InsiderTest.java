package com.useinsider.insider;

import com.useinsider.insider.page.CareersOpenPositionsPage;
import com.useinsider.insider.page.CareersPage;
import com.useinsider.insider.page.Careers_QAPage;
import com.useinsider.insider.page.HomePage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsiderTest {
    private HomePage homePage;
    private CareersPage careersPage;
    private Careers_QAPage qaPage;
    private CareersOpenPositionsPage openPositonPage;


    @BeforeEach
    public void setUp() {
        Driver.getDriver();
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
    }

    @Test
    public void toolsMenu() throws InterruptedException {
        homePage = new HomePage();
        careersPage = new CareersPage();
        qaPage = new Careers_QAPage();
        openPositonPage = new CareersOpenPositionsPage();


//      1- Visit https://useinsider.com/
        homePage.goToInsider();
        homePage.declineAllCookies();

//      2- Check Insider home page is opened or not
        Utility.waitUntilPageIsLoaded(10);
        homePage.assertHomePageOpen();

//      3- Select the “Company” menu in the navigation bar and select "Careers"
        homePage.navigateToCareerPage();

//      4- Check Career page, its Locations, Teams, and Life at Insider blocks are open or not
        Utility.waitUntilPageIsLoaded(10);
        careersPage.assertCareerPage();

//      5- Go to https://useinsider.com/careers/quality-assurance/
        careersPage.goToInsiderCareer();

//      6- Click "See all QA jobs"
        Utility.waitUntilPageIsLoaded(10);
        qaPage.clickOnSeeAllQAJobsButton();

//      7- Filter jobs by Location: "Istanbul, Turkey"
        openPositonPage.selectDesiredLocation("Istanbul, Turkey");

//      8- And filter Department: "Quality Assurance"
        openPositonPage.selectDesiredDepartment("Quality Assurance");

//      9- Check the presence of the jobs list
        openPositonPage.assertSelectedFilters("Istanbul, Turkey", "Quality Assurance");
        Utility.waitUntilPageIsLoaded(10);
        openPositonPage.checkPresenceOfOpenPositions();

//      10- Check that all jobs’ Position contains "Quality Assurance"
        openPositonPage.assertPositionTitle("Quality Assurance");

//      11- Check that all jobs’ Department contains "Quality Assurance"
        openPositonPage.assertPositionDepartment("Quality Assurance");

//      12- And Check that all jobs’ Location contains "Istanbul, Turkey"
        openPositonPage.assertPositionLocation("Istanbul, Turkey");

//      13- Click the "View Role" button
        openPositonPage.viewRoleRandomly();

//      14- Check that this action redirects us to the Lever Application form page
        Utility.switchToNewWindow();
        Utility.waitUntilPageIsLoaded(10);

        openPositonPage.assertLeverAppPage();
    }

}
