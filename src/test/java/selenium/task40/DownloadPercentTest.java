package selenium.task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selenium.task40.ByVariables.DOWNLOAD_BUTTON;
import static selenium.task40.ByVariables.PERCENT_TEXT;

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
