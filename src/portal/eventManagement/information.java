package src.portal.eventManagement;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;

public class information extends BaseTest_Portal {
    @Test
    public void fillEvent() {
        /// Fill event information
        String filePath = "src/datafile/portal/forEvent/information.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            /// Event title
            driver.findElement(By.cssSelector("#create-event_title")).sendKeys((String) data.get("title"));
            /// Event Description
            driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys((String) data.get("description"));
            /// Genre
            driver.findElement(By.cssSelector("#create-event_categoryId")).sendKeys((String) data.get("genre"));
            driver.findElement(By.cssSelector("#create-event_categoryId")).sendKeys(Keys.ENTER);
            /// Country
            driver.findElement(By.cssSelector("#create-event_location_country")).sendKeys((String) data.get("country"));
            driver.findElement(By.cssSelector("#create-event_location_country")).sendKeys(Keys.ENTER);
            /// City
            driver.findElement(By.cssSelector("#create-event_location_city")).sendKeys((String) data.get("city"));
            driver.findElement(By.cssSelector("#create-event_location_state")).sendKeys((String) data.get("state"));
            /// Postal code
            driver.findElement(By.cssSelector("#create-event_location_postalCode")).sendKeys((String) data.get("postal"));
            /// Address
            driver.findElement(By.cssSelector("#create-event_location_address")).sendKeys((String) data.get("address"));

        }
        /// Event Type
        waitForClickable(By.xpath("//span[normalize-space()='Stand-up comedy']"));
    }
}
