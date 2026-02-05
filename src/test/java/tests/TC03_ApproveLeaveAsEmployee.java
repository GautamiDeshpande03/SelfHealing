package test.java.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.pages.LeaveApprovalPage;
import test.java.pages.LoginPage;
import test.java.setup.DriverSetup;
/**
 * Test script for TC02 - Approve Lea as RM.
 * This script performs login as RM, navigates to leave approvals,
 * and verifies the pending approvals and approve/reject links.
 */
public class TC03_ApproveLeaveAsEmployee {
    private WebDriver driver;
    private LoginPage loginPage;
    private LeaveApprovalPage leaveApprovalPage;
    @BeforeTest
    public void setUp() {
        driver = DriverSetup.getDriver();
        loginPage = new LoginPage(driver);
        leaveApprovalPage = new LeaveApprovalPage(driver);
        driver.get("https://qa-wagonhr.mouritech.net");
    }
    @Test(description = "TC03 - Approve Leave as Employee Fail")
    public void approveLeaveAsEmployee() throws Exception {

    	Thread.sleep(3000);
        loginPage.loginAsEmployee();
        Thread.sleep(5000);

        leaveApprovalPage.navigateToTeamLeavesApprovals();
        
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}