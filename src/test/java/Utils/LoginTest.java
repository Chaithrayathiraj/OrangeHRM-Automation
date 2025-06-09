package Utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import Utils.ExcelUtil;  // ✅ make sure this is added!

import java.io.IOException;

public class LoginTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        return ExcelUtil.readExcel("src/test/resources/LoginData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Testing with Username: " + username + " and Password: " + password);

        if (username.equals("Admin") && password.equals("admin123")) {
            System.out.println("Login Success!");
            Assert.assertTrue(true);
        } else {
            System.out.println("Login Failed.");
            Assert.assertTrue(false);
        }
    }
}
