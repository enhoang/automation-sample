package src.portal.voucherManagement.createVoucher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.portal.a0_pages.P5_VoucherManagement;

public class buttonCreateVoucher extends BaseTest_Portal {
    @Test
    public void btnCreateEvent() {
        /// Open Events page
        P5_VoucherManagement voucherMgn = new P5_VoucherManagement(driver);
        voucherMgn.vouchermanagement();

        /// Click button Create Event
        waitForClickable(By.xpath("//span[normalize-space()='Create Voucher']"));
        Assert.assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='Create Voucher']")).getText(),"Create Voucher");
    }
}
