package pages;

import com.microsoft.playwright.Page;

public class NonBreakingSpacePage {
    private final Page page;
    private final String nonBreakingSpaceButton = "//button[text()='My\u00A0Button']";

    public NonBreakingSpacePage(Page page) {
        this.page = page;
    }

    public void navigateToNonBreakingSpacePage() {
        page.navigate("http://uitestingplayground.com/nbsp");
    }

    public void clickTheButton() {
        page.locator(nonBreakingSpaceButton).click();
    }
}