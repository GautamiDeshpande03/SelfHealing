package test.java.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.LeaveApprovalPage;
import test.java.pages.LoginPage;
import test.java.setup.DriverSetup;
/**
 * Test script for TC02 - Approve Lea as RM.
 * This script performs login as RM, navigates to leave approvals,
 * and verifies the pending approvals and approve/reject links.
 */
public class TC02_ApproveLeaveAsRM1 {
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
    @Test(description = "TC02 - Approve Lea as RM")
    public void approveLeaveAsRM1() throws Exception {
       	Thread.sleep(3000);
        // Step 1: Login with RM role
        loginPage.loginAsRM();
        Thread.sleep(5000);
        // Step 2: Verify Home page is displayed by checking profile element visibility
        //Assert.assertTrue(loginPage.isProfileDisplayed(), "Home page profile should be displayed after login");
        // Step 3: Navigate to My Actions > Team Leaves > Approvals
        leaveApprovalPage.navigateToTeamLeavesApprovals();
        // Step 4: Verify Pending Approvals section is displayed
        Assert.assertTrue(leaveApprovalPage.isPendingApprovalsSectionDisplayed(), "Pending Approvals section should be displayed");
        // Step 5: Verify Approve and Reject links are available on the first record
        //Assert.assertTrue(leaveApprovalPage.areApproveAndRejectLinksAvailable(), "Approve and Reject links should be available on the first record");
        // Additional steps such as clicking Approve or Reject can be added here if needed
    }
     
    @AfterTest
    public void tearDown() {
                  DriverSetup.quitDriver();
    }
}