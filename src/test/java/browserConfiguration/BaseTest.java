package browserConfiguration;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import playwrightInitializer.PlaywrightFactory;

public class BaseTest {
    static PlaywrightFactory playwrightFactory;
    protected static Page page;

    @BeforeAll
    static void setUp() {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initialiseBrowser("chrome");
    }

    @AfterAll
    static void tearDown() {
        page.context().browser().close();
    }
}
