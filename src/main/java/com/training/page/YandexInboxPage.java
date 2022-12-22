package com.training.page;

import org.openqa.selenium.By;

public class YandexInboxPage extends BasePage {

    private final static By MESSAGE_BOX = By.xpath("//div[@data-key='box=left-box']");
    private final static By USER_MENU = By.xpath("//span[@class='user-account__name']/following-sibling::div");
    private static final By LOGOUT_BUTTON = By.xpath("//a[contains(@class, 'item_action_exit')]");

    public YandexInboxPage() {
        super();
    }

    public boolean isDisplayed() {
        wait.waitForElementLocated(MESSAGE_BOX);
        return isDisplayed(driver.findElement(MESSAGE_BOX));
    }

    public void logout() {
        wait.waitForElementLocated(MESSAGE_BOX);
        driver.findElement(USER_MENU).click();
        driver.findElement(LOGOUT_BUTTON).click();
        new YandexSignInPage();
    }
}
