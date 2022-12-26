import com.training.page.YandexInboxPage;
import com.training.page.YandexSignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AuthorizationTest extends BaseTest {

    private YandexSignInPage yandexSignInPage;
    private YandexInboxPage yandexInboxPage;

    @BeforeEach
    public void navigateToLogin() {
        yandexSignInPage = yandexEntryPage.navigateToSignInPage();
        yandexInboxPage = yandexSignInPage.login(USER_NAME, PASSWORD);
    }

    @DisplayName("Login to Yandex")
    @Test
    public void loginYandexTest() throws IOException {
        Assertions.assertTrue(yandexInboxPage.isDisplayed(),
                "You are on wrong page. Please check the page!");
        createScreenshot("YandexHomePage");
    }

    @DisplayName("Logout from Yandex")
    @Test
    public void logoutYandexTest() throws IOException {
        yandexInboxPage.logout();

        Assertions.assertTrue(yandexSignInPage.getTitle().contains("reliable and easy to use"),
                "You are on wrong page. Please check the page!");
        createScreenshot("YandexStartPage");
    }
}
