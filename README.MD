# 🧪 OrangeHRM Web Automation Framework
> **Status:** 🚧 Under Active Development...
### High-Performance Selenium Framework | Java 17 | TestNG | Maven
> **Goal:** Architect a decoupled automation suite leveraging **the Page Object Model (POM)** and Clean Code principles. The framework must prioritize test resilience through **strategic Explicit Waits** and a **centralized data management** strategy to ensure scalability and minimize maintenance overhead.
---
## 🧠 Engineering Focus & Problem Solving
* **Resilient Async Handling:** Architect custom wait strategies to manage race conditions and dynamic DOM updates, eliminating flaky test results.
* **Strategic Error Handling:** Built a robust exception-handling layer with **automated screenshot capture**, integrated into **Allure Reports** for full failure traceability and visual debugging.
* **Modular Architecture (POM):** Design a decoupled, scalable suite using Page Object Model and Fluent Interface patterns to ensure code reusability and minimize maintenance.
* **Data-Driven & Clean Logic:** Implement a centralized data management strategy to eliminate hardcoded values, leveraging Clean Code principles for high-readability scripts.
---
## 🛠️ Tech Stack
* **Language:** Java 17
* **Engine:** Selenium WebDriver 4
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Reporting:** Allure Reports
---
## 📊 Observability & Reporting
- **Allure Framework Integration:** Detail test execution reports including step-by-step logs, severity levels, and environment metadata.
- **Automated Evidence Collection:** The framework must capture and attaches screenshots automatically to **Allure reports** upon test failure, significantly reducing debugging time.
---
## 🚀 How to Run
* Note: Detailed execution steps and environment setup will be published once the MVP (Minimum Viable Product) phase is reached.
---



## 🗺️ Roadmap & Implementation Status

- [x] **Phase 0: Dependency Management SetUp** Establish the Maven lifecycle, and dependency management in `pom.xml`.

- [x] **Phase 1: Project Scaffolding** Establish directory structure and package architecture.

- [x] **Phase 2: Core Engine & Resilience** Develop the `DriverManager` and `BasePage`. Implementation of **Explicit Wait wrappers** to handle async DOM updates and eliminate flakiness.

- [x] **Phase 3: Smoke Test Validation** Execution of a baseline script to verify environment stability, Maven dependency resolution, and core WebDriver connectivity.

- [x] **Phase 4: Page Object Model (POM) Design** Map OrangeHRM business flows (Login, PIM, Admin) into decoupled, reusable Page Objects and Locators.

- [x] **Phase 5: CI/CD Integration** Implementation of a GitHub Actions workflow to automate test execution on every Push or Pull Request

- [x] **Phase 6: Advanced Reporting & Observability** Integrate **Allure Framework** with custom TestNG Listeners for automated screenshot capture and failure traceability.

- [ ] **Phase 7: Future Enhancements & Scalability** Implementation and expanded test coverage for edge-case business flows.

* Note: This roadmap is iterative. New features and architectural refinements will be integrated as the framework evolves to meet higher quality standards.
---


*Carlos Vega | SDET Focus | QA Automation Engineer specialized in scalable testing architectures.*