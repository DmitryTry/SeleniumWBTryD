package com.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YandexEntryPage  extends BasePage {

    private final static String INITIAL_URL = "https://mail.yandex.com/";

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//button[@autocomplete='off']"));
    }

    public YandexEntryPage() {
        super();
    }

    public void navigateTo() {
        driver.get(INITIAL_URL);
    }

    public YandexSignInPage navigateToSignInPage() {
        getLoginButton().click();
        return new YandexSignInPage();
    }
}
