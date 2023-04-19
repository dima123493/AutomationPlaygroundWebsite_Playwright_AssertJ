package pages;

import com.microsoft.playwright.Page;

public class SampleAppPage {
    private final Page page;
    private final String userNameField = "//input[@name='UserName']";
    private final String passwordField = "//input[@name='Password']";
    private final String loginButton = "#login";
    private final String passwordValue = "pwd";
    private final String successfulLogin = "#loginstatus";

    public SampleAppPage(Page page) {
        this.page = page;
    }

    public void navigateToSampleApp() {
        page.navigate("http://uitestingplayground.com/sampleapp");
    }

    public void login(String username) {
        page.locator(userNameField).fill(username);
        page.locator(passwordField).fill(passwordValue);
        page.locator(loginButton).click();
    }

    public String loginResult() {
       return page.locator(successfulLogin).textContent();
    }

}