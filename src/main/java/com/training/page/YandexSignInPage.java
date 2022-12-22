package com.training.page;

public class YandexSignInPage extends BasePage {

    public YandexSignInPage() {
        super();
    }

    public YandexInboxPage login(String userName, String userPassword) {
        loginField().sendKeys(userName);
        signInButton().click();
        passwordField().sendKeys(userPassword);
        signInButton().click();
        return new YandexInboxPage();
    }
}
