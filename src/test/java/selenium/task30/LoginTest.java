package selenium.task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static selenium.task30.ByVariables.*;

public class LoginTest {

    private static final String USERNAME = "SeleniumTestTru";
    private static final String PASSWORD = "SeleniumTestTru_QwE1";
    private static final String TARGET_URL = "https://mail.yandex.com/";
    private static final String EXPECTED_URL = "https://mail.yandex.com/?uid=1711957842#tabs/relevant";



    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }

    @DisplayName("Login to Yandex Test")
    @Test
    public void loginYandexTest() throws InterruptedException {
        driver.get(TARGET_URL);
        driver.findElement(LOGIN_BUTTON)
                .click();
        driver.findElement(USERNAME_FIELD)
                .sendKeys(USERNAME);
        driver.findElement(SIGN_IN_BUTTON)
                .click();
        driver.findElement(PASSWORD_FIELD)
                .sendKeys(PASSWORD);
        driver.findElement(SIGN_IN_BUTTON)
                .click();
        Thread.sleep(3000); // Thread.sleep, because for Selenium displayed previous URL from login page

        Assertions.assertAll(
                () -> Assertions.assertEquals(EXPECTED_URL, driver.getCurrentUrl(), "URL isn't expected"),
                () -> Assertions.assertTrue(driver.findElement(HOME_YA_MAIL_PAGE)
                        .isDisplayed(), "Required page element wasn't found"));
    }

}
