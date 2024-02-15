package org.automation.steps.uiChrome;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.webdriver.WebDriverFactory;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YoutubeChromeTest extends WebDriverFactory {
    @When("I go to page on chrome {string}")
    public void iGoToPageOnChrome(String pageUrl) {
        getDriver().get(pageUrl);

    }

    @Then("I verify YouTube channel name onchrome {string}")
    public void iVerifyYouTubeChannelNameOnchrome(String expectedChannelName) {
        String actualChannelName = getDriver().findElement(By.id("channel-name")).getText();

        assertEquals(actualChannelName,expectedChannelName);
    }
}
