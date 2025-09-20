package src.portal.voucherManagement.createVoucher;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;

public class voucherThumbnail extends BaseTest_Portal {
    @Test
    public void uploadMedia() {
        /// Upload thumbnail
        WebElement uploadBanner = driver.findElement(By.xpath("//span[@class='ant-upload']//input[@type='file']"));
        String filePath = "src/datafile/portal/forVoucher/vouchermedia.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            /// Thumbnail
            uploadBanner.sendKeys((String) data.get("thumbnail"));
        }
    }
}
