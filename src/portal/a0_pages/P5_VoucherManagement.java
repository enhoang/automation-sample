package src.portal.a0_pages;

import org.openqa.selenium.WebDriver;
import src.base.BaseTest_Customer;
import src.utils.ConfigManagement;

public class P5_VoucherManagement extends BaseTest_Customer {
    WebDriver driver;
    public P5_VoucherManagement(WebDriver driver) {
        this.driver = driver;
    }
    public void vouchermanagement() {
        /// Config URL
        String baseUrl = ConfigManagement.getvoucherUrl();
        driver.get(baseUrl);
        getDefaultTimeout();
    }
}
