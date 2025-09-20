package src.portal.a0_pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.ConfigManagement;
import src.utils.JsonDataReader;

import java.util.List;

public class Login_Portal_SA extends BaseTest_Portal {
    @Test
    public void superadmin() {
        open();
        waitForVisible(By.cssSelector("label[title='Email']"));
        String filePath = "src/datafile/portal/portal_SA.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            driver.findElement(By.cssSelector("#email")).sendKeys((String) data.get("email"));
            driver.findElement(By.cssSelector("#password")).sendKeys((String) data.get("password"));
        }
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();

        /// Check Login status
        waitForVisible(By.xpath("//a[contains(text(),'Dashboard')]"));
        String env = ConfigManagement.getEnv();
        ConfigManagement.loadEnv(env);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://trievent-merchant-" + env + ".tribox.me/dashboard";
        Assert.assertEquals(currentURL, expectedURL,
                "Expected to navigate to Dashboard page but URL was different.");
    }
}
