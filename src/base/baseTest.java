package src.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import src.utils.ConfigManagement;

import java.time.Duration;

public abstract class baseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"env", "browser", "ui.enabled", "wait.timeout"})
    public void setupSuite(String env, String browser, String uiEnabled, String timeout) {
        // Load environment and browser from config or system properties
        ConfigManagement.loadEnv(env);

        // Switch browser
        boolean headless = !Boolean.parseBoolean(System.getProperty("ui.enabled", "false"));
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                if (headless) {
                    ffOptions.addArguments("-headless");
                }
                driver = new FirefoxDriver(ffOptions);
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless", "--disable-gpu");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(getDefaultTimeout()));

    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    /// Allow tests to disable UI (headless) via system property
    protected boolean isUIEnabled() {
        return Boolean.parseBoolean(System.getProperty("ui.enabled", "true"));
    }

    /// Default explicit wait timeout, can be overridden by subclasses
    protected long getDefaultTimeout() {
        return Long.parseLong(System.getProperty("wait.timeout", "3"));
    }

    /// Type text and press ENTER
    protected void sendKeysWithEnter(org.openqa.selenium.By locator, String text) {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(locator));
        org.openqa.selenium.WebElement el = driver.findElement(locator);
        el.sendKeys(text, org.openqa.selenium.Keys.ENTER);
    }

    /// Wait until the element is visible on the page
    protected void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    /// Wait until the element is clickable, then return it
    protected void waitForClickable(By locator) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }
    protected void waitForClickable(WebElement element) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        el.click();
    }
}
