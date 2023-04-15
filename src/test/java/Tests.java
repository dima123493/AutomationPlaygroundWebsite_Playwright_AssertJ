import browserConfiguration.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Tests extends BaseTest {

    @Test()
    void gatherLinksToTasksFromTheMainPageTest() {
        List<String> linksToTasks = new ArrayList<>();
        int numberOfLinksToTasksShouldBe = 18;
        MainPage mainPage = new MainPage(page);
        mainPage.navigateToMainPage();
        mainPage.collectLinksToTaskPages(linksToTasks);

        assertThat(linksToTasks).hasSize(numberOfLinksToTasksShouldBe);
    }

    @Test
    void dynamicIDTest() {
        DynamicIdPage dynamicIdPage = new DynamicIdPage(page);
        dynamicIdPage.navigateToDynamicIdPage();
        String idBeforeReload = dynamicIdPage.findButtonId();
        dynamicIdPage.pressTheButton();
        dynamicIdPage.reloadThePage();
        String idAfterReload = dynamicIdPage.findButtonId();
        dynamicIdPage.pressTheButton();

        assertThat(idBeforeReload).isNotEqualTo(idAfterReload);
    }

    @Test
    void classAttributeTest() {
        String alertMessage = "Primary button pressed";
        String alertMessageFromPage;
        ClassAttributePage classAttribute = new ClassAttributePage(page);
        classAttribute.navigateToClassAttributePage();
        alertMessageFromPage = classAttribute.pressTheButtonAndGetValueFromAlertWindow();

        assertThat(alertMessageFromPage).isEqualTo(alertMessage);
    }

    @Test
    void hiddenLayersTest() {
        boolean statusBefore = true;
        boolean statusAfter;
        HiddenLayersPage hiddenLayers = new HiddenLayersPage(page);
        hiddenLayers.navigateToClassAttributePage();
        statusAfter = hiddenLayers.pressTheGreenButton(statusBefore);
        hiddenLayers.pressTheGreenButton(statusAfter);

        assertThat(statusAfter).isFalse();
    }

    @Test
    void loadDelaysTest01() {
        String textExpected = "Button Appearing After Delay";
        String textFromTheButton;
        LoadDelayPage loadDelay = new LoadDelayPage(page);
        loadDelay.navigateToLoadDelayPage();
        textFromTheButton = loadDelay.checkThatButtonIsPresentedOnThePage();
        assertThat(textExpected).isEqualTo(textFromTheButton);
    }

    @Test
    void loadDelaysTest02() {
        String textExpected = "Button Appearing After Delay";
        String textFromTheButton;
        MainPage mainPage = new MainPage(page);
        LoadDelayPage loadDelay = new LoadDelayPage(page);
        mainPage.navigateToMainPage();
        mainPage.clickOnTheLinkToLoadDelayTask();
        textFromTheButton = loadDelay.checkThatButtonIsPresentedOnThePage();
        assertThat(textExpected).isEqualTo(textFromTheButton);
    }

    @Test
    void ajaxDataTest() {
        String textExpected = "Data loaded with AJAX get request.";
        String textAfterAjax;
        AjaxDataPage ajaData = new AjaxDataPage(page);
        ajaData.navigateToAjaxPage();
        ajaData.pressTheButton();
        textAfterAjax = ajaData.getDataAfterAjax();
        assertThat(textExpected).isEqualTo(textAfterAjax);
    }

    @Test
    void clientSideDelayTest() {
        String textExpected = "Data calculated on the client side.";
        String textAfterDelay;
        ClientSideDelayPage clientSideDelay = new ClientSideDelayPage(page);
        clientSideDelay.navigateToAjaxPage();
        clientSideDelay.pressTheButton();
        textAfterDelay = clientSideDelay.getDataAfterDelay();
        assertThat(textExpected).isEqualTo(textAfterDelay);
    }

    @Test
    void clickTest() {
        String textExpected = "btn btn-success";
        String textAfterClick;
        ClickPage clickPage = new ClickPage(page);
        clickPage.navigateToClickPage();
        clickPage.pressTheButtonPhysically();
        textAfterClick = clickPage.getDataAfterClick();
        assertThat(textExpected).isEqualTo(textAfterClick);
    }

    @Test
    void textInputTest() {
        String textExpected = "New button value";
        String buttonTextAfterClick;
        TextInputPage textInput = new TextInputPage(page);
        textInput.navigateToInputPage();
        textInput.inputDataIntoField(textExpected);
        buttonTextAfterClick = textInput.getDataAfterClick();
        assertThat(textExpected).isEqualTo(buttonTextAfterClick);
    }

    @Test
    void scrollbarsTest() {
        String buttonNameShouldBe = "Hiding Button";
        String buttonNameFromPage;
        ScrollbarPage scrollbar = new ScrollbarPage(page);
        scrollbar.navigateToScrollbarPage();
        scrollbar.locateToElement();
        buttonNameFromPage = scrollbar.clickTheHidingButton();

        assertThat(buttonNameShouldBe).isEqualTo(buttonNameFromPage);
    }

    @Test
    void dynamicTableTest() {
        String propertyName = "CPU";
        String browserName = "Chrome";
        String cellResult;
        String textOnThePage;
        DynamicTablePage dynamicTable = new DynamicTablePage(page);
        dynamicTable.navigateToDynamicTablePage();
        cellResult = dynamicTable.findElementInTheTable(propertyName, browserName);
        textOnThePage = dynamicTable.findElementOnThePage();
        assertThat(browserName + " " + propertyName + ": " + cellResult).isEqualTo(textOnThePage);
    }

    @Test
    void verifyTextTest() {
        String welcomeMessage = "Welcome UserName!";
        String textOnThePage;
        VerifyTextPage verifyText = new VerifyTextPage(page);
        verifyText.navigateToVerifyTextPage();
        textOnThePage = verifyText.findElementOnThePage();
        assertThat(textOnThePage).isEqualTo(welcomeMessage);
    }

    @Test
    void progressBarTest() {
        int progressShouldBeStoppedAt = 75;
        String barResult;
        ProgressBarPage progressBar = new ProgressBarPage(page);
        progressBar.navigateToProgressBarPage();
        barResult = progressBar.loadingCheck(progressShouldBeStoppedAt);
        int convertedValueFromProgressBar = Integer.parseInt(barResult.replaceAll("\\D+", ""));

        assertThat(progressShouldBeStoppedAt).isEqualTo(convertedValueFromProgressBar);
    }
}