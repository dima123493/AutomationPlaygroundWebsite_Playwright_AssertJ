import browserConfiguration.BaseTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.TestMethodOrder;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainPageTest extends BaseTest {
    List<String> linksToTasks = new ArrayList<>();

    @Test()
    @Order(1)
    void gatherLinksToTasks() {
        int numberOfLinksToTasksShouldBe = 18;
        MainPage mainPage = new MainPage(page);
        mainPage.navigateToMainPage();
        mainPage.collectLinksToTaskPages(linksToTasks);

        assertThat(linksToTasks).hasSize(numberOfLinksToTasksShouldBe);
    }

}