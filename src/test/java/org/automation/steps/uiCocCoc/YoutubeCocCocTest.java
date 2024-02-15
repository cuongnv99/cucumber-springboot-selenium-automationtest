package org.automation.steps.uiCocCoc;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.webdriver.WebDriverFactory;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YoutubeCocCocTest extends WebDriverFactory {

    @When("I go to page on coccoc {string}")
    public void iGoToPageOnCoccoc(String pageUrl) {
        getDriver().get(pageUrl);
    }

    @Then("I verify YouTube channel name on coccoc {string}")
    public void iVerifyYouTubeChannelNameOnCoccoc(String expectedChannelName) {
        String actualChannelName = getDriver().findElement(By.id("channel-name")).getText();

        assertEquals(actualChannelName,expectedChannelName);
    }
}
