package org.automation.steps.uiEdge;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.webdriver.WebDriverFactory;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YouTubeTests extends WebDriverFactory {
    @When("I go to page {string}")
    public void iGoToPage(String pageUrl) {
        getDriver().get(pageUrl);
    }

    @Then("I verify YouTube channel name {string}")
    public void iVerifyYouTubeChannelName(String expectedChannelName) {
        String actualChannelName = getDriver().findElement(By.id("channel-name")).getText();

        assertEquals(actualChannelName,expectedChannelName);
    }

}
