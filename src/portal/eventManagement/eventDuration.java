package src.portal.eventManagement;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;

public class eventDuration extends BaseTest_Portal {
    @Test
    public void duration() {
        String filePath = "src/datafile/portal/forEvent/information.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            /// Sale start date and hour
            sendKeysWithEnter(By.cssSelector("#create-event_saleStartHour"), (String) data.get("start hour"));
            sendKeysWithEnter(By.cssSelector("#create-event_saleStartDate"), (String) data.get("start day"));

            /// Sale end date and hour
            sendKeysWithEnter(By.cssSelector("#create-event_saleEndDate"), (String) data.get("end day"));
            sendKeysWithEnter(By.cssSelector("#create-event_saleEndHour"), (String) data.get("end hour"));

            /// Price description
            driver.findElement(By.cssSelector("#create-event_priceDescription")).sendKeys((String) data.get("price desc"));
        }
    }
}
