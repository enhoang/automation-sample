package src.portal.voucherManagement.createVoucher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;

import static src.utils.ToggleReader.isToggleEnabled;

public class lp_terms extends BaseTest_Portal {
    @Test
    public void lp() {
        /// LP Award
        if (isToggleEnabled("lp")) {
            WebElement toggleA = driver.findElement(By.cssSelector("#isRewardLp"));
            if (!toggleA.isSelected()) {
                toggleA.click();
            }
        }

        /// Terms
        if (isToggleEnabled("term")) {
            WebElement toggleB = driver.findElement(By.id("hasTerms"));
            if (!toggleB.isSelected()) {
                toggleB.click();
                WebElement termsInput = driver.findElement(By.xpath("//div[@data-placeholder='Enter Terms & Conditions']//p"));
                termsInput.sendKeys("These are the Terms & Conditions. Follow it!");
            }
        }
    }
}
