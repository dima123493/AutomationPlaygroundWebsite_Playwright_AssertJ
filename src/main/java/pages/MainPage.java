package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class MainPage {
    private final Page page;
    private final String listOfLinksToTaskPages = "//*[@id=\"overview\"]/div/div//a";
    private final String linkToLoadDelayTask = "//a[normalize-space()='Load Delay']";

    public MainPage(Page page) {
        this.page = page;
    }

    public void navigateToMainPage() {
        page.navigate("http://uitestingplayground.com/home");
    }

    public void collectLinksToTaskPages(List<String> all) {
        Locator links = page.locator(listOfLinksToTaskPages);
        int linksNumber = links.count();
        for (int i = 0; i < linksNumber; i++) {
            all.add(links.nth(i).getAttribute("href"));
        }
    }

    public void clickOnTheLinkToLoadDelayTask() {
        page.locator(linkToLoadDelayTask).click();
    }

}