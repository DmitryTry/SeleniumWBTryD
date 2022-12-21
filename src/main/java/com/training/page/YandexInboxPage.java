package com.training.page;

import com.training.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexInboxPage {

    @FindBy(xpath = "//div[@data-key='box=left-box']")
    private WebElement messageBox;

    @FindBy(xpath = "//span[@class='user-account__name']/following-sibling::div")
    private WebElement userMenu;

    @FindBy(xpath = "//a[contains(@class, 'item_action_exit')]")
    private WebElement logoutButton;

    public YandexInboxPage() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(messageBox));
    }

    public void logout() {
        userMenu.click();
        logoutButton.click();
        new YandexSignInPage();
    }
}
