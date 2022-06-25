package com.verint.utils.manager;


import com.verint.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class DriverManager {
    private final ConfigReader reader;
    private final String browserType;
    private final int timeOut;
    private WebDriver driver;
    public DriverManager() {
        reader = new ConfigReader();
        browserType = reader.getBrowser();
        timeOut = reader.getTimeOut();
    }

    /**
     * This method return the WebDriver based on the browser type
     *
     * @return the WebDriver based on the browser type
     */
    public WebDriver getWebDriver() {

        if (browserType.toLowerCase().contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.toLowerCase().contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserType.toLowerCase().contains("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            fail("Browser is not supported");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }
}
