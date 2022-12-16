package com.issoft.training.selenium;

import com.issoft.training.settings.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.issoft.training.helpers.ByVariables.DOWNLOAD_BUTTON;
import static com.issoft.training.helpers.ByVariables.PERCENT_TEXT;

public class DownloadPercentTest extends TestBase {

    @DisplayName("Refresh page after 50% download - Test")
    @Test
    public void download50PercentRefreshTest() {
        driver.get(testProperties.getProperty("seleniumeasy.download-url"));
        driver.findElement(DOWNLOAD_BUTTON).click();

        new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(50))
                .until(driver -> driver.findElement(PERCENT_TEXT).getText().contains("50"));
        driver.navigate().refresh();
        Assertions.assertTrue(driver.findElement(DOWNLOAD_BUTTON).isDisplayed(), "Download button is not found");
    }
}
