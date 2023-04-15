package playwrightInitializer;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initialiseBrowser(String browserName) {
        playwright = Playwright.create();
        switch (browserName.toLowerCase().trim()) {
            case "chromium" ->
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "chrome" ->
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            case "firefox", "gecko" ->
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "safari", "webkit" ->
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            default -> System.out.println("Pass the right browser name... (chromium, chrome" +
                    ", firefox, safari)");
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();

        return page;
    }

}