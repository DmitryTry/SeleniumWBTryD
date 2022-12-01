package com.issoft.training.helpers;

import org.openqa.selenium.By;

public class ByVariables {

    public static final By LOGIN_BUTTON = By.xpath("//button[@autocomplete='off']");
    public static final By USERNAME_FIELD = By.id("passp-field-login");
    public static final By SIGN_IN_BUTTON = By.id("passp:sign-in");
    public static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    public static final By HOME_YA_MAIL_PAGE = By.xpath("//div[@class='mail-Layout-Main js-mail-layout-content']");
    public static final By PERCENT_TEXT = By.xpath("//div[@class='percenttext']");
    public static final By USER_LOADING = By.id("loading");
    public static final By CONFIRM_BOX = By.xpath("//button[contains(@onclick, 'myConfirm')]");
    public static final By CONFIRM_RESULT = By.id("confirm-demo");
    public static final By USER_IMG = By.id("loading");
    public static final By GET_NEW_USER_BUTTON = By.id("save");
    public static final By MULTISELECT_LIST = By.id("multi-select");
    public static final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    public static final By ALERT_BUTTON = By.xpath("//button[contains(@onclick, 'myAlert')]");

}
