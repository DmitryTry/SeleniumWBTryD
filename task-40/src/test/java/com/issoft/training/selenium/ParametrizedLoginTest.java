package com.issoft.training.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.issoft.training.settings.TestSettings;

import java.time.Duration;

import static com.issoft.training.helpers.ByVariables.*;

public class ParametrizedLoginTest extends TestSettings {
    private static final String EXPECTED_TITLE = "Inbox";

    @DisplayName("Login to Yandex with two users - Test")
    @ParameterizedTest
    @CsvSource({"SeleniumTestTru,SeleniumTestTru_QwE1", "SeleniumTestTru2,SeleniumTestTru2_123@"})
    public void loginYandexTest(String userName, String userPassword) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get(testProperties.getProperty("mail.yandex-url"));
        driver.findElement(LOGIN_BUTTON)
                .click();
        driver.findElement(USERNAME_FIELD)
                .sendKeys(userName);
        driver.findElement(SIGN_IN_BUTTON)
                .click();
        driver.findElement(PASSWORD_FIELD)
                .sendKeys(userPassword);
        driver.findElement(SIGN_IN_BUTTON)
                .click();
        webDriverWait.pollingEvery(Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(HOME_YA_MAIL_PAGE));

        Assertions.assertTrue(driver.getTitle().contains(EXPECTED_TITLE), "Expected title not found!");
    }
}
