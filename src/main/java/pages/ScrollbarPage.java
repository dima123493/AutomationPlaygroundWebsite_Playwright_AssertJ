package pages;

import com.microsoft.playwright.Page;

public class ScrollbarPage {
    private final Page page;
    private final String hidingButton = "#hidingButton";

    public ScrollbarPage(Page page) {
        this.page = page;
    }

    public void navigateToScrollbarPage() {
        page.navigate("http://uitestingplayground.com/scrollbars");
    }

    public void locateToElement() {
        page.locator(hidingButton).scrollIntoViewIfNeeded();
    }

    public String clickTheHidingButton() {
        page.locator(hidingButton).click();
        return page.locator(hidingButton).textContent();
    }

}