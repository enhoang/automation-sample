package src.portal.eventManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.ConfigManagement;

public class assigned extends BaseTest_Portal {
    @Test
    public void assignedMer() {
        /// Assigned Merchant
        WebElement merchant = driver.findElement(By.cssSelector("#create-event_organizer"));
        merchant.click();
        /// Select merchant
        String merchantName = ConfigManagement.getMerchantText();
        merchant.sendKeys(merchantName);
        waitForClickable(By.xpath("//div[@class='ant-select-item-option-content']"));
    }
}