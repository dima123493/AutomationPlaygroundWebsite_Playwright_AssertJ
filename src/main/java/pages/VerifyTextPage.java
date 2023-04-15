package pages;

import com.microsoft.playwright.Page;

public class VerifyTextPage {
    private final Page page;
    private final String welcomeText = "//span[1][normalize-space(.)='Welcome UserName!']";

    public VerifyTextPage(Page page) {
        this.page = page;
    }

    public void navigateToVerifyTextPage() {
        page.navigate("http://uitestingplayground.com/verifytext");
    }

    public String findElementOnThePage() {
        return page.locator(welcomeText).textContent().trim();
    }
}