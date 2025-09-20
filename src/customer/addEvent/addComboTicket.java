package src.customer.addEvent;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Customer;
import src.utils.JsonDataReader;

import java.time.Duration;
import java.util.List;

public class addComboTicket extends BaseTest_Customer {
@Test
    public void addComboTicket1() {
    /// Add combo ticket
    waitForClickable(By.cssSelector(".MuiBox-root.css-vcwcdy"));

    String filePath = "src/datafile/portal/date&time.json";
    List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
    for (JSONObject data : testDataList) {
        String slot1Start = (String) data.get("slot1start");
        String slot1End = (String) data.get("slot1end");
        String slotTime = slot1Start + " - " + slot1End;

        /// Select date combo 1
        WebElement container1 = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
        WebElement dateElement1 = driver.findElement(By.xpath("//*[text()='Sat, Aug 30th 2025']"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", container1, dateElement1);
        waitForClickable(By.cssSelector("div[id='2025-08-30'] div[class='MuiBox-root css-u78wi']"));

        /// Select time combo 1
        waitForClickable(By.xpath("//div[contains(text(),'" + slotTime + "')]"));
        waitForClickable(By.cssSelector("span[role='button']"));

        /// Add date combo 2
        WebElement container2 = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
        WebElement dateElement2 = driver.findElement(By.xpath("//*[text()='Fri, Aug 29th 2025']"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", container2, dateElement2);
        waitForClickable(By.cssSelector("div[id='2025-08-29'] div[class='MuiBox-root css-u78wi']"));

        /// Select time combo 2
        String slot2Start = (String) data.get("slot2start");
        String slot2End = (String) data.get("slot2end");
        String slotTime2 = slot2Start + " - " + slot2End;

        waitForClickable(By.xpath("//div[contains(text(),'" + slotTime2 + "')]"));
        waitForClickable(By.cssSelector(".MuiBox-root.css-vcwcdy"));

        /// Add quantity
        waitForClickable(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > span:nth-child(2) > div:nth-child(1) > button:nth-child(3)"));
    }

    /// Add to cart
    waitForClickable(By.xpath("//span[@role='button' and contains(., 'Add to Cart')]"));
    WebElement successMessage = driver.findElement(By.cssSelector("div[role='alert']"));
    waitForVisible(successMessage);
    Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed!");
    Assert.assertEquals(successMessage.getText(), "Add Combo successfully!!", "Wrong message!");
    }
}
