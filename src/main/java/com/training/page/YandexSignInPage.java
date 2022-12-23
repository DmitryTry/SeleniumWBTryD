package com.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YandexSignInPage extends BasePage {

    public WebElement getLoginField(){
        return driver.findElement(By.id("passp-field-login"));
    }

    public WebElement getPasswordField(){
        return driver.findElement(By.id("passp-field-passwd"));
    }

    public WebElement getSignInButton(){
        return driver.findElement(By.id("passp:sign-in"));
    }

    public YandexSignInPage() {
        super();
    }

    public YandexInboxPage login(String userName, String userPassword) {
        getLoginField().sendKeys(userName);
        getSignInButton().click();
        getPasswordField().sendKeys(userPassword);
        getSignInButton().click();
        return new YandexInboxPage();
    }
}
