package pages;

import com.microsoft.playwright.Page;

public class VisibilityPage {
    private final Page page;
    private final String hideButton = "#hideButton";
    private final String capacity0Button = "#transparentButton";
    private final String removedButton = "#removedButton";
    private final String invisibilityHiddenButton = "#invisibleButton";
    private final String zeroWidthButton = "#zeroWidthButton";
    private final String displayNoneButton = "#notdisplayedButton";
    private final String overlappedButton = "#overlappedButton";
    private final String offscreenButton = "#offscreenButton";

    public VisibilityPage(Page page) {
        this.page = page;
    }

    public void navigateToVisibility() {
        page.navigate("http://uitestingplayground.com/visibility");
    }

    public void clickTheHideButton() {
        page.locator(hideButton).click();
    }

    public boolean visibilityCapacity0Button() {
        return page.locator(capacity0Button).isVisible();
    }

    public boolean visibilityRemovedButtonButton() {
        return page.locator(removedButton).isVisible();
    }

    public boolean visibilityInvisibilityHiddenButtonButton() {
        return page.locator(invisibilityHiddenButton).isVisible();
    }

    public boolean visibilityZeroWidthButtonButton() {
        return page.locator(zeroWidthButton).isVisible();
    }

    public boolean visibilityDisplayNoneButtonButton() {
        return page.locator(displayNoneButton).isVisible();
    }

    public boolean visibilityOverlappedButtonButton() {
        return page.locator(overlappedButton).isVisible();
    }

    public boolean visibilityOffscreenButtonButton() {
        return page.locator(offscreenButton).isVisible();
    }
}
