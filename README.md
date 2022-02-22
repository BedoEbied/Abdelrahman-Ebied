# Abdelrahman-Ebied

### Content:
* [First Part: Test plan for "Trello" mobile application](Trello-TestPlan.pdf)
* [Second Part: Reporting defects for the same app](https://docs.google.com/spreadsheets/d/17q4oWgtqATZDnSg2ABUwnA7vh7A_FStI-wOJ7HARrPQ/edit?usp=sharing)
* [Third Part: Automated tests for Facebook registration and login scenarios](/FacebookAutomation)
* [Fourth Part: Automated tests for Best Buy APIs](#best-buy-apis-automation)

# Facebook Automation Scenarios
### Overview
![image](/FacebookAutomation/Facebook.png)

### Prerequisites:
-   [Selenium](https://www.selenium.dev/)
-   Java (version 6 minimum).
-   IDE (IntelliJ / Eclipse).
-   Maven.
-   TestNG.
> Check [pom.xml](/FacebookAutomation/pom.xml) for dependencies info.

Snippet:
```XML
<dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>4.1.2</version>
</dependency>
````


---

# Best-Buy-APIs-Automation
Testing RESTful API in Best Buy API playground.

## Installation

### Prerequisites:
-   Java (version 6 minimum).
-   IDE (IntelliJ / Eclipse).
-   Maven.
-   TestNG.

>**Framework used: [Rest-assured](https://rest-assured.io/)**

### Getting Started
Start setting up the playground, make sure you have  [NodeJS](https://nodejs.org/)  installed (we require version 4 or newer).

```bash
git clone https://github.com/bestbuy/api-playground/
cd api-playground
npm install
npm start
# Best Buy API Playground started at http://localhost:3030
```

---
### Test Project Setup
1. Create a new maven project.
2. Replace [BestBuy-api-test](/BestBuy-api-test)  folder contents into your maven project directory.
3. Sync the dependencies using *pom.xml*.
4. Build the project.
5. Run test cases as *TestNG Suite*.

