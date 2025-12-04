import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends TestBase {
    @Test
    void issueTabWithLambdaTest() {

        step("Open main page", () -> {
            open("/");
        });

        step("Find repository " + REPOSITORY, () -> {
            $("[class='search-input']").click();
            $("[id='query-builder-test']").setValue(REPOSITORY).pressEnter();
        });

        step("Open repository", () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Verify that Issues tab presents", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });
    }
}