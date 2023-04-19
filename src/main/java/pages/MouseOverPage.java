package pages;

import com.microsoft.playwright.Page;

public class MouseOverPage {
    private final Page page;
    private final String clickMeHyperlink = "text=Click me";
    private final String clickCount = "#clickCount";

    public MouseOverPage(Page page) {
        this.page = page;
    }

    public void navigateToMouseOverPage() {
        page.navigate("http://uitestingplayground.com/mouseover");
    }

    public void clickTheLink() {
        page.locator(clickMeHyperlink).hover();
        page.locator(clickMeHyperlink).dblclick();
    }

    public String clickResult() {
        return page.locator(clickCount).textContent();
    }
}