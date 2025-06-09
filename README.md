# OrangeHRM-Automation
OrangeHRM is an open-source Human Resource Management system that helps organizations manage employee information, recruitment, attendance, and performance efficiently.
# OrangeHRM Automation Testing Project

This project automates functional testing of the OrangeHRM web application using Java, Selenium WebDriver, and TestNG. It follows best practices like Page Object Model (POM), ExtentReports for test reporting, and integrates screenshots and assertions for robust validation.

---

##  Project Features

- 🔐 Login & Logout functionality validation
- 📋 Admin Panel Search functionalities:
  - Search by Username
  - Search by User Role
  - Search by Status
  - Count of Left Menu Items
- 📸 Screenshot capture on failure
- 📊 ExtentReports integration for HTML reporting
- 📂 Page Object Model (POM) for maintainable code structure

---

##  Tech Stack

- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Reporting:** ExtentReports  
- **Build Tool:** Maven  
- **IDE:** Eclipse  
- **Version Control:** Git & GitHub  

---

##  Project Structure
OrangeHRM-Automation/
├── src/
│ ├── pages/ # Page classes (POM)
│ ├── tests/ # TestNG test classes
│ └── utils/ # Utility classes (screenshot, Excel, reports)
├── test-output/ # TestNG default output
├── reports/ # ExtentReport HTML files
├── screenshots/ # Captured screenshots on test failure
├── pom.xml # Maven project file
└── README.md # Project documentation

---

## ✅ How to Run the Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/Chaithrayathiraj/OrangeHRM-Automation.git

Open in Eclipse or any Java IDE.

Run tests via TestNG:

Right-click the testng.xml → Run As → TestNG Suite.

View the generated report at:

/reports/OrangeHRM_ExtentReport.html

Sample Screenshot on Failure
Screenshots will be saved under /screenshots/ folder when any test fails.

Sample ExtentReport Output

(Add this screenshot or remove the section if not ready)
