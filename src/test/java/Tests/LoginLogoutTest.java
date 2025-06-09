package Tests;



import Base.BaseTest;
import Pages.LoginPage;
import Pages.DashBoardPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;


public class LoginLogoutTest extends BaseTest {

	@Test
	public void testLoginAndLogout() {
	    test = extent.createTest("Login and Logout Test");

	    try {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("Admin", "admin123");
	        test.pass("Logged in with valid credentials");

	        DashBoardPage dashboardPage = new DashBoardPage(driver);
	        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard should be visible after login.");
	        test.log(Status.PASS, "Login successful");

	        dashboardPage.logout();
	        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"), "Should be redirected to login page after logout.");
	        test.log(Status.PASS, "Logout successful");

	    } catch (AssertionError | Exception e) {
	    	 test.log(Status.FAIL, "Test failed: " + e.getMessage());
	        throw e; // still fail the test in TestNG
	    }
	
}
}