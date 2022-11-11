package selenium.task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }

    @DisplayName("Login to Yandex Test")
    @Test
    public void loginYandexTest() throws InterruptedException {
        driver.get(TARGET_URL);
        driver.findElement(By.xpath("//button[@autocomplete='off']"))
                .click();
        driver.findElement(By.xpath("//input[@id='passp-field-login']"))
                .sendKeys(USERNAME);
        driver.findElement(By.xpath("//button[@id='passp:sign-in']"))
                .click();
        driver.findElement(By.xpath("//input[@id='passp-field-passwd']"))
                .sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[@id='passp:sign-in']"))
                .click();
        Thread.sleep(3000); // Thread.sleep, because for Selenium displayed previous URL from login page

        Assertions.assertAll(
                () -> Assertions.assertEquals(EXPECTED_URL, driver.getCurrentUrl(), "URL isn't expected"),
                () -> Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='mail-Layout-Main js-mail-layout-content']"))
                        .isDisplayed(), "Required page element wasn't found"));
    }

}
