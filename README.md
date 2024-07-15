# Insider Automation Test Project

## Project Description

This project automates the testing of specific user actions on the Insider website using Java and Selenium WebDriver. The test case follows the requirements outlined below, ensuring that all necessary actions and verifications are performed to validate the proper functioning of the website features.

## Task Criteria

1. **Visit the Insider homepage**
    - URL: [Insider Homepage](https://useinsider.com/)
    - Verify that the Insider homepage is opened.

2. **Navigate to the Careers Page**
    - Select the “Company” menu in the navigation bar.
    - Click on “Careers”.
    - Verify that the Careers page and its sections (Locations, Teams, and Life at Insider) are opened.

3. **Access the Quality Assurance Careers Page**
    - URL: [Insider QA Careers](https://useinsider.com/careers/quality-assurance/)
    - Click on “See all QA jobs”.
    - Filter jobs by Location: “Istanbul, Turkey”.
    - Filter jobs by Department: “Quality Assurance”.
    - Verify the presence of the jobs list.

4. **Verify Job Listings**
    - Check that all job positions contain “Quality Assurance”.
    - Check that all job departments contain “Quality Assurance”.
    - Check that all job locations contain “Istanbul, Turkey”.

5. **Verify Job Application Redirection**
    - Click on the “View Role” button.
    - Verify that the redirection to the Lever Application form page is successful.


## Project Structure

```plaintext
src
└── com
    └── useinsider
        └── insider
            ├── Driver.java
            ├── Utility.java
            ├── page
            │   ├── HomePage.java
            │   ├── CareersPage.java
            │   ├── Careers_QAPage.java
            │   ├── CareersOpenPositionsPage.java
            └── InsiderTest.java
```

### `Driver.java`

Manages the WebDriver instance.

### `Utility.java`

Contains utility methods for common actions (e.g., waiting for elements, scrolling, clicking with JavaScript).

### Page Classes (`HomePage.java`, `CareersPage.java`, `Careers_QAPage.java`, `CareersOpenPositionsPage.java`)

Each class represents a specific page on the Insider website, encapsulating the elements and actions that can be performed on that page.

### `InsiderTest.java`

Contains the test method `toolsMenu()` that performs the end-to-end test scenario as described in the task criteria.

## How to Run

1. **Clone the Repository**
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Set Up Dependencies**
    Ensure you have the required dependencies in your `pom.xml` (if using Maven):
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.22.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.1.0-alpha1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-simple -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>2.1.0-alpha1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    ```

3. **Run the Tests**
    Execute the tests from your IDE or use the Maven command:
    ```sh
    mvn test
    ```

## Notes

- Ensure you have the latest version of ChromeDriver installed and it is compatible with your Chrome browser.
- Make sure the ChromeDriver executable is in your system's PATH.

## Author

Mustafa

---

This README provides an overview of the project, including the purpose, structure, and instructions for running the tests. It ensures that anyone reviewing the project can understand what it does and how to execute it.
