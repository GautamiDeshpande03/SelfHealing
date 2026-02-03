package test.java.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

    private static WebDriver driver; // <--- Single static driver

    public static WebDriver getDriver() {

        if (driver == null) {  // <--- Driver not initialized? Create once.
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);  // <--- Assign to static driver
              driver.manage().window().maximize();
            System.out.println("Driver initialized: " + driver);
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
