package org.automation.steps.uiChrome;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.webdriver.WebDriverFactory;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VibloTestChrome extends WebDriverFactory  {
    @When("I open page on chrome {string}")
    public void iOpenPageOnChrome(String pageUrl) {
        getDriver().get(pageUrl);
    }

    @Then("I verify Viblo name on chrome {string}")
    public void iVerifyVibloNameOnChrome(String expectedChannelName) {
        String actualChannelName = getDriver().findElement(By.className("article-content__title")).getText();
        assertEquals(actualChannelName,expectedChannelName);
    }
}
