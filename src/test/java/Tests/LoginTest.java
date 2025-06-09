package Tests;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.*;
import Utils.ExtentReportManager;

public class LoginTest {
	ExtentReports extent;
    ExtentTest test;
    WebDriver driver;
    LoginPage loginPage;
    
    @BeforeClass
    public void setUp() {
    	extent = ExtentReportManager.getInstance(); // initialize report

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        // 🔁 Wait until login field appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    

    }
  
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        loginPage.login(username, password);

        boolean isLoginSuccessful = false;

        try {
            WebElement dashboard = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.oxd-userdropdown-name")));
            Assert.assertTrue(dashboard.isDisplayed(), "Login success expected.");
            isLoginSuccessful = true;

            // ✅ Logout if login is successful
            dashboard.click(); // Click on user dropdown
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement logoutLink = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
            logoutLink.click();
         // ✅ Wait for login page to reappear
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        } catch (Exception e) {
            System.out.println("Login failed for: " + username + " - " + e.getMessage());
        }

        // 📸 Take screenshot after login attempt
        captureScreenshot(username + (isLoginSuccessful ? "_success" : "_failure"));
    }

    
        public void captureScreenshot(String fileName) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            // ✅ Ensure screenshot directory exists
            File screenshotsDir = new File("./screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs(); // create folder if it doesn't exist
            }
            File dest = new File("./screenshots/" + fileName + "_" + timestamp + ".png");

            try {
                FileHandler.copy(src, dest);
                System.out.println("Screenshot saved: " + dest.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Failed to save screenshot: " + e.getMessage());
            }
        }


   

    @AfterClass
    public void tearDown() {
    	extent.flush(); // important!
        driver.quit();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
            {"invalidUser", "wrongpass"},
            {"Admin", "admin123"}
            
            
        };
    }
}
    

  