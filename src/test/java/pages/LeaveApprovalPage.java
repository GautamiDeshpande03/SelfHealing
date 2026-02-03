package test.java.pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Page Object Model class for Leave Approval page functionality.
 */
public class LeaveApprovalPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // Locators
    private By myActionsMenu = By.xpath("//div[@class='hrms-sidebar ']//div[contains(text(),'My Actions')]");
    private By teamLeavesMenu = By.xpath("//button[contains(text(),'Team Leaves')]");
    private By approvalsTab = By.xpath("//div[@id='collapse1']//li[contains(text(),'Approvals')]");
    private By pendingApprovalsSection = By.xpath("//a[contains(text(),'Pending Approvals')]");
    private By pendingApprovalsList = By.xpath("//a[contains(text(),'Pending Approvals')]"); // Adjust if needed
    private By firstRecordApproveLink = By.xpath("(//a[contains(text(),'Approve')])[1]");
    private By firstRecordRejectLink = By.xpath("(//a[contains(text(),'Reject')])[1]");
    public LeaveApprovalPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    /**
     * Navigate to Team Leaves Approvals page from My Actions menu.
     */
    public void navigateToTeamLeavesApprovals() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myActionsMenu));
    	driver.findElement(myActionsMenu).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(teamLeavesMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(approvalsTab)).click();
    }
    /**
     * Verify if Pending Approvals section is displayed.
     * @return true if displayed, false otherwise
     */
    public boolean isPendingApprovalsSectionDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pendingApprovalsSection)).isDplayed();
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Click on the first pending approval record's Approve link.
     */
    public void clickFirstRecordApprove() {
        wait.until(ExpectedConditions.elementToBeClickable(firstRecordApproveLink)).click();
    }
    /**
     * Click on the first pending approval record's Reject link.
     */
    public void clickFirstRecordReject() {
        wait.until(ExpectedConditions.elementToBeClickable(firstRecordRejectLink)).click();
    }
    /**
     * Verify if Approve and Reject links are available on the first record.
     * @return true if both links are displayed, false otherwise
     */
    public boolean areApproveAndRejectLinksAvailable() {
        try {
            boolean approveVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(firstRecordApproveLink)).isDplayed();
            boolean rejectVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(firstRecordRejectLink)).isDplayed();
            return approveVisible && rejectVisible;
        } catch (Exception e) {
            return false;
        }
    }
}