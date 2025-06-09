package Tests;



import org.testng.annotations.Test;
import org.testng.Assert;

import Pages.LoginPage;
import Pages.AdminPage;
import Base.BaseTest;

public class AdminTest extends BaseTest {

    @Test(priority = 1)
    public void testLeftMenuOptionsCount() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminTab();  // navigate to admin page
        int menuCount = adminPage.getLeftMenuItemsCount();

        
        System.out.println("Total menu items: " + menuCount);
        Assert.assertEquals(menuCount, 12, "Menu count should be 12");

       
    }

    @Test(priority = 2)
    public void testSearchByUsername() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.searchByUsername("Admin");
        String result = adminPage.getResultText();
        System.out.println("Search by username result: " + result);
        adminPage.resetSearch();
    }

    @Test(priority = 3)
    public void testSearchByUserRole() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.searchByUserRole("Admin");
        String result = adminPage.getResultText();
        System.out.println("Search by user role result: " + result);
        adminPage.resetSearch();
    }

    @Test(priority = 4)
    public void testSearchByStatus() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.searchByUserStatus("Enabled");
        String result = adminPage.getResultText();
        System.out.println("Search by status result: " + result);
        adminPage.resetSearch();
    }
}
