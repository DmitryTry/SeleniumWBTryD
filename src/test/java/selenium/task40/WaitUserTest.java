package selenium.task40;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selenium.task30.ByVariables.USER_LOADING;

public class WaitUserTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @DisplayName("Waiting for the user loading - Test")
    @Test
    public void waitUserDisplayTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
        driver.findElement(By.xpath("//button[@id='save']")).click();
        webDriverWait.until(ExpectedConditions.and(ExpectedConditions.textToBePresentInElement(driver.findElement(USER_LOADING), "First Name : "),
                ExpectedConditions.textToBePresentInElement(driver.findElement(USER_LOADING), "Last Name :")));

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@id='loading']/img")).isDisplayed(), "User not displayed");
    }
}
