package test.java.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.pages.*;
import test.java.setup.DriverSetup;
/**
 * Test script for TC02 - Approve Lea as RM.
 * This script performs login as RM, navigates to leave approvals,
 * and verifies the pending approvals and approve/reject links.
 */
public class TC02_approveLeaveAsRM {
    private WebDriver driver;
    private LoginPage loginPage;
    private LeaveApprovalPage leaveApprovalPage;
    @BeforeMethod
    public void setUp() {
        driver = DriverSetup.getDriver();
        loginPage = new LoginPage(driver);
        leaveApprovalPage = new LeaveApprovalPage(driver);
        driver.get("https://qa-wagonhr.mouritech.net");
    }
    @Test(description = "TC02- Approve Leave as RM")
    public void approveLeaveAsRM() throws Exception {
    		Thread.sleep(3000);
    
        loginPage.loginAsRM();
        Thread.sleep(5000);
        
        leaveApprovalPage.navigateToTeamLeavesApprovals();
    
        Assert.assertTrue(leaveApprovalPage.isPendingApprovalsSectionDisplayed(), "Pending Approvals section should be displayed");

    }
     
    @AfterMethod
    public void tearDown() {
         DriverSetup.quitDriver();
    }
}