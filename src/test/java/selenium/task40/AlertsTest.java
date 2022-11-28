package selenium.task40;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertsTest {

    public WebDriver driver;
    public WebElement confirmBoxButton;
    public WebElement confirmResult;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        confirmBoxButton = driver.findElement(By.xpath("//button[contains(@onclick, 'myConfirm')]"));
        confirmResult = driver.findElement(By.xpath("//p[@id='confirm-demo']"));
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @DisplayName("JS Confirm Box Accept Test")
    @Test
    public void jsConfirmBoxAcceptTest() {
        confirmBoxButton.click();
        driver.switchTo().alert().accept();

        Assertions.assertTrue(confirmResult.getText().contains("OK"), "Element not found!");
    }

    @DisplayName("JS Confirm Box Decline Test")
    @Test
    public void jsConfirmBoxDeclineTest() {
        confirmBoxButton.click();
        driver.switchTo().alert().dismiss();

        Assertions.assertTrue(confirmResult.getText().contains("Cancel"), "Element not found!");
    }

    @DisplayName("JS Alert Box Test")
    @Test
    public void jsAlertBoxTest() {
        driver.findElement(By.xpath("//button[contains(@onclick, 'myAlert')]"))
                .click();
        Alert alert = driver.switchTo().alert();

        Assertions.assertTrue(alert.getText()
                .equalsIgnoreCase("I am an alert box!"), "Element not found!");
    }
}
