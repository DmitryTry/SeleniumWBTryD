package com.training.page;

import org.openqa.selenium.By;

public class YandexSignInPage extends BasePage {
    private static final By LOGIN_FIELD = By.id("passp-field-login");
    private static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private static final By SIGN_IN_BUTTON = By.id("passp:sign-in");

    public YandexSignInPage() {
        super();
    }

    public YandexInboxPage login(String userName, String userPassword) {
        driver.findElement(LOGIN_FIELD).sendKeys(userName);
        driver.findElement(SIGN_IN_BUTTON).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(userPassword);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new YandexInboxPage();
    }
}
