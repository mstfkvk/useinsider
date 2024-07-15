package com.useinsider.insider;

import com.useinsider.insider.page.CareersOpenPositionsPage;
import com.useinsider.insider.page.CareersPage;
import com.useinsider.insider.page.Careers_QAPage;
import com.useinsider.insider.page.HomePage;
import org.junit.jupiter.api.*;


public class InsiderTest {


    @BeforeEach
    public void setUp() {
        Driver.getDriver();
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
    }

    @Test
    public void toolsMenu() {
        HomePage homePage = new HomePage();
        CareersPage careersPage = new CareersPage();
        Careers_QAPage qaPage = new Careers_QAPage();
        CareersOpenPositionsPage openPositionPage = new CareersOpenPositionsPage();


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
        openPositionPage.selectDesiredLocation("Istanbul, Turkey");

//      8- And filter Department: "Quality Assurance"
        openPositionPage.selectDesiredDepartment("Quality Assurance");

//      9- Check the presence of the jobs list
        openPositionPage.assertSelectedFilters("Istanbul, Turkey", "Quality Assurance");
        Utility.waitUntilPageIsLoaded(10);
        openPositionPage.checkPresenceOfOpenPositions();

//      10- Check that all jobs’ Position contains "Quality Assurance"
        openPositionPage.assertPositionTitle("Quality Assurance");

//      11- Check that all jobs’ Department contains "Quality Assurance"
        openPositionPage.assertPositionDepartment("Quality Assurance");

//      12- And Check that all jobs’ Location contains "Istanbul, Turkey"
        openPositionPage.assertPositionLocation("Istanbul, Turkey");

//      13- Click the "View Role" button
        openPositionPage.viewRoleRandomly();

//      14- Check that this action redirects us to the Lever Application form page
        Utility.switchToNewWindow();
        Utility.waitUntilPageIsLoaded(10);

        openPositionPage.assertLeverAppPage();
    }

}
