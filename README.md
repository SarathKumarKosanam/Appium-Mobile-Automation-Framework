# Appium Mobile Automation Framework 🚀

A professional-grade, hybrid automation framework built for scale and reliability. This project demonstrates a robust mobile testing solution using the **Page Object Model (POM)** and **BDD** approach.

---

## 🛠 Tech Stack
* **Language:** Java
* **Mobile Engine:** Appium (UiAutomator2)
* **Testing Framework:** TestNG & Cucumber (BDD)
* **Build Tool:** Maven
* **Reporting:** Extent Reports with Base64 Screenshot embedding
* **Design Pattern:** Page Object Model (POM)

---

## ✨ Key Features
* **Hybrid Execution:** Supports both local and cloud-based execution (LambdaTest/BrowserStack).
* **Parallel Execution:** Configured for running tests on multiple devices simultaneously.
* **Smart Reporting:** Automatically generates detailed HTML reports with failure screenshots.
* **CI/CD Ready:** Optimized for GitHub Actions integration.
* **Abstraction Layer:** Simplified wrapper methods for common mobile actions (swipe, scroll, tap).

---

## 📁 Project Structure
```text
├── src/test/java          # Step Definitions, Hooks, and Runners
├── src/main/java          # Page Objects and Core Utilities
├── src/test/resources     # Gherkin Feature files and Config properties
├── pom.xml                # Project dependencies and plugins
└── .gitignore             # Excluded build artifacts (target, .idea, etc.)
