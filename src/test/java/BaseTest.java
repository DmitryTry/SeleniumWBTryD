import com.training.driver.Driver;
import com.training.page.YandexEntryPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected YandexEntryPage yandexEntryPage;

    @BeforeEach
    public void startBrowser() {
        yandexEntryPage = new YandexEntryPage();
        yandexEntryPage.navigateTo();
    }

    @AfterEach
    public void closeBrowser() {
        Driver.tearDown();
    }
}
