package com.issoft.training.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import com.issoft.training.settings.TestBase;

import static com.issoft.training.helpers.ByVariables.*;

public class AlertsTest extends TestBase {

    @BeforeEach
    public void setUp() {
        driver.get(testProperties.getProperty("seleniumeasy.alerts-url"));
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @DisplayName("JS Confirm Box Accept Test")
    @Test
    public void jsConfirmBoxAcceptTest() {
        WebElement confirmBoxButton = driver.findElement(CONFIRM_BOX);
        WebElement confirmResult = driver.findElement(CONFIRM_RESULT);
        confirmBoxButton.click();
        driver.switchTo().alert().accept();

        Assertions.assertTrue(confirmResult.getText().contains("OK"), "Element not found!");
    }

    @DisplayName("JS Confirm Box Decline Test")
    @Test
    public void jsConfirmBoxDeclineTest() {
        WebElement confirmBoxButton = driver.findElement(CONFIRM_BOX);
        WebElement confirmResult = driver.findElement(CONFIRM_RESULT);
        confirmBoxButton.click();
        driver.switchTo().alert().dismiss();

        Assertions.assertTrue(confirmResult.getText().contains("Cancel"), "Element not found!");
    }

    @DisplayName("JS Alert Box Test")
    @Test
    public void jsAlertBoxTest() {
        driver.findElement(ALERT_BUTTON).click();
        Alert alert = driver.switchTo().alert();

        Assertions.assertTrue(alert.getText().equalsIgnoreCase("I am an alert box!"), "Element not found!");
    }
}
