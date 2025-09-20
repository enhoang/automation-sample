package src.base;

import org.openqa.selenium.JavascriptExecutor;
import src.utils.ConfigManagement;

public class BaseTest_Customer extends baseTest {
    /// Config URL
    public void open() {
        String baseUrl = ConfigManagement.getHomeUrl();
        driver.get(baseUrl);
    }


    @Override
    protected long getDefaultTimeout() {
        // e.g. 15 seconds instead of the framework default
        return Long.parseLong(System.getProperty("wait.timeout.customer", "15"));
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
