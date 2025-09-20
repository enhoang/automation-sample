package src.portal.voucherManagement.createVoucher;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;

public class voucherDate extends BaseTest_Portal {
    @Test
    public void date() {
        String filePath = "src/datafile/portal/forVoucher/information.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            /// Release date
            sendKeysWithEnter(By.cssSelector("#releaseDate"), (String) data.get("release date"));

            /// Release time
            sendKeysWithEnter(By.cssSelector("#releaseTime"), (String) data.get("release time"));

            /// Expiration date
            waitForClickable(By.cssSelector("#expDate"));
            sendKeysWithEnter(By.cssSelector("#expDate"), (String) data.get("expiration date"));

            /// Expiration time
            waitForClickable(By.cssSelector("#expTime")); //hold
            sendKeysWithEnter(By.cssSelector("#expTime"), (String) data.get("expiration time"));
            
            /// Sale start date
            sendKeysWithEnter(By.cssSelector("#saleStartDate"), (String) data.get("sale start date"));

            /// Sale start time
            sendKeysWithEnter(By.cssSelector("#saleStartTime"), (String) data.get("sale start time"));

            /// Sale end date
            sendKeysWithEnter(By.cssSelector("#saleEndDate"), (String) data.get("sale end date"));

            /// Sale end time
            sendKeysWithEnter(By.cssSelector("#saleEndTime"), (String) data.get("sale end time"));
        }
    }
}
