# DemoQA-Test-Automation

A modular and scalable Test Automation Framework built using Java, Selenium WebDriver, TestNG, Maven, and WebDriverManager. This project automates various UI test cases and follows best practices for maintainability, reusability, and reporting.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- ExtentReports (Reporting)
- Page Object Model (POM) Design
- Utilities: Excel, PDF, DB, Mobile (Coming Soon)
- API + Appium (To Be Integrated)

## Folder Structure

```
com.framework
│
├── driver/           # WebDriver management
├── utils/            # Common utilities like PageActionUtils, ScreenshotUtils
├── pages/            # Page classes for DemoQA modules
├── tests/            # TestNG test classes
├── resources/        # Config, mail, db properties (externalized settings)
└── reports/          # Test output with screenshots and logs
```

## 🚀 Features

- Page Object Model with action utilities
- Parallel test execution via TestNG XML
- Screenshot capture on success/failure
- Dynamic browser support via config/testng
- Custom logging
- ExtentReports HTML output

## 📦 How to Run

```bash
# Clean and build project
mvn clean install

# Run TestNG suite
mvn test -DsuiteXmlFile=testng.xml
```

## 🔐 Future Scope

- API testing using Rest-Assured
- Mobile testing using Appium
- CI/CD integration with Jenkins
- Xray integration for JIRA

## 👨‍💻 Author

**Abdul Mateen**  
Senior QA Automation Engineer | Selenium | Java | Appium | TestNG | REST APIs