package src.portal.a0_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.utils.ConfigManagement;

public class P4_EventManagement {
    WebDriver driver;
    public P4_EventManagement(WebDriver driver) {
        this.driver = driver;
    }
    public void eventManagement() {
        /// Config URL
        String baseUrl = ConfigManagement.geteventUrl();
        driver.get(baseUrl);
    }
}
