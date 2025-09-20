package src.customer.a0_pages;

import org.openqa.selenium.WebDriver;
import src.base.BaseTest_Customer;
import src.utils.ConfigManagement;

public class P2_Voucher extends BaseTest_Customer {
    WebDriver driver;
    public P2_Voucher(WebDriver driver) {
        this.driver = driver;
    }
    public void voucher() {
        /// Config URL
        String baseUrl = ConfigManagement.getvmkpUrl();
        driver.get(baseUrl);
    }
}
