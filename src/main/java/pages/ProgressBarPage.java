package pages;

import com.microsoft.playwright.Page;

public class ProgressBarPage {
    private final Page page;
    private final String startButton = "#startButton";
    private final String stopButton = "#stopButton";
    private final String barField = "#progressBar";

    public ProgressBarPage(Page page) {
        this.page = page;
    }

    public void navigateToProgressBarPage() {
        page.navigate("http://uitestingplayground.com/progressbar");
    }

    public String loadingCheck(int progressShouldBeStoppedAt) {
        page.locator(startButton).click();
        String expectedLoadBreak = String.format("//*[@aria-valuenow=%d]",progressShouldBeStoppedAt);
        page.waitForSelector(expectedLoadBreak);

        page.locator(stopButton).click();
        return page.locator(barField).textContent();
    }
}