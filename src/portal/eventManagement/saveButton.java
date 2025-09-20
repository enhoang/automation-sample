package src.portal.eventManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;

import java.time.Duration;

public class saveButton extends BaseTest_Portal {
    @Test
    public void savebtn() {
        WebElement save = driver.findElement(By.xpath("//span[normalize-space()='Save & Publish']"));
        save.click();

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
