package src.customer.addVoucher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Customer;

public class cartVoucher extends BaseTest_Customer {
    @Test
    public void testCart() {
        /// Open Cart
        WebElement cart = driver.findElement(By.xpath("//div[@id='cartFooterDesktop']//button[1]"));
        waitForVisible(cart);
        cart.click();
        waitForVisible(By.xpath("//div[contains(text(),'Vouchers')]"));
        WebElement btn = driver.findElement(By.xpath("//div[contains(text(),'Vouchers')]"));
        btn.click();
    }
}
