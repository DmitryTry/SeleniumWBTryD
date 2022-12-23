package com.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YandexInboxPage extends BasePage {

    private final static By MESSAGE_BOX = By.xpath("//div[@data-key='box=left-box']");

    public WebElement getUserMenu(){
        return driver.findElement(By.xpath("//span[@class='user-account__name']/following-sibling::div"));
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.xpath("//a[contains(@class, 'item_action_exit')]"));
    }

    public YandexInboxPage() {
        super();
    }

    public boolean isDisplayed() {
        wait.waitForElementLocated(MESSAGE_BOX);
        return isDisplayed(driver.findElement(MESSAGE_BOX));
    }

    public void logout() {
        wait.waitForElementLocated(MESSAGE_BOX);
        getUserMenu().click();
        getLogoutButton().click();
        new YandexSignInPage();
    }
}
