package pages;

import com.microsoft.playwright.Page;

public class HiddenLayers {
    private final Page page;
    private final String greenButton = "#greenButton";

    public HiddenLayers(Page page) {
        this.page = page;
    }

    public void navigateToClassAttributePage() {
        page.navigate("http://uitestingplayground.com/hiddenlayers");
    }

    public boolean pressTheGreenButton(boolean status) {
        if(status){
            page.locator(greenButton).click();
        }
        return false;
    }

}
