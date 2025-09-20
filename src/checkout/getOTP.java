package src.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Customer;

public class getOTP extends BaseTest_Customer {
    @Test
    public void otp() {
        /// Request OTP
        waitForClickable(By.xpath("//button[normalize-space()='Request OTP']"));
        waitForVisible(By.xpath("//*[contains(text(),'OTP/TAC:')]"));
        /// Get OTP
        WebElement otpTextElement = driver.findElement(By.xpath("//*[contains(text(),'OTP/TAC:')]"));
        waitForVisible(otpTextElement);
        String otpText = otpTextElement.getText();

        /// Get code
        String otpCode = otpText.split(":")[1].trim();

        /// Input OTP
        WebElement otpInput = driver.findElement(By.cssSelector("#otp-input"));
        otpInput.sendKeys(otpCode);

        /// Pay now
        WebElement pay = driver.findElement(By.xpath("//button[normalize-space()='Pay Now']"));
        pay.click();
        waitForVisible(By.cssSelector(".d-block"));

        /// Check status
        Assert.assertEquals(driver.findElement(By.cssSelector(".d-block")).getText(), "Payment Completed", "Payment Failed");
        Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Back To Order']")).isDisplayed(), "Button is visible");
    }
}
