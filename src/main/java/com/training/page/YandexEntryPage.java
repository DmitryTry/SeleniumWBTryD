package com.training.page;

import org.openqa.selenium.By;

public class YandexEntryPage  extends BasePage {

    private static final By LOGIN_BUTTON = By.xpath("//button[@autocomplete='off']");
    private final static String INITIAL_URL = "https://mail.yandex.com/";

    public YandexEntryPage() {
        super();
    }

    public void navigateTo() {
        driver.get(INITIAL_URL);
    }

    public YandexSignInPage navigateToSignInPage() {
        driver.findElement(LOGIN_BUTTON).click();
        return new YandexSignInPage();
    }
}
