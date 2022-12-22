package com.training.page;

import com.training.driver.Driver;
import com.training.helper.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    protected Waiter wait;

    public BasePage() {
        driver = Driver.getDriver();
        wait = new Waiter(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}
