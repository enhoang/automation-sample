package src.customer.addEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Customer;

public class cartEvent extends BaseTest_Customer {
    @Test
    public void testCart() {
        /// Open Cart
        waitForClickable(By.xpath("//*[@id=\"cartFooterDesktop\"]/button[1]/div[1]"));
        waitForVisible(By.xpath("//button[@type='submit' an contains(text(), 'Checkout')]"));
    }
}
