package selenium.task40;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selenium.task30.ByVariables.PERCENT_TEXT;

public class DownloadPercentTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(14));
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @DisplayName("Refresh page after 50% download - Test")
    @Test
    public void Download50PercentRefreshTest() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
        driver.findElement(By.xpath("//button[@id='cricle-btn']")).click();

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
