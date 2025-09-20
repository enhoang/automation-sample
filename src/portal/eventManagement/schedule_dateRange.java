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

public class schedule_dateRange extends BaseTest_Portal {
    @Test
    public void setSchedule() {
        /// Open Schedule
        WebElement scheduleBtn = driver.findElement(By.xpath("//span[normalize-space()='Schedules Management']"));
        scheduleBtn.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Schedules Management')]")).getText(), "Schedules Management");

        ///Add Schedule
        waitForClickable(By.xpath("//span[normalize-space()='+ Add Schedule']"));

        /// Add Range Schedule
        waitForClickable(By.xpath("//span[normalize-space()='Add Date Range']"));
        waitForClickable(By.xpath("//span[normalize-space()='Confirm']"));

        String filePath = "src/datafile/portal/date&time.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            /// Start Date Range
            sendKeysWithEnter(By.cssSelector("#create-schedule_eventSlots_0_startDate"), (String) data.get("startdate"));

            /// End Date Range
            sendKeysWithEnter(By.cssSelector("#create-schedule_eventSlots_0_endDate"), (String) data.get("enddate"));
            getDefaultTimeout();

            /// Add Time Slot
            waitForClickable(By.xpath("//span[normalize-space()='Manage Time Slots']"));
            waitForClickable(By.xpath("//span[normalize-space()='+ Add More']"));
            /// Time Slot 1
            sendKeysWithEnter(By.cssSelector("#timeSlots_0_startTime"), (String) data.get("slot1start"));
            sendKeysWithEnter(By.cssSelector("#timeSlots_0_endTime"), (String) data.get("slot1end"));

            /// Time Slot 2
            driver.findElement(By.xpath("//span[normalize-space()='+ Add More']")).click();
            sendKeysWithEnter(By.cssSelector("#timeSlots_1_startTime"), (String) data.get("slot2start"));
            sendKeysWithEnter(By.cssSelector("#timeSlots_1_endTime"), (String) data.get("slot2end"));
        }
            /// Confirm
            driver.findElement(By.cssSelector("button[type='submit']")).click();

        /// Save schedule
        WebElement saveSchedule = driver.findElement(By.xpath("//span[normalize-space()='Save Schedules']"));
        saveSchedule.click();
        getDefaultTimeout();
    }
}
