package com.training.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexInboxPage extends BasePage {

    @FindBy(xpath = "//div[@data-key='box=left-box']")
    private WebElement messageBox;

    @FindBy(xpath = "//span[@class='user-account__name']/following-sibling::div")
    private WebElement userMenu;

    @FindBy(xpath = "//a[contains(@class, 'item_action_exit')]")
    private WebElement logoutButton;

    public YandexInboxPage() {
        super();
    }

    public boolean isDisplayed() {
        wait.waitForElementLocated(messageBox);
        return isDisplayed(messageBox);
    }

    public void logout() {
        wait.waitForElementLocated(messageBox);
        userMenu.click();
        logoutButton.click();
        new YandexSignInPage();
    }
}
