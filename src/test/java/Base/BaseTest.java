package Base;





import Utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public void setUp() {
    	extent = ExtentReportManager.getInstance();
        test = extent.createTest("Your Test Name");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        extent = ExtentReportManager.getInstance();
    }
    @AfterClass
    public void tearDown() {
        if (extent != null) {
            extent.flush(); // MUST call flush once
        }
        if (driver != null) {
            driver.quit();
        }
    }
}