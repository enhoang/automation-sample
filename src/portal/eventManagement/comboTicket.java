package src.portal.eventManagement;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.time.Duration;
import java.util.List;

public class comboTicket extends BaseTest_Portal {
    @Test
    public void combo() {
    /// Setup combo ticket
    WebElement combotickets = driver.findElement(By.xpath("//span[normalize-space()='Combo Tickets']"));
    combotickets.click();
    Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Combo Tickets')]")).isDisplayed());

    /// Add combo 1
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='+ Add More']"))).click();

        /// Upload thumbnail
        WebElement thumbnail1 = driver.findElement(By.xpath("//span[@class='ant-upload']//input[@id='combos_combos_0_ticketImage']"));
        String filePath3 = "src/datafile/portal/forEvent/eventmedia.json";
        List<JSONObject> testDataList3 = JsonDataReader.getTestData(filePath3);
        for (JSONObject data : testDataList3) {
            thumbnail1.sendKeys((String) data.get("comboImage1"));
        }

        /// Information
        String filePath = "src/datafile/portal/forEvent/combo 0.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            /// Title
            driver.findElement(By.cssSelector("#combos_0_title")).sendKeys((String) data.get("name"));
            /// Capacity
            driver.findElement(By.cssSelector("#combos_0_capacity")).sendKeys((String) data.get("capacity"));
            /// Combo Price
            driver.findElement(By.cssSelector("#combos_0_price")).sendKeys((String) data.get("comboprice"));
            /// Time Slot Qty
            driver.findElement(By.cssSelector("#combos_0_quantityOfSlot")).sendKeys((String) data.get("timeslotqty"));
        }

        /// Add combo 2
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='+ Add More']"))).click();

        /// Upload thumbnail
        WebElement thumbnail2 = driver.findElement(By.xpath("//span[@class='ant-upload']//input[@id='combos_combos_1_ticketImage']"));
        waitForVisible(thumbnail2);
        String filePath2 = "src/datafile/portal/forEvent/eventmedia.json";
        List<JSONObject> testDataList2 = JsonDataReader.getTestData(filePath2);
        for (JSONObject data : testDataList2) {
            thumbnail2.sendKeys((String) data.get("comboImage2"));
        }

        /// Information
        String filePath1 = "src/datafile/portal/forEvent/combo 1.json";
        List<JSONObject> testDataList1 = JsonDataReader.getTestData(filePath1);
        for (JSONObject data : testDataList1) {
            /// Title
            driver.findElement(By.cssSelector("#combos_1_title")).sendKeys((String) data.get("name"));
            /// Capacity
            driver.findElement(By.cssSelector("#combos_1_capacity")).sendKeys((String) data.get("capacity"));
            /// Combo Price
            driver.findElement(By.cssSelector("#combos_1_price")).sendKeys((String) data.get("comboprice"));
            /// Time Slot Qty
            driver.findElement(By.cssSelector("#combos_1_quantityOfSlot")).sendKeys((String) data.get("timeslotqty"));
        }
    /// Save
    WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
    save.click();
    getDefaultTimeout();
    }
}
