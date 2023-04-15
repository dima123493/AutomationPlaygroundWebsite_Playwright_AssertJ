package pages;

import com.microsoft.playwright.Page;

public class HiddenLayersPage {
    private final Page page;
    private final String greenButton = "#greenButton";

    public HiddenLayersPage(Page page) {
        this.page = page;
    }

    public void navigateToClassAttributePage() {
        page.navigate("http://uitestingplayground.com/hiddenlayers");
    }

    public boolean pressTheGreenButton(boolean status) {
        if (status) {
            page.locator(greenButton).click();
        }
        return false;
    }

}