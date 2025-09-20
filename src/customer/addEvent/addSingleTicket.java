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

public class addSingleTicket extends BaseTest_Customer {
@Test
    public void addTicket1() {
    /// Add ticket
    ///Step 1
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    WebElement step1title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiBox-root.css-hpfhri")));
    Assert.assertTrue(step1title.isDisplayed(), "Step 1 is not displayed!");

    String filePath = "src/datafile/portal/date&time.json";
    List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
    for (JSONObject data : testDataList) {
        WebElement container = driver.findElement(By.cssSelector("div[name='date']"));
        WebElement dateElement = driver.findElement(By.xpath("//*[text()='Sun, Aug 31st 2025']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", container, dateElement);

        WebElement ticket1 = driver.findElement(By.cssSelector("button[id='2025-08-31'] div[class='MuiBox-root css-0']"));
        ticket1.click();

        /// Add ticket - Step 2
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement step2title = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='App'] div:nth-child(3) span:nth-child(1)")));
        Assert.assertTrue(step2title.isDisplayed(), "Step 2 is not displayed!");

        String slot1Start = (String) data.get("slot1start");
        String slot1End = (String) data.get("slot1end");
        String slotTime = slot1Start + " - " + slot1End;
        waitForClickable(By.xpath("//div[contains(text(),'" + slotTime + "')]"));
    }

    /// Add ticket - Add slot
    String filePath1 = "src/datafile/portal/forEvent/single ticket 0.json";
    String filePath2 = "src/datafile/portal/forEvent/single ticket 1.json";
    List<JSONObject> testDataList1 = JsonDataReader.getCombinedTestData(filePath1, filePath2);
    System.out.println(testDataList1);
    for (JSONObject data1 : testDataList1) {
        if (data1.containsKey("name")) {
            String slot1 = (String) data1.get("name");
            if (slot1 != null && !slot1.isEmpty()) {
                waitForClickable(By.xpath("//div[@id='ticketSettings." + slot1 + "']//button[2]//*[name()='svg']"));
            }
        }
        if (data1.containsKey("name1")) {
            String slot2 = (String) data1.get("name1");
            if (slot2 != null && !slot2.isEmpty()) {
                waitForClickable(By.xpath("//div[@id='ticketSettings." + slot2 + "']//button[2]//*[name()='svg']"));
            }
        }
    }
    /// Add to cart
    WebElement addToCart = driver.findElement(By.xpath("//button[normalize-space()='Add to Cart']"));
    addToCart.click();
    WebElement successMessage = driver.findElement(By.cssSelector(".MuiBox-root.css-1gp406"));

    /// Check status after adding cart
    waitForVisible(successMessage);
    Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed!");
    Assert.assertEquals(successMessage.getText(), "Added to cart successfully!", "Wrong message!");
    }
}
