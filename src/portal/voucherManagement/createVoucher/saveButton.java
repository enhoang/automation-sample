package src.portal.voucherManagement.createVoucher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;

public class saveButton extends BaseTest_Portal {
    @Test
    public void saveBtn() {
        waitForClickable(By.xpath("//span[normalize-space()='Create']"));

        /// Confirm create voucher
        waitForVisible(By.xpath("//div[contains(text(),'Confirm to create voucher')]"));
        waitForClickable(By.xpath("//span[normalize-space()='Proceed']"));

        /// Check status
        By msgLocator = By.cssSelector("div.ant-message-notice-content");
        WebElement messageEl = wait.until(ExpectedConditions.visibilityOfElementLocated(msgLocator));
        String msg = messageEl.getAttribute("textContent").trim();
        if (msg.contains("successfully")) {
            System.out.println("Success: " + msg);
        } else {
            System.out.println("Error: " + msg);
            Assert.fail("Error message displayed: " + msg);
        }
    }
}
