package src.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import src.base.BaseTest_Customer;

import java.time.Duration;

public class buy extends BaseTest_Customer {
    @Test
    public void checkout() {
        waitForClickable(By.xpath("//button[@type='submit' and contains(text(), 'Checkout')]"));
        waitForClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/button"));
    }
}
