package test.java.tests;

import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import test.java.pages.LoginPage;
import test.java.setup.DriverSetup;
import Config.PropertiesFile;

public class TC01_Login_Leave extends DriverSetup {

    private WebDriver driver;
    private LoginPage loginPage;
 
    

    @BeforeTest
    public void setup() throws InterruptedException {

        PropertiesFile.loadProperties();

        driver = DriverSetup.getDriver();
        driver.manage().window().maximize();

        String url = PropertiesFile.getApplicationUrl();
        System.out.println("Navigating to URL: " + url);
        driver.get(url);
    }

    @Test(description = "Verify Login")
    public void Login() throws Exception {
    	loginPage = new LoginPage(driver);
        // Login steps
       loginPage.LoginAs("Employee");
		Thread.sleep(3000);
		// Verification step
		Assert.assertTrue(driver.getCurrentUrl().contains("home"), "Login failed or dashboard not reached.");
    }

    @AfterTest
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
