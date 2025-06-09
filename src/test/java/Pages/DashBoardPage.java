package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class DashBoardPage {
    private WebDriver driver;

    private By profileIcon = By.className("oxd-userdropdown-icon"); // may vary
    private By logoutLink = By.xpath("//a[text()='Logout']");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains("/dashboard"));
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).click();
    }
}
