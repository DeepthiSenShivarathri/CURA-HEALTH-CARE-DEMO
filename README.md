# Cura Healthcare Demo Automation Testing <br> https://katalon-demo-cura.herokuapp.com/#appointment <br>
This project contains automated tests for the Cura Healthcare Web Application, written in Java using Selenium WebDriver and TestNG. It validates key functionalities like login, appointment booking, menu navigation, and logout. <br>

**Tools & Technologies** <br>
1.Java for test scripting <br>
2.Selenium WebDriver for browser automation <br>
3.TestNG for test management <br>
4.Firefox WebDriver (Geckodriver) for Firefox browser automation or choose WebDrivers as per the Browsers <br><br>
**Setup** <br>
**Prerequisites:** <br>
1.Install **Java** and **Geckodriver**. <br>
2.Clone the repository:
```
git clone https://github.com/DeepthiSenShivarathri/CURA-HEALTH-CARE-DEMO.git
```
3.Set the path for Geckodriver in the code:
```
String driverpath = ("C:\\path\\to\\geckodriver.exe");
```
**Run Tests** <br>
1.Open the project in your IDE (e.g., IntelliJ, Eclipse). <br>
2.Run TestCasesExecution.java using TestNG. <br><br>
**Test Cases** <br>
1.Launching URL <br>
2.Screen Scroll Functionality <br>
3.Verify Home Button <br>
4.Verify Login Page <br>
5.Login Credentials <br>
6.Booking Appointment <br>
7.Verify History in Menu <br>
8.Verify Profile in Menu <br>
9.Logout <br><br>
**Project Structure** <br>
The project is organized as follows: <br>

```

cura-healthcare-demo-automation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── curahealthcare/
│   │   │       └── TestCasesExecution.java
│   └── test/
│       └── java/
│           ├── curahealthcare/
│           │   └── TestCasesExecution.java
└── README.md

```
**TestCasesExecution.java:** Contains all the automated test cases written for the Cura Healthcare demo app. <br>
