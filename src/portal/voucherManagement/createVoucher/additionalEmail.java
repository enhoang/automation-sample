package src.portal.voucherManagement.createVoucher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;

import static src.utils.ToggleReader.isToggleEnabled;

public class additionalEmail extends BaseTest_Portal {
    @Test
    public void additional() {
        if (isToggleEnabled("additionalEmail")) {
            WebElement toggleA = driver.findElement(By.id("hasAdditionalEmails"));
            if (!toggleA.isSelected()) {
                toggleA.click();
                WebElement mailInput = driver.findElement(By.cssSelector("#additionalEmails_0"));
                mailInput.sendKeys("autotestmail01@yopmail.com");
            }
        }
    }
}
