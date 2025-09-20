package src.customer.a0_pages;

import org.openqa.selenium.WebDriver;
import src.base.BaseTest_Customer;
import src.utils.ConfigManagement;

public class P1_HomePage extends BaseTest_Customer {
    WebDriver driver;

    public P1_HomePage(WebDriver driver) {
        this.driver = driver;
        /// Config URL
        String baseUrl = ConfigManagement.getUrl();
        driver.get(baseUrl);
    }
}
