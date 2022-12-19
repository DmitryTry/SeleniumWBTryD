package com.issoft.training.pageObject.tests;

import com.issoft.training.pageObject.helpers.WebDriverSingleton;
import com.issoft.training.pageObject.helpers.YandexEntryPage;
import com.issoft.training.pageObject.helpers.YandexInboxPage;
import com.issoft.training.pageObject.helpers.YandexSignInPage;
import org.junit.jupiter.api.*;

public class AuthorizationTest {
    private YandexEntryPage yandexEntryPage;
    private YandexSignInPage yandexSignInPage;
    private YandexInboxPage yandexInboxPage;

    @BeforeEach
    public void setUp() {
        yandexEntryPage = new YandexEntryPage();
    }

    @AfterEach
    public void close() {
        WebDriverSingleton.getInstance().driverClose();
    }

    @DisplayName("Login to Yandex")
    @Test
    public void loginYandexTest() {
        yandexSignInPage = yandexEntryPage.navigateToSignInPage();
        yandexInboxPage = yandexSignInPage.login("SeleniumTestTru", "SeleniumTestTru_QwE1");

        Assertions.assertTrue(WebDriverSingleton.getInstance().getDriver().getTitle().contains("Inbox — Yandex Mail")
                , "You are on wrong page. Please check the page!");
    }

    @DisplayName("Logout from Yandex")
    @Test
    public void logoutYandexTest() {
        yandexSignInPage = yandexEntryPage.navigateToSignInPage();
        yandexInboxPage = yandexSignInPage.login("SeleniumTestTru", "SeleniumTestTru_QwE1");
        yandexInboxPage.logout();

        Assertions.assertTrue(WebDriverSingleton.getInstance().getDriver().getTitle().contains("reliable and easy to use")
                , "You are on wrong page. Please check the page!");
    }
}
