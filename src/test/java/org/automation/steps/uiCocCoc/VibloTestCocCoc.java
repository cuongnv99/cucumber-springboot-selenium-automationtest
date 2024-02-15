package org.automation.steps.uiCocCoc;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.webdriver.WebDriverFactory;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VibloTestCocCoc extends WebDriverFactory  {
    @When("I open page on coccoc {string}")
    public void iOpenPageOnCocCoc(String pageUrl) {
        getDriver().get(pageUrl);
    }

    @Then("I verify Viblo name on coccoc {string}")
    public void iVerifyVibloNameOnCocCoc(String expectedChannelName) {
        String actualChannelName = getDriver().findElement(By.className("article-content__title")).getText();
        assertEquals(actualChannelName,expectedChannelName);
    }
}
