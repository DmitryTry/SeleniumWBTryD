package com.training.page;

import com.training.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexSignInPage {
    @FindBy(id="passp-field-login")
    private WebElement loginField;

    @FindBy(id="passp-field-passwd")
    private WebElement passwordField;

    @FindBy(id="passp:sign-in")
    private WebElement signInButton;

    public YandexSignInPage() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public YandexInboxPage login(String userName, String userPassword) {
        loginField.sendKeys(userName);
        signInButton.click();
        passwordField.sendKeys(userPassword);
        signInButton.click();
        return new YandexInboxPage();
    }
}
