import browserConfiguration.BaseTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import pages.ClassAttribute;
import pages.DynamicIdPage;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

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
        ClassAttribute classAttribute = new ClassAttribute(page);
        classAttribute.navigateToClassAttributePage();
        classAttribute.pressTheButton();
    }

}