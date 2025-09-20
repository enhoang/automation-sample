package src.base;

import org.openqa.selenium.*;
import src.utils.ConfigManagement;


public class BaseTest_Portal extends baseTest {
    /// Config URL
    public void open() {
        String baseUrl = ConfigManagement.getUrl();
        driver.get(baseUrl);
    }

    @Override
    protected long getDefaultTimeout() {
        // e.g. 20 seconds for potentially heavier portal pages
        return Long.parseLong(System.getProperty("wait.timeout.portal", "20"));
    }

    /// Check timezone
    public void checktimezone() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return new Date().getTimezoneOffset();";
        Long offsetInMinutes = (Long) js.executeScript(script);
        int offsetInHours = (int) (-offsetInMinutes / 60);
        System.out.println("GMT offset: GMT" + (offsetInHours >= 0 ? "+" : "") + offsetInHours);
    }
}

