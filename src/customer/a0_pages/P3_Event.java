package src.customer.a0_pages;

import org.openqa.selenium.WebDriver;
import src.base.BaseTest_Customer;
import src.utils.ConfigManagement;

public class P3_Event extends BaseTest_Customer {
    WebDriver driver;
    public P3_Event(WebDriver driver) {
        this.driver = driver;
    }
    public void event() {
        /// Config URL
        String baseUrl = ConfigManagement.getemkpUrl();
        driver.get(baseUrl);
    }
}
