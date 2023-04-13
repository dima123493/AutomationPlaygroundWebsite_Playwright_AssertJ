package pages;

import com.microsoft.playwright.Page;

public class ClassAttribute {
    private final Page page;
    private final String button = "//button[contains(@class,'btn-primary')]";

    public ClassAttribute(Page page) {
        this.page = page;
    }

    public void navigateToClassAttributePage() {
        page.navigate("http://uitestingplayground.com/classattr");
    }

    public void pressTheButton() {
        page.locator(button).click();
    }

}
