package com.training.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexSignInPage extends BasePage {
    @FindBy(id="passp-field-login")
    private WebElement loginField;

    @FindBy(id="passp-field-passwd")
    private WebElement passwordField;

    @FindBy(id="passp:sign-in")
    private WebElement signInButton;

    public YandexSignInPage() {
        super();
    }

    public YandexInboxPage login(String userName, String userPassword) {
        loginField.sendKeys(userName);
        signInButton.click();
        passwordField.sendKeys(userPassword);
        signInButton.click();
        return new YandexInboxPage();
    }
}
