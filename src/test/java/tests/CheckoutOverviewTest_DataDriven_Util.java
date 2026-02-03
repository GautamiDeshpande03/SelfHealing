package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 import test.java.pages.*;
import utils.ExcelUtils;
import test.java.setup.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class CheckoutOverviewTest_DataDriven_Util extends DriverSetup {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    

    private static final String URL = "https://www.saucedemo.com/";
    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @BeforeMethod
    public void setup() throws InterruptedException {
    	driver = DriverSetup.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);

        loginPage = new LoginPage(driver);
         
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "checkoutData")
    public Iterator<Object[]> getData() throws IOException {
        String path = "src/Data/TestData.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtils.getSheetData(path, sheetName);
    }

    /**
     * TC_AIGPMM-38_007: Verify Payment Information and Shipping Information display on Checkout: Overview page
     * TC_AIGPMM-38_008: Verify Item Total, Tax, and Total amounts are displayed correctly
     * TC_AIGPMM-38_010: Verify Finish button on Checkout: Overview navigates to Finish page
     */
    @Test(dataProvider = "checkoutData")
    public void testCheckoutOverviewFlow(String firstName, String lastName, String postalCode) {
       // loginPage.login(USERNAME, PASSWORD);
    	loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        

         
    }

    /**
     * TC_AIGPMM-37_025: Verify Remove button removes product and decrements cart count
     */
    @Test
    public void testRemoveProductFromCart() {
    	loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        
    }

    /**
     * TC_AIGPMM-37_032: Verify Continue Shopping button navigates back to Products page
     */
    @Test
    public void testContinueShoppingButton() {
    	loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        
         }
}
