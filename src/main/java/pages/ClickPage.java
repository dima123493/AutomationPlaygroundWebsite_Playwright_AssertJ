package pages;

import com.microsoft.playwright.Page;

public class ClickPage {
    private final Page page;
    private final String button = "#badButton";

    public ClickPage(Page page) {
        this.page = page;
    }

    public void navigateToClickPage() {
        page.navigate("http://uitestingplayground.com/click");
    }

    public void pressTheButtonPhysically() {
        page.locator(button).hover();
        page.mouse().down();
        page.mouse().up();
    }

    public String getDataAfterClick() {
        return page.locator(button).getAttribute("class");
    }
}