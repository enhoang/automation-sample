package src.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Customer;

public class backEvent extends BaseTest_Customer {
    @Test
    public void back() {
        WebElement backToOrder = driver.findElement(By.xpath("//button[normalize-space()='Back To Order']"));
        backToOrder.click();
        waitForVisible(By.xpath("//div[contains(text(),'Tickets Purchased')]"));

        /// Check status after back
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Tickets Purchased')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Your Tickets have been added to your Digital Assets. Please check in My Tickets.')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Go To My Tickets')]")).isDisplayed(), "Button is visible");
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'View More Events')]")).isDisplayed(), "Button is visible");
        getDefaultTimeout();
    }
}
