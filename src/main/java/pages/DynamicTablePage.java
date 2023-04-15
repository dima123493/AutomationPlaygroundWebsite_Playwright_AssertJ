package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DynamicTablePage {
    private final Page page;
    private final String requestedValueToBeFound = ".bg-warning";
    private final String tableRow = "//section//div[3]/div";
    private final String tableColumn = "//div[2]/div/span";

    public DynamicTablePage(Page page) {
        this.page = page;
    }

    public void navigateToDynamicTablePage() {
        page.navigate("http://uitestingplayground.com/dynamictable");
    }

    public String findElementInTheTable(String property, String browserName) {

        Locator tableRows = page.locator(tableRow);
        Locator headerRow = page.locator(tableColumn);

        int rowsTotalNumber = tableRows.count();
        int columnsTotalNumber = headerRow.count();

        int ixCPU = 0;
        for (int i = 0; i < columnsTotalNumber; i++) {
            if (headerRow.nth(i).textContent().equals(property)) {
                ixCPU = i;
                break;
            }
        }

        String chromeCpu = "";
        for (int j = 0; j < rowsTotalNumber; j++) {
            var row = tableRows.nth(j);
            if (row.nth(0).textContent().contains(browserName)) {
                chromeCpu = row.getByRole(AriaRole.CELL).nth(ixCPU).textContent();
                break;
            }
        }

        return chromeCpu;
    }

    public String findElementOnThePage() {
        return page.locator(requestedValueToBeFound).textContent();
    }

}