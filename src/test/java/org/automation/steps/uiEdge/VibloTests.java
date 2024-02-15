package org.automation.steps.uiEdge;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.webdriver.WebDriverFactory;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VibloTests  extends WebDriverFactory {
    @When("I open page {string}")
    public void iOpenPage(String pageUrl) {
        getDriver().get(pageUrl);
    }

    @Then("I verify Viblo name {string}")
    public void iVerifyVibloName(String expectedChannelName) {
        String actualChannelName = getDriver().findElement(By.className("article-content__title")).getText();
        assertEquals(actualChannelName,expectedChannelName);
    }

}
