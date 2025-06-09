package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class AdminPage {
    WebDriver driver;

    // Locators
    private By leftMenuItems = By.xpath("//ul[contains(@class,'oxd-main-menu')]/li");  // list of menu items
    private By adminTab = By.xpath("//span[text()='Admin']");
    
    private By usernameField = By.xpath("//input[@placeholder='Type for hints...']");
    private By userRoleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div//div[contains(@class, 'select-text')]");
    private By userRoleOptions = By.xpath("//div[@role='listbox']//span");

    private By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div//div[contains(@class, 'select-text')]");
    private By statusOptions = By.xpath("//div[@role='listbox']//span");

    private By searchButton = By.xpath("//button[@type='submit']");
    private By resetButton = By.xpath("//button[normalize-space()='Reset']");
    private By resultSpan = By.xpath("//div[contains(@class, 'orangehrm-horizontal-padding') and contains(@class, 'orangehrm-vertical-padding')]//span");

    

        public AdminPage(WebDriver driver) {
            this.driver = driver;
        }

        // ✅ Add this method
        public int getLeftMenuItemsCount() {
        	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(leftMenuItems));
            List<WebElement> menuItems = driver.findElements(By.xpath("//ul[contains(@class,'oxd-main-menu')]/li"));
            return menuItems.size();
        }

        // Your other methods like clickAdminTab(), etc.
    
    public void clickAdminTab() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement adminElement = wait.until(ExpectedConditions.elementToBeClickable(adminTab));
        adminElement.click();
    }

    // 2️⃣ Search by username
    public void searchByUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(searchButton).click();
    }

    // 3️⃣ Search by user role
    public void searchByUserRole(String roleName) {
        driver.findElement(userRoleDropdown).click();
        List<WebElement> options = driver.findElements(userRoleOptions);
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(roleName)) {
                option.click();
                break;
            }
        }
        driver.findElement(searchButton).click();
    }

    // 4️⃣ Search by status
    public void searchByUserStatus(String statusName) {
        driver.findElement(statusDropdown).click();
        List<WebElement> options = driver.findElements(statusOptions);
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(statusName)) {
                option.click();
                break;
            }
        }
        driver.findElement(searchButton).click();
    }

    // 📌 Display result count
    
    	public String getResultText() {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(resultSpan));
    	    return resultText.getText();
    	}

    

    // 🔁 Reset Search
    public void resetSearch() {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Reset']")));
    	    reset.click();
    }

	}

