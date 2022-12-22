package com.training.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexEntryPage extends BasePage {

    @FindBy(xpath = "//button[@autocomplete='off']")
    private WebElement loginButton;

    public YandexEntryPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get(INITIAL_URL);
    }

    public YandexSignInPage navigateToSignInPage() {
        loginButton.click();
        return new YandexSignInPage();
    }
}
