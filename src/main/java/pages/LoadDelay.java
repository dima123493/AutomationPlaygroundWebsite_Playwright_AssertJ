package pages;

import com.microsoft.playwright.Page;

public class LoadDelay {
    private final Page page;
    private final String afterLoadButton = "//button[normalize-space()='Button Appearing After Delay']";
    public LoadDelay(Page page) {
        this.page = page;
    }

    public void navigateToLoadDelayPage() {
        page.navigate("http://uitestingplayground.com/loaddelay");
    }

    public String checkThatButtonIsPresentedOnThePage() {
        page.locator(afterLoadButton).waitFor();
       return page.locator(afterLoadButton).textContent();
    }
}
