package org.automation.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.automation.webdriver.WebDriverFactory;

public class CucumberEdgeHooks {

    @Before("@uiEdge")
    public void beforeEach(){
        WebDriverFactory.createEdgeDriver();
    }
    @After("@uiEdge")
    public void afterEach(){
        WebDriverFactory.cleanUpDriver();
    }

}
