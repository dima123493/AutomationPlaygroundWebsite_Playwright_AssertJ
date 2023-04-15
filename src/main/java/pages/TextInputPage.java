package pages;

import com.microsoft.playwright.Page;

public class TextInputPage {
    private final Page page;
    private final String inputField = "#newButtonName";
    private final String buttonWithNewText = "#updatingButton";

    public TextInputPage(Page page) {
        this.page = page;
    }

    public void navigateToInputPage() {
        page.navigate("http://uitestingplayground.com/textinput");
    }

    public void inputDataIntoField(String fieldInput) {
        page.locator(inputField).hover();
        page.mouse().down();
        page.mouse().up();
        page.keyboard().insertText(fieldInput);
    }

    public String getDataAfterClick() {
        page.locator(buttonWithNewText).click();
        return page.locator(buttonWithNewText).textContent();
    }
}