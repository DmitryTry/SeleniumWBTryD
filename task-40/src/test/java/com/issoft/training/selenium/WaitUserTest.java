package com.issoft.training.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.issoft.training.settings.TestSettings;

import java.time.Duration;

import static com.issoft.training.helpers.ByVariables.*;


public class WaitUserTest extends TestSettings {


    @DisplayName("Waiting for the user loading - Test")
    @Test
    public void waitUserDisplayTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(testProperties.getProperty("seleniumeasy.loading-url"));
        driver.findElement(GET_NEW_USER_BUTTON).click();
        webDriverWait.until(ExpectedConditions.and(ExpectedConditions.textToBePresentInElement(driver.findElement(USER_LOADING), "First Name : "),
                ExpectedConditions.textToBePresentInElement(driver.findElement(USER_LOADING), "Last Name :")));

        Assertions.assertTrue(driver.findElement(USER_IMG).isDisplayed(), "User not displayed");
    }
}
