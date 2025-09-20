package src.portal.voucherManagement.createVoucher;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;
import java.util.Optional;

public class information extends BaseTest_Portal {
    @Test
    public void voucherinfor() {
        String filePath1 = "src/datafile/portal/forVoucher/information.json";
        List<JSONObject> testDataList = JsonDataReader.getCombinedTestData(filePath1);
        for (JSONObject data : testDataList) {
            /// Title
            driver.findElement(By.cssSelector("#title")).sendKeys((String) data.get("name"));
            driver.findElement(By.cssSelector("#description")).sendKeys((String) data.get("description"));
            driver.findElement(By.cssSelector("div[data-placeholder='Enter Voucher Details']")).sendKeys((String) data.get("detail"));
            /// Price
            driver.findElement(By.cssSelector("#price")).sendKeys((String) data.get("price"));
            /// Genre
            sendKeysWithEnter(By.cssSelector("#svoucherCategoryId"), (String) data.get("genre"));
            /// Genre Type
            waitForVisible(By.cssSelector("#svoucherSubcategoryId"));
            sendKeysWithEnter(By.cssSelector("#svoucherSubcategoryId"), (String) data.get("genre type"));
            /// Quantity
            driver.findElement(By.cssSelector("#quantity")).sendKeys((String) data.get("quantity"));
        }
    }
}
