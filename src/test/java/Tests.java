import browserConfiguration.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Tests extends BaseTest {


    @Test()
    void gatherLinksToTasksFromTheMainPage() {
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
    void classAttribute() {
        String alertMessage = "Primary button pressed";
        String alertMessageFromPage;
        ClassAttribute classAttribute = new ClassAttribute(page);
        classAttribute.navigateToClassAttributePage();
        alertMessageFromPage = classAttribute.pressTheButtonAndGetValueFromAlertWindow();

        assertThat(alertMessageFromPage).isEqualTo(alertMessage);
    }

    @Test
    void hiddenLayers() {
        boolean statusBefore = true;
        boolean statusAfter;
        HiddenLayers hiddenLayers = new HiddenLayers(page);
        hiddenLayers.navigateToClassAttributePage();
        statusAfter = hiddenLayers.pressTheGreenButton(statusBefore);
        hiddenLayers.pressTheGreenButton(statusAfter);

        assertThat(statusAfter).isFalse();
    }

    @Test
    void loadDelays_01() {
        String textExpected = "Button Appearing After Delay";
        String textFromTheButton;
        LoadDelay loadDelay = new LoadDelay(page);
        loadDelay.navigateToLoadDelayPage();
       textFromTheButton = loadDelay.checkThatButtonIsPresentedOnThePage();
        assertThat(textExpected).isEqualTo(textFromTheButton);
    }

    @Test
    void loadDelays_02() {
        String textExpected = "Button Appearing After Delay";
        String textFromTheButton;
        MainPage mainPage = new MainPage(page);
        LoadDelay loadDelay = new LoadDelay(page);
        mainPage.navigateToMainPage();
        mainPage.clickOnTheLinkToLoadDelayTask();
        textFromTheButton = loadDelay.checkThatButtonIsPresentedOnThePage();
        assertThat(textExpected).isEqualTo(textFromTheButton);
    }

}