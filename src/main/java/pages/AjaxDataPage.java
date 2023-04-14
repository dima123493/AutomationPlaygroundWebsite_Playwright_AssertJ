package pages;

import com.microsoft.playwright.Page;

public class AjaxDataPage {
    private final Page page;
    private final String button = "#ajaxButton";
    private final String loadedDataAfterAjax = ".bg-success";

    public AjaxDataPage(Page page) {
        this.page = page;
    }

    public void navigateToAjaxPage() {
        page.navigate("http://uitestingplayground.com/ajax");
    }

    public void pressTheButton() {
        page.locator(button).click();
    }

    public String getDataAfterAjax() {
        page.locator(loadedDataAfterAjax).waitFor();
        return page.locator(loadedDataAfterAjax).textContent();
    }

}