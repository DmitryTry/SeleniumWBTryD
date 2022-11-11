package selenium.task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByVariables {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://mail.yandex.com/");
        driver.findElement(By.xpath("//div[@class='PageWrapper_2aGaNaGauHNRzr8W2U0GwV']")).isDisplayed();
        driver.findElement(By.linkText("Get started with Premium")).isDisplayed();
        driver.findElement(By.cssSelector("div[class='Text_S6Oq9oB2XJtxRu7BNIqYk']")).isDisplayed();
        driver.findElement(By.tagName("div")).isDisplayed();
        driver.findElement(By.partialLinkText("24-hour support")).isDisplayed();

        driver.get("https://passport.yandex.com/");
        driver.findElement(By.name("login")).isDisplayed();
        driver.findElement(By.className("AuthSocialBlock")).isDisplayed();
        driver.findElement(By.id("passp:exp-register")).isDisplayed();
        driver.close();
        System.out.println("All elements was found");
    }
}
