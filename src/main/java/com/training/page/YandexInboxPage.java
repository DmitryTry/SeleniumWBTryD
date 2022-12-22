package com.training.page;

public class YandexInboxPage extends BasePage {

    public YandexInboxPage() {
        super();
    }

    public boolean isDisplayed() {
        wait.waitForElementLocated(MESSAGE_BOX);
        return isDisplayed(driver.findElement(MESSAGE_BOX));
    }

    public void logout() {
        wait.waitForElementLocated(MESSAGE_BOX);
        userMenu().click();
        logoutButton().click();
        new YandexSignInPage();
    }
}
