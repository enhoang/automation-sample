package src.portal.eventManagement;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;

public class schedule_singleDate extends BaseTest_Portal {
    @Test
    public void setSchedule() {
        /// Open Schedule
        WebElement scheduleBtn = driver.findElement(By.xpath("//span[normalize-space()='Schedules Management']"));
        scheduleBtn.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Schedules Management')]")).getText(), "Schedules Management");

        ///Add Schedule
        waitForClickable(By.xpath("//span[normalize-space()='+ Add Schedule']"));

        /// Add Single Schedule
        waitForClickable(By.xpath("//span[normalize-space()='Add Single Date']"));
        waitForClickable(By.xpath("//span[normalize-space()='Confirm']"));

        String filePath = "src/datafile/portal/date&time.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            /// Schedule 1
            /// Date
            getDefaultTimeout();
            sendKeysWithEnter(By.cssSelector("#create-schedule_eventSlots_0_date"), (String) data.get("startdate"));

            /// Add time slot
            waitForClickable(By.xpath("//span[normalize-space()='Manage Time Slots']"));
            waitForClickable(By.xpath("//span[normalize-space()='+ Add More']"));
            /// Slot 1
            sendKeysWithEnter(By.cssSelector("#timeSlots_0_startTime"), (String) data.get("slot1start"));
            sendKeysWithEnter(By.cssSelector("#timeSlots_0_endTime"), (String) data.get("slot1end"));

//
        }
        /// Confirm
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        /// Save schedule
        WebElement saveSchedule = driver.findElement(By.xpath("//span[normalize-space()='Save Schedules']"));
        saveSchedule.click();
        getDefaultTimeout();
    }
}
