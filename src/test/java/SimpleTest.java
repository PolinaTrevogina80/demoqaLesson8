
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SimpleTest extends TestBase{

    @Test
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/");

        $("[class='search-input']").click();
        $("[id='query-builder-test']").sendKeys(REPOSITORY);
        $("[id='query-builder-test']").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("No results")).should(Condition.exist);
    }

}