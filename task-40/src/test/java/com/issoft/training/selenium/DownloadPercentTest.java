package com.issoft.training.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.issoft.training.settings.TestSettings;

import java.time.Duration;

import static com.issoft.training.helpers.ByVariables.DOWNLOAD_BUTTON;
import static com.issoft.training.helpers.ByVariables.PERCENT_TEXT;

public class DownloadPercentTest extends TestSettings {

    @DisplayName("Refresh page after 50% download - Test")
    @Test
    public void download50PercentRefreshTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(14));
        driver.get(testProperties.getProperty("seleniumeasy.download-url"));
        driver.findElement(DOWNLOAD_BUTTON).click();

        webDriverWait.until((ExpectedCondition<Boolean>) driver -> {
                    int progress = Integer.parseInt(driver.findElement(PERCENT_TEXT).getText()
                            .replace("%", ""));
                    if (progress >= 50) {
                        driver.navigate().refresh();
                        return true;
                    }
                    return false;
                }
        );
        Assertions.assertEquals("0%", driver.findElement(PERCENT_TEXT).getText(), "Percent text not found");
    }
}
