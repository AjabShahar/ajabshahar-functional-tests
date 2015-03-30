package org.ajabshahar.qa;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final String CHROME = "chrome";

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    @BeforeSuite
    public void Setup() {
/*
        String browser = System.getenv("browser.name");
        if (browser.toLowerCase().equals(CHROME)) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
*/
        System.setProperty("webdriver.chrome.driver","/opt/chromedriver/chromedriver");
//        System.out.println(System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void TearDown() {
        driver.close();
    }
}
