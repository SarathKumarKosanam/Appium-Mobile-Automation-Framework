# Appium Mobile Automation Framework 🚀

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Appium](https://img.shields.io/badge/Appium-662d91?style=for-the-badge&logo=appium&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

An enterprise-grade, hybrid automation framework engineered for high scalability and reliability. This project demonstrates an advanced mobile testing architecture leveraging the **Page Object Model (POM)** and **BDD (Cucumber)** methodologies.

---

## 🛠 Tech Stack

| Component | Technology |
| :--- | :--- |
| **Language** | Java 11+ |
| **Mobile Engine** | Appium (UiAutomator2) |
| **Test Runner** | TestNG |
| **BDD** | Cucumber |
| **Build Tool** | Apache Maven |
| **Reporting** | Extent Reports (Spark) |
| **Design Pattern** | Page Object Model (POM) |

---

## ✨ Key Features

* **Hybrid Execution Engine:** Seamlessly toggle between local emulators/devices and cloud platforms like **LambdaTest** or **BrowserStack**.
* **Parallel Execution:** Fully configured to run test suites across multiple mobile nodes simultaneously to reduce execution time.
* **Automated Reporting:** Real-time generation of interactive HTML reports with **Base64 screenshot embedding** for failed steps.
* **CI/CD Integration:** Ready-to-use configurations for **GitHub Actions** and Jenkins pipelines.
* **Robust Utility Wrapper:** Custom-built abstraction layer for complex mobile gestures (Swipe, Scroll, Long Press, Touch Actions).

---

## 📁 Project Structure

```text
├── src/main/java          # Core framework utilities, BaseSetup, and Page Objects
├── src/test/java          # Step Definitions, Cucumber Hooks, and Test Runners
├── src/test/resources     # Gherkin Feature files and environment-specific configs
├── pom.xml                # Project dependencies and Maven build plugins
└── .gitignore             # Optimized to exclude build artifacts and IDE metadata
