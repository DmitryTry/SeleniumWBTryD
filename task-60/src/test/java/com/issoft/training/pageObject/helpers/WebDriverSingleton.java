package com.issoft.training.pageObject.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSingleton {
    private WebDriver driver;
    private static WebDriverSingleton webDriverSingleton;

    private WebDriverSingleton() {

    }

    public static WebDriverSingleton getInstance() {
        if (webDriverSingleton == null) {
            webDriverSingleton = new WebDriverSingleton();
        }
        return webDriverSingleton;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver;
        }
        return driver;
    }

    public void driverClose() {
        if (webDriverSingleton != null) {
            driver.close();
            webDriverSingleton = null;
        }
    }
}
