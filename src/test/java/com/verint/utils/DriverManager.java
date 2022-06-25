package com.verint.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;
import org.junit.Assert;

public class DriverManager {
    /**
     * DriverManager handle the creation of web driver according to the property file
     * and also handle the closing of the driver
     */
    private final String browserType;
    private final int timeOut;
    private WebDriver driver;
    public DriverManager() {
        ConfigReader reader = new ConfigReader();
        browserType = reader.getBrowser();
        timeOut = reader.getTimeOut();
    }
    public WebDriver getWebDriver() {
        if (browserType.toLowerCase().contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            // chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browserType.toLowerCase().contains("firefox")) {
            WebDriverManager.firefoxdriver().avoidBrowserDetection().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            // firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browserType.toLowerCase().contains("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            Assert.fail("Browser is not supported");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }
}
