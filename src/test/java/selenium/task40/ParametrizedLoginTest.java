package selenium.task40;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selenium.task30.ByVariables.*;

public class ParametrizedLoginTest {

    private static final String TARGET_URL = "https://mail.yandex.com/";
    private static final String EXPECTED_TITLE = "Inbox";

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }

    @DisplayName("Login to Yandex with two users - Test")
    @ParameterizedTest
    @CsvSource({"SeleniumTestTru,SeleniumTestTru_QwE1", "SeleniumTestTru2,SeleniumTestTru2_123@"})
    public void loginYandexTest(String userName, String userPassword) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get(TARGET_URL);
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
