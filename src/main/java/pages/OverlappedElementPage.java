package pages;

import com.microsoft.playwright.Page;

public class OverlappedElementPage {
    private final Page page;
    private final String idField = "#id";
    private final String nameField = "#name";

    public OverlappedElementPage(Page page) {
        this.page = page;
    }

    public void navigateToOverlappedElementPage() {
        page.navigate("http://uitestingplayground.com/overlapped");
    }

    public void inputValuesIntoFields(String idValue, String nameValue) {
        page.locator(idField).fill(idValue);
        page.locator(nameField).scrollIntoViewIfNeeded();
        page.locator(nameField).fill(nameValue);
    }

}
