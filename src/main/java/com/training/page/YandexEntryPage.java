package com.training.page;

import com.training.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexEntryPage {
    private final static String INITIAL_URL = "https://mail.yandex.com/";

    @FindBy(xpath = "//button[@autocomplete='off']")
    private WebElement loginButton;

    public YandexEntryPage() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        driver.get(INITIAL_URL);
        PageFactory.initElements(driver, this);
    }

    public YandexSignInPage navigateToSignInPage() {
        loginButton.click();
        return new YandexSignInPage();
    }
}
