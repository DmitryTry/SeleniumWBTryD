package com.training.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexEntryPage extends BasePage {

    public static final String INITIAL_URL = "https://mail.yandex.com/";

    @FindBy(xpath = "//button[@autocomplete='off']")
    private WebElement loginButton;

    public YandexEntryPage() {
        super();
    }

    public void navigateTo() {
        driver.get(INITIAL_URL);
    }

    public YandexSignInPage navigateToSignInPage() {
        loginButton.click();
        return new YandexSignInPage();
    }
}
