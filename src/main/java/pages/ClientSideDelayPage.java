package pages;

import com.microsoft.playwright.Page;

public class ClientSideDelayPage {
    private final Page page;
    private final String button = "#ajaxButton";
    private final String loadedDataAfterDelay = ".bg-success";

    public ClientSideDelayPage(Page page) {
        this.page = page;
    }

    public void navigateToAjaxPage() {
        page.navigate("http://uitestingplayground.com/clientdelay");
    }

    public void pressTheButton() {
        page.locator(button).click();
    }

    public String getDataAfterDelay() {
        page.locator(loadedDataAfterDelay).waitFor();
        return page.locator(loadedDataAfterDelay).textContent();
    }
}