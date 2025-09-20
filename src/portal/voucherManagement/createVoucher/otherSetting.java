package src.portal.voucherManagement.createVoucher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;

import static src.utils.ToggleReader.isToggleEnabled;

public class otherSetting extends BaseTest_Portal {
    @Test
    public void other() {
        /// Show the Voucher
        if (isToggleEnabled("showVoucher")) {
            WebElement toggleA = driver.findElement(By.cssSelector("#isMarketplace"));
            if (!toggleA.isSelected()) {
                toggleA.click();
            }
        }

        /// Auto remove
        if (isToggleEnabled("autoRemove")) {
            WebElement toggleB = driver.findElement(By.cssSelector("#isRemovedAfterExpired"));
            if (!toggleB.isSelected()) {
                toggleB.click();
            }
        }

        /// Trident GO
        if (isToggleEnabled("Trigo")) {
            WebElement toggleC = driver.findElement(By.cssSelector("#isTridentityGo"));
            if (!toggleC.isSelected()) {
                toggleC.click();
            }
        }
    }
}
