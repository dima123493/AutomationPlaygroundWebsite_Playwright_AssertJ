package pages;

import com.microsoft.playwright.Page;

public class DynamicIdPage {
    private final Page page;
    private final String button = "//button[@type=\"button\" and @id]";

    public DynamicIdPage(Page page) {
        this.page = page;
    }

    public void navigateToDynamicIdPage() {
        page.navigate("http://uitestingplayground.com/dynamicid");
    }

    public String findButtonId() {
        return page.locator(button).getAttribute("id");
    }

    public void pressTheButton() {
        page.locator(button).click();
    }

    public void reloadThePage() {
        page.reload();
    }
}
