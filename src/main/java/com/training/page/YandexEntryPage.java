package com.training.page;

public class YandexEntryPage  extends BasePage {

    public YandexEntryPage() {
        super();
    }

    public void navigateTo() {
        driver.get(INITIAL_URL);
    }

    public YandexSignInPage navigateToSignInPage() {
        loginButton().click();
        return new YandexSignInPage();
    }
}
