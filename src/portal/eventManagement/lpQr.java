package src.portal.eventManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;

import static src.utils.ToggleReader.isToggleEnabled;

public class lpQr extends BaseTest_Portal {
    @Test
    public void lpQR() {
        if (isToggleEnabled("lpEvent")) {
            WebElement toggleA = driver.findElement(By.cssSelector("#create-event_isRewardLp"));
            if (!toggleA.isSelected()) {
                toggleA.click();
            }
        }
        if (isToggleEnabled("qr")) {
            WebElement toggleB = driver.findElement(By.cssSelector("#create-event_isQrcodeDynamic"));
            if (!toggleB.isSelected()) {
                toggleB.click();
            }
        }
    }
}
