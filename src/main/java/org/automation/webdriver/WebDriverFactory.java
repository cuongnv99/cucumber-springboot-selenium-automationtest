package org.automation.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class WebDriverFactory {
    public static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();
    private static final Random random = new Random();
    private static List<String> BROWSER_LIST;
    private static boolean randomizeBrowser;
    private static String defaultBrowser;
    public static final String CHROME = "chrome";
    public static final String COCCOC = "coccoc";
    public static final String EDGE = "MicrosoftEdge";
    public static final String FIREFOX = "firefox";
    public static final String SAFARI = "safari";


    public static WebDriver getDriver() {
        if (THREAD_LOCAL_DRIVER.get() != null) {
            return THREAD_LOCAL_DRIVER.get();
        } else {
            log.error("webdriver null =))");
            throw new RuntimeException("webdriver null =))");
        }
    }

    public static void cleanUpDriver() {
        WebDriverFactory.quitDriver();
        WebDriverFactory.removeDriver();
    }

    public static void quitDriver() {
        if (THREAD_LOCAL_DRIVER.get() != null) {
            THREAD_LOCAL_DRIVER.get().quit();
        }
    }

    public static void removeDriver() {
        if (THREAD_LOCAL_DRIVER.get() != null) {
            THREAD_LOCAL_DRIVER.remove();
        }
    }

    public static void createChromeDriver() {
        if (BROWSER_LIST.contains(CHROME)) {
            THREAD_LOCAL_DRIVER.set(createLocalChromeDriver());
        }  else {
            log.error("unknown type browser");
            throw new RuntimeException("unknown type browser");
        }
    }
    public static void createEdgeDriver() {
        if (BROWSER_LIST.contains(EDGE)) {
            THREAD_LOCAL_DRIVER.set(createLocalMSEdgeDriver());
        }  else {
            log.error("unknown type browser");
            throw new RuntimeException("unknown type browser");
        }
    }
    public static void createFirefoxDriver() {
        if (BROWSER_LIST.contains(FIREFOX)) {
            THREAD_LOCAL_DRIVER.set(createLocalFireFoxDriver());
        }  else {
            log.error("unknown type browser");
            throw new RuntimeException("unknown type browser");
        }
    }
//    public static void createCocCocDriver() {
//        if (BROWSER_LIST.contains(COCCOC)) {
//            THREAD_LOCAL_DRIVER.set(createLocalCocCocDriver());
//        }  else {
//            log.error("unknown type browser");
//            throw new RuntimeException("unknown type browser");
//        }
//    }

    public static WebDriver createLocalChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        setBasicDriverProperties(webDriver);
        return webDriver;
    }

    public static WebDriver createLocalMSEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriver webDriver = new EdgeDriver(edgeOptions);
        setBasicDriverProperties(webDriver);
        return webDriver;
    }

    public static WebDriver createLocalFireFoxDriver() {
        WebDriverManager.edgedriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver webDriver = new FirefoxDriver(firefoxOptions);
        setBasicDriverProperties(webDriver);
        return webDriver;
    }

//    public static WebDriver createLocalCocCocDriver() {
//        WebDriverManager.edgedriver().setup();
//        ChromeOptions cocCocOptions = new ChromeOptions();
//        cocCocOptions.setBinary("\"C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe\"");
//        WebDriver webDriver = new ChromeDriver(cocCocOptions);
//        setBasicDriverProperties(webDriver);
//        return webDriver;
//    }


    private static void setBasicDriverProperties(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    @Value("#{'${test.browser,list}'.split(',')}")
    public void setBrowserList(List<String> browserList) {
        BROWSER_LIST = browserList;
    }

    @Value("${test.browser.randomize}")
    public void setRandomizeBrowser(boolean randomizeBrowser) {
        WebDriverFactory.randomizeBrowser = randomizeBrowser;
    }

    @Value("${test.browser.default}")
    public void setDefaultBrowser(String defaultBrowser) {
        WebDriverFactory.defaultBrowser = defaultBrowser;
    }
}
