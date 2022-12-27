import com.training.driver.Driver;
import com.training.page.YandexEntryPage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected YandexEntryPage yandexEntryPage;

    public static final String USER_NAME = "SeleniumTestTru";
    public static final String PASSWORD = "SeleniumTestTru_QwE1";

    @BeforeEach
    public void startBrowser() {
        yandexEntryPage = new YandexEntryPage();
        yandexEntryPage.navigateTo();
    }

    @AfterEach
    public void closeBrowser() {
        Driver.tearDown();
    }

    public void createScreenshot(String screenshotName) throws IOException {
        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("target/Screenshots/" + screenshotName
                + RandomStringUtils.randomNumeric(5) + ".png"));
    }
}
