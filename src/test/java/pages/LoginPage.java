package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
    private WebDriver driver;
    // Locators
    private By usernameInput = By.xpath("//input[@id='username']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@type='submit' and normalize-space()='Login']");
   	public By code1 = By.xpath("//input[@class='form-control text-center mx-1'][1]");
	public By code2 = By.xpath("//input[2]");
	public By code3 = By.xpath("//input[3]");
	public By code4 = By.xpath("//input[4]");
	public By code5 = By.xpath("//input[5]");
	public By code6 = By.xpath("//input[6]");
    public By verifycode= By.xpath("//button[normalize-space()='Verify Code']");
 
    public LoginPage(WebDriver driver) {
       this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    /**
     * Logs in as an Employee role.
     * Uses test data from session or hardcoded for demonstration.
     * @throws InterruptedException 
     */
    public void loginAsEmployee() throws InterruptedException {
        // Replace with actual employee username and password from test data
        String employeeUsername = "sundari.in@mouritech.com";
        String employeePassword = "J%130323765756ay";
        WebElement usernameElem = driver.findElement(usernameInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameElem.clear();
        
        usernameElem.sendKeys(employeeUsername);
        WebElement passwordElem = driver.findElement(passwordInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordElem.clear();
        passwordElem.sendKeys(employeePassword);
        driver.findElement(loginButton).click();
      Thread.sleep(3000);
		// Verification step
		wait.until(ExpectedConditions.visibilityOfElementLocated(code1));
		driver.findElement(code1).sendKeys("1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(code2));
	   driver.findElement(code2).sendKeys("2");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(code3));
	   driver.findElement(code3).sendKeys("3");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(code4));
	   driver.findElement(code4).sendKeys("4");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(code5));
	   driver.findElement(code5).sendKeys("5");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(code6));
	   driver.findElement(code6).sendKeys("6");
	   wait.until(ExpectedConditions.elementToBeClickable(verifycode));
          driver.findElement(verifycode).click();
      //((JavascriptExecutor) driver).executeScript("arguments[0].click();", verifycode);
    }
    
    public void loginAsRM() throws InterruptedException {
        // Replace with actual employee username and password from test data
        String RMUsername = "rm808@mouritech.com";
        String RMPassword = "J%130323765756ay";
        WebElement usernameElem = driver.findElement(usernameInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameElem.clear();
        
        usernameElem.sendKeys(RMUsername);
        WebElement passwordElem = driver.findElement(passwordInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordElem.clear();
        passwordElem.sendKeys(RMPassword);
        driver.findElement(loginButton).click();
      Thread.sleep(3000);
		// Verification step
		wait.until(ExpectedConditions.visibilityOfElementLocated(code1));
		driver.findElement(code1).sendKeys("1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(code2));
	   driver.findElement(code2).sendKeys("2");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(code3));
	   driver.findElement(code3).sendKeys("3");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(code4));
	   driver.findElement(code4).sendKeys("4");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(code5));
	   driver.findElement(code5).sendKeys("5");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(code6));
	   driver.findElement(code6).sendKeys("6");
	   wait.until(ExpectedConditions.elementToBeClickable(verifycode));
          driver.findElement(verifycode).click();
      //((JavascriptExecutor) driver).executeScript("arguments[0].click();", verifycode);
    }

}