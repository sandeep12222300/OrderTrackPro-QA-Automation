# OrderTrackPro QA Automation Framework

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-DC524A?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)

</div>

## 📌 Project Overview

**OrderTrackPro QA Automation Framework** is a robust, scalable Selenium-based test automation framework built with industry best practices. This framework leverages Java, TestNG, and Maven to provide automated testing capabilities for web applications. It implements the Page Object Model (POM) design pattern, ensuring maintainable and reusable test code.

The framework currently automates login functionality testing for [OrangeHRM Demo Application](https://opensource-demo.orangehrmlive.com/), demonstrating both successful and failed authentication scenarios.

### ✨ Key Highlights
- **Design Pattern**: Page Object Model (POM) for better code maintainability
- **Automated Browser Management**: WebDriverManager for seamless driver setup
- **Intelligent Waits**: Combination of implicit and explicit waits for stable test execution
- **Clean Architecture**: Well-organized Maven project structure
- **Extensible Framework**: Easy to extend with additional test scenarios and pages

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 11+ | Core programming language |
| **Selenium WebDriver** | 4.14.1 | Browser automation |
| **TestNG** | 7.8.0 | Test framework and assertions |
| **Maven** | 3.6+ | Build and dependency management |
| **WebDriverManager** | 5.6.3 | Automatic browser driver management |
| **Extent Reports** | 5.1.1 | Test reporting (ready to integrate) |

## 🚀 Features

✅ **Automated Test Scenarios**
- Valid and invalid login credential testing
- Dashboard verification after successful login
- Error message validation for failed login attempts

✅ **Framework Capabilities**
- Page Object Model (POM) architecture
- Explicit and implicit wait strategies
- Cross-browser ready (Chrome supported, extensible to others)
- TestNG test orchestration and parallel execution support
- Maven-based build and dependency management
- WebDriverManager for zero-configuration driver setup

## 📋 Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 11 or higher
  ```bash
  java -version
  ```
- **Apache Maven**: Version 3.6 or higher
  ```bash
  mvn -version
  ```
- **Google Chrome**: Latest stable version (for ChromeDriver compatibility)
- **IDE** (Optional but recommended): IntelliJ IDEA, Eclipse, or VS Code

## 🔧 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/sandeep12222300/OrderTrackPro-QA-Automation.git
   cd OrderTrackPro-QA-Automation
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Verify setup**
   ```bash
   mvn clean compile
   ```

## 🧪 Test Scenarios

The framework currently includes the following test scenarios:

| Test Case | Description | Expected Result |
|-----------|-------------|-----------------|
| `testSuccessfulLogin` | Verifies login with valid credentials (Admin/admin123) | Dashboard is displayed successfully |
| `testInvalidLogin` | Verifies login failure with invalid credentials | Error message is displayed |

## ▶️ How to Run

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn clean test -Dtest=LoginTest
```

### Run Specific Test Method
```bash
mvn clean test -Dtest=LoginTest#testSuccessfulLogin
```

### Run with TestNG XML
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Generate Reports
```bash
mvn clean test
# Test results will be available in: target/surefire-reports/
```

## 📂 Project Structure

```
OrderTrackPro-QA-Automation/
│
├── src/
│   ├── main/java/
│   │   └── com/ordertrackpro/
│   │       ├── pages/                  # Page Object Model classes
│   │       │   ├── BasePage.java       # Base page with common methods
│   │       │   └── LoginPage.java      # Login page objects and methods
│   │       └── utils/                  # Utility classes
│   │           └── DriverFactory.java  # WebDriver factory (placeholder for future implementation)
│   │
│   └── test/java/
│       └── com/ordertrackpro/
│           └── tests/                  # Test classes
│               ├── BaseTest.java       # Base test with setup/teardown
│               └── LoginTest.java      # Login test scenarios
│
├── pom.xml                             # Maven configuration and dependencies
├── testng.xml                          # TestNG suite configuration
├── .gitignore                          # Git ignore rules
├── LICENSE                             # MIT License
└── README.md                           # Project documentation
```

### Key Components

- **BasePage.java**: Base class for all page objects, initializes WebDriver and sets up PageFactory for element initialization
- **LoginPage.java**: Page Object for login page with element locators and actions
- **BaseTest.java**: Sets up WebDriver, manages browser lifecycle (setup/teardown), and initializes page objects
- **LoginTest.java**: Contains test methods for various login scenarios
- **testng.xml**: Configures test suite execution order and parameters

## ⚙️ Configuration

### Browser Configuration
Currently configured for Chrome. To add support for other browsers, modify `BaseTest.java`:

```java
// For Firefox
WebDriverManager.firefoxdriver().setup();
driver = new FirefoxDriver();

// For Edge
WebDriverManager.edgedriver().setup();
driver = new EdgeDriver();
```

### Test URL Configuration
The application URL is configured in `BaseTest.java`:
```java
driver.get("https://opensource-demo.orangehrmlive.com/");
```

### Timeout Configuration
Implicit wait is set to 10 seconds in `BaseTest.java`. Explicit waits are configured per element in page objects.

## 📊 Test Reporting

Test execution results are generated in the following locations:

- **Surefire Reports**: `target/surefire-reports/`
  - HTML reports: `index.html`
  - XML reports: `TEST-*.xml`
  - Text reports: `*.txt`

- **TestNG Reports**: `test-output/`
  - `index.html` - Detailed test execution report
  - `emailable-report.html` - Summary report

## 🐛 Troubleshooting

### Common Issues and Solutions

**Issue**: ChromeDriver version mismatch
```
Solution: WebDriverManager automatically handles driver versions. 
Ensure you have the latest Chrome browser installed.
```

**Issue**: Tests failing due to timeouts
```
Solution: Increase implicit/explicit wait times in BaseTest.java or LoginPage.java.
Check your internet connection and application availability.
```

**Issue**: Maven dependencies not resolving
```bash
# Clear Maven cache and reinstall
mvn dependency:purge-local-repository
mvn clean install -U
```

**Issue**: Port already in use
```
Solution: Close any existing browser instances or ChromeDriver processes.
Use Task Manager/Activity Monitor to kill chromedriver processes.
```

## 📈 Future Enhancements

- [ ] **Enhanced Reporting**: Integrate Extent Reports for detailed HTML reports with screenshots
- [ ] **Parallel Execution**: Configure TestNG for concurrent test execution
- [ ] **CI/CD Integration**: Add GitHub Actions/Jenkins pipeline configuration
- [ ] **Screenshot on Failure**: Automatic screenshot capture for failed test cases
- [ ] **Data-Driven Testing**: Implement test data management using Excel/CSV/JSON
- [ ] **Cross-Browser Testing**: Add support for Firefox, Edge, and Safari
- [ ] **Logging Framework**: Integrate Log4j for comprehensive logging
- [ ] **API Testing**: Extend framework to include REST API testing capabilities
- [ ] **Docker Support**: Containerize tests for consistent execution environments
- [ ] **Allure Reports**: Add Allure reporting for better visualization

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**B Sandeep**

- GitHub: [@sandeep12222300](https://github.com/sandeep12222300)

## 🙏 Acknowledgments

- [OrangeHRM](https://www.orangehrm.com/) for providing a demo application for testing
- [Selenium WebDriver](https://www.selenium.dev/) for browser automation capabilities
- [TestNG](https://testng.org/) for the testing framework
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) for simplified driver management

---

<div align="center">

**If you find this project helpful, please consider giving it a ⭐!**

</div>

