package curahealthcaredemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestCasesExecution {

    public String baseurl = "https://katalon-demo-cura.herokuapp.com/#appointment";
    String driverpath = ("C:\\Users\\SVCS\\Downloads\\Selenium\\browser drivers\\geckodriver.exe");
    public WebDriver driver;

    @BeforeTest
    public void test1_LaunchingURL() throws InterruptedException {
        System.out.println("Launching Firefox Browser");
        System.setProperty("webdriver.gecko.driver", driverpath);
        driver = new FirefoxDriver();
        driver.get(baseurl);
    }

    @Test
    public void test2_ScreenScrollFunctionality() throws InterruptedException {
        // Verifying the functionality of scrolling screen 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        driver.findElement(By.id("to-top")).click();
        Thread.sleep(500);
    }

    @Test
    public void test3_VerifyHomeButtonInMenu() throws InterruptedException {
        // Verifying the functionality of Home in menu
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[2]/a")).click();
        Thread.sleep(1000);
    }

    @Test
    public void test4_VerifyLoginPage() throws InterruptedException {
        // Type1 login page navigation (Navigating to Login Page using make appointment button)
        driver.findElement(By.id("btn-make-appointment")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("Navigation Back completed");
        Thread.sleep(1000);

        // Type2 login page navigation (Navigating to Login Page login button in menu )
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(4) > a")).click();
        Thread.sleep(1000);
    }

    @Test
    public void test5_VerifyLoginCredential() throws InterruptedException {
        // Test5 - Providing the credentials USERNAME, PASSWORD and logging in
        WebElement element1 = driver.findElement(By.cssSelector("#login > div > div > div.col-sm-offset-3.col-sm-6 > form > div.alert.alert-info > div:nth-child(1) > div > div > input"));
        String userName = element1.getAttribute("value");
        System.out.println("The Username is:" + userName);

        WebElement element2 = driver.findElement(By.cssSelector("#login > div > div > div.col-sm-offset-3.col-sm-6 > form > div.alert.alert-info > div:nth-child(2) > div > div > input"));
        String password = element2.getAttribute("value");
        System.out.println("The Password is:" + password);

        if(userName.equals("John Doe") && password.equals("ThisIsNotAPassword")) {
            driver.findElement(By.cssSelector("#txt-username")).sendKeys(userName);
            driver.findElement(By.cssSelector("#txt-password")).sendKeys(password);
            driver.findElement(By.id("btn-login")).click();
        } else {
            System.out.println("Incorrect Credentials");
        }
    }

    @Test
    public void test6_BookingAppointment() throws InterruptedException {
        // Verifying the functionality of the Facility Center(Dropdown)
        WebElement facility = driver.findElement(By.id("combo_facility"));
        Select f1 = new Select(facility);

        // Selecting the multiple option
        List<WebElement> facilities = f1.getOptions();
        System.out.println(facilities.size());

        for (int i = 0; i < facilities.size(); i++) {
            facilities.get(i).click();
            String dropdownelements = facilities.get(i).getText();
            Thread.sleep(1000);
            System.out.println(dropdownelements);
        }

        // Selecting any of the options
        f1.selectByVisibleText("Hongkong CURA Healthcare Center");

        // Verifying the functionality of Readmission (checkbox - Selecting and Unselecting)
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("chk_hospotal_readmission")).click();

        // Verifying the functionality of the Health Program Type (Radio Buttons)
        List<WebElement> healthcareProgram = driver.findElements(By.name("programs"));
        for (int i = 0; i < healthcareProgram.size(); i++) {
            healthcareProgram.get(i).click();
            String txt = healthcareProgram.get(i).getText();
            Thread.sleep(1000);
            System.out.println(txt);
        }

        // Verifying the functionality of Visit Date (Datepicker)
        driver.findElement(By.name("visit_date")).sendKeys("1/02/2025");
        driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[1]/td[7]")).click();
        Thread.sleep(500);

        // Verifying the functionality of Comment (TextArea)
        driver.findElement(By.id("txt_comment")).sendKeys("Hello World!");

        // Verifying the functionality of the Book Appointment Button
        driver.findElement(By.id("btn-book-appointment")).click();
    }

    @Test
    public void test7_VerifyHistoryInMenu() throws InterruptedException {
        // Verifying the History functionality in Menu
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".sidebar-nav > li:nth-child(4) > a:nth-child(1)")).click();

        // Verifying Go to home button functionality
        driver.findElement(By.cssSelector(".btn-default")).click();
    }

    @Test
    public void test8_VerifyProfileInMenu() throws InterruptedException {
        // Verifying the Profile functionality in Menu
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".sidebar-nav > li:nth-child(5) > a:nth-child(1)")).click();
    }

    @Test
    public void test9_VerifyLogout() throws InterruptedException {
        // Verifying the Logout functionality
        driver.findElement(By.xpath("/html/body/section/div/div/div/p[2]/a")).click();
        Thread.sleep(500);
    }

    @AfterTest
    public void test10_TerminatingWebPage() throws InterruptedException {
        driver.close();
    }
}
