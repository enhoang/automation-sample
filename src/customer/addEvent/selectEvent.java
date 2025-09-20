package src.customer.addEvent;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.customer.a0_pages.P3_Event;
import src.base.BaseTest_Customer;
import src.utils.ConfigManagement;
import src.utils.JsonDataReader;

import java.util.List;

public class selectEvent extends BaseTest_Customer {
    @Test
    public void select() {
        /// Open Events page
        P3_Event event = new P3_Event(driver);
        event.event();

        /// Select event
        String filePath = "src/datafile/portal/forEvent/information.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            String eventTitle = (String) data.get("title");
            waitForClickable(By.xpath("//div[normalize-space()='" + eventTitle + "']"));
            System.out.println(eventTitle);
        }

        /// Get ticket
        waitForClickable(By.xpath("//span[@role='button' and text()='Get Tickets']"));
    }
}

