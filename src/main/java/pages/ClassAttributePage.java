package pages;

import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class ClassAttributePage {
    private final Page page;
    private final String button = "//button[contains(@class,'btn-primary')]";

    public ClassAttributePage(Page page) {
        this.page = page;
    }

    public void navigateToClassAttributePage() {
        page.navigate("http://uitestingplayground.com/classattr");
    }

    public String pressTheButtonAndGetValueFromAlertWindow() {
        List<String> alertMessage = new ArrayList<>();
        page.onDialog(dialog -> {
            alertMessage.add(dialog.message());
            dialog.accept();
        });
        page.locator(button).click();
        return alertMessage.get(0);
    }

}