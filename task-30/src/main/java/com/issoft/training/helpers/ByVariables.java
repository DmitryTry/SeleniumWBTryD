package com.issoft.training.helpers;

import org.openqa.selenium.By;


public class ByVariables {

    public static final By NAME = By.name("login");
    public static final By XPATH = By.xpath("//div[@class='PageWrapper_2aGaNaGauHNRzr8W2U0GwV']");
    public static final By LINK_TEXT = By.linkText("Get started with Premium");
    public static final By CSS_SELECTOR = By.cssSelector("div[class='Text_S6Oq9oB2XJtxRu7BNIqYk']");
    public static final By TAG_NAME = By.tagName("div");
    public static final By PARTIAL_LINK_TEXT = By.partialLinkText("24-hour support");
    public static final By CLASS_NAME = By.className("AuthSocialBlock");
    public static final By ID = By.id("passp:exp-register");

    // constants used in the tests
    public static final By LOGIN_BUTTON = By.xpath("//button[@autocomplete='off']");
    public static final By USERNAME_FIELD = By.id("passp-field-login");
    public static final By SIGN_IN_BUTTON = By.id("passp:sign-in");
    public static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    public static final By HOME_YA_MAIL_PAGE = By.xpath("//div[@class='mail-Layout-Main js-mail-layout-content']");


}
