package selenium.task40;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;


public abstract class TestSettings {

    protected WebDriver driver;
    protected Properties testProperties;

    @BeforeEach
    public void setUpDriver() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + "test.properties";

        testProperties = new Properties();
        testProperties.load(new FileInputStream(appConfigPath));

    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}
