package browserConfiguration;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import playwrightInitializer.PlaywrightFactory;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    static PlaywrightFactory playwrightFactory;
    protected static Page page;

    @BeforeAll
    static void setUp() {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initialiseBrowser("chrome");
    }

    @RegisterExtension
    public TestWatcher watchman = new TestWatcher() {
        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy~HH-mm-ss");
            String timeStamp = df.format(new Date());
            String testName = context.getDisplayName();
            String testClass = String.valueOf(context.getTestClass());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/failedTestsScreenshots/" + testClass + testName + timeStamp + ".png")).setFullPage(true));
        }
    };

    @AfterAll
    static void tearDown() {
        page.context().browser().close();
    }
}