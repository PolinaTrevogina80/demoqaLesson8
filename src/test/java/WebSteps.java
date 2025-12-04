import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    private String repository;

    @Step("Open main page")
    public void openMainPage() {
        open("/");
    }

    @Step("Find repository")
    public void searchRepository(String repository) {
        this.repository = repository;
        $("[class='search-input']").click();
        $("[id='query-builder-test']").setValue(repository).pressEnter();
    }

    @Step("Open repository")
    public void goToRepository() {
        $(linkText(repository)).click();
    }

    @Step("Verify that Issues tab presents")
    public void shouldSeeIssues(String value) {
        $("#issues-tab").shouldHave(text(value));
    }

}