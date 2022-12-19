package com.issoft.training.pageObject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexEntryPage {
    private final WebDriver driver;
    private final By loginButton = By.xpath("//button[@autocomplete='off']");
    private final static String INITIAL_URL = "https://mail.yandex.com/";

    public YandexEntryPage() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
        driver.get(INITIAL_URL);
    }

    public YandexSignInPage navigateToSignInPage() {
        driver.findElement(loginButton).click();
        return new YandexSignInPage();
    }
}
