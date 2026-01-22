package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExtentTestManager;

@Listeners(TestListener.class)
public class AdminTests extends BaseTest {

    @Test
    public void TCADMIN_001_searchUserAdmin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        ExtentTestManager.getTest().info("Step 1: Open login page");
        login.login("Admin", "admin123");
        ExtentTestManager.getTest().info("Step 2: Enter valid username and password");

        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDisplayed(), "Dashboard should be visible");
        ExtentTestManager.getTest().info("Step 3: Verify dashboard page is displayed");

        AdminPage admin = new AdminPage(driver);
        admin.openAdminModule();
        ExtentTestManager.getTest().info("Step 4: Open Admin module");
        admin.searchUser("Admin");
        ExtentTestManager.getTest().info("Step 5: Search for user 'Admin'");

        Assert.assertTrue(
                admin.isResultDisplayed(),
                "Admin user should appear in search results"
        );
        ExtentTestManager.getTest().info("Step 6: Verify search results for 'Admin'");
    }
}
