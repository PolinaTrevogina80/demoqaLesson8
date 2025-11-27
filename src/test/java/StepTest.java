import org.junit.jupiter.api.Test;


public class StepTest extends TestBase{

    private static final String ISSUES = "Issues";

    @Test
    void issueTabWithStepsTest() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.goToRepository();
        steps.shouldSeeIssues(ISSUES);
    }
}


