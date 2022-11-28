package selenium.task40;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiSelectTest {

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
        driver.quit();
    }

    @DisplayName("Select for three options - Test")
    @Test
    public void selectOptionsTest() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        WebElement list = driver.findElement(By.xpath("//select[@id='multi-select']"));
        Select multiSelectList = new Select(list);
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Florida", "Ohio", "Texas"));
        for (String state : expectedOptions) {
            multiSelectList.selectByVisibleText(state);
        }
        List<String> selectedOptions = multiSelectList.getAllSelectedOptions().stream()
                .map(WebElement::getText).collect(Collectors.toList());

        Assertions.assertEquals(expectedOptions, selectedOptions, "Options not found!");
    }
}
