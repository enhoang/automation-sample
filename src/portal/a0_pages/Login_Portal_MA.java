package src.portal.a0_pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.ConfigManagement;
import src.utils.JsonDataReader;

import java.util.List;

public class Login_Portal_MA extends BaseTest_Portal {
    @Test
    public void merchantadmin() {
        String filePath = "src/datafile/portal/portal_MA.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            driver.findElement(By.cssSelector("#email")).sendKeys((String) data.get("email"));
            driver.findElement(By.cssSelector("#password")).sendKeys((String) data.get("password"));
        }
        waitForClickable(By.xpath("//button[@type='submit']"));
        waitForVisible(By.xpath("////a[contains(text(),'Event Management')]"));

        String env = ConfigManagement.getEnv();
        ConfigManagement.loadEnv(env);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://trievent-merchant-" + env + ".tribox.me/events/event-management";
        Assert.assertEquals(currentURL, expectedURL,
                "Expected to navigate to Event Management page but URL was different.");
    }
}
